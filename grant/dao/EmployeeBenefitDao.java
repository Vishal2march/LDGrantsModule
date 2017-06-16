package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.EmployeeBenefit;
import gov.nysed.oce.ldgrants.user.domain.User;

public class EmployeeBenefitDao extends GenericDao<EmployeeBenefit, Long> {

	@Override
	public List<EmployeeBenefit> selectAll() {

		//@formatter:off
		String sql = "  SELECT  " +
				"       NAME AS name, " +
				"       CREATED_BY AS createdBy, " +
				"       IS_TOTAL AS isTotal, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       PERS_ID AS persId, " +
				"       INST_CONT AS instCont, " +
				"       GRA_ID AS graId, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       FY_CODE AS fyCode, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       EXP_APPROVED AS expApproved, " +
				"       BENEFIT_PERCENT AS benefitPercent, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       AMEND_AMOUNT AS amendAmount, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified " +
				"       FROM EMPLOYEE_BENEFITS "; 
		
		try{
		ArrayList<EmployeeBenefit> benefitList = (ArrayList<EmployeeBenefit>) jt.query(sql,
				new BeanPropertyRowMapper<EmployeeBenefit>(EmployeeBenefit.class));

		return benefitList;
	} catch (Exception e) {
		System.err.println("selectAll()" + e.getMessage());
	}


		return null;
	}
	
	@Override
	public EmployeeBenefit select(Long id) {
		
		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       NAME AS name, " +
				"       CREATED_BY'' AS createdBy, " +
				"       IS_TOTAL AS isTotal, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       PERS_ID AS persId, " +
				"       INST_CONT AS instCont, " +
				"       GRA_ID AS graId, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       FY_CODE AS fyCode, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       EXP_APPROVED AS expApproved, " +
				"       BENEFIT_PERCENT AS benefitPercent, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       AMEND_AMOUNT AS amendAmount, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified " +
				"       FROM EMPLOYEE_BENEFITS where ID =? ";
		

		try{
			EmployeeBenefit benefitRecords = (EmployeeBenefit) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<EmployeeBenefit>(EmployeeBenefit.class));
				
				return benefitRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}

		return null;
	}
	
	@Override
	public Long insert(EmployeeBenefit benefit, User user) {
		
		//@formatter:off
		String sql = "INSERT INTO EMPLOYEE_BENEFITS (ID, " +
				"                               NAME, " +
				"                               CREATED_BY, " +
				"                               PROJ_TOTAL, " +
				"                               PERS_ID, " +
				"                               INST_CONT, " +
				"                               GRA_ID, " +
				"                               GRANT_REQUEST, " +
				"                               EXP_SUBMITTED, " +
				"                               EXP_APPROVED, " +
				"                               BENEFIT_PERCENT, " +
				"                               AMOUNT_APPROVED, " +
				"                               AMEND_AMOUNT, " +
				"                               DATE_CREATED) " +
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
				"             SYSDATE) "; 
		
		try{
			Long pk  = getNextId("PROJ_BUDG_SEQ");
			
			 int rowAdd = jt.update(sql, new Object[] { pk,benefit.getName(),user.getCreatedBy(),
					 benefit.getProjTotal(),benefit.getPersId(),benefit.getInstCont(),benefit.getGraId(),
					 benefit.getGrantRequest(),benefit.getExpSubmitted(),benefit.getExpApproved(),
					 benefit.getBenefitPercent(),benefit.getAmountApproved(),benefit.getAmendAmount()});

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
	public Long update(EmployeeBenefit benefit, User user) {
		
		int rows = 0;
		//@formatter:off
		String sql = "  UPDATE EMPLOYEE_BENEFITS " +
				"       SET NAME = ?, " +
				"       MODIFIED_BY = ?, " +
				"       PROJ_TOTAL = ?, " +
				"       PERS_ID = ?, " +
				"       INST_CONT = ?, " +
				"       GRA_ID = ?, " +
				"       GRANT_REQUEST = ?, " +
				"       EXP_SUBMITTED = ?, " +
				"       EXP_APPROVED = ?, " +
				"       BENEFIT_PERCENT = ?, " +
				"       AMOUNT_APPROVED = ?, " +
				"       AMEND_AMOUNT = ?, " +
				"       DATE_MODIFIED = SYSDATE " +
				"       WHERE ID = ? "; 
		

		try{
			  rows = jt.update(sql, new Object[] {benefit.getName(),user.getModifiedBy(),benefit.getProjTotal(),
					  benefit.getPersId(),benefit.getInstCont(),benefit.getGraId(),
					  benefit.getGrantRequest(),benefit.getExpSubmitted(),benefit.getExpApproved(),
					  benefit.getBenefitPercent(),benefit.getAmountApproved(),benefit.getAmendAmount(),
					  benefit.getId()});
			  
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
		
		String sql = "DELETE FROM EMPLOYEE_BENEFITS WHERE id=?";		
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
