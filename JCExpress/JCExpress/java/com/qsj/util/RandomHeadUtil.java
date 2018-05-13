package com.qsj.util;

import java.util.Random;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.util 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月22日 下午5:20:22 
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
