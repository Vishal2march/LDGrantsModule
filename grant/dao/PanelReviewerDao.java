package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.PanelReviewer;
import gov.nysed.oce.ldgrants.user.domain.User;

public class PanelReviewerDao extends GenericDao<PanelReviewer,Long> {

	@Override
	public PanelReviewer select(Long id) {
		
		String sql = "  SELECT MODIFIED_BY, " +
				"       CREATED_BY, " +
				"       PAN_ID, " +
				"       REV_ID, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM PANEL_REVIEWERS " +
				"       WHERE ID = ? " ;

		try{
			PanelReviewer panelRecords = (PanelReviewer) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<PanelReviewer>(PanelReviewer.class));
				
				return panelRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}
		return null;
	}

	@Override
	public List<PanelReviewer> selectAll() {
		
		String sql = "  SELECT MODIFIED_BY, " +
				"       CREATED_BY, " +
				"       ID, " +
				"       PAN_ID, " +
				"       REV_ID, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM PANEL_REVIEWERS "; 

		try{
			ArrayList<PanelReviewer> list = (ArrayList<PanelReviewer>) jt.query(sql,
					new BeanPropertyRowMapper<PanelReviewer>(PanelReviewer.class));

			return list;
			
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}
		return null;
	}
	
	@Override
	public Long insert(PanelReviewer review, User user) {
		
		String sql = "INSERT INTO PANEL_REVIEWERS (ID, " +
				"                             CREATED_BY, " +
				"                             PAN_ID, " +
				"                             REV_ID, " +
				"                             DATE_CREATED) " +
				"     VALUES (?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE) "; 

				
		try{
			Long pk  = getNextId("pr_seq");
			int rowAdd = jt.update(sql, new Object[] { pk,user.getCreatedBy(),
					review.getPanId(),review.getRevId()});
			
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
	public Long update(PanelReviewer review, User user) {
		
		String sql = "  UPDATE PANEL_REVIEWERS " +
				"       SET MODIFIED_BY = ?, " +
				"       PAN_ID = ?, " +
				"       REV_ID = ?, " +
				"       DATE_MODIFIED = SYSDATE " +
				"       WHERE ID = ? "; 
		

		try{
			  int rows = jt.update(sql, new Object[] {user.getCreatedBy(),review.getPanId(),review.getRevId(),
					  review.getId()});
			  
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
		
		String sql = "DELETE FROM PANEL_REVIEWERS WHERE id=?";		
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
