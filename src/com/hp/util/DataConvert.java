package com.hp.util;

import com.hp.data.ContentData;

/**
 * @author Administrator
 * @version 1.0.0
 * @description TODO
 * @createTime 2023/4/6 11:50
 */
public class DataConvert {

    public static String[] getStringArr(ContentData contentData){
        if (contentData == null){
            return new String[]{};
        }
        String[] res = new String[4];
        res[0] = contentData.getTitle();
        res[1] = contentData.getMark();
        res[2] = contentData.getFileName();
        res[3] = contentData.getContent();
        return  res;
    }
}
