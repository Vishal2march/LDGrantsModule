package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.PanelGrant;
import gov.nysed.oce.ldgrants.user.domain.User;

public class PanelGrantDao extends GenericDao<PanelGrant,Long> {

	@Override
	public PanelGrant select(Long id) {
		String sql = "  SELECT RECOMMENDATION, " +
				"       RAO_COMMENTS, " +
				"       RAO_CHANGES, " +
				"       PANEL_NOTES, " +
				"       MODIFIED_BY, " +
				"       JUSTIFICATION, " +
				"       DECISION_NOTES, " +
				"       CREATED_BY, " +
				"       RECOMMEND_AMT, " +
				"       PAN_ID, " +
				"       GRA_ID, " +
				"       FINAL_SCORE, " +
				"       BONUS_POINTS, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM PANEL_GRANTS " +
				"       WHERE ID = ?"; 
		
		try{
			PanelGrant panelRecords = (PanelGrant) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<PanelGrant>(PanelGrant.class));
				
				return panelRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}

		return null;
	}

	@Override
	public List<PanelGrant> selectAll() {
		
		String sql = "  SELECT RECOMMENDATION, " +
				"       RAO_COMMENTS, " +
				"       RAO_CHANGES, " +
				"       PANEL_NOTES, " +
				"       MODIFIED_BY, " +
				"       JUSTIFICATION, " +
				"       DECISION_NOTES, " +
				"       CREATED_BY, " +
				"       RECOMMEND_AMT, " +
				"       PAN_ID, " +
				"       ID, " +
				"       GRA_ID, " +
				"       FINAL_SCORE, " +
				"       BONUS_POINTS, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM PANEL_GRANTS " ;
		
		try{
			ArrayList<PanelGrant> list = (ArrayList<PanelGrant>) jt.query(sql,
					new BeanPropertyRowMapper<PanelGrant>(PanelGrant.class));

			return list;
			
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}
	@Override
	public Long insert(PanelGrant pgrant, User user) {
		
		String sql = "INSERT INTO PANEL_GRANTS (ID, " +
				"                          RECOMMENDATION, " +
				"                          RAO_COMMENTS, " +
				"                          RAO_CHANGES, " +
				"                          PANEL_NOTES, " +
				"                          JUSTIFICATION, " +
				"                          DECISION_NOTES, " +
				"                          CREATED_BY, " +
				"                          RECOMMEND_AMT, " +
				"                          PAN_ID, " +
				"                          GRA_ID, " +
				"                          FINAL_SCORE, " +
				"                          BONUS_POINTS, " +
				"                          DATE_CREATED) " +
				"     VALUES (?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE) " ;

		try{
			Long pk  = getNextId("pg_seq");
			
			 int rowAdd = jt.update(sql, new Object[] { pk,pgrant.getRecommendation(),pgrant.getRaoComments(),
					 pgrant.getRaoChanges(),pgrant.getPanelNotes(),pgrant.getJustification(),
					 pgrant.getDecisionNotes(),user.getCreatedBy(),pgrant.getRecommendAmt(),
					 pgrant.getPanId(),pgrant.getGraId(),pgrant.getFinalScore(),pgrant.getBonusPoints()});
			 
			 if(rowAdd == 1 ){
				 System.out.println("1 row added");
				 return pk;
			}
			 else{
				 return null;
			 }	 
				}catch (Exception e) {
					System.err.println("error insert() " + e.toString());
				}	
		return null;
	}

	@Override
	public Long update(PanelGrant pgrant, User user) {
		String sql = "  UPDATE PANEL_GRANTS " +
				"       SET RECOMMENDATION = 'F', " +
				"       RAO_COMMENTS = 'COMMENTS', " +
				"       RAO_CHANGES = 'C', " +
				"       PANEL_NOTES = 'NOTES', " +
				"       JUSTIFICATION = 'J', " +
				"       DECISION_NOTES = 'DNOTES', " +
				"       MODIFIED_BY = 'VA', " +
				"       RECOMMEND_AMT = 2587, " +
				"       PAN_ID = 28, " +
				"       GRA_ID = 966, " +
				"       FINAL_SCORE = 72, " +
				"       BONUS_POINTS = 0, " +
				"       DATE_MODIFIED = SYSDATE " +
				"       WHERE ID = ? " ;			

				try{
					  int rows = jt.update(sql, new Object[] {pgrant.getRecommendation(),pgrant.getRaoComments(),
								 pgrant.getRaoChanges(),pgrant.getPanelNotes(),pgrant.getJustification(),
								 pgrant.getDecisionNotes(),user.getModifiedBy(),pgrant.getRecommendAmt(),
								 pgrant.getPanId(),pgrant.getGraId(),pgrant.getFinalScore(),pgrant.getBonusPoints(),
								 pgrant.getId()});
				
				if(rows == 1){
					  System.out.println("1 row updated");
						 return (long) rows;
				  }
					} catch (Exception e)
						{
						System.err.println("error update() " + e.toString());
						}
		return null;
	}

	@Override
	public boolean delete(Long id) {
		
		String sql = "DELETE FROM PANEL_GRANTS WHERE id=?";		
		try {
			
			int rows = jt.update(sql, new Object[] { id });
			
			return (rows == 1);
		}
		catch (Exception e) 
		{
			e.getMessage();
		}
		return false;
	}

}
