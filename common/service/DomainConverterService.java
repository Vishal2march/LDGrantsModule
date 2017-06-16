package gov.nysed.oce.ldgrants.grants.common.service;

import gov.nysed.oce.ldgrants.grants.common.domain.ProjectNarrative;
import gov.nysed.oce.ldgrants.user.domain.User;
import mypackage.CoversheetBean;
import mypackage.DescriptionBean;
import mypackage.UserBean;

public class DomainConverterService {
	private User user;
	private ProjectNarrative projectNarrative;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User convert(UserBean userBean) {
		user.setUserId(userBean.getUserid());
		return user;
	}

	public ProjectNarrative convert(CoversheetBean cb) {
		projectNarrative.setNarrative(cb.getSummaryDesc());
		projectNarrative.setNarrativeTypeId((long) cb.getNarrTypeId());
		return projectNarrative;
	}
	
	public ProjectNarrative convert(DescriptionBean pdb){
		projectNarrative.setNarrative(pdb.getNarrative());
		projectNarrative.setNarrativeTypeId((long) pdb.getNarrTypeID());
		return projectNarrative;
	}

}
