package com.ets.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ets.service.IFileService;
import com.ets.util.FTPUtil;
import com.google.common.collect.Lists;

@Service("fileService")
public class FileServiceImpl implements IFileService {
	private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
	public String upload(MultipartFile file,String path){
		String fileName = file.getOriginalFilename();
		//扩展名
		String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		String uoloadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
		logger.info("开始上传文件，上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uoloadFileName);
		
		File fileDir = new File(path);
		if(!fileDir.exists()){
			fileDir.setWritable(true);
			fileDir.mkdirs();
		}
		File targetFile = new File(path,uoloadFileName);
		
		try {
			file.transferTo(targetFile);
			
			FTPUtil.uploadFile(Lists.newArrayList(targetFile));
			
			targetFile.delete();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("上传文件异常",e);
			return null;
		}
		return targetFile.getName();
	}
	
}
