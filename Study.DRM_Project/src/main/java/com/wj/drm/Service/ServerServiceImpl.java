package com.wj.drm.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.wj.drm.DTO.FileListDTO;
import com.wj.drm.DAO.StudyDAO;
@Service
public class ServerServiceImpl implements ServerService{
	public final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudyDAO studyDAO;
	
	
	@Override
	public ModelAndView setMainPageData(ModelAndView mav) {
		mav.setViewName("mainPageJsp");
		List<FileListDTO> fileList = new ArrayList<FileListDTO>();
		try {
			fileList = studyDAO.selectFileList_RecentUpload_10();
			if(fileList == null) {
				LOGGER.error("fileList is null");
			}
		}catch (Exception e) {
			LOGGER.error("filestList 데이터를 불러오는데 실패했습니다.",e);
		}
		
		mav.addObject("recentFileList",fileList);
		
		return mav;
	}

}
