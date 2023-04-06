package com.hp.data;

import a.h.i.S;

/**
 * @author Administrator
 * @version 1.0.0
 * @description TODO
 * @createTime 2023/4/6 10:25
 */
public class ContentData {

    /**
     * 笔记小标题
     */
    private String title;

    /**
     * 笔记注释
     */
    private String mark;

    /**
     * 勾选内容
     */
    private String content;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

    public ContentData() {
    }

    public ContentData(String title, String mark, String content, String fileName, String fileType) {
        this.title = title;
        this.mark = mark;
        this.content = content;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "ContentData{" +
                "title='" + title + '\'' +
                ", mark='" + mark + '\'' +
                ", content='" + content + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
