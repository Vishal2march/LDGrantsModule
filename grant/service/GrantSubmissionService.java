package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;
import gov.nysed.oce.ldgrants.grants.grant.dao.GrantSubmissionDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.GrantSubmission;
import gov.nysed.oce.ldgrants.user.domain.User;

public class GrantSubmissionService implements GenericDaoService<GrantSubmission,Long> {

	GrantSubmissionDao dao = new GrantSubmissionDao();
	
	@Override
	public Long insert(GrantSubmission t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(GrantSubmission t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
	
		return dao.delete(id);
	}

	@Override
	public GrantSubmission select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<GrantSubmission> selectAll() {
		
		return dao.selectAll();
	}
}
