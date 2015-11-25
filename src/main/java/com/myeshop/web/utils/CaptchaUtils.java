package com.myeshop.web.utils;

import java.util.Random;

public class CaptchaUtils {
	
	private CaptchaUtils() {}
	
	public static final String SALT_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	
	private static final Random random = new Random();
	
	public static String generateSimpleCaptchaText() {
		int number = random.nextInt();
		String hash = Integer.toHexString(number);
		return hash;
	}
	
	public static String generateCaptchaText(final int captchaLength) {
		StringBuffer captchaStrBuffer = new StringBuffer();
		while (captchaStrBuffer.length() < captchaLength) {
			int index = (int)(random.nextFloat() * SALT_CHARS.length());
			captchaStrBuffer.append(SALT_CHARS.substring(index, index + 1));
		}
		return captchaStrBuffer.toString();
	}
}
