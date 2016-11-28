package com.huawangxin.test;

import java.lang.reflect.Field;

public class test {

	public static void main(String[] args) throws SecurityException, NoSuchFieldException, RuntimeException, IllegalAccessException {
		Class cache = Integer.class.getDeclaredClasses()[0]; //1
	      Field myCache = cache.getDeclaredField("cache"); //2
	      myCache.setAccessible(true);//3
	 
	      Integer[] newCache = (Integer[]) myCache.get(cache); //4
	      newCache[132] = newCache[133]; //5
	 
	      int a = 131;
	      int b = a + a;
	      System.out.printf("%d + %d = %d", a, a, b); //
	}

}
