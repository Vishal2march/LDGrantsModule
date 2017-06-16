package gov.nysed.oce.ldgrants.grants.common.dao;

import gov.nysed.oce.ldgrants.shared.dao.common.DatabaseConnectionInt;

public interface NarrativeDaoInt extends DatabaseConnectionInt {

	public int insertNarrative(String userid, Long grantId, Long narrativeTypeId);

	public boolean deleteNarrativeRecord(Long grantid, Long narrTypeId);

	public boolean updateNarrative(String narrative, String userId, Long grantId, Long narrativeTypeId);

}
