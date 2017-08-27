package com.shenyang.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;

public class StringUtil {
	/**
	 * 取出字符串中的所有路径
	 * @param str
	 * @return
	 */
	public static List<String> pathList (String str){
		List<String>list = Lists.newArrayList();
		String regex = "(src|href).+?\"(.+?)\""; 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()){
			list.add(matcher.group(2));
		}
		return list;
	}
	/**
	 * 获取一个字符串在另一个字符串中出现的次数
	 * @param from
	 * @param match
	 * @return
	 */
	public static int getCountFromString(String from,String match){
		int count = 0;
		for(int index=from.indexOf(match);;index=from.indexOf(match)){
			if(index==-1){
				break;
			}
			count++;
			from = from.substring(index+match.length(), from.length()-1);
		}
		return count;
	}
	/**
	 * 截取字符串，以第count个匹配字符结尾
	 * @param orginalStr
	 * @param match
	 * @param count
	 */
	public static String subStringByLastMatchChar(String orginalStr,String match,int count){
		for(int i=0;i<count;i++){
			int index = orginalStr.lastIndexOf(match);
			if(index==-1)break;
			orginalStr = orginalStr.substring(0,index);
		}
		return orginalStr;
	}
}
