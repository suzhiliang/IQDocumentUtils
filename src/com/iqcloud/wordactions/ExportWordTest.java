package com.iqcloud.wordactions;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by blinkfox on 15-11-19.
 */
public class ExportWordTest {

	/**
	 * 构造测试数据
	 * 
	 * @return
	 */
	public static Map<String, Object> createDatas() {
		Map<String, Object> testMap = new HashMap<String, Object>();
		// 构造散数据
		testMap.put("author", "闪烁之狐");
		testMap.put("date", "2015-11-20");

		// 构造列表循环数据存放在ArrayList集合中
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 5; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("xh", (i + 1) + "");
			map.put("name", "张三" + i);
			map.put("phone", "1381111222" + i);
			list.add(map);
		}
		testMap.put("datas", list);

		return testMap;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Object> testMap = createDatas();
		WordUtil handler = new WordUtil();
		Writer out = null;
		try {
			// 生成test.doc的word文件到某文件路径下
			FileOutputStream fos = new FileOutputStream("E:/zlsu/Document/marking/framktodoc/test2.doc");
			out = new OutputStreamWriter(fos, "UTF-8");
			String templatePath = "E:/zlsu/Document/marking/framktodoc/";
			handler.write(templatePath, "framkdoc2.xml", testMap, out);
			System.out.println("导出成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
