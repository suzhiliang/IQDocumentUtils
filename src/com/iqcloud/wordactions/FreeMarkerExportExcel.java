package com.iqcloud.wordactions;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerExportExcel {

	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		for (int i = 1; i < 10; i++) {
			map = new HashMap<String, Object>();
			map.put("dx", i);
			map.put("class", i + "班");
			map.put("d1", i + "1%");
			map.put("d2", i + "2%");
			map.put("d3", i + "3%");
			map.put("d4", i + "4%");
			map.put("d5", i + "5%");
			map.put("d6", i + "6%");
			map.put("d7", i + "7%");
			map.put("d8", i + "8%");
			list.add(map);
		}
		Map<String, Object> testMap = new HashMap<String, Object>();
		testMap.put("datas", list);
		FreeMarkerUtil handler = new FreeMarkerUtil();
		Writer out = null;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("E:/zlsu/Document/marking/framktodoc/2017-10-23 -学校考勤报表.xls");
			out = new OutputStreamWriter(fos, "UTF-8");
			String templatePath = "E:/zlsu/Document/marking/framktodoc/";
			handler.write(templatePath, "2017-10-23 -学校考勤报表.xml", testMap, out);
			System.out.println("导出成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
