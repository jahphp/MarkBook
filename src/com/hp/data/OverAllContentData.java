package com.hp.data;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @description TODO
 * @createTime 2023/4/6 10:29
 */
public class OverAllContentData {

    /**
     * 勾选笔记内容
     */
    public static String CONTENT = "";
    /**
     * 文件名称
     */
    public static String FILE_NAME = "";
    /**
     * 文件类型
     */
    public static String FILE_TYPE = "";
    /**
     * 笔记列表内容
     */
    public static List<ContentData> CONTENT_DATA_LIST = new LinkedList<>();
    /**
     * 表头
     */
    private static final String[] COLUMN_NAME={"标题","备注","文件名","代码段"};

    public static DefaultTableModel TABLE_MODEL = new DefaultTableModel(null,COLUMN_NAME);

    public static  void  clear(){
       CONTENT_DATA_LIST = null;
    }
}
