import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.vfs.VirtualFile;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.io.IOException;

/**
 * Created by AlexYin on 2016-09-01.
 */
public class TFSUndo extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        TFSAction.executeCmd(e, "tf undo ?");
    }
}
