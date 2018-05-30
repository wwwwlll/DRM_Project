
package com.wj.drm.DAO;

import java.util.ArrayList;
import java.util.List;

import com.wj.drm.DTO.FileListDTO;

public interface StudyDAO {
	/**
	 * 2018. 5. 14. JCONE_WONJAE ?‘?„±.
	 *
	 * ?—…ë¡œë“œ ?ŒŒ?¼ ?°?´?„° db ???¥
	 * 
	 * @param fileListDTO
	 * @return
	 * 
	 */
	public int insertFile(FileListDTO fileListDTO);

	public List<FileListDTO> selectFileList_RecentUpload_10();

}
