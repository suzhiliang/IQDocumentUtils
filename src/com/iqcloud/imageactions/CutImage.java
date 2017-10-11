package com.iqcloud.imageactions;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class CutImage {

	/**
	 * @Title: cutImage
	 * @Description: 切图
	 * @param in
	 * @param out
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return: void
	 */
	public void cutImage(String in, String out, int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3) {
		FileInputStream is = null;
		ImageInputStream iis = null;
		try {
			// 读取图片文件
			is = new FileInputStream(in);

			/*
			 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
			 * 参数：formatName - 包含非正式格式名称 . （例如 "jpeg" 或 "tiff"）等 。
			 */
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("jpg");
			ImageReader reader = it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(is);

			/*
			 * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。
			 * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
			 */
			reader.setInput(iis, true);

			/*
			 * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O
			 * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的
			 * getDefaultReadParam 方法中返回 ImageReadParam 的实例。
			 */
			ImageReadParam param = reader.getDefaultReadParam();

			int beginy = y0 - y1 > 0 ? y1 : y0;
			int endy = y2 - y3 > 0 ? y2 : y3;
			int bh = endy - beginy;
			int beginx = x0 - x2 > 0 ? x2 : x0;
			int endx = x1 - x3 > 0 ? x1 : x3;
			int bw = endx - beginx;
			/*
			 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			 * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
			 */
			Rectangle rect = new Rectangle(x0, y0, bw, bh);

			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);

			/*
			 * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的
			 * BufferedImage 返回。
			 */
			BufferedImage bi = reader.read(0, param);

			// 保存新图片
			ImageIO.write(bi, "jpg", new File(out));
		} catch (Exception e) {

		} finally {
			try {
				if (is != null)
					is.close();
				if (iis != null)
					iis.close();
			} catch (Exception e2) {
			}

		}
	}

	public static void main(String args[]) throws IOException {
		String basePath = "D:/临时文件/8/";
		CutImage pic = new CutImage();
		pic.cutImage(basePath + "img20170926_14285105.jpg", basePath + "10.jpg", 68, 107, 3239, 107, 68, 4596, 3239,
				4596);
	}
}