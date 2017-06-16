package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.ArrayList;
import java.util.List;

import gov.nysed.oce.ldgrants.grants.grant.dao.UploadDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.Upload;
import gov.nysed.oce.ldgrants.user.domain.User;

public class UploadService implements GenericDaoService<Upload, Long> {

	
	UploadDao dao = new UploadDao();
	
	@Override
	public Long insert(Upload t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(Upload t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
	
		return dao.delete(id);
	}

	@Override
	public Upload select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<Upload> selectAll() {
		
		return dao.selectAll();
	}
	
	public ArrayList<Upload> searchByMimeType(String mimeType){
		
		return dao.searchByMimeType(mimeType);
	}

}
