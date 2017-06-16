package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.SystemFiscalYearDetail;
import gov.nysed.oce.ldgrants.user.domain.User;

public class SystemFiscalYearDetailDao  extends GenericDao<SystemFiscalYearDetail,Long> {

	
	public SystemFiscalYearDetailDao(){
		
	}
	
	public ArrayList<SystemFiscalYearDetail> searchByFyCode (Long fyCode){
		
		String sql = "  SELECT ID, " +
				"       FC_CODE, " +
				"       FINAL_ALLOCATION, " +
				"       FINAL_RECOMMENDATION, " +
				"       FY_CODE, " +
				"       INITIAL_ALLOCATION, " +
				"       LSM_ID, " +
				"       DUE_DATE, " +
				"       DATE_CREATED, " +
				"       CREATED_BY, " +
				"       MODIFIED_BY, " +
				"       DATE_MODIFIED " +
				"       FROM SYSTEM_FISCALYEAR_DETAILS " +
				"       WHERE UPPER (fy_code) LIKE (?) ";
		

		try{
			List<SystemFiscalYearDetail> details = jt.query(sql, new Object[] { '%' + fyCode + '%' },
					new BeanPropertyRowMapper<SystemFiscalYearDetail>(SystemFiscalYearDetail.class));

			if (details.size() > 0) {
				return (ArrayList<SystemFiscalYearDetail>) details;
			} else
			{
				System.out.println("Getting no results");
				return null;
			}			
		}
		catch (Exception e) 
		{
			System.err.println("error searchByFyCode() " + e.toString());
		}
		return null; 

	}
	
	
	@Override
	public SystemFiscalYearDetail select(Long id) {
		
		String sql = "  SELECT FC_CODE, " +
				"       FINAL_ALLOCATION, " +
				"       FINAL_RECOMMENDATION, " +
				"       FY_CODE, " +
				"       INITIAL_ALLOCATION, " +
				"       LSM_ID, " +
				"       DUE_DATE, " +
				"       DATE_CREATED, " +
				"       CREATED_BY, " +
				"       MODIFIED_BY, " +
				"       DATE_MODIFIED " +
				"       FROM SYSTEM_FISCALYEAR_DETAILS " +
				"       WHERE ID = ? "; 
		
		try{
			SystemFiscalYearDetail details = (SystemFiscalYearDetail) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<SystemFiscalYearDetail>(SystemFiscalYearDetail.class));
				
				return details;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}

		return null;
	}

	@Override
	public List<SystemFiscalYearDetail> selectAll() {
		
		String sql = "  SELECT ID, " +
				"       FC_CODE, " +
				"       FINAL_ALLOCATION, " +
				"       FINAL_RECOMMENDATION, " +
				"       FY_CODE, " +
				"       INITIAL_ALLOCATION, " +
				"       LSM_ID, " +
				"       DUE_DATE, " +
				"       DATE_CREATED, " +
				"       CREATED_BY, " +
				"       MODIFIED_BY, " +
				"       DATE_MODIFIED " +
				"       FROM SYSTEM_FISCALYEAR_DETAILS "; 
		
		try{
			ArrayList<SystemFiscalYearDetail> yearList = (ArrayList<SystemFiscalYearDetail>) jt.query(sql,
					new BeanPropertyRowMapper<SystemFiscalYearDetail>(SystemFiscalYearDetail.class));

			return yearList;
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}
	
	@Override
	public Long insert(SystemFiscalYearDetail fiscal, User user) {
		
		String sql = "INSERT INTO SYSTEM_FISCALYEAR_DETAILS (ID, " +
				"                                       FC_CODE, " +
				"                                       FINAL_ALLOCATION, " +
				"                                       FINAL_RECOMMENDATION, " +
				"                                       FY_CODE, " +
				"                                       INITIAL_ALLOCATION, " +
				"                                       LSM_ID, " +
				"                                       DUE_DATE, " +
				"                                       DATE_CREATED, " +
				"                                       CREATED_BY) " +
				"     VALUES (?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE, " +
				"             SYSDATE, " +
				"             ?) "; 

		try{
			Long pk  = getNextId("SFD_SEQ");
			
			int rowAdd = jt.update(sql, new Object[] { pk,fiscal.getFcCode(),fiscal.getFinalAllocation(),
					fiscal.getFinalRecommendation(),fiscal.getFyCode(),fiscal.getInitialAllocation(),
					fiscal.getLsmId(),user.getCreatedBy()});
			
			 
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
	public Long update(SystemFiscalYearDetail fiscal, User user) {
		
		String sql = "  UPDATE SYSTEM_FISCALYEAR_DETAILS " +
				"       SET FC_CODE = ?, " +
				"       FINAL_ALLOCATION = ?, " +
				"       FINAL_RECOMMENDATION = ?, " +
				"       FY_CODE = ?, " +
				"       INITIAL_ALLOCATION = ?, " +
				"       LSM_ID = ?, " +
				"       DUE_DATE = SYSDATE, " +
				"       DATE_MODIFIED = SYSDATE, " +
				"       MODIFIED_BY = ? " +
				"       WHERE ID = ? ";
		
		try{
			  int rows = jt.update(sql, new Object[] {fiscal.getFcCode(),fiscal.getFinalAllocation(),
						fiscal.getFinalRecommendation(),fiscal.getFyCode(),fiscal.getInitialAllocation(),
						fiscal.getLsmId(),user.getModifiedBy(),fiscal.getId()});
			  
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
		
		String sql = "DELETE FROM SYSTEM_FISCALYEAR_DETAILS WHERE id=?";		
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
