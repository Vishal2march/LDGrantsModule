package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.ArrayList;
import java.util.List;

import gov.nysed.oce.ldgrants.grants.grant.dao.PanelDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.Panel;
import gov.nysed.oce.ldgrants.user.domain.User;

public class PanelService implements GenericDaoService<Panel,Long> {

	PanelDao dao = new PanelDao();
	
	@Override
	public Long insert(Panel t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(Panel t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public Panel select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<Panel> selectAll() {
		
		return dao.selectAll();
	}
	
	public ArrayList<Panel> searchByFyCode(Long fyCode){
		return dao.searchByFyCode(fyCode);
	}

}
