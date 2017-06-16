package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.TravelExpense;
import gov.nysed.oce.ldgrants.user.domain.User;

public class TravelExpenseDao  extends GenericDao<TravelExpense,Long> {
	
	
	@Override
	public TravelExpense select(Long id) {
		
		String sql = "  SELECT AMEND_AMOUNT AS amendAmount, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       EXP_APPROVED AS expApproved, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       FY_CODE AS fyCode, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       GRA_ID AS graId, " +
				"       INST_CONT AS instCont, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       CREATED_BY AS createdBy, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       DESCRIPTION AS description, " +
				"       IS_TOTAL AS isTotal, " +
				"       TRAVELER_NAME AS travellerName, " +
				"       JOURNAL_ENTRY AS journalEntry, " +
				"       TRAVEL_PERIOD AS travelPeriod, " +
				"       PURPOSE AS purpose " +
				"       FROM TRAVEL_EXPENSES " +
				"        WHERE ID = ? " ;
		
		
		try{
			TravelExpense travelRecords = (TravelExpense) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<TravelExpense>(TravelExpense.class));
				
				return travelRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}

		return null;
	}

	@Override
	public List<TravelExpense> selectAll() {
		
		String sql = "  SELECT AMEND_AMOUNT AS amendAmount, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       EXP_APPROVED AS expApproved, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       FY_CODE AS fyCode, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       GRA_ID AS graId, " +
				"       ID AS id, " +
				"       INST_CONT AS instCont, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       CREATED_BY AS createdBy, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       DESCRIPTION AS description, " +
				"       IS_TOTAL AS isTotal, " +
				"       TRAVELER_NAME AS travellerName, " +
				"       JOURNAL_ENTRY AS journalEntry, " +
				"       TRAVEL_PERIOD AS travelPeriod, " +
				"       PURPOSE AS purpose " +
				"       FROM TRAVEL_EXPENSES " ;
				

		try{
			ArrayList<TravelExpense> travelList = (ArrayList<TravelExpense>) jt.query(sql,
					new BeanPropertyRowMapper<TravelExpense>(TravelExpense.class));

			return travelList;
			
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}
		return null;
	}

	@Override
	public Long insert(TravelExpense travel, User user) {
		
		
		String sql = "INSERT INTO TRAVEL_EXPENSES (ID, " +
				"                             AMEND_AMOUNT, " +
				"                             AMOUNT_APPROVED, " +
				"                             EXP_APPROVED, " +
				"                             EXP_SUBMITTED, " +
				"                             FY_CODE, " +
				"                             GRANT_REQUEST, " +
				"                             GRA_ID, " +
				"                             INST_CONT, " +
				"                             PROJ_TOTAL, " +
				"                             CREATED_BY, " +
				"                             DESCRIPTION, " +
				"                             IS_TOTAL, " +
				"                             TRAVELER_NAME, " +
				"                             JOURNAL_ENTRY, " +
				"                             TRAVEL_PERIOD, " +
				"                             PURPOSE, " +
				"                             DATE_CREATED, COSTSUMMARY) " +
				"              VALUES (?, " +
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
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE, ?)  "; 
		
		try{
			Long pk  = getNextId("PROJ_BUDG_SEQ");
			
			 int rowAdd = jt.update(sql, new Object[] { pk,travel.getAmendAmount(),travel.getAmountApproved(),
					 travel.getExpApproved(),travel.getExpSubmitted(),travel.getFyCode(),travel.getGrantRequest(),
					 travel.getGraId(),travel.getInstCont(),travel.getProjTotal(),user.getCreatedBy(),travel.getDescription(),
					 travel.getIsTotal(),travel.getTravellerName(),travel.getJournalEntry(),travel.getTravelPeriod(),
					 travel.getPurpose(),travel.getCostSummary()});
			 
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
	public Long update(TravelExpense travel, User user) {
		
		String sql = "  UPDATE TRAVEL_EXPENSES " +
				"       SET AMEND_AMOUNT = ?, " +
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
				"       TRAVELER_NAME = ?, " +
				"       JOURNAL_ENTRY = ?, " +
				"       TRAVEL_PERIOD = ?, " +
				"       PURPOSE = ?, " +
				"       COSTSUMMARY = ?, " +
				"       DATE_MODIFIED = SYSDATE " +
				"       WHERE ID = ? " ;
		
		try{
			  int rows = jt.update(sql, new Object[] {travel.getAmendAmount(),travel.getAmountApproved(),
					  travel.getExpApproved(),travel.getExpSubmitted(),travel.getFyCode(),
					  travel.getGrantRequest(),travel.getGraId(),travel.getInstCont(),travel.getProjTotal(),
					  travel.getDescription(),user.getModifiedBy(),travel.getIsTotal(),travel.getTravellerName(),
					  travel.getJournalEntry(),travel.getTravelPeriod(),travel.getPurpose(),travel.getCostSummary(),
					  travel.getId()});
					  
					  
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
	

		String sql = "DELETE FROM TRAVEL_EXPENSES WHERE id=?";		
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
