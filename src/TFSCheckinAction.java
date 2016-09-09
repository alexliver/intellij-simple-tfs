import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.IOException;

/**
 * Created by AlexYin on 2016-09-01.
 */
public class TFSCheckinAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        TFSAction.executeCmd(e, "tf checkin ?");
    }
}
