package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.Authorization;
import gov.nysed.oce.ldgrants.user.domain.User;

public class AuthorizationDao extends GenericDao<Authorization, Long> {

	@Override
	public List<Authorization> selectAll() {

		//@formatter:off
		String sql = "  SELECT AFFILIATION AS affiliation, " +
				"       AUTH_DATE AS authDate, " +
				"       AUT_USER AS autUser, " +
				"       CREATED_BY AS createdBy, " +
				"       VERSION AS version, " +
				"       TITLE AS title, " +
				"       NAME AS name, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       ID AS id, " +
				"       GRA_ID AS graId, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified " +
				"       FROM AUTHORIZATIONS "; 
		
		try {

			ArrayList<Authorization> list = (ArrayList<Authorization>) jt.query(sql,
					new BeanPropertyRowMapper<Authorization>(Authorization.class));

			return list;
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}
	
	@Override
	public Authorization select(Long id) {
		
		//@formatter:off
		String sql = "  SELECT AFFILIATION AS affiliation, " +
				"       AUTH_DATE AS authDate, " +
				"       AUT_USER AS autUser, " +
				"       CREATED_BY AS createdBy, " +
				"       VERSION AS version, " +
				"       TITLE AS title, " +
				"       NAME AS name, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       ID AS id, " +
				"       GRA_ID AS graId, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified " +
				"       FROM AUTHORIZATIONS WHERE ID = ? "; 
		
		try{
			Authorization records =  jt.queryForObject(sql, new Object[] { id },
			        new BeanPropertyRowMapper<Authorization>(Authorization.class));
			
					return records;
					
				}catch (Exception e){
					System.out.println("AuthorizationDao.select()" + e.getMessage());
				}

		return null;
	}
	@Override
	public Long insert(Authorization auth, User user) {
		
		//@formatter:off
		String sql = "INSERT INTO AUTHORIZATIONS (ID, " +
				"                            AUTH_DATE, " +
				"                            AUT_USER, " +
				"                            CREATED_BY, " +
				"                            VERSION, " +
				"                            TITLE, " +
				"                            NAME, " +
				"                            MODIFIED_BY, " +
				"                            GRA_ID, " +
				"                            DATE_CREATED) " +
				"     VALUES (?, " +
				"             SYSDATE, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE) " ;

		
		try{
			Long pk  = getNextId("AUTHORIZATION_SEQ");
			int rowAdd = jt.update(sql, new Object[] { pk, auth.getAutUser(),user.getCreatedBy(),auth.getVersion(),
			auth.getTitle(),auth.getName(),user.getModifiedBy(),auth.getGraId()});
			
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
	public Long update(Authorization auth, User user) {
	
		//@formatter:off
		String sql =  " UPDATE AUTHORIZATIONS " +
				"       SET AUT_USER = ?, " +
				"       VERSION = ?, " +
				"       TITLE = ?, " +
				"       NAME = ?, " +
				"       MODIFIED_BY = ?, " +
				"       GRA_ID = ?, " +
				"       DATE_MODIFIED = SYSDATE " +
				"       WHERE id = ? " ;

		try{
			  
			Long rows = (long) jt.update(sql, new Object[] {auth.getAutUser(),auth.getVersion(),auth.getTitle(),
					auth.getName(),user.getModifiedBy(),auth.getGraId(),auth.getId()});
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
		
	String sql = "DELETE FROM AUTHORIZATIONS WHERE id=?";		
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

	public ArrayList<Authorization> searchByTitle (String title){
		
		//@formatter:off
		String sql = "  SELECT AFFILIATION AS affiliation, " +
				"       AUTH_DATE AS authDate, " +
				"       AUT_USER AS autUser, " +
				"       CREATED_BY AS createdBy, " +
				"       VERSION AS version, " +
				"       TITLE AS title, " +
				"       NAME AS name, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       ID AS id, " +
				"       GRA_ID AS graId, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified " +
				"       FROM AUTHORIZATIONS " +
				"       WHERE UPPER (title) LIKE UPPER (?) " ;
		
		try{
			List<Authorization> titles = jt.query(sql, new Object[] { '%' + title + '%' },
					new BeanPropertyRowMapper<Authorization>(Authorization.class));

			if (titles.size() > 0) {
				return (ArrayList<Authorization>) titles;
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
