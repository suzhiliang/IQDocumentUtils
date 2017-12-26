package com.iqcloud.imageactions;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

import com.sun.media.jai.codec.BMPEncodeParam;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageEncoder;

/**
 * Copyright © 2017RUIDA. All rights reserved.
 * 
 * @ClassName: FormatImage
 * @Description: 可以实现jpg/tif/bmp 等图片之间格式得互相转换
 * @author: SZL
 * @date: 2017年12月11日 上午11:38:00
 */
public class FormatImage {

	public static void main(String[] args) {
		/* tif转换到jpg格式 */
		// String input2 = "d:/img/a.tif";
		// String output2 = "d:/img/a.jpg";
		// RenderedOp src2 = JAI.create("fileload", input2);
		// OutputStream os2;
		try {
			// os2 = new FileOutputStream(output2);
			// JPEGEncodeParam param2 = new JPEGEncodeParam();
			// // 指定格式类型，jpg 属于 JPEG 类型
			// ImageEncoder enc2 = ImageCodec.createImageEncoder("JPEG", os2,
			// param2);
			// enc2.encode(src2);
			// os2.close();
			/* jpg转换到bmp格式 */
			Date t1 = new Date();
			System.out.println("转换开始时间---------------》" + t1.getTime());
			String inputFile = "d:/img/S28BW-817121110390.jpg";
			String outputFile = "d:/img/b.bmp";
			RenderedOp src = JAI.create("fileload", inputFile);
			OutputStream os = new FileOutputStream(outputFile);
			BMPEncodeParam param = new BMPEncodeParam();
			ImageEncoder enc = ImageCodec.createImageEncoder("BMP", os, param);
			enc.encode(src);
			os.close();// 关闭流
			System.out.println("转换用时---------------》" + ((new Date().getTime()) - t1.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
