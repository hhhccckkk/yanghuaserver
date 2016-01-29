package com.hck.yanghua.util;

public class Log {
	private static boolean isPrit=true;
public static void log(String data){
	if (isPrit) {
		System.out.println(data);
	}
}
}
