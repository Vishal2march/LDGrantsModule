package gov.nysed.oce.ldgrants.grants.common.dao;

public class NarrativeDao implements NarrativeDaoInt {

	
	public boolean deleteNarrativeRecord(Long grantid, Long narrTypeId) {
		int rows = 0;
		String update = "DELETE FROM Project_Narratives WHERE gra_id =? AND nat_id = ? ";
		try {
			rows = jt.update(update, new Object[] { grantid, narrTypeId });
		} catch (Exception ex) {
			rows = 0;
			System.err.println("error deleteNarrativeRecord() " + ex.toString());
		} finally {
		}
		return (rows == 1);
	}

	
	public boolean updateNarrative(String narrative, String userId, Long grantId, Long narrativeTypeId) {
		int rows = 0;
		String update = " update PROJECT_NARRATIVES set NARRATIVE_DESCR = ?, "
				+ " MODIFIED_BY=?, DATE_MODIFIED=SYSDATE where GRA_ID = ? and NAT_ID = ?";
		try {
			rows = jt.update(update, new Object[] { narrative, userId, grantId, narrativeTypeId });
		} catch (Exception ex) {
			rows = 0;
			System.err.println("error updateNarrative() " + ex.toString());
		} finally {
		}
		return (rows == 1);
	}

	
	public int insertNarrative(String userid, Long grantId, Long narrativeTypeId) {
		int rows = 0;
		String update = "insert into project_narratives(ID, GRA_ID, NARRATIVE_DESCR, NAT_ID, "
				+ " DATE_CREATED, CREATED_BY) VALUES (proj_narrative_seq.nextval, ?, "
				+ " EMPTY_CLOB(), ?, SYSDATE, ?) ";
		try {
			rows = jt.update(update, new Object[] { grantId, narrativeTypeId, userid });
		} catch (Exception ex) {
			rows = 0;
			System.err.println("error insertNarrative() " + ex.toString());
		} finally {
		}

		return rows;
	}

}
