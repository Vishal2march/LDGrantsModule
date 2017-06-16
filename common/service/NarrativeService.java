package gov.nysed.oce.ldgrants.grants.common.service;

import gov.nysed.oce.ldgrants.grants.common.dao.NarrativeDao;
import gov.nysed.oce.ldgrants.grants.common.domain.Grant;
import gov.nysed.oce.ldgrants.grants.common.domain.ProjectNarrative;
import gov.nysed.oce.ldgrants.user.domain.User;
import mypackage.CoversheetBean;
import mypackage.DescriptionBean;
import mypackage.UserBean;

public class NarrativeService {

	
	private NarrativeDao narrativeDao = new NarrativeDao();
	
	public void insertNarrative(User user, Grant grant, ProjectNarrative projectNarrative){
		narrativeDao.insertNarrative(user.getUserId(), grant.getId(), projectNarrative.getNarrativeTypeId());
	}

	public void updateNarrative(ProjectNarrative narrative, User user, Grant grant) {
		narrativeDao.updateNarrative(narrative.getNarrative(), user.getUserId(), grant.getId(),
				narrative.getNarrativeTypeId());
	}
	
	
	public void deleteNarrative(Grant grant, ProjectNarrative projectNarrative){
		narrativeDao.deleteNarrativeRecord(grant.getId(), projectNarrative.getNarrativeTypeId());
	}

	/**
	 * @deprecated use public void
	 *             updateNarrative(ProjectNarrative narrative, User user, Grant
	 *             grant) where possible
	 * @param cb
	 * @param user
	 * @param grantid
	 */
	@Deprecated
	public void updateNarrative(CoversheetBean cb, UserBean user, long grantid) {
		narrativeDao.updateNarrative(cb.getSummaryDesc(), user.getUserid(), grantid, ((long) cb.getNarrTypeId()));
	}

	/**
	 * @deprecated use public void
	 *             updateNarrative(ProjectNarrative narrative, User user, Grant
	 *             grant) where possible
	 * @param user
	 * @param grantid
	 * @param pdb
	 */
	@Deprecated
	public void updateNarrative(UserBean user, long grantid, DescriptionBean pdb) {
		narrativeDao.updateNarrative(pdb.getNarrative(), user.getUserid(), grantid, (long) pdb.getNarrTypeID());
	}

	/**
	 * @deprecated legacy version, please use public void
	 *             updateNarrative(ProjectNarrative narrative, User user, Grant
	 *             grant) where possible
	 * @param userBean
	 * @param grantId
	 * @param narrTypeId
	 * @param narrative
	 */
	@Deprecated
	public void updateNarrative(UserBean userBean, long grantId, int narrTypeId, String narrative) {
		narrativeDao.updateNarrative(narrative, userBean.getUserid(), grantId, (long) narrTypeId);
	}

	/**
	 * @deprecated use insertNarrative(User user, Grant grant, ProjectNarrative projectNarrative)
	 * @return
	 * @param narrTypeID
	 * @param userb
	 * @param grantid
	 */
	@Deprecated
	public void insertNarrativeRecord(UserBean user, long grantId, int narrTypeID) {
		narrativeDao.insertNarrative(user.getUserid(), grantId, (long) narrTypeID);
	}


	/**
	 * @deprecated  use deleteNarrative(Grant grant, ProjectNarrative projectNarrative)
	 * @param grantid
	 * @param narrTypeId
	 */
	@Deprecated
	public void deleteNarrative(Long grantid, Long narrTypeId) {
		narrativeDao.deleteNarrativeRecord(grantid, narrTypeId);
	}

}
