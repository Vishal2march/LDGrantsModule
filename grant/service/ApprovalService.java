package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;

import gov.nysed.oce.ldgrants.grants.grant.dao.ApprovalDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.Approval;
import gov.nysed.oce.ldgrants.user.domain.User;

public class ApprovalService implements GenericDaoService<Approval,Long> {

	ApprovalDao dao = new ApprovalDao();
	
	@Override
	public Long insert(Approval t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(Approval t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public Approval select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<Approval> selectAll() {
		
		return dao.selectAll();
	}

}
