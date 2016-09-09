import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.IOException;

/**
 * Created by AlexYin on 2016-09-01.
 */
public class TFSAction extends AnAction{

    public TFSAction() {
        // Set the menu item name.
        super("Text _Boxes");
        // Set the menu item name, description and icon.
        // super("Text _Boxes","Item description",IconLoader.getIcon("/Mypackage/icon.png"));
    }
    public static void executeCmd(AnActionEvent e, String cmd) {
        VirtualFile virtualFile = PlatformDataKeys.VIRTUAL_FILE.getData(e.getDataContext());
        String path = virtualFile.getPath();
        System.out.println(path);
        Runtime rt = Runtime.getRuntime();
        //exe '!tf checkout "' expand('%:p') '"'

        try {
            Process pr = rt.exec("cmd /c start " + cmd.replace("?", "\"" + path + "\""));
            pr.waitFor();
            virtualFile.refresh(false, true);
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        String txt= Messages.showInputDialog(project, "What is your name?", "Input your name", Messages.getQuestionIcon());
        Messages.showMessageDialog(project, "Hello, " + txt + "!\n I am glad to see you.", "Information", Messages.getInformationIcon());
    }
}
