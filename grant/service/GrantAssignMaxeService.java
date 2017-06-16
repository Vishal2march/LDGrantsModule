package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;

import gov.nysed.oce.ldgrants.grants.grant.dao.GrantAssignMaxeDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.GrantAssignMax;
import gov.nysed.oce.ldgrants.user.domain.User;

public class GrantAssignMaxeService implements GenericDaoService<GrantAssignMax,Long> {

	GrantAssignMaxeDao dao = new GrantAssignMaxeDao();
	
	@Override
	public Long insert(GrantAssignMax t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(GrantAssignMax t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public GrantAssignMax select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<GrantAssignMax> selectAll() {
		
		return dao.selectAll();
	}

}
