package com.iqcloud.wordactions;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;

public class Test {

	public static void main(String[] args) {
		POIWord2007Utils t = new POIWord2007Utils();
		CustomXWPFDocument_S_9 xdoc = new CustomXWPFDocument_S_9();
		int[] colWidthArr = new int[] { 300, 300, 300, 300, 300, 300, 300, 300 };
		XWPFTable table = t.createTable(xdoc, 2, 8, true, colWidthArr);
		// 设置每行的行高
		for (int rowIndex = 0, rowLen = table.getNumberOfRows(); rowIndex < rowLen; rowIndex++) {
			XWPFTableRow row = table.getRow(rowIndex);
			if (rowIndex == 0) {
				row.setHeight(100);
			} else {
				row.setHeight(400);
			}
		}
		t.setTableWidthAndHAlign(table, "1600", STJc.RIGHT);
		CTTblBorders tblBorders = t.getTableBorders(table);
		// CTBorder rBorder = tblBorders.addNewTop();
		// rBorder.setVal(STBorder.SINGLE);
		// rBorder.setSz(new BigInteger("1"));
		// rBorder.setColor("BF9C9C");
		CTBorder lBorder = tblBorders.addNewBottom();
		lBorder.setVal(STBorder.NONE);
		t.testFillTableValue(table);
		String filePath = "f:/saveFile/temp/sys_测试表格.docx";
		try {
			t.saveDocument(xdoc, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
