package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.ProjectStatistic;
import gov.nysed.oce.ldgrants.user.domain.User;

public class ProjectStatisticDao extends GenericDao<ProjectStatistic, Long> {

	
	@Override
	public ProjectStatistic select(Long id) {
		
		String sql = "  SELECT ID, " +
				"       SCORE, " +
				"       REASON, " +
				"       DATE_CREATED, " +
				"       CREATED_BY, " +
				"       DATE_MODIFIED, " +
				"       MODIFIED_BY, " +
				"       GRA_ID, " +
				"       ST_ID " +
				"       FROM PROJECT_STATISTICS WHERE ID = ? " ;
		
		try{
			ProjectStatistic statisticRecords = (ProjectStatistic) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<ProjectStatistic>(ProjectStatistic.class));
				
				return statisticRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}

		return null;
	}

	@Override
	public List<ProjectStatistic> selectAll() {
		
		String sql = "  SELECT ID, " +
				"       SCORE, " +
				"       REASON, " +
				"       DATE_CREATED, " +
				"       CREATED_BY, " +
				"       DATE_MODIFIED, " +
				"       MODIFIED_BY, " +
				"       GRA_ID, " +
				"       ST_ID " +
				"       FROM PROJECT_STATISTICS "; 
		
		try{
			ArrayList<ProjectStatistic> list = (ArrayList<ProjectStatistic>) jt.query(sql,
					new BeanPropertyRowMapper<ProjectStatistic>(ProjectStatistic.class));

			return list;
			
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}
	@Override
	public Long insert(ProjectStatistic stat, User user) {
		
		String sql = "INSERT INTO PROJECT_STATISTICS (ID, " +
				"                                SCORE, " +
				"                                REASON, " +
				"                                DATE_CREATED, " +
				"                                CREATED_BY, " +
				"                                GRA_ID, " +
				"                                ST_ID) " +
				"     VALUES (?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE, " +
				"             ?, " +
				"             ?, " +
				"             ?) " ;

try{
	Long pk  = getNextId("PS_SEQ");
	
	 int rowAdd = jt.update(sql, new Object[] { pk,stat.getScore(),stat.getReason(),
			 user.getCreatedBy(),stat.getGraId(),stat.getStId()});
	 
	 
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
	public Long update(ProjectStatistic stat, User user) {
		
		String sql = "  UPDATE PROJECT_STATISTICS " +
				"       SET SCORE = ?, " +
				"       REASON = ?, " +
				"       DATE_MODIFIED = SYSDATE, " +
				"       MODIFIED_BY = ?, " +
				"       GRA_ID = ?, " +
				"       ST_ID = ? " +
				"       WHERE ID = ? " ;
		
		try{
			  int rows = jt.update(sql, new Object[] {stat.getScore(),stat.getReason(),
					  user.getModifiedBy(),stat.getGraId(),stat.getStId(),stat.getId()});
			 
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
		
		String sql = "DELETE FROM PROJECT_STATISTICS WHERE id=?";		
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
