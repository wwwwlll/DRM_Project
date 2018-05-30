package com.wj.drm.DTO;

import java.util.Date;

import com.wj.drm.util.CommonUtil;

public class FileListDTO {

	String IDX;
	String fileName;
	String uploadDate;
	String path;
	public String getIDX() {
		return IDX;
	}
	public void setIDX() {
		IDX = new CommonUtil().getUuid().substring(0, 16);
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "fileListDTO [IDX=" + IDX + ", fileName=" + fileName + ", uploadDate=" + uploadDate + ", path=" + path
				+ "]";
	}
	
	
	
}
