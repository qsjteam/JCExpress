package com.qsj.util;

import java.util.Random;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class RandomHeadUtil {
	public static String RandomHeadImage() {
		int max = 8;
		int min = 1;
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		StringBuffer sb = new StringBuffer();
		sb.append("images/avatar_");
		sb.append(s);
		sb.append(".jpg");
		// System.out.println(sb);
		return sb.toString();
	}

	public static void main(String[] args) {
		RandomHeadImage();
	}
}
