package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;
import gov.nysed.oce.ldgrants.grants.grant.dao.ProjectStatisticDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.ProjectStatistic;
import gov.nysed.oce.ldgrants.user.domain.User;

public class ProjectStatisticService implements GenericDaoService <ProjectStatistic,Long>{

	ProjectStatisticDao dao = new ProjectStatisticDao();
	
	@Override
	public Long insert(ProjectStatistic t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(ProjectStatistic t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public ProjectStatistic select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<ProjectStatistic> selectAll() {
		
		return dao.selectAll();
	}
}
