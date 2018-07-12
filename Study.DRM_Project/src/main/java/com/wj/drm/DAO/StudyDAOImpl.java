package com.wj.drm.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wj.drm.DTO.FileListDTO;
import com.wj.drm.DTO.UsersDTO;

@Repository
public class StudyDAOImpl implements StudyDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public int insertFile(FileListDTO fileListDTO) {
		return sqlSession.insert("INSERT_FILE", fileListDTO);
	}

	@Override
	public List<FileListDTO> selectFileList_RecentUpload_10() {
		return sqlSession.selectList("selectFileList_RecentUpload_10");
	}
	@Override
	public int INSERT_USERS(UsersDTO usersDTO) {
		return sqlSession.insert("INSERT_USERS",usersDTO);
	}

	@Override
	public UsersDTO SELECT_USERS_ONLY_ID(String userId) {
		return sqlSession.selectOne("SELECT_USERS_ONLY_ID",userId);
	}

	@Override
	public UsersDTO SELECT_USERS_ID_WITH_PWD(UsersDTO usersDTO) {
		return sqlSession.selectOne("SELECT_USERS_ID_WITH_PWD",usersDTO);
	}

	@Override
	public int UPDATE_ACCESSKEY(UsersDTO usersDTO) {
		return sqlSession.update("UPDATE_ACCESSKEY",usersDTO);
	}
	@Override
	public String test(String sql) {
		System.out.println(sqlSession.selectMap("dynamicTest", sql).toString());
		return null;
	}
	
}
