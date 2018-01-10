package pdfaction.flyingsaucer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.pdf.BaseFont;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HtmlToPDF {

	public static void convert() throws Exception {
		FileOutputStream os = null;
		try {
			// 创建一个freemarker.template.Configuration实例，它是存储 FreeMarker
			// 应用级设置的核心部分
			// 指定版本号
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
			// 设置模板目录
			cfg.setDirectoryForTemplateLoading(new File("src/pdfaction/flyingsaucer"));
			// 设置默认编码格式
			cfg.setDefaultEncoding("UTF-8");

			// 数据
			Map<String, Object> product = new HashMap<String, Object>();
			product.put("candidate", "A");
			product.put("position", "B");
			product.put("source", "天");
			product.put("lastInterviewDate", "D");
			product.put("testPaper", "E");
			product.put("testDate", "F");
			product.put("iqSingleScore", "G");
			product.put("iqMultipleScore", 1);
			product.put("logicalSingleScore", 2);
			product.put("logicalMultipleScore", 3);
			product.put("englishScore", 4);
			product.put("javaProScore", 5);
			product.put("netProScore", 6);
			product.put("totalScore", 7);
			product.put("iqSingleCom", 8);
			product.put("iqMultipleCom", 9);
			product.put("logicalSingleCom", 19);
			product.put("logicalMultipleCom", 11);
			product.put("englishCom", 12);
			product.put("javaProCom", 13);
			product.put("netProCom", 14);
			product.put("verbalEngScore", "verbalEngScore");
			product.put("optionalScore", "optionalScore");
			product.put("mapScore", "mapScore");
			product.put("firstIntTotalScore", "firstIntTotalScore");
			product.put("firstIntComment", "firstIntComment");
			product.put("firstInterviewer", "firstInterviewer");
			product.put("secondIntComment", "secondIntComment");
			product.put("secondInterviewer", "secondInterviewer");
			product.put("thirdIntComment", "thirdIntComment");
			product.put("thirdInterviewer", "thirdInterviewer");
			product.put("finalSuggestion", "finalSuggestion");
			product.put("decision", "decision");
			product.put("reason", "reason");

			// 从设置的目录中获得模板
			Template temp = cfg.getTemplate("答题卡预览.ftl");
			// 从模板生成html文件
			String file1 = "D:/PDF/答题卡预览.html";
			File file = new File(file1);
			if (!file.exists()) {
				file.createNewFile();
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			temp.process(product, out);

			// 关闭
			out.close();

			ITextRenderer renderer = new ITextRenderer();
			os = new FileOutputStream("D:/PDF/答题卡预览.pdf");
			renderer.setDocument(new File(file1).toURI().toURL().toString());
			// 获取中文字体(FTL模板中也要设置相应的字体才能有效)
			ITextFontResolver fontResolver = renderer.getFontResolver();
			fontResolver.addFont("C:/Windows/Fonts/文泉驿微米黑.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED); /// 宋体
			fontResolver.addFont("C:/Windows/Fonts/HYT_OMR_Small.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 答题卡中的字体
			renderer.layout();
			renderer.createPDF(os, false, 0);
			// 设置多页PDF其实很简单，第一个页面不变，从第二个起
			// for (int i = 1; i <= 4; i++) {
			// renderer.setDocument(new File(file1).toURI().toURL().toString());
			// renderer.layout();
			// renderer.writeNextDocument();
			// }
			renderer.finishPDF();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		try {
			convert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
