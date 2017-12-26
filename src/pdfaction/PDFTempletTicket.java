package pdfaction;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * Copyright © 2017RUIDA. All rights reserved.
 * 
 * @ClassName: PDFTempletTicket
 * @Description: TODO
 * @author: SZL
 * @date: 2017年12月25日 下午1:15:08
 */
public class PDFTempletTicket {

	private String templatePdfPath;
	private String ttcPath;
	private String targetPdfpath;
	private Ticket ticket;

	public PDFTempletTicket() {
		super();
	}

	public PDFTempletTicket(String templatePdfPath, String ttcPath, String targetPdfpath, Ticket ticket) {
		this.templatePdfPath = templatePdfPath;
		this.ttcPath = ttcPath;
		this.targetPdfpath = targetPdfpath;
		this.ticket = ticket;
	}

	public void templetTicket(File file) throws Exception {

		PdfReader reader = new PdfReader(templatePdfPath);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		PdfStamper ps = new PdfStamper(reader, bos);

		/* 使用中文字体 */
		BaseFont bf = BaseFont.createFont("C:/Windows/Fonts/simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		ArrayList<BaseFont> fontList = new ArrayList<BaseFont>();
		fontList.add(bf);

		AcroFields s = ps.getAcroFields();
		s.setSubstitutionFonts(fontList);

		s.setField("name", ticket.getName());
		s.setField("classes", ticket.getClasses());
		s.setField("school", ticket.getSchool());
		s.setField("sysName", ticket.getTopic());

		ps.setFormFlattening(true);
		ps.close();

		FileOutputStream fos = new FileOutputStream(file);
		fos.write(bos.toByteArray());
		fos.close();
	}

	/**
	 * @return the templatePdfPath
	 */
	public String getTemplatePdfPath() {
		return templatePdfPath;
	}

	/**
	 * @param templatePdfPath
	 *            the templatePdfPathto set
	 */
	public void setTemplatePdfPath(String templatePdfPath) {
		this.templatePdfPath = templatePdfPath;
	}

	/**
	 * @return the ttcPath
	 */
	public String getTtcPath() {
		return ttcPath;
	}

	/**
	 * @param ttcPath
	 *            the ttcPath to set
	 */
	public void setTtcPath(String ttcPath) {
		this.ttcPath = ttcPath;
	}

	/**
	 * @return the targetPdfpath
	 */
	public String getTargetPdfpath() {
		return targetPdfpath;
	}

	/**
	 * @param targetPdfpath
	 *            the targetPdfpath toset
	 */
	public void setTargetPdfpath(String targetPdfpath) {
		this.targetPdfpath = targetPdfpath;
	}

	/**
	 * @return the ticket
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * @param ticket
	 *            the ticket to set
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}