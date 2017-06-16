package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.ProjectNarrative;
import gov.nysed.oce.ldgrants.user.domain.User;

public class ProjectNarrativeDao extends GenericDao<ProjectNarrative, Long> {

	@Override
	public List<ProjectNarrative> selectAll() {

		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       CREATED_BY AS createdBy, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       GRA_ID AS graId, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       NARRATIVE_DESCR AS narrativeDescr, " +
				"       NAT_ID AS natId, " +
				"       STATISTIC_DESCR AS statisticDescr " +
				"       FROM PROJECT_NARRATIVES" ;
		
		try {

			ArrayList<ProjectNarrative> narrativeList = (ArrayList<ProjectNarrative>) jt.query(sql,
					new BeanPropertyRowMapper<ProjectNarrative>(ProjectNarrative.class));

			return narrativeList;
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}	

	@Override
	public ProjectNarrative select(Long id) {
		
		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       CREATED_BY AS createdBy, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       GRA_ID AS graId, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       NARRATIVE_DESCR AS narrativeDescr, " +
				"       NAT_ID AS natId, " +
				"       STATISTIC_DESCR AS statisticDescr " +
				"       FROM PROJECT_NARRATIVES where id = ? " ;
		
		try{
		ProjectNarrative records =  jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<ProjectNarrative>(ProjectNarrative.class));
		
				return records;
				
			}catch (Exception e){
				System.out.println("ProjectNarrativeDao.select()" + e.getMessage());
			}

		return null;
	}
	
	@Override
	public Long insert(ProjectNarrative projectNarr, User user) {
		
		//@formatter:off
		String sql = "INSERT INTO project_narratives (ID, " +
				"                                GRA_ID, " +
				"                                NARRATIVE_DESCR, " +
				"                                NAT_ID,                             " +
				"       DATE_CREATED, " +
				"       CREATED_BY)  " +
				"       VALUES (?, " +
				"       ?,  " +
				"       EMPTY_CLOB(), " +
				"       ?, " +
				"       SYSDATE, ?) " ;

		
		try{
			Long pk  = getNextId("PROJ_NARRATIVE_SEQ");
			int rowAdd = jt.update(sql, new Object[] { pk,projectNarr.getGraId(),
					projectNarr.getNatId(),user.getCreatedBy()});
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
	public Long update(ProjectNarrative projectNarr, User user) {
		
		//@formatter:off
		String sql = "  UPDATE PROJECT_NARRATIVES " +
				"       SET NAT_ID = ?, " +
				"       GRA_ID = ?, " +
				"       MODIFIED_BY = ?, " +
				"       DATE_MODIFIED = SYSDATE " +
				"       WHERE ID = ? " ;

		
		try{
			  
			Long rows = (long) jt.update(sql, new Object[] {projectNarr.getNatId(),projectNarr.getGraId(),
					   user.getModifiedBy(),projectNarr.getId()});
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
		
		String sql = "DELETE FROM PROJECT_NARRATIVES WHERE id=?";		
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
	
	public ArrayList<ProjectNarrative> searchByGraId (Long graId){
		
		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       CREATED_BY AS createdBy, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       GRA_ID AS graId, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       NARRATIVE_DESCR AS narrativeDescr, " +
				"       NAT_ID AS natId, " +
				"       STATISTIC_DESCR AS statisticDescr " +
				"       FROM PROJECT_NARRATIVES " +
				"       WHERE GRA_ID = ? "; 
		
		try{
		ArrayList<ProjectNarrative> pnList = (ArrayList<ProjectNarrative>) jt.query(sql, 
				new Object[] { graId }, new BeanPropertyRowMapper<ProjectNarrative>(ProjectNarrative.class));

		return pnList;
		
		} catch (Exception e) {
			System.err.println("searchByGraId()" + e.getMessage());
		}
		return null;
		
	}
	
	
}
