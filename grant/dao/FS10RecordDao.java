package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.FS10Record;
import gov.nysed.oce.ldgrants.user.domain.User;

public class FS10RecordDao extends GenericDao<FS10Record, Long> {

	
	public FS10RecordDao(){
		
	}
	
	@Override
	public FS10Record select(Long id) {
		
		String sql = "  SELECT  " +
				"       GRA_ID, " +
				"       FY_CODE, " +
				"       EXT_ID, " +
				"       EXP_CODE, " +
				"       AMOUNT_INCR, " +
				"       AMOUNT_DECR, " +
				"       ADMIN_APPROVAL, " +
				"       CREATED_BY, " +
				"       DESCRIPTION, " +
				"       EXP_NAME, " +
				"       MODIFIED_BY, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM FS10_RECORDS WHERE ID = ? "; 
		
		try{
			FS10Record fsRecords = (FS10Record) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<FS10Record>(FS10Record.class));
				
				return fsRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}

		return null;
	}

	@Override
	public List<FS10Record> selectAll() {
		
		String sql = "  SELECT ID, " +
				"       GRA_ID, " +
				"       FY_CODE, " +
				"       EXT_ID, " +
				"       EXP_CODE, " +
				"       AMOUNT_INCR, " +
				"       AMOUNT_DECR, " +
				"       ADMIN_APPROVAL, " +
				"       CREATED_BY, " +
				"       DESCRIPTION, " +
				"       EXP_NAME, " +
				"       MODIFIED_BY, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM FS10_RECORDS "; 
		
		try{
			ArrayList<FS10Record> list = (ArrayList<FS10Record>) jt.query(sql,
					new BeanPropertyRowMapper<FS10Record>(FS10Record.class));

			return list;
			
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}
		return null;
	}
	
	@Override
	public Long insert(FS10Record fs, User user) {
		
	String sql = "INSERT INTO FS10_RECORDS (ID, " +
			"                          GRA_ID, " +
			"                          FY_CODE, " +
			"                          EXT_ID, " +
			"                          EXP_CODE, " +
			"                          AMOUNT_INCR, " +
			"                          AMOUNT_DECR, " +
			"                          ADMIN_APPROVAL, " +
			"                          CREATED_BY, " +
			"                          DESCRIPTION, " +
			"                          EXP_NAME, " +
			"                          DATE_CREATED) " +
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
			"             SYSDATE) " ;
	
	try{
		Long pk  = getNextId("FS10_SEQ");
		
		 int rowAdd = jt.update(sql, new Object[] { pk,fs.getGraId(),fs.getFyCode(),fs.getExtId(),
				 fs.getExpCode(),fs.getAmountIncr(),fs.getAmountDecr(),fs.getAdminApproval(),
				 user.getCreatedBy(),fs.getDescription(),fs.getExpName()});
		 
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
	public Long update(FS10Record fs, User user) {
		
		String sql= "   UPDATE FS10_RECORDS " +
				"       SET GRA_ID = ?, " +
				"       FY_CODE = ?, " +
				"       EXT_ID = ?, " +
				"       EXP_CODE = ?, " +
				"       AMOUNT_INCR = ?, " +
				"       AMOUNT_DECR = ?, " +
				"       ADMIN_APPROVAL = ?, " +
				"       MODIFIED_BY = ?, " +
				"       DESCRIPTION = ?, " +
				"       EXP_NAME = ?, " +
				"       DATE_MODIFIED = SYSDATE " +
				"       WHERE ID = ? " ;
		try{
			  int rows = jt.update(sql, new Object[] {fs.getGraId(),fs.getFyCode(),fs.getExtId(),
						 fs.getExpCode(),fs.getAmountIncr(),fs.getAmountDecr(),fs.getAdminApproval(),
						 user.getModifiedBy(),fs.getDescription(),fs.getExpName(),
						 fs.getId()});
			  
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
		
		String sql = "DELETE FROM FS10_RECORDS WHERE id=?";		
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
