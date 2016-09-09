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
public class TFSCheckoutAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        VirtualFile virtualFile = PlatformDataKeys.VIRTUAL_FILE.getData(e.getDataContext());
        String path = virtualFile.getPath();
        System.out.println(path);
        Runtime rt = Runtime.getRuntime();
        //exe '!tf checkout "' expand('%:p') '"'

        try {
            Process pr = rt.exec("tf checkout \"" + path + "\"");
            pr.waitFor();
            virtualFile.refresh(false, true);
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
