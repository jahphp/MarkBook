package com.hp.window;

import com.hp.data.ContentData;
import com.hp.data.OverAllContentData;
import com.hp.process.DefaultSourceNoteData;
import com.hp.process.FreeMarkCreateMarkDown;
import com.hp.process.Process;
import com.hp.process.SourceNoteData;
import com.hp.util.DataConvert;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.messages.MessageDialog;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import org.jetbrains.annotations.NotNull;

import javax.sql.DataSource;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @description TODO
 * @createTime 2023/4/6 10:37
 */
public class MarkBootWindow {

    private JPanel container;
    private JButton btnCreateMarkBoot;
    private JButton btnClear;
    private JButton btnCancel;
    private JTextField bookTitle;
    private JTable dataTable;

    private void init(){
        dataTable.setModel(OverAllContentData.TABLE_MODEL);
        dataTable.setEnabled(true);
    }

    public MarkBootWindow(Project project,ToolWindow toolWindow) {
        init();
        btnCreateMarkBoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = "";
                VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFolderDescriptor(), project, project.getBaseDir());
                if(virtualFile!=null){
                    path = virtualFile.getPath();
                }
                String bookTitleText = bookTitle.getText();
                if (!(bookTitleText == null || "".equals(bookTitleText))){
                    String filePath = path + File.separator + bookTitleText + ".md";
                    SourceNoteData sourceNoteData = new DefaultSourceNoteData(bookTitleText, filePath, OverAllContentData.CONTENT_DATA_LIST);
                    Process process = new FreeMarkCreateMarkDown();
                    try {
                        process.process(sourceNoteData);
                        MessageDialogBuilder.yesNo("操作结果","添加成功!").show();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                }
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               OverAllContentData.clear();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide(null);
            }
        });
    }

    public JPanel getContainer() {
        return container;
    }
}
