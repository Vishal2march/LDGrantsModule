package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import gov.nysed.oce.ldgrants.grants.grant.domain.Grant;
import gov.nysed.oce.ldgrants.user.domain.User;

public class GrantDao extends GenericDao<Grant, Long> {

	public GrantDao() {
	}

	public ArrayList<Grant> searchGrantByName(String name) {
		//@formatter:off	
			String sql = "  SELECT NAME AS name, " +
					"       ID AS id, " +
					"       CREATED_BY AS createdBy, " +
					"       DATE_CREATED AS dateCreated, " +
					"       FC_CODE AS fcCode, " +
					"       FY_CODE AS fyCode, " +
					"       PRM_ID AS prmId, " +
					"       LOCK_APP AS lockApp " +
					"       FROM GRANTS " +
					"       WHERE UPPER (name) LIKE UPPER (?) " ;

			try{
			List<Grant> names = jt.query(sql, new Object[] { '%' + name + '%' },
					new BeanPropertyRowMapper<Grant>(Grant.class));

			if (names.size() > 0) {
				return (ArrayList<Grant>) names;
			} else
			{
				System.out.println("Getting no results");
				return null;
			}			
		}
		catch (Exception e) 
		{
			System.err.println("error searchByName() " + e.toString());
		}
		
		return null;		
	}

	@Override
	public Long insert(Grant grant, User user) {

		//@formatter:off
String query = "INSERT INTO GRANTS (ID, " +
		"                    NAME, " +
		"                    DATE_CREATED, " +
		"                    CREATED_BY, " +
		"                    MODIFIED_BY, " +
		"                    FY_CODE, " +
		"                    FC_CODE, " +
		"                    LOCK_APP) " +
		"     VALUES (?, " +
		"             ?, " +
		"             SYSDATE, " +
		"             ?, " +
		"             ?, " +
		"             ?, " +
		"             ?, " +
		"             ?) "; 

		
		try{
			Long pk  = getNextId("GRANTS_SEQ");
			
	 int rowAdd = jt.update(query, new Object[] { pk, grant.getName(), user.getCreatedBy(), user.getModifiedBy(), grant.getFyCode(), grant.getFcCode(), grant.getLockApp() });
		
	 if(rowAdd == 1 ){
		 System.out.println("1 row added");
		 return pk;
	}
	 else{
		 return null;
	 }
	 
		}catch (Exception e) {
			System.err.println("error insertGrant() " + e.toString());
		}
		
		return null;
	}

	@Override
	public Long update(Grant grant, User user) {
		
		int rows=0 ;
		//@formatter:off
		
		String updatesql = "UPDATE GRANTS " +
				"       SET NAME = ?, " +
				"       DATE_MODIFIED = SYSDATE, " +
				"       CREATED_BY = ?, " +
				"       MODIFIED_BY = ? " +
				"       WHERE ID = ?" ; 
		
		try{
  rows = jt.update(updatesql, new Object[] { grant.getName(), user.getCreatedBy(), user.getModifiedBy(), grant.getId()});

  if(rows == 1){
	  System.out.println("1 row updated");
		 return (long) rows;
  }
	} catch (Exception e)
		{
		System.err.println("error updateGrant() " + e.toString());
		}
		return null;
	}

	@Override
	public boolean delete(Long id) {
		
     String sql = "DELETE FROM Grants WHERE id=?";		
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
	@Override
	public Grant select(Long id) {
		
		//@formatter:off
			String sql = "  SELECT ID AS id, " +
					"       NAME AS name, " +
					"       CREATED_BY AS createdBy, " +
					"       DATE_CREATED AS dateCreated, " +
					"       FC_CODE AS fcCode, " +
					"       FY_CODE AS fyCode, " +
					"       PRM_ID AS prmId, " +
					"       LOCK_APP AS lockApp, " +
					"       AMT_APPROVED_YN AS amtApprovedYn, " +
					"       AMT_REQUESTED_YN AS amtRequestedYn, " +
					"       ATTACH_COMP AS attachComp, " +
					"       AUTHORIZED_BY AS authorizedBy, " +
					"       AUTH_COMP AS authComp, " +
					"       AWAITING_APPR AS awaitingAppr, " +
					"       BUDGET_COMP AS budgetComp, " +
					"       CONTRACT_NUM AS contractNum, " +
					"       COVERSHEET_COMP AS coversheetComp, " +
					"       COVERSHEET_YN AS coversheetYn, " +
					"       DATE_MODIFIED AS dateModified, " +
					"       DESCRIPTION_COMP AS descriptionComp, " +
					"       DORIS_FLAG AS dorisFlag, " +
					"       DORIS_NAME AS dorisName, " +
					"       DURATION AS duration, " +
					"       EDUCATION_APP AS educationApp, " +
					"       EXP_APPROVED_YN AS expApprovedYn, " +
					"       EXP_SUBMITTED_YN AS expSubmittedYn, " +
					"       FINAL_BUDGET_COMP AS finalBudgetComp, " +
					"       FINAL_NARRATIVE_YN AS finalNarrativeYn, " +
					"       FINAL_NARR_COMP AS finalNarrComp, " +
					"       FINAL_SIGNOFF_YN AS finalSignoffYn, " +
					"       FS10A_YN AS fs10aYn, " +
					"       FS10F_YN AS fs10fYn, " +
					"       FS20_YN AS fs20fYn, " +
					"       INST_AUTH_YN AS instAuthYn, " +
					"       MICROFORM_YN AS microformYn, " +
					"       PAID_IN_FULL_YN AS paidInFullYn, " +
					"       PAYEE_COMP AS payeeComp, " +
					"       PC_ID AS pdId, " +
					"       PHOTO_COMP AS photoComp, " +
					"       PROJ_DESC_YN AS projDescYn, " +
					"       PROJ_SEQ_NUM AS projSeqNum, " +
					"       RELIGIOUS_AFILL AS religiousAfill, " +
					"       SEAF_COMP AS seafComp, " +
					"       SHPO_COMP AS shpoComp, " +
					"       SIGNOFF_COMP AS signoffComp " +
					"       FROM GRANTS " +
					"       WHERE ID = ? " ;

try{
			
	
			Grant grantRecords = (Grant) jt.queryForObject(sql, new Object[] { id },
	        new BeanPropertyRowMapper<Grant>(Grant.class));
			
			return grantRecords;
		}catch (Exception e){
			System.out.println("GrantDao.selectGrant()" + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Grant> selectAll() {
		
		return null;
	}	
	
}
