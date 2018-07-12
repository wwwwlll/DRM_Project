
package com.wj.drm.DAO;

import java.util.ArrayList;
import java.util.List;

import com.wj.drm.DTO.FileListDTO;
import com.wj.drm.DTO.UsersDTO;

public interface StudyDAO {
	/**
	 * 2018. 5. 14. JCONE_WONJAE ?��?��.
	 *
	 * ?��로드 ?��?�� ?��?��?�� db ???��
	 * 
	 * @param fileListDTO
	 * @return
	 * 
	 */
	public int insertFile(FileListDTO fileListDTO);

	public List<FileListDTO> selectFileList_RecentUpload_10();

	public int INSERT_USERS(UsersDTO usersDTO);
	
	public UsersDTO SELECT_USERS_ONLY_ID(String userId);
	
	public UsersDTO SELECT_USERS_ID_WITH_PWD(UsersDTO usersDTO);

	public int UPDATE_ACCESSKEY(UsersDTO usersDTO);
	public String test(String sql);
}
