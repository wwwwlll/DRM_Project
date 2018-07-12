package com.wj.drm.Service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wj.drm.DTO.FileListDTO;
import com.wj.drm.util.CommonUtil;
import com.wj.drm.util.encrypt.EncryptUtil;
import com.wj.drm.util.messages.ConfigProperties;
import com.wj.drm.DAO.StudyDAO;


@Service
public class FileServiceImpl implements FileService {
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	CommonUtil commonUtil = new CommonUtil();
	
	@Autowired
	ConfigProperties configProperties;
	@Autowired
	StudyDAO studyDAO;
	
	
	@Override
	public String fileUpload(MultipartHttpServletRequest request) throws Exception{		
		MultipartFile multipartFile = request.getFile("docFile");
		String fileName;
		String orgFileName;
		try {
			orgFileName = new String(multipartFile.getOriginalFilename().getBytes("8859_1"),"UTF-8");
			String datePath = commonUtil.getDatePath_STR();
//			File file = new File(multipartFile.getOriginalFilename()); 
//			multipartFile.transferTo(file); 
			String ext = orgFileName.substring(orgFileName.lastIndexOf("."));
			LOGGER.info("org file Name = {}",orgFileName);
			fileName = commonUtil.getUuid();
			LOGGER.info("new File Name = {}",fileName);
			String path = "";
			path += configProperties.getDocFile_Path();
			path += datePath+"/";
			path += fileName+"/encrypt/";
			commonUtil.makeFolder(path);
			String fullPath = path+fileName+ext;
			LOGGER.info("FILE FULL PATH : {}",path);
			File encFile = new File(fullPath);
			EncryptUtil encryptUtil = new EncryptUtil();
			File orgFile = new File(multipartFile.getOriginalFilename());
//			multipartFile.transferTo(orgFile);
			encryptUtil.encryptFile(orgFile, encFile);
			
			try {
				LOGGER.info("insert File");
				FileListDTO fileListDTO = new FileListDTO();
				fileListDTO.setIDX();
				fileListDTO.setFileName(orgFileName);
				fileListDTO.setPath(fullPath);
				fileListDTO.setUploadDate(datePath);
				LOGGER.info(fileListDTO.toString());
				LOGGER.info(fileListDTO.getPath().length()+"/length");
				studyDAO.insertFile(fileListDTO);
				return fullPath;
			} catch (Exception e2) {
				LOGGER.error("db에 데이터를 입력하던 중 에러가 발생했습니다.",e2);
			}
		} catch (Exception e) {
			LOGGER.error("encrypt File Fail",e);
		}
		return "fail";
	}
	@Override
	public String fileDownload(String path) throws Exception {
		
		LOGGER.info("path = "+path);
		try {
			EncryptUtil encryptUtil = new EncryptUtil();
			encryptUtil.decryptFile(new File(path),new File(path.replace("encrypt", "decrypt")));
			return "success";
			}catch (Exception e) {
			LOGGER.error("fileDownload fail",e);
		}
		return "fail";
	}
	
}
