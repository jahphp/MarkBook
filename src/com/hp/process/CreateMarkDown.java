package com.hp.process;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Administrator
 * @version 1.0.0
 * @description TODO
 * @createTime 2023/4/6 13:16
 */
public abstract class CreateMarkDown implements Process {

    //获取模板
    protected abstract Template getTempLate(SourceNoteData sourceNoteData) throws IOException;

    //获取数据模型
    protected abstract Object getModel(SourceNoteData sourceNoteData);

    //写出数据
    protected abstract Writer writeData(SourceNoteData sourceNoteData) throws FileNotFoundException;

    @Override
    public void process(SourceNoteData sourceNoteData) throws IOException, TemplateException {
        Template tempLate = getTempLate(sourceNoteData);
        Object model = getModel(sourceNoteData);
        Writer writer = writeData(sourceNoteData);
        tempLate.process(model,writer);
    }
}
