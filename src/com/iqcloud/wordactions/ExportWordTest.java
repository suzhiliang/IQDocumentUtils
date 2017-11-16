package com.iqcloud.wordactions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.misc.BASE64Encoder;

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
		List<Map<String, String>> imageDates = new ArrayList<Map<String, String>>();
		Map<String, String> imageDate = null;
		String imagePath = "E:/zlsu/Document/marking/framktodoc/image/";
		Date t1 = new Date();
		String base64 = null;
		StringBuffer stringBuffer = new StringBuffer();
		StringBuffer stringBuffer2 = new StringBuffer();
		String relationship = null;
		String relationship2 = null;
		Integer themeNum = null;
		List<String> rIds = new ArrayList<String>();
		for (int i = 1; i <= 6; i++) {
			imageDate = new HashMap<String, String>();
			Date t2 = new Date();
			imageDate.put("name", "/word/media/image" + i + ".jpeg");
			base64 = imageToBase64(imagePath + i + ".jpg");
			System.out.println("转换的base64-----------》" + base64);
			imageDate.put("val", base64);
			System.out.println("转换第" + i + "张图片用时----------->" + (new Date().getTime() - t2.getTime()));
			imageDates.add(imageDate);
			themeNum = i + 6;
			relationship = "<Relationship Id=\"rId" + themeNum
					+ "\"  Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument\" Target=\"word/document.xml\" />";
			stringBuffer.append(relationship);
			relationship2 = "<Relationship Id=\"rId" + themeNum
					+ "\"  Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/image\" Target=\"media/image"
					+ i + ".jpeg\" />";
			stringBuffer2.append(relationship2);
			rIds.add("rId" + themeNum.toString());
		}
		System.out.println("转换6张图片用时----------->" + (new Date().getTime() - t1.getTime()));
		testMap.put("relationship", stringBuffer);
		testMap.put("relationship2", stringBuffer2);
		testMap.put("rIds", rIds);
		testMap.put("imageDates", imageDates);
		return testMap;
	}

	/**
	 * @Title: imageToBase64
	 * @Description: 图片转换base64
	 * @param imagePath
	 * @return: void
	 */
	private static String imageToBase64(String imagePath) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		InputStream in = null;
		byte[] date = null;
		try {
			in = new FileInputStream(new File(imagePath));
			date = new byte[in.available()];
			in.read(date);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return base64Encoder.encode(date);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Object> testMap = createDatas();
		FreeMarkerUtil handler = new FreeMarkerUtil();
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
