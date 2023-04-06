package com.hp.process;

import com.hp.data.ContentData;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @description TODO
 * @createTime 2023/4/6 13:18
 */
public interface SourceNoteData {

     String getBookTitle();

     String getFilePath();

     List<ContentData> getContentDataList();

}
