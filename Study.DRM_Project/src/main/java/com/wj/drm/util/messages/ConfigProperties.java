package com.wj.drm.util.messages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigProperties {
	@Value("${docFile.Path}")
	private String docFile_Path;

	public String getDocFile_Path() {
		return this.docFile_Path;
	}
	
}
