package com.iqcloud.wordactions;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Created by blinkfox on 15-11-19.
 */
public class WordUtil {

	private Configuration configuration = null;

	/**
	 * 构造方法
	 */
	public WordUtil() {
		try {
			configuration = new Configuration();
			configuration.setDefaultEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据类路径获取模板
	 * 
	 * @param templatePath
	 * @param templateName
	 * @return
	 * @throws IOException
	 */
	private Template getTemplate(String templatePath, String templateName) throws IOException {
		configuration.setDirectoryForTemplateLoading(new File(templatePath));
		Template t = configuration.getTemplate(templateName);
		t.setEncoding("UTF-8");
		return t;
	}

	/**
	 * 生成word文档
	 * 
	 * @param templatePath
	 * @param templateName
	 * @param dataMap
	 * @param out
	 */
	public void write(String templatePath, String templateName, Map<String, Object> dataMap, Writer out) {
		try {
			Template t = getTemplate(templatePath, templateName);
			t.process(dataMap, out);
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}