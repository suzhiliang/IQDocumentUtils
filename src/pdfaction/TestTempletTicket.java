package pdfaction;

import java.io.File;

//import org.csun.ns.client.OSSConfigure;
//import org.csun.ns.client.OSSUtil;

/**
 * Copyright © 2017RUIDA. All rights reserved.
 * 
 * @ClassName: TestTempletTicket
 * @Description: TODO
 * @author: SZL
 * @date: 2017年12月25日 下午1:22:06
 */
public class TestTempletTicket {

	public static void main(String[] args) throws Exception {

		Ticket ticket = new Ticket();

		ticket.setName("张三");
		ticket.setSchool("锐达中学");
		ticket.setClasses("一班");
		ticket.setTopic("内容");

		PDFTempletTicket pdfTT = new PDFTempletTicket();

		pdfTT.setTemplatePdfPath("C:/Users/zlsu/Desktop/testexportPDF/1/化学A3.pdf");
		pdfTT.setTargetPdfpath("C:/Users/zlsu/Desktop/testexportPDF/1/hh.pdf");
		pdfTT.setTicket(ticket);

		File file = new File("C:/Users/zlsu/Desktop/testexportPDF/1/hh.pdf");
		file.createNewFile();
		pdfTT.templetTicket(file);

		// OSSConfigureconfig = OSSUtil.getOSSConfigure();
		// OSSManageUtil.uploadFile(config, file, "aaabbbccc.pdf","pdf",
		// "ticket/" + "aaabbbccc");

		// System.out.println("path = " + config.getAccessUrl());

	}

}