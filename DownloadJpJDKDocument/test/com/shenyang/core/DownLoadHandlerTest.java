package com.shenyang.core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DownLoadHandlerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		DownLoadHandler downLoadHandler = new DownLoadHandler("F:/图片/参考");
		downLoadHandler.handler("/index.html");
	}

}
