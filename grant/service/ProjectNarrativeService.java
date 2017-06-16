package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.ArrayList;
import java.util.List;

import gov.nysed.oce.ldgrants.grants.grant.dao.ProjectNarrativeDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.ProjectNarrative;
import gov.nysed.oce.ldgrants.user.domain.User;

public class ProjectNarrativeService implements GenericDaoService<ProjectNarrative, Long> {

	ProjectNarrativeDao dao = new ProjectNarrativeDao();

	@Override
	public Long insert(ProjectNarrative t, User user) {

		return dao.insert(t, user);
	}

	@Override
	public Long update(ProjectNarrative t, User user) {

		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {

		return dao.delete(id);
	}

	@Override
	public ProjectNarrative select(Long id) {

		return dao.select(id);
	}

	@Override
	public List<ProjectNarrative> selectAll() {

		return dao.selectAll();
	}

	public ArrayList<ProjectNarrative> searchByGraId(Long graId) {

		return dao.searchByGraId(graId);

	}

}
