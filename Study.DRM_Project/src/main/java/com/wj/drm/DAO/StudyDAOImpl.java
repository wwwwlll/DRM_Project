package com.wj.drm.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wj.drm.DTO.FileListDTO;

@Repository
public class StudyDAOImpl implements StudyDAO{
	@Autowired
	SqlSessionTemplate sqlSession;

@Override
	public int insertFile(FileListDTO fileListDTO) {
	return sqlSession.insert("INSERT_FILE",fileListDTO);
	}

@Override
public List<FileListDTO> selectFileList_RecentUpload_10() {
	return sqlSession.selectList("selectFileList_RecentUpload_10");
}	
	
}
