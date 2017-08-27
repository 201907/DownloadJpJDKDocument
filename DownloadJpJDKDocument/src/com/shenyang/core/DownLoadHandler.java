package com.shenyang.core;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.shenyang.utils.FileUtil;
import com.shenyang.utils.HTMLUtil;
import com.shenyang.utils.StringUtil;

public class DownLoadHandler {
	private final String host = "https://docs.oracle.com/javase/jp/8/docs/api";
	private String target;
	
	public DownLoadHandler(String target) {
		super();
		this.target = target;
	}

	public void handler(String filename){
		if(filename.indexOf(host)!=-1){
			filename = filename.substring(host.length(),filename.length());
		}
		String path = host+filename;
		String targetName = target+filename;
		if(filename.indexOf("http")!=-1){
			return;
		}
		File targetFile = new File(targetName);
		if(targetFile.exists())return;
		try {
			System.out.println("正在下载："+path+"-->至-->"+ targetName);
			String result = HTMLUtil.getHTML(path);
			List<String> linkList = StringUtil.pathList(result);
			File dir = new File(targetName.substring(0,targetName.lastIndexOf("/")));
			if(!dir.exists()){
				dir.mkdirs();
			}
			FileUtil.writeFile(result, targetName);
			for(String link:linkList){
				if(link.contains("javascript")||link.contains("#")||link.contains("?")||link.equals("script"))continue;
				link=HTMLUtil.getCurrentPath(link, path);
				handler(link);
			}
		} catch (IOException e) {
//			FileUtil.deleteAllfile(new File(target));
			e.printStackTrace();
		}
		
	}

}
