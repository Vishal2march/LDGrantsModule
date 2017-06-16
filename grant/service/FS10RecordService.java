package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;
import gov.nysed.oce.ldgrants.grants.grant.dao.FS10RecordDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.FS10Record;
import gov.nysed.oce.ldgrants.user.domain.User;

public class FS10RecordService implements GenericDaoService<FS10Record,Long>

{
	FS10RecordDao dao = new FS10RecordDao();
	
	@Override
	public Long insert(FS10Record t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(FS10Record t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public FS10Record select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<FS10Record> selectAll() {
		
		return dao.selectAll();
	}

}
