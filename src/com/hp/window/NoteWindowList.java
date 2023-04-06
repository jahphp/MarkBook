package com.hp.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author Administrator
 * @version 1.0.0
 * @description TODO
 * @createTime 2023/4/6 11:00
 */
public class NoteWindowList implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {

        //获取布局对象
        MarkBootWindow markBootWindow = new MarkBootWindow(project,toolWindow);
        //获取内容工厂的实例
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        //获取用于toolWindow显示的内容
        Content content = contentFactory.createContent(markBootWindow.getContainer(), "", false);
        //给toolWindow设置内容
        toolWindow.getContentManager().addContent(content);
    }
}
