package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;
import gov.nysed.oce.ldgrants.grants.grant.dao.PanelReviewerAssignDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.PanelReviewerAssign;
import gov.nysed.oce.ldgrants.user.domain.User;

public class PanelReviewerAssignService implements GenericDaoService <PanelReviewerAssign,Long> {

	PanelReviewerAssignDao dao = new PanelReviewerAssignDao();
	
	@Override
	public Long insert(PanelReviewerAssign t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(PanelReviewerAssign t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public PanelReviewerAssign select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<PanelReviewerAssign> selectAll() {
		
		return dao.selectAll();
	}

}
