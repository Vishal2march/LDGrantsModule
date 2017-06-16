package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import gov.nysed.oce.ldgrants.grants.grant.domain.Grant;
import gov.nysed.oce.ldgrants.grants.grant.domain.PersonalService;
import gov.nysed.oce.ldgrants.grants.grant.domain.ProjectNarrative;
import gov.nysed.oce.ldgrants.user.domain.User;

public class PersonalServiceDao extends GenericDao<PersonalService, Long> {

	@Override
	public PersonalService select(Long id) {

		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       AMEND_AMOUNT AS amendAmount, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       EXP_APPROVED AS expApproved, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       FTE AS fte, " +
				"       FY_CODE AS fyCode, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       GRA_ID AS graId, " +
				"       INST_CONT AS instCont, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       SALARY_RATE AS salaryRate, " +
				"       SMET_CODE AS smetCode, " +
				"       CREATED_BY AS createdBy, " +
				"       IS_TOTAL AS isTotal, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       NAME AS name, " +
				"       TITLE AS title, " +
				"       BEGIN_DATE AS beginDate, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       END_DATE AS endDate " +
				"       FROM PERSONAL_SERVICES " ;

		
		try{
			PersonalService records =  jt.queryForObject(sql, new Object[] { id },
			 new BeanPropertyRowMapper<PersonalService>(PersonalService.class));
			
					return records;
					
				}catch (Exception e){
					System.out.println("PersonalServiceDao.select()" + e.getMessage());
				}

		return null;
	}

	@Override
	public List<PersonalService> selectAll() {
		
		//@formatter:off
		String sql = "  SELECT  " +
				"       AMEND_AMOUNT AS amendAmount, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       EXP_APPROVED AS expApproved, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       FTE AS fte, " +
				"       FY_CODE AS fyCode, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       GRA_ID AS graId, " +
				"       INST_CONT AS instCont, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       SALARY_RATE AS salaryRate, " +
				"       SMET_CODE AS smetCode, " +
				"       CREATED_BY AS createdBy, " +
				"       IS_TOTAL AS isTotal, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       NAME AS name, " +
				"       TITLE AS title, " +
				"       BEGIN_DATE AS beginDate, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       END_DATE AS endDate " +
				"       FROM PERSONAL_SERVICES WHERE ID = ? " ;

		
		try {

			ArrayList<PersonalService> list = (ArrayList<PersonalService>) jt.query(sql,
					new BeanPropertyRowMapper<PersonalService>(PersonalService.class));

			return list;
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}
		return null;
	}
	@Override
	public Long insert(PersonalService personal, User user) {
		
		//@formatter:off
		String sql="       INSERT INTO PERSONAL_SERVICES (ID, " +
				"                               AMEND_AMOUNT, " +
				"                               AMOUNT_APPROVED, " +
				"                               EXP_APPROVED, " +
				"                               EXP_SUBMITTED, " +
				"                               FTE, " +
				"                               FY_CODE, " +
				"                               GRANT_REQUEST, " +
				"                               GRA_ID, " +
				"                               INST_CONT, " +
				"                               PROJ_TOTAL, " +
				"                               SALARY_RATE, " +
				"                               SMET_CODE, " +
				"                               CREATED_BY, " +
				"                               IS_TOTAL, " +
				"                               NAME, " +
				"                               TITLE, " +
				"                               BEGIN_DATE, " +
				"                               DATE_CREATED, " +
				"                               END_DATE) " +
				"             VALUES (?, " +
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
				"             SYSDATE, " +
				"             SYSDATE) "; 
		
		try{
			Long pk  = getNextId("PROJ_BUDG_SEQ");
			int rowAdd = jt.update(sql, new Object[] { pk,personal.getAmendAmount(),personal.getAmountApproved(),
					personal.getExpApproved(),personal.getExpSubmitted(),personal.getFte(),personal.getFyCode(),
					personal.getGrantRequest(),personal.getGraId(),personal.getInstCont(),
					personal.getProjTotal(),personal.getSalaryRate(),personal.getSmetCode(),
					user.getCreatedBy(),personal.getIsTotal(),personal.getName(),personal.getTitle()});
			
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
	public Long update(PersonalService personal, User user) {
		
		//@formatter:off
		String sql = 
				"  UPDATE PERSONAL_SERVICES " +
				"       SET AMEND_AMOUNT = ?, " +
				"       AMOUNT_APPROVED = ?, " +
				"       EXP_APPROVED = ?, " +
				"       EXP_SUBMITTED = ?, " +
				"       FTE = ?, " +
				"       FY_CODE = ?, " +
				"       GRANT_REQUEST = ?, " +
				"       GRA_ID = ?, " +
				"       INST_CONT = ?, " +
				"       PROJ_TOTAL = ?, " +
				"       SALARY_RATE = ?, " +
				"       SMET_CODE = ?, " +
				"       MODIFIED_BY = ?, " +
				"       IS_TOTAL = ?, " +
				"       NAME = ?, " +
				"       TITLE = ? , DATE_MODIFIED = SYSDATE" +
				"       WHERE ID = ? " ;
		
		
		try{
		
		Long rows = (long) jt.update(sql, new Object[] {personal.getAmendAmount(),personal.getAmountApproved(),
				personal.getExpApproved(),personal.getExpSubmitted(),personal.getFte(),personal.getFyCode(),
				personal.getGrantRequest(),personal.getGraId(),personal.getInstCont(),
				personal.getProjTotal(),personal.getSalaryRate(),personal.getSmetCode(),
				user.getModifiedBy(),personal.getIsTotal(),personal.getName(),
				personal.getTitle(),personal.getId()});
		
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
	
		String sql = "DELETE FROM PERSONAL_SERVICES WHERE id=?";		
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

	public ArrayList<PersonalService> searchByTitle (String title){
		
		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       AMEND_AMOUNT AS amendAmount, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       EXP_APPROVED AS expApproved, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       FTE AS fte, " +
				"       FY_CODE AS fyCode, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       GRA_ID AS graId, " +
				"       INST_CONT AS instCont, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       SALARY_RATE AS salaryRate, " +
				"       SMET_CODE AS smetCode, " +
				"       CREATED_BY AS createdBy, " +
				"       IS_TOTAL AS isTotal, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       NAME AS name, " +
				"       BEGIN_DATE AS beginDate, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       END_DATE AS endDate " +
				"       FROM PERSONAL_SERVICES " +
				"       WHERE UPPER (title) LIKE UPPER (?) " ;

				
		try{
		List<PersonalService> names = jt.query(sql, new Object[] { '%' + title + '%' },
				new BeanPropertyRowMapper<PersonalService>(PersonalService.class));

		if (names.size() > 0) {
			return (ArrayList<PersonalService>) names;
		} else
		{
			System.out.println("Getting no results");
			return null;
		}			
	}
	catch (Exception e) 
	{
		System.err.println("error searchByTitle() " + e.toString());
	}
	
	return null;
	}

}
