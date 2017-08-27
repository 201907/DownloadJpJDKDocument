package com.shenyang.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
//		try {
//			String str = HTMLUtil.getHTML("https://docs.oracle.com/javase/jp/8/docs/api/index.html");
//			FileUtil.writeFile(str, "F:\\index.html");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		FileUtil.deleteAllfile(new File("F:/图片/参考/123"));
	}

}
