package com.cn.xm.common.utils;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

public class FreeMarkerHelper {
    private static Configuration freemarkerCfg;

    static {
        freemarkerCfg = new Configuration();
        freemarkerCfg.setClassForTemplateLoading(FreeMarkerHelper.class, "/template/");
        freemarkerCfg.setObjectWrapper(new DefaultObjectWrapper());
    }

    /**
     * 
     * @param root
     * @param templateFile
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public static String generate(Map<?, ?> root, String templateFile) throws IOException, TemplateException {
        Writer outWriter = null;
        try {
            // 设置输出的字符类型
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            outWriter = new OutputStreamWriter(outStream, "utf-8");
            Template template = freemarkerCfg.getTemplate(templateFile, "utf-8");
            Environment e = template.createProcessingEnvironment(root, outWriter);
            e.setOutputEncoding("utf-8");
            e.process();
            outWriter.flush();
            return outStream.toString();
        } finally {
            if (outWriter != null) {
                outWriter.close();
            }
        }
    }

}
