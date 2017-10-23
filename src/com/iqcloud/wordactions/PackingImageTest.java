package com.iqcloud.wordactions;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

/**
 * Copyright © 2017RUIDA. All rights reserved.
 * 
 * @ClassName: PackingImageTest
 * @Description: 压缩图片（不改变文件大小像素）
 * @author: SZL
 * @date: 2017年10月12日 上午9:20:06
 */
public class PackingImageTest {

	public static void main(String[] args) {
		// BufferedImage result = null;
		try {
			// BufferedImage im = ImageIO
			// .read(new
			// File("E:/zlsu/Document/marking/5/0E683763DE9247269B4F409C996DE426.png"));

			/* 原始图像的宽度和高度 */
			// int width = im.getWidth();
			// int height = im.getHeight();
			//
			// // 压缩计算
			// float resizeTimes = 0.3f; /* 这个参数是要转化成的倍数,如果是1就是转化成1倍 */
			//
			// /* 调整后的图片的宽度和高度 */
			// int toWidth = (int) (width * resizeTimes);
			// int toHeight = (int) (height * resizeTimes);
			//
			// /* 新生成结果图片 */
			// result = new BufferedImage(toWidth, toHeight,
			// BufferedImage.TYPE_INT_RGB);
			//
			// result.getGraphics().drawImage(im.getScaledInstance(toWidth,
			// toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0,
			// null);

			/* 输出到文件流 */
			// FileOutputStream newimage = new FileOutputStream(
			// "E:/zlsu/Document/marking/5/0E683763DE9247269B4F409C996DE4262.png");
			// // JPEGImageEncoder encoder =
			// JPEGCodec.createJPEGEncoder(newimage);
			// JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(im);
			// /* 压缩质量 */
			// jep.setQuality(0.5f, true);
			// encoder.encode(im, jep);
			/* 近JPEG编码 */
			// newimage.close();

			// BufferedImage image = new BufferedImage((int)
			// PageSize.A4.getWidth(), (int) PageSize.A4.getHeight(),
			// BufferedImage.TYPE_INT_BGR);
			// BufferedImage bufferedImage = ImageIO
			// .read(new
			// File("E:/zlsu/testYsuo/73A9F1638C6845449E9A021DC7A9FF34.png"));
			// Graphics g = image.getGraphics();
			// File file = new File("E:/zlsu/testYsuo/1.png");
			// g.drawImage(bufferedImage, 0, 0, (int) PageSize.A4.getWidth(),
			// (int) PageSize.A4.getHeight(), null);
			// ImageIO.write(image, "png", file);
			compressPic("E:/zlsu/Document/marking/5/0E683763DE9247269B4F409C996DE426.png", (float) 0.5,
					"E:/zlsu/testYsuo/73A9F1638C6845449E9A021DC7A9FF34.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public static boolean compressPic(String srcFilePath, float quality, String descFilePath) throws IOException {
		File file = null;
		BufferedImage src = null;
		FileOutputStream out = null;
		ImageWriter imgWrier;
		ImageWriteParam imgWriteParams;

		// 指定写图片的方式为 jpg
		imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
		imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);
		// 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
		imgWriteParams.setCompressionMode(imgWriteParams.MODE_EXPLICIT);
		// 这里指定压缩的程度，参数qality是取值0~1范围内，
		imgWriteParams.setCompressionQuality(quality);
		imgWriteParams.setProgressiveMode(imgWriteParams.MODE_DISABLED);
		ColorModel colorModel = ImageIO.read(new File(srcFilePath)).getColorModel();// ColorModel.getRGBdefault();
		// 指定压缩时使用的色彩模式
		// imgWriteParams.setDestinationType(new
		// javax.imageio.ImageTypeSpecifier(
		// colorModel, colorModel.createCompatibleSampleModel(16, 16)));
		imgWriteParams.setDestinationType(
				new javax.imageio.ImageTypeSpecifier(colorModel, colorModel.createCompatibleSampleModel(16, 16)));

		try {
			if (isBlank(srcFilePath)) {
				return false;
			} else {
				file = new File(srcFilePath);
				System.out.println(file.length());
				src = ImageIO.read(file);
				out = new FileOutputStream(descFilePath);

				imgWrier.reset();
				// 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何
				// OutputStream构造
				imgWrier.setOutput(ImageIO.createImageOutputStream(out));
				// 调用write方法，就可以向输入流写图片
				imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean isBlank(String string) {
		if (string == null || string.length() == 0 || string.trim().equals("")) {
			return true;
		}
		return false;
	}
}
