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
	private static final String DATU_PATH = "tiezi_images"; // ԭͼ���·��
	private static final String XIAOTU_PATH = "tiezi_images_xiaotu"; // Сͼ���·��
	private static final int FONT_SIZE = 18; // ���ִ�С
	private static final String APP_NAME = "����app��������"; // ��Ҫ�ӵ�����
	private static int NEW_IMAGE_SIZE = 240; // ѹ�����ͼƬ��С

	
	
	private static Image	srcImage	= null;
	private static File	srcFile  = null;
	private static File	destFile	= null;
	private static String	fileSuffix	= null;
    
	private static int imageWidth = 0;
	private static int imageHeight = 0;
	/**
	 * 
	 * @param targetImg
	 *            ͼƬ·��
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
			g.setColor(Color.white); // ������ɫ
			g.setFont(new Font(APP_NAME, Font.PLAIN, FONT_SIZE));
			g.drawString(Contans.APP_NAME,// �����������ֵ�λ��
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
