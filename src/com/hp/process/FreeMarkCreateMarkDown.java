package com.hp.process;

import com.intellij.ide.fileTemplates.impl.UrlUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @description TODO
 * @createTime 2023/4/6 13:25
 */
public class FreeMarkCreateMarkDown extends CreateMarkDown{

    @Override
    public Template getTempLate(SourceNoteData sourceNoteData) throws IOException {
        //加载模板字符串
        String templateString = UrlUtil.loadText(FreeMarkCreateMarkDown.class.getResource("/template/md.ftl"));
        //创建模板配置
        Configuration configuration = new Configuration();
        //创建字符串模板的导入器
        StringTemplateLoader stringTemplateLoader=new StringTemplateLoader();
        //导入字符串模板
        stringTemplateLoader.putTemplate("MDTemplate",templateString);
        configuration.setTemplateLoader(stringTemplateLoader);
        //获取模板
        return configuration.getTemplate("MDTemplate");
    }

    @Override
    protected Object getModel(SourceNoteData sourceNoteData) {
        Map<String, Object> map = new HashMap<>();
        map.put("bookTitle", sourceNoteData.getBookTitle());
        map.put("contentList",sourceNoteData.getContentDataList());
        return map;
    }

    @Override
    public Writer writeData(SourceNoteData sourceNoteData) throws FileNotFoundException {
        String filePath = sourceNoteData.getFilePath();
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
    }
}
