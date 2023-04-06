package com.hp.action;

import com.hp.data.OverAllContentData;
import com.hp.dialog.AddDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

/**
 * @author Administrator
 * @version 1.0.0
 * @description TODO
 * @createTime 2023/4/4 9:28
 */
public class PopAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        //获取勾选内容
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        SelectionModel selectionModel = editor.getSelectionModel();
        OverAllContentData.CONTENT = selectionModel.getSelectedText();
        //获取文件名 文件类型
        OverAllContentData.FILE_NAME = e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        OverAllContentData.FILE_TYPE = OverAllContentData.FILE_NAME.substring(OverAllContentData.FILE_NAME.lastIndexOf(".")+1);
        new AddDialog().show();
    }
}
