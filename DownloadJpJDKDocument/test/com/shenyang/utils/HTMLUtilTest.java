package com.shenyang.utils;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HTMLUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String str;
		try {
			str = HTMLUtil.getHTML("https://docs.oracle.com/javase/jp/8/docs/api/index.html");
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test1() {
		String str;

		int index = StringUtil.getCountFromString("https://docs.oracle.com/javase/jp/8/docs/api/../../../stylesheet.css", "../");
		System.out.println(index);
	}
	@Test
	public void test2(){
		String result = StringUtil.subStringByLastMatchChar("https://docs.oracle.com/javase/jp/8/docs/api/stylesheet.css","/",2);
		System.out.println(result);
	}
	@Test
	public void test3(){
		String result = HTMLUtil.getCurrentPath("../../../../javax/lang/model/type/package-tree.html", "https://docs.oracle.com/javase/jp/8/docs/api/javax/lang/model/util/package-tree.html");
		System.out.println(result);
	}
}
