package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import gov.nysed.oce.ldgrants.grants.grant.domain.Approval;
import gov.nysed.oce.ldgrants.grants.grant.domain.SystemFiscalYearDetail;
import gov.nysed.oce.ldgrants.user.domain.User;

public class ApprovalDao extends GenericDao<Approval, Long> {

	@Override
	public Approval select(Long id) {
		
		String sql = "  SELECT AMOUNT_DECLINE, " +
				"       FMT_ID, " +
				"       FY_FY_CODE, " +
				"       GRA_ID, " +
				"       ADMIN, " +
				"       APPROVAL_TYPE, " +
				"       VERSION, " +
				"       CREATED_BY, " +
				"       MODIFIED_BY, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED, " +
				"       DATE_ACCEPTED " +
				"       FROM APPROVALS " +
				"       WHERE ID = ? "; 
		
		try{
			Approval approvals = (Approval) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<Approval>(Approval.class));
				
				return approvals;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}

		return null;
	}

	@Override
	public List<Approval> selectAll() {
		
		String SQL = "  SELECT ID, " +
				"       AMOUNT_DECLINE, " +
				"       FMT_ID, " +
				"       FY_FY_CODE, " +
				"       GRA_ID, " +
				"       ADMIN, " +
				"       APPROVAL_TYPE, " +
				"       VERSION, " +
				"       CREATED_BY, " +
				"       MODIFIED_BY, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED, " +
				"       DATE_ACCEPTED " +
				"       FROM APPROVALS "; 
		
		try{
			ArrayList<Approval> approvals = (ArrayList<Approval>) jt.query(SQL,
					new BeanPropertyRowMapper<Approval>(Approval.class));

			return approvals;
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}
	
	@Override
	public Long insert(Approval approval, User user) {
		
		String sql = "INSERT INTO APPROVALS (ID, " +
				"                       AMOUNT_DECLINE, " +
				"                       FMT_ID, " +
				"                       FY_FY_CODE, " +
				"                       GRA_ID, " +
				"                       ADMIN, " +
				"                       APPROVAL_TYPE, " +
				"                       VERSION, " +
				"                       CREATED_BY, " +
				"                       DATE_CREATED, " +
				"                       DATE_ACCEPTED) " +
				"     VALUES (?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE, " +
				"             SYSDATE) "; 

		
		try{
			Long pk  = getNextId("APPROVAL_SEQ");
			int rowAdd = jt.update(sql, new Object[] { pk,approval.getAmountDecline(),approval.getFmtId(),
					approval.getFyFyCode(),approval.getGraId(),approval.getAdmin(),approval.getApprovalType(),
					approval.getVersion(),user.getCreatedBy()});
			
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
	public Long update(Approval approval, User user) {
		
		String sql = "  UPDATE APPROVALS " +
				"       SET AMOUNT_DECLINE = ?, " +
				"       FMT_ID = ?, " +
				"       FY_FY_CODE = ?, " +
				"       GRA_ID = ?, " +
				"       ADMIN = ?, " +
				"       APPROVAL_TYPE = ?, " +
				"       VERSION = ?, " +
				"       MODIFIED_BY = ?, " +
				"       DATE_MODIFIED = SYSDATE, " +
				"       DATE_ACCEPTED = SYSDATE " +
				"       WHERE ID = ? "; 

		try{
			  int rows = jt.update(sql, new Object[] {approval.getAmountDecline(),approval.getFmtId(),
						approval.getFyFyCode(),approval.getGraId(),approval.getAdmin(),approval.getApprovalType(),
						approval.getVersion(),user.getModifiedBy(),approval.getId()});
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
		
		String sql = "DELETE FROM APPROVALS WHERE id=?";		
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
