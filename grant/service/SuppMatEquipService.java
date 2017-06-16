package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;
import gov.nysed.oce.ldgrants.grants.grant.dao.SuppMatEquipDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.SuppMatEquip;
import gov.nysed.oce.ldgrants.user.domain.User;

public class SuppMatEquipService implements GenericDaoService<SuppMatEquip,Long> {

	
	SuppMatEquipDao dao = new SuppMatEquipDao();
	@Override
	public Long insert(SuppMatEquip t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(SuppMatEquip t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public SuppMatEquip select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<SuppMatEquip> selectAll() {
		
		return dao.selectAll();
	}

	
}
