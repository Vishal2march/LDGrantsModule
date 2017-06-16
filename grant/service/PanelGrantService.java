package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;
import gov.nysed.oce.ldgrants.grants.grant.dao.PanelGrantDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.PanelGrant;
import gov.nysed.oce.ldgrants.user.domain.User;

public class PanelGrantService implements GenericDaoService<PanelGrant,Long> {

	PanelGrantDao dao = new PanelGrantDao();
	@Override
	public Long insert(PanelGrant t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(PanelGrant t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public PanelGrant select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<PanelGrant> selectAll() {
		
		return dao.selectAll();
	}

}
