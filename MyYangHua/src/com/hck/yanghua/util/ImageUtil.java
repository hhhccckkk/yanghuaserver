package com.hck.yanghua.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import com.hck.data.contans.Contans;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
public class ImageUtil {
	private static final String DATU_PATH = "tiezi_images"; // 原图存放路径
	private static final String XIAOTU_PATH = "tiezi_images_xiaotu"; // 小图存放路径
	private static final int FONT_SIZE = 18; // 文字大小
	private static final String APP_NAME = "来自app养花社区"; // 需要加的文字
	private static int NEW_IMAGE_SIZE = 240; // 压缩后的图片大小

	
	
	private static Image	srcImage	= null;
	private static File	srcFile  = null;
	private static File	destFile	= null;
	private static String	fileSuffix	= null;
    
	private static int imageWidth = 0;
	private static int imageHeight = 0;
	/**
	 * 
	 * @param targetImg
	 *            图片路径
	 */
	public static void pressText(String targetImg) {
		try {
			File _file = new File(targetImg);
			Image src = ImageIO.read(_file);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			g.setColor(Color.white); // 文字颜色
			g.setFont(new Font(APP_NAME, Font.PLAIN, FONT_SIZE));
			g.drawString(Contans.APP_NAME,// 可以设置文字的位置
					wideth - 160, height - 10);
			g.dispose();
			FileOutputStream out = new FileOutputStream(targetImg);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
		
	


	
		

	

}
