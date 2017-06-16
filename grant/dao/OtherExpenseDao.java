package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.OtherExpense;
import gov.nysed.oce.ldgrants.user.domain.User;

public class OtherExpenseDao extends GenericDao<OtherExpense,Long> {

	
	@Override
	public OtherExpense select(Long id) {
		
		String sql = "  SELECT  " +
				"       AMEND_AMOUNT AS amendAmount, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       CREATED_BY createdBy, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       ENCUMBRANCE_DATE AS encumbranceDate, " +
				"       EXP_APPROVED AS expApproved, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       FY_CODE AS fyCode, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       GRA_ID AS graId, " +
				"       INST_CONT AS instCont, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       DESCRIPTION AS description, " +
				"       IS_TOTAL AS isTotal, " +
				"       JOURNAL_ENTRY AS journalEntry, " +
				"       PROVIDER_USED AS providerUsed " +
				"       FROM OTHER_EXPENSES WHERE ID = ? " ;
		
		try{
			OtherExpense expenseRecords = (OtherExpense) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<OtherExpense>(OtherExpense.class));
				
				return expenseRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}


		return null;
	}

	@Override
	public List<OtherExpense> selectAll() {
		
		String sql = "  SELECT ID AS id, " +
				"       AMEND_AMOUNT AS amendAmount, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       CREATED_BY createdBy, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       ENCUMBRANCE_DATE AS encumbranceDate, " +
				"       EXP_APPROVED AS expApproved, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       FY_CODE AS fyCode, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       GRA_ID AS graId, " +
				"       INST_CONT AS instCont, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       DESCRIPTION AS description, " +
				"       IS_TOTAL AS isTotal, " +
				"       JOURNAL_ENTRY AS journalEntry, " +
				"       PROVIDER_USED AS providerUsed " +
				"       FROM OTHER_EXPENSES "; 
		
		

		try{
			ArrayList<OtherExpense> list = (ArrayList<OtherExpense>) jt.query(sql,
					new BeanPropertyRowMapper<OtherExpense>(OtherExpense.class));

			return list;
			
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}
	
	@Override
	public Long insert(OtherExpense other, User user) {
		
		String sql= "INSERT INTO OTHER_EXPENSES (ID, " +
				"                            AMEND_AMOUNT, " +
				"                            AMOUNT_APPROVED, " +
				"                            CREATED_BY, " +
				"                            DATE_CREATED, " +
				"                            ENCUMBRANCE_DATE, " +
				"                            EXP_APPROVED, " +
				"                            EXP_SUBMITTED, " +
				"                            FY_CODE, " +
				"                            GRANT_REQUEST, " +
				"                            GRA_ID, " +
				"                            INST_CONT, " +
				"                            PROJ_TOTAL, " +
				"                            description, " +
				"                            IS_TOTAL, " +
				"                            JOURNAL_ENTRY, " +
				"                            PROVIDER_USED, COST_SUMMARY) " +
				"     VALUES (?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE, " +
				"             SYSDATE, " +
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
				"             ?,?)" ;
		
		try{
			Long pk  = getNextId("PROJ_BUDG_SEQ");
			
			 int rowAdd = jt.update(sql, new Object[] { pk,other.getAmendAmount(),other.getAmountApproved(),
					 user.getCreatedBy(),other.getExpApproved(),other.getExpSubmitted(),other.getFyCode(),
					 other.getGrantRequest(),other.getGraId(),other.getInstCont(),other.getProjTotal(),
					 other.getDescription(),other.getIsTotal(),other.getJournalEntry(),other.getProviderUsed(),
					 other.getCostSummary()});
			 
			 
			 
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
	public Long update(OtherExpense other, User user) {
		
		String sql= "UPDATE OTHER_EXPENSES " +
				"   SET AMEND_AMOUNT = ?, " +
				"       AMOUNT_APPROVED = ?, " +
				"       EXP_APPROVED = ?, " +
				"       EXP_SUBMITTED = ?, " +
				"       FY_CODE = ?, " +
				"       GRANT_REQUEST = ?, " +
				"       GRA_ID = ?, " +
				"       INST_CONT = ?, " +
				"       PROJ_TOTAL = ?, " +
				"       DESCRIPTION = ?, " +
				"       MODIFIED_BY = ?, " +
				"       IS_TOTAL = ?, " +
				"       JOURNAL_ENTRY = ?, " +
				"       ENCUMBRANCE_DATE = SYSDATE, " +
				"       COST_SUMMARY = ?, " +
				"       PROVIDER_USED = ?, " +
				"       DATE_MODIFIED = SYSDATE " +
				" WHERE ID = ? " ;
		
		try{
			  int rows = jt.update(sql, new Object[] {other.getAmendAmount(),other.getAmountApproved(),
					  other.getExpApproved(),other.getExpSubmitted(),other.getFyCode(),
					  other.getGrantRequest(),other.getGraId(),other.getInstCont(),other.getProjTotal(),
					  other.getDescription(),user.getModifiedBy(),other.getIsTotal(),other.getJournalEntry(),
					  other.getCostSummary(),other.getProviderUsed(),other.getId()});
			  
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
		
		String sql = "DELETE FROM OTHER_EXPENSES WHERE id=?";		
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
