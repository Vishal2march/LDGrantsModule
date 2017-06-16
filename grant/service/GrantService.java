package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.ArrayList;
import java.util.List;

import gov.nysed.oce.ldgrants.grants.grant.dao.GrantDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.Grant;
import gov.nysed.oce.ldgrants.user.domain.User;

public class GrantService implements GenericDaoService<Grant, Long> {

	GrantDao grantDao = new GrantDao();

	public ArrayList<Grant> searchByName(String Name) {

		return grantDao.searchGrantByName("Name");
	}

	@Override
	public Long insert(Grant t, User user) {

		return grantDao.insert(t, user);
	}

	@Override
	public Long update(Grant t, User user) {

		return grantDao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {

		return grantDao.delete(id);
	}

	@Override
	public Grant select(Long id) {

		return grantDao.select(id);
	}

	@Override
	public List<Grant> selectAll() {

		return null;
	}
}
