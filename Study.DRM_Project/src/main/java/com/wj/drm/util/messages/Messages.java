package com.wj.drm.util.messages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Messages {
	@Value("${msg.test}")
	private String testMsg;

	public String getTestMsg() {
		return this.testMsg;
	}
	
}
