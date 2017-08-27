package com.shenyang.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.common.io.Files;

/**
 * 文件存储类
 * @author Administrator
 *
 */
public class FileUtil {
	/**
	 * 文件写入
	 * @param str
	 * @param path
	 * @throws IOException
	 */
	public static void writeFile(String str,String path) throws IOException{
		Files.write(str.getBytes(),new File(path));
//		BufferedWriter bufferedWriter = null;
//		bufferedWriter = new BufferedWriter(new FileWriter(path));
//		bufferedWriter.write(str);
//		bufferedWriter.flush();
//		bufferedWriter.close();
	}
	/**
	 * 删除目录下所有文件
	 * @param target
	 */
	public static void deleteAllfile(File file){
		if(!file.exists()){
			return;
		}
		if(file.isFile()){
			file.delete();
		}else{
			File[] files = file.listFiles();
			for(File temp : files){
				deleteAllfile(temp);
			}
			file.delete();
		}
	}
}
