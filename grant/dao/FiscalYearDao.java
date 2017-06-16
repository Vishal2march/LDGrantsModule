package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.FiscalYear;
import gov.nysed.oce.ldgrants.user.domain.User;

public class FiscalYearDao extends GenericDao<FiscalYear, Long> {

	public FiscalYearDao() {
	}

	@Override
	public FiscalYear select(Long code) {

		//@formatter:off
			
			String sql = 	    "SELECT s.DESCRIPTION, " +
						"       s.DATE_CREATED, " +
						"       s.START_DATE, " +
						"       s.END_DATE, " +
						"       s.CODE, " +
						"       s.CREATED_BY " +
						"       FROM FISCAL_YEARS s " +
						"       WHERE s.CODE = ? "; 
			try{

					FiscalYear fy = (FiscalYear)jt.queryForObject(sql, new Object[] { code },
						        new BeanPropertyRowMapper<FiscalYear>(FiscalYear.class));
							
				return fy;
				}catch (Exception e) {
					e.getMessage();
				}	
		return null;
	}
	
	@Override
	public List<FiscalYear> selectAll() {
		
		String sql = "  SELECT DESCRIPTION, " +
				"       DATE_CREATED, " +
				"       START_DATE, " +
				"       END_DATE, " +
				"       CODE, " +
				"       CREATED_BY, " +
				"       DATE_MODIFIED, " +
				"       MODIFIED_BY " +
				"       FROM FISCAL_YEARS "; 
		
		try{
			ArrayList<FiscalYear> list = (ArrayList<FiscalYear>) jt.query(sql,
					new BeanPropertyRowMapper<FiscalYear>(FiscalYear.class));

			return list;
			
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}
	
	public FiscalYear selectFiscalYearByDescription (Long description){
		//@formatter:off
		
			String sql = "  SELECT s.DESCRIPTION, " +
					"       s.DATE_CREATED, " +
					"       s.START_DATE, " +
					"       s.END_DATE, " +
					"       s.CODE, " +
					"       s.CREATED_BY " +
					"       FROM FISCAL_YEARS s " +
					"       WHERE s.DESCRIPTION =? " ;
			try{
	
			FiscalYear fiscal = (FiscalYear)jt.queryForObject(sql, new Object[] { description },
	        new BeanPropertyRowMapper<FiscalYear>(FiscalYear.class) );	
			
			return fiscal;
		}catch (Exception e) {
			e.getMessage();
		}	
		return null;
	}



	@Override
	public Long insert(FiscalYear obj, User user) {
		// TODO Auto-generated method stub
		return null;}

	@Override
	public Long update(FiscalYear obj, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
