package com.r2dsolution.comein.centaurs.util;

import java.util.Random;

public class StringUtils {
	
	private static String baseStr = "ABCDEFGHJKLMNPRTUVWXYZ123456789acdefghjkmnpqrtuvwxyz";
	
	public static String randomStr(int n) {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++) {
			int j = r.nextInt(baseStr.length());
			sb = sb.append(baseStr.charAt(j));
		}
		return sb.toString();
	}
	public static void main(String[] arg) {
		String str = randomStr(40);
		System.out.println("str= "+str);
	}

}
