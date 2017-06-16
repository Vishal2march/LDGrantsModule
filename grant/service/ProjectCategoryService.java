package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.ArrayList;

import gov.nysed.oce.ldgrants.grants.grant.dao.ProjectCategoryDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.ProjectCategory;

public class ProjectCategoryService {

	ProjectCategoryDao dao = new ProjectCategoryDao();

	public ProjectCategory selectProjectId(Long id) {

		return dao.select(id);

	}

	public ArrayList<ProjectCategory> selectProjectDescr(String Descr) {

		return dao.searchProjectCategoryByDescr("Descr");
	}
}
