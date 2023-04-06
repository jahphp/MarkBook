package com.hp.dialog;

import com.hp.data.ContentData;
import com.hp.data.OverAllContentData;
import com.hp.util.DataConvert;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @description TODO
 * @createTime 2023/4/4 10:15
 */
public class AddDialog extends DialogWrapper {
    EditorTextField north = null;
    EditorTextField south = null;

    public AddDialog() {
        super(true);
        setTitle("添加注释");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new BorderLayout());
        north = new EditorTextField("添加标题");
        south = new EditorTextField("添加注释");
        south.setPreferredSize(new Dimension(200,200));
        dialogPanel.add(north,BorderLayout.NORTH);
        dialogPanel.add(south,BorderLayout.SOUTH);
        return dialogPanel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel dialogPanel = new JPanel();
        JButton button = new JButton("添加到列表");
        button.addActionListener(e -> {
            String title = north.getText();
            String mark = south.getText();
            ContentData contentData = new ContentData();
            contentData.setTitle(title);
            contentData.setMark(mark);
            contentData.setContent(OverAllContentData.CONTENT);
            contentData.setFileName(OverAllContentData.FILE_NAME);
            contentData.setFileType(OverAllContentData.FILE_TYPE);
            OverAllContentData.CONTENT_DATA_LIST.add(contentData);
            //渲染表格
            OverAllContentData.TABLE_MODEL.addRow(DataConvert.getStringArr(contentData));
            //关闭窗口
            MessageDialogBuilder.yesNo("操作结果","添加成功!").show();
        });
        dialogPanel.add(button);
        return dialogPanel;
    }
}
