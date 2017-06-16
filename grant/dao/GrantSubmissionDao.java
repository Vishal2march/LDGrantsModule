package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.dao.GenericDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.GrantSubmission;
import gov.nysed.oce.ldgrants.user.domain.User;

public class GrantSubmissionDao extends GenericDao<GrantSubmission, Long> {

	@Override
	public List<GrantSubmission> selectAll() {

		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       GRAS_USER AS grasUser, " +
				"       CREATED_BY AS createdBy, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       VERSION AS version, " +
				"       FMT_ID AS fmtId, " +
				"       GRA_ID AS gtaId, FY_FY_CODE " +
				"       FROM GRANT_SUBMISSIONS "; 
		
		try {

			ArrayList<GrantSubmission> list = (ArrayList<GrantSubmission>) jt.query(sql,
					new BeanPropertyRowMapper<GrantSubmission>(GrantSubmission.class));

			return list;
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}
	
	@Override
	public GrantSubmission select(Long id) {
		
		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       GRAS_USER AS grasUser, " +
				"       CREATED_BY AS createdBy, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       VERSION AS version, " +
				"       FMT_ID AS fmtId, " +
				"       GRA_ID AS gtaId, FY_FY_CODE " +
				"       FROM GRANT_SUBMISSIONS WHERE ID=? "; 
		
		try{
			GrantSubmission records =  jt.queryForObject(sql, new Object[] { id },
			 new BeanPropertyRowMapper<GrantSubmission>(GrantSubmission.class));
			
					return records;
					
				}catch (Exception e){
					System.out.println("GrantSubmissionDao.select()" + e.getMessage());
				}

		return null;
	}

	@Override
	public Long insert(GrantSubmission submission, User user) {
		
		//@formatter:off
		String sql="INSERT INTO GRANT_SUBMISSIONS (ID, " +
				"                               DATE_SUBMITTED, " +
				"                               GRAS_USER, " +
				"                               VERSION, " +
				"                               DATE_CREATED, " +
				"                               CREATED_BY, " +
				"                               GRA_ID, " +
				"                               FMT_ID, " +
				"                               FY_FY_CODE) " +
				"     VALUES (?, " +
				"             SYSDATE, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?) "; 

		
		try{
			Long pk  = getNextId("GRA_SUB_SEQ");
			int rowAdd = jt.update(sql, new Object[] { pk,submission.getGrasUser(),submission.getVersion(),
					user.getCreatedBy(),submission.getGraId(),submission.getFmtId(),submission.getFyFyCode()});
			
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
	public Long update(GrantSubmission submission, User user) {
		
		//@formatter:off
		String sql= "   UPDATE GRANT_SUBMISSIONS " +
				"       SET GRAS_USER = ?, " +
				"       MODIFIED_BY = ?, " +
				"       DATE_MODIFIED = SYSDATE, " +
				"       VERSION = ?, " +
				"       FMT_ID = ?, " +
				"       GRA_ID = ? , FY_FY_CODE = ?" +
				"       WHERE ID = ? " ;
		try{
		
		Long rows = (long) jt.update(sql, new Object[] {submission.getGrasUser(),user.getModifiedBy(),
		submission.getVersion(),submission.getFmtId(),submission.getGraId(),submission.getFyFyCode(),
		submission.getId()});

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
	
		String sql = "DELETE FROM GRANT_SUBMISSIONS WHERE id=?";		
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
