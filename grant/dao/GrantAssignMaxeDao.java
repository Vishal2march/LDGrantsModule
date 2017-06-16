package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.GrantAssignMax;
import gov.nysed.oce.ldgrants.user.domain.User;

public class GrantAssignMaxeDao extends GenericDao<GrantAssignMax,Long> {

	
	@Override
	public GrantAssignMax select(Long id) {
		
		String sql = "SELECT REV_ID, " +
				"       NUM_ACCEPTED, " +
				"       FY_CODE, " +
				"       CREATED_BY, " +
				"       DESCRIPTION, " +
				"       GRANT_PROGRAM, " +
				"       MODIFIED_BY, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM GRANT_ASSIGN_MAXES " +
				"       WHERE ID = ? " ;
		
		try{
			GrantAssignMax assignRecords = (GrantAssignMax) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<GrantAssignMax>(GrantAssignMax.class));
				
				return assignRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}

		return null;
	}

	@Override
	public List<GrantAssignMax> selectAll() {
		
		String sql = "  SELECT REV_ID, " +
				"       NUM_ACCEPTED, " +
				"       ID, " +
				"       FY_CODE, " +
				"       CREATED_BY, " +
				"       DESCRIPTION, " +
				"       GRANT_PROGRAM, " +
				"       MODIFIED_BY, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM GRANT_ASSIGN_MAXES " ;
		
		try{
			ArrayList<GrantAssignMax> list = (ArrayList<GrantAssignMax>) jt.query(sql,
					new BeanPropertyRowMapper<GrantAssignMax>(GrantAssignMax.class));

			return list;
			
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}
	
	@Override
	public Long insert(GrantAssignMax max, User user) {
		
		String sql = "INSERT INTO GRANT_ASSIGN_MAXES (ID, " +
				"                                REV_ID, " +
				"                                NUM_ACCEPTED, " +
				"                                FY_CODE, " +
				"                                CREATED_BY, " +
				"                                DESCRIPTION, " +
				"                                GRANT_PROGRAM, " +
				"                                DATE_CREATED) " +
				"     VALUES (?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE) "; 

		try{
			Long pk  = getNextId("GRA_ASSIGN_MAX_SEQ");
			 int rowAdd = jt.update(sql, new Object[] { pk,max.getRevId(),max.getNumAccepted(),max.getFyCode(),
					 user.getCreatedBy(),max.getDescription(),max.getGrantProgram()});
			 
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
	public Long update(GrantAssignMax max, User user) {
		
		String sql = "  UPDATE GRANT_ASSIGN_MAXES " +
				"       SET REV_ID = ?, " +
				"       NUM_ACCEPTED = ?, " +
				"       FY_CODE = ?, " +
				"       MODIFIED_BY = ?, " +
				"       DESCRIPTION = ?, " +
				"       GRANT_PROGRAM = ?, " +
				"       DATE_MODIFIED = SYSDATE " +
				"       WHERE ID = ? " ;

		try{
			  int rows = jt.update(sql, new Object[] {max.getRevId(),max.getNumAccepted(),max.getFyCode(),
					  user.getModifiedBy(),max.getDescription(),max.getGrantProgram(),max.getId()});
			  
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
		

		String sql = "DELETE FROM GRANT_ASSIGN_MAXES WHERE id=?";		
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
