package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.PanelReviewerAssign;
import gov.nysed.oce.ldgrants.user.domain.User;

public class PanelReviewerAssignDao extends GenericDao<PanelReviewerAssign,Long> {

	
	@Override
	public PanelReviewerAssign select(Long id) {
		
		String sql =  " SELECT RECOMMEND_AMT, " +
				"       RECOMMENDATION, " +
				"       BONUS_POINTS, " +
				"       RATING_COMPLETE, " +
				"       PR_ID, " +
				"       PG_ID, " +
				"       MODIFIED_BY, " +
				"       CREATED_BY, " +
				"       CONFLICT_INTEREST, " +
				"       FINAL_SCORE, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM PANEL_REVIEWER_ASSIGNS " +
				"       WHERE ID = ? "; 

		try{
			PanelReviewerAssign panelRecords = (PanelReviewerAssign) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<PanelReviewerAssign>(PanelReviewerAssign.class));
				
				return panelRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}
		
		return null;
	}

	@Override
	public List<PanelReviewerAssign> selectAll() {
		
		String sql = "  SELECT RECOMMEND_AMT, " +
				"       RECOMMENDATION, " +
				"       BONUS_POINTS, " +
				"       RATING_COMPLETE, " +
				"       PR_ID, " +
				"       PG_ID, " +
				"       MODIFIED_BY, " +
				"       CREATED_BY, " +
				"       CONFLICT_INTEREST, " +
				"       ID, " +
				"       FINAL_SCORE, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM PANEL_REVIEWER_ASSIGNS ";
		
		try{
			ArrayList<PanelReviewerAssign> list = (ArrayList<PanelReviewerAssign>) jt.query(sql,
					new BeanPropertyRowMapper<PanelReviewerAssign>(PanelReviewerAssign.class));

			return list;
			
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}
		return null;
	}
	
	@Override
	public Long insert(PanelReviewerAssign assign, User user) {
		
		String sql = "INSERT INTO PANEL_REVIEWER_ASSIGNS (ID, " +
				"                                    RECOMMEND_AMT, " +
				"                                    RECOMMENDATION, " +
				"                                    BONUS_POINTS, " +
				"                                    RATING_COMPLETE, " +
				"                                    PR_ID, " +
				"                                    PG_ID, " +
				"                                    CREATED_BY, " +
				"                                    CONFLICT_INTEREST, " +
				"                                    FINAL_SCORE, " +
				"                                    DATE_CREATED) " +
				"     VALUES (PRA_SEQ.NEXTVAL, " +
				"             0, " +
				"             'M', " +
				"             0, " +
				"             1, " +
				"             13, " +
				"             20, " +
				"             'VA', " +
				"             'Y', " +
				"             0, " +
				"             SYSDATE) " ;	
		
		try{
			Long pk  = getNextId("PRA_SEQ");
			int rowAdd = jt.update(sql, new Object[] { pk,assign.getRecommendAmt(),assign.getRecommendation(),
					assign.getBonusPoints(),assign.getRatingComplete(),assign.getPrId(),assign.getPgId(),
					user.getCreatedBy(),assign.getConflictInterest(),assign.getFinalScore()});
			
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
	public Long update(PanelReviewerAssign assign, User user) {
		
		String sql = "  UPDATE PANEL_REVIEWER_ASSIGNS " +
				"       SET RECOMMEND_AMT = ?, " +
				"       RECOMMENDATION = ?, " +
				"       BONUS_POINTS = ?, " +
				"       RATING_COMPLETE = ?, " +
				"       PR_ID = ?, " +
				"       PG_ID = ?, " +
				"       MODIFIED_BY = ?, " +
				"       CONFLICT_INTEREST = ?, " +
				"       FINAL_SCORE = ?, " +
				"       DATE_MODIFIED = SYSDATE " +
				"       WHERE ID = ? " ;
		

		try{
			  int rows = jt.update(sql, new Object[] {assign.getRecommendAmt(),assign.getRecommendation(),
					  assign.getBonusPoints(),assign.getRatingComplete(),assign.getPrId(),assign.getPgId(),
					  user.getModifiedBy(),assign.getConflictInterest(),assign.getFinalScore(),assign.getId()});
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
		
		String sql = "DELETE FROM PANEL_REVIEWER_ASSIGNS WHERE id=?";		
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
