package com.hck.yanghua.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.hck.data.contans.Contans;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtil {
	private static final String DATU_PATH = "tiezi_images"; // ԭͼ���·��
	private static final String XIAOTU_PATH = "tiezi_images_xiaotu"; // Сͼ���·��
	private static final int FONT_SIZE = 18; // ���ִ�С
	private static final String APP_NAME = "����app��������"; // ��Ҫ�ӵ�����
	private static int NEW_IMAGE_SIZE = 110; // ѹ�����ͼƬ��С

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

	public static void getImageXiaoTuPath(String imgaePath) {
		try {
			File fi = new File(imgaePath); // ��ͼ�ļ�
			String newImageXiaoTuPath = imgaePath.replace(DATU_PATH,
					XIAOTU_PATH);
			File fo = new File(newImageXiaoTuPath); // ��Ҫת������Сͼ�ļ�
			/*
			 * AffineTransform ���ʾ 2D ����任����ִ�д� 2D ���굽���� 2D
			 * ���������ӳ�䣬�������ߵġ�ֱ���ԡ��͡�ƽ���ԡ�������ʹ��һϵ ��ƽ�ơ����š���ת����ת�ͼ������������任��
			 */
			AffineTransform transform = new AffineTransform();
			BufferedImage bis = ImageIO.read(fi); // ��ȡͼƬ
			if (bis == null) {
				return;
			}
			int w = bis.getWidth();
			int h = bis.getHeight();
			// double scale = (double)w/h;
			int nh = (NEW_IMAGE_SIZE * h) / w;
			double sx = (double) NEW_IMAGE_SIZE / w;
			double sy = (double) nh / h;
			transform.setToScale(sx, sy); // setToScale(double sx, double sy)
											// ���˱任����Ϊ���ű任��
			/*
			 * AffineTransformOp��ʹ�÷���ת����ִ�д�Դͼ��� Raster �� 2D ���굽Ŀ��ͼ��� Raster �� 2D
			 * ���������ӳ�䡣��ʹ�õĲ�ֵ�����ɹ��췽��ͨ�� һ�� RenderingHints �����ͨ�������ж����������ֵ����֮һ��ָ����
			 * ����ڹ��췽����ָ���� RenderingHints ������ʹ�ò�ֵ��ʾ�ͳ���
			 * ��������ʾΪ�˲������ò�ֵ���͡�Ҫ�������ɫת��ʱ������ʹ����ɫ ������ʾ�Ͷ�����ʾ�� ע�⣬���Ҫ��������Լ����Դͼ����Ŀ��ͼ��
			 * ���벻ͬ�� ���� Raster ����Դͼ���е� band ���������Ŀ��ͼ���� �� band ����
			 */
			AffineTransformOp ato = new AffineTransformOp(transform, null);
			BufferedImage bid = new BufferedImage(NEW_IMAGE_SIZE, nh,
					BufferedImage.TYPE_3BYTE_BGR);
			/*
			 * TYPE_3BYTE_BGR ��ʾһ������ 8 λ RGB ��ɫ������ͼ�� ��Ӧ�� Windows ���� BGR
			 * ��ɫģ�ͣ������� 3 �ֽڴ� ���� Blue��Green �� Red ������ɫ��
			 */
			ato.filter(bis, bid);
			ImageIO.write(bid, "jpg", fo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
