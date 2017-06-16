package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.Upload;
import gov.nysed.oce.ldgrants.user.domain.User;

public class UploadDao extends GenericDao<Upload, Long> {

	@Override
	public Upload select(Long id) {

		//@formatter:off
		String sql =  " SELECT  " +
				"       CONTENT_TYPE AS contentType, " +
				"       CREATED_BY AS createdBy, " +
				"       DAD_CHARSET AS dadCharset, " +
				"       DOC_TYPE AS docType, " +
				"       MIME_TYPE AS mimeType, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       NAME AS name, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       DOC_SIZE AS docSize, " +
				"       GRA_ID AS graId, " +
				"       LAST_UPDATED AS lastUpdated " +
				"       FROM uploads where id = ? " ;
		
		try{
		Upload uploadRecords = (Upload) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<Upload>(Upload.class));
				
				return uploadRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}

		return null;
	}

	@Override
	public List<Upload> selectAll() {
		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       CONTENT_TYPE AS contentType, " +
				"       CREATED_BY AS createdBy, " +
				"       DAD_CHARSET AS dadCharset, " +
				"       DOC_TYPE AS docType, " +
				"       MIME_TYPE AS mimeType, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       NAME AS name, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       DOC_SIZE AS docSize, " +
				"       GRA_ID AS graId, " +
				"       LAST_UPDATED AS lastUpdated " +
				"       FROM uploads " ;
		
		try {

			ArrayList<Upload> uploadList = (ArrayList<Upload>) jt.query(sql,
					new BeanPropertyRowMapper<Upload>(Upload.class));

			return uploadList;
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}
	
	@Override
	public Long insert(Upload upload, User user) {
		
		
		//@formatter:off
		String sql = "INSERT INTO UPLOADS (ID, " +
				"                     CONTENT_TYPE, " +
				"                     CREATED_BY, " +
				"                     DAD_CHARSET, " +
				"                     DOC_TYPE, " +
				"                     MIME_TYPE, " +
				"                     NAME, " +
				"                     DATE_CREATED, " +
				"                     DOC_SIZE, " +
				"                     GRA_ID, " +
				"                     LAST_UPDATED) " +
				"     VALUES (?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE) "; 
		
		
		
		try{
			Long pk  = getNextId("UPLOAD_SEQ");
			
	 int rowAdd = jt.update(sql, new Object[] { pk, upload.getContentType(),user.getCreatedBy(),upload.getDadCharset(),
			 upload.getDocType(),upload.getMimeType(),upload.getName(),upload.getDocSize(),
			 upload.getGraId()});
			 
	 
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
	public Long update(Upload upload, User user) {
		
		int rows=0 ;
		
		//@formatter:off
		String sql = "  UPDATE UPLOADS " +
				"       SET CONTENT_TYPE = ?, " +
				"       MODIFIED_BY = ?, " +
				"       DAD_CHARSET = ?, " +
				"       DOC_TYPE = ?, " +
				"       MIME_TYPE = ?, " +
				"       NAME = ?, " +
				"       DATE_MODIFIED = SYSDATE, " +
				"       DOC_SIZE = ?, " +
				"       GRA_ID = ? " +
				"       WHERE ID = ? " ;

		try{
			  rows = jt.update(sql, new Object[] {upload.getContentType(),user.getCreatedBy(),
					  upload.getDadCharset(),upload.getDocType(),upload.getMimeType(),upload.getName(),upload.getDocSize(),
					  upload.getGraId(), upload.getId()});
			  				  
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
	
	public ArrayList<Upload> searchByMimeType (String mimeType){
		
		//@formatter:off
		String sql = "SELECT ID AS id, " +
				"       MIME_TYPE AS mimeType, " +
				"       CONTENT_TYPE AS contentType, " +
				"       CREATED_BY AS createdBy, " +
				"       DAD_CHARSET AS dadCharset, " +
				"       DOC_TYPE AS docType, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       NAME AS name, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       DOC_SIZE AS docSize, " +
				"       GRA_ID AS graId, " +
				"       LAST_UPDATED AS lastUpdated " +
				"       FROM uploads " +
				"       WHERE UPPER (mimeType) LIKE UPPER (?) "; 
		
		


		try{
		List<Upload> types = jt.query(sql, new Object[] { '%' + mimeType + '%' },
				new BeanPropertyRowMapper<Upload>(Upload.class));

		if (types.size() > 0) {
			return (ArrayList<Upload>) types;
		} else
		{
			System.out.println("Getting no results");
			return null;
		}			
	}
	catch (Exception e) 
	{
		System.err.println("error searchByMimeType() " + e.toString());
	}
	
	return null;
		
	}

	@Override
	public boolean delete(Long id) {
		String sql = "DELETE FROM UPLOADS WHERE id=?";		
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
