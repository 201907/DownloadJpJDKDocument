package com.shenyang.utils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import com.google.common.base.CharMatcher;
import com.google.common.io.Resources;

public class HTMLUtil {
	/**
	 * 根据连接获取html数据
	 * @param url
	 * @return
	 * @throws IOException 
	 */
	public static String getHTML(String urlPath) throws IOException{
		return Resources.toString(new URL(urlPath), Charset.forName("utf-8"));
	}
	/**
	 * 获取正确的路径
	 * @param 原始路径
	 * @param 相对于哪个路径
	 * @return
	 */
	public static String getCurrentPath(String origialPath,String path){
		String currentPath = null;
		if(origialPath.indexOf("../")==-1){
			currentPath = path.substring(0,path.lastIndexOf("/"));
			return currentPath + "/"+ origialPath;
		}else{
			int count = StringUtil.getCountFromString(origialPath, "../");
			currentPath = StringUtil.subStringByLastMatchChar(path, "/", count+1);
			String pathName = origialPath.substring(origialPath.lastIndexOf("../")+3,origialPath.length());
			return currentPath + "/"+ pathName;
		}
	}
}
