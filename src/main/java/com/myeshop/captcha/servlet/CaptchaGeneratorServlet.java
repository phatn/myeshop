package com.myeshop.captcha.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.myeshop.web.utils.CaptchaUtils;


public class CaptchaGeneratorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final String FILE_TYPE = "jpeg";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Max-age", 0);
		
		String captchaSt = CaptchaUtils.generateCaptchaText(6);
		try {
			int width = 100;
			int height = 40;
			
			Color background = new Color(0, 255, 255);
			Color foreground = new Color(0, 100, 0);
			
			Font font = new Font("Arial", Font.BOLD, 20);
			BufferedImage captchaImage = new BufferedImage(width, height, BufferedImage.OPAQUE);
			Graphics graphics = captchaImage.createGraphics();
			graphics.setFont(font);
			graphics.setColor(background);
			graphics.fillRect(0, 0, width, height);
			graphics.setColor(foreground);
			graphics.drawString(captchaSt, 10, 25);
			HttpSession session = request.getSession(true);
			session.setAttribute("CAPTCHA", captchaSt);
			
			OutputStream outputStream = response.getOutputStream();
			ImageIO.write(captchaImage, FILE_TYPE, outputStream);
			outputStream.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}

}
