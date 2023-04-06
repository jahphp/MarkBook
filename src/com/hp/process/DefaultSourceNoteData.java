package com.hp.process;

import a.h.i.S;
import com.hp.data.ContentData;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @description TODO
 * @createTime 2023/4/6 13:37
 */
public class DefaultSourceNoteData implements SourceNoteData{

    private String bookTitle;

    private String filePath;

    private List<ContentData> contentDataList;

    public DefaultSourceNoteData(String bookTitle, String filePath, List<ContentData> contentDataList) {
        this.bookTitle = bookTitle;
        this.filePath = filePath;
        this.contentDataList = contentDataList;
    }

    @Override
    public String getBookTitle() {
        return bookTitle;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public List<ContentData> getContentDataList() {
        return contentDataList;
    }
}
