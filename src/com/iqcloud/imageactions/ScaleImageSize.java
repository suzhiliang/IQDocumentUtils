package com.iqcloud.imageactions;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import com.mortennobel.imagescaling.ResampleOp;

/**
 * Copyright © 2017RUIDA. All rights reserved.
 * 
 * @ClassName: ScaleImageSize
 * @Description: 缩放图片大小
 * @author: SZL
 * @date: 2017年10月12日 上午9:25:57
 */
public class ScaleImageSize {

	public static void main(String[] args) {
		File in = new File("D:/临时文件/12/6C3B72A2B26B44BF81B51D2BB7F1894D.png");
		File out = new File("D:/临时文件/12/1.jpg");
		Date t1 = new Date();
		scaleImageSize(in, out, 750, 1170 * 3);
		Date t2 = new Date();
		System.out.println("第一种方法用时------------------------->" + (t2.getTime() - t1.getTime()));
		in = new File("D:/临时文件/12/6C3B72A2B26B44BF81B51D2BB7F1894D.png");
		out = new File("D:/临时文件/12/2.png");
		resize(in, out, 750, 1170 * 3, "jpg");
		System.out.println("第二种方法用时------------------------->" + (new Date().getTime() - t2.getTime()));
	}

	/**
	 * @Title: scaleImageSize
	 * @Description: 缩放图片第一种方法
	 * @param in
	 * @param out
	 * @param width
	 * @param heigth
	 * @return: void
	 */
	private static void scaleImageSize(File in, File out, int width, int heigth) {
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(in);
			System.out.println("图片宽------------------》" + bufferedImage.getWidth());
			System.out.println("图片高------------------》" + bufferedImage.getHeight());
			BufferedImage reslut = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
			Graphics g = reslut.getGraphics();
			g.drawImage(bufferedImage.getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
			ImageIO.write(reslut, "jpg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @Title: resize
	 * @Description: 缩放图片第二种方法(快 4 5倍左右)
	 * @param originalFile
	 * @param resizedFile
	 * @param newWidth
	 * @param newHeight
	 * @param formatName
	 * @return: void
	 */
	public static void resize(File originalFile, File resizedFile, int newWidth, int newHeight, String formatName) {
		try {
			BufferedImage inputBufImage = ImageIO.read(originalFile);
			ResampleOp resampleOp = new ResampleOp(newWidth, newHeight);// 转换
			BufferedImage rescaledTomato = resampleOp.filter(inputBufImage, null);
			ImageIO.write(rescaledTomato, formatName, resizedFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
