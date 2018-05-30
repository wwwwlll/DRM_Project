package com.wj.drm.Service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	public String fileUpload(MultipartHttpServletRequest request) throws Exception;
	public String fileDownload(String path) throws Exception;
}
