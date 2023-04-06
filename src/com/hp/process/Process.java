package com.hp.process;

import freemarker.template.Template;

/**
 * @author Administrator
 * @version 1.0.0
 * @description TODO
 * @createTime 2023/4/6 13:03
 */
public interface Process {

    void process(SourceNoteData sourceNoteData) throws Exception;
}
