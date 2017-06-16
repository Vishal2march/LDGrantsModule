package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.ContractedService;
import gov.nysed.oce.ldgrants.user.domain.User;

public class ContractedServiceDao extends GenericDao<ContractedService, Long> {

	@Override
	public ContractedService select(Long id) {

		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       CREATED_BY AS createdBy, " +
				"       IS_TOTAL AS isTotal, " +
				"       JOURNAL_ENTRY AS journalEntry, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       PROVIDER_USED AS providerUsed, " +
				"       RECIPIENT AS recipient, " +
				"       SERVICE_DESCR AS serviceDescr, " +
				"       SERVICE_TYPE AS serviceType, " +
				"       AMEND_AMOUNT AS amendAmount, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       CODE AS code, " +
				"       EXP_APPROVED AS expApproved, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       FY_CODE AS fyCode, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       GRA_ID AS graId, " +
				"       INST_CONT AS instCont, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       ENCUMBRANCE_DATE AS encumbranceDate " +
				"       FROM CONTRACTED_SERVICES WHERE ID = ? " ;
		
		
		try{
			ContractedService serviceRecords = (ContractedService) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<ContractedService>(ContractedService.class));
				
				return serviceRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}

		return null;
	}

	@Override
	public List<ContractedService> selectAll() {
		
		
		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       CREATED_BY AS createdBy, " +
				"       IS_TOTAL AS isTotal, " +
				"       JOURNAL_ENTRY AS journalEntry, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       PROVIDER_USED AS providerUsed, " +
				"       RECIPIENT AS recipient, " +
				"       SERVICE_DESCR AS serviceDescr, " +
				"       SERVICE_TYPE AS serviceType, " +
				"       AMEND_AMOUNT AS amendAmount, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       CODE AS code, " +
				"       EXP_APPROVED AS expApproved, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       FY_CODE AS fyCode, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       GRA_ID AS graId, " +
				"       INST_CONT AS instCont, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       ENCUMBRANCE_DATE AS encumbranceDate " +
				"       FROM CONTRACTED_SERVICES ";

		try{
			ArrayList<ContractedService> serviceList = (ArrayList<ContractedService>) jt.query(sql,
					new BeanPropertyRowMapper<ContractedService>(ContractedService.class));

			return serviceList;
			
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}
		return null;
	}
	
	@Override
	public Long insert(ContractedService contract, User user) {
		
		//@formatter:off
		String sql = "/* Formatted on 2/21/2017 2:05:03 PM (QP5 v5.252.13127.32847) */ " +
				"INSERT INTO CONTRACTED_SERVICES (ID, " +
				"                                 CREATED_BY, " +
				"                                 IS_TOTAL, " +
				"                                 JOURNAL_ENTRY, " +
				"                                 PROVIDER_USED, " +
				"                                 RECIPIENT, " +
				"                                 SERVICE_DESCR, " +
				"                                 SERVICE_TYPE, " +
				"                                 AMEND_AMOUNT, " +
				"                                 AMOUNT_APPROVED, " +
				"                                 CODE, " +
				"                                 EXP_APPROVED, " +
				"                                 EXP_SUBMITTED, " +
				"                                 FY_CODE, " +
				"                                 GRANT_REQUEST, " +
				"                                 GRA_ID, " +
				"                                 INST_CONT, " +
				"                                 PROJ_TOTAL, " +
				"                                 DATE_CREATED, " +
				"                                 ENCUMBRANCE_DATE) " +
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
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE, " +
				"             SYSDATE) " ;

				
		try{
			Long pk  = getNextId("PROJ_BUDG_SEQ");
			
			 int rowAdd = jt.update(sql, new Object[] { pk,user.getCreatedBy(),contract.getIsTotal(),contract.getJournalEntry(),
					 contract.getProviderUsed(),contract.getRecipient(),contract.getServiceDescr(),contract.getServiceType(),
					 contract.getAmendAmount(),contract.getAmountApproved(),contract.getCode(),
					 contract.getExpApproved(),contract.getExpSubmitted(),contract.getFyCode(),contract.getGrantRequest(),
					 contract.getGraId(),contract.getInstCont(),contract.getProjTotal()});
			 
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
	public Long update(ContractedService contract, User user) {
		
		//@formatter:off
		String sql = "UPDATE CONTRACTED_SERVICES " +
				"   SET MODIFIED_BY = ?, IS_TOTAL = ?, " +
				"                                 JOURNAL_ENTRY=?, " +
				"                                 PROVIDER_USED=?, " +
				"                                 RECIPIENT=?, " +
				"                                 SERVICE_DESCR=?, " +
				"                                 SERVICE_TYPE=?, " +
				"                                 AMEND_AMOUNT=?, " +
				"                                 AMOUNT_APPROVED=?, " +
				"                                 CODE=?, " +
				"                                 EXP_APPROVED=?, " +
				"                                 EXP_SUBMITTED=?, " +
				"                                 FY_CODE=?, " +
				"                                 GRANT_REQUEST=?, " +
				"                                 GRA_ID=?, " +
				"                                 INST_CONT=?, " +
				"                                 PROJ_TOTAL=?, " +
				"                                 DATE_MODIFIED=SYSDATE WHERE ID=? " ;
		
		try{
			  int rows = jt.update(sql, new Object[] {user.getModifiedBy(),contract.getIsTotal(),contract.getJournalEntry(),
					  contract.getProviderUsed(),contract.getRecipient(),contract.getServiceDescr(),contract.getServiceType(),
					  contract.getAmendAmount(),contract.getAmountApproved(),contract.getCode(),contract.getExpApproved(),
					  contract.getExpSubmitted(),contract.getFyCode(),contract.getGrantRequest(),contract.getGraId(),contract.getInstCont(),
					  contract.getProjTotal(),contract.getId()});
			  
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
		

		String sql = "DELETE FROM CONTRACTED_SERVICES WHERE id=?";		
		try {
			
			int rows = jt.update(sql, new Object[] { id });
			
			return (rows ==   1);
      
		}
		catch (Exception e) 
		{
			e.getMessage();
		}
		return false;
	}

	

}
