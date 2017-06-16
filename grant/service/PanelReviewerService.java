package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;

import gov.nysed.oce.ldgrants.grants.grant.dao.PanelReviewerDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.PanelReviewer;
import gov.nysed.oce.ldgrants.user.domain.User;

public class PanelReviewerService implements GenericDaoService<PanelReviewer,Long> {

	PanelReviewerDao dao = new PanelReviewerDao();
	
	@Override
	public Long insert(PanelReviewer t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(PanelReviewer t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
	
		return dao.delete(id);
	}

	@Override
	public PanelReviewer select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<PanelReviewer> selectAll() {
		
		return dao.selectAll();
	}

}
