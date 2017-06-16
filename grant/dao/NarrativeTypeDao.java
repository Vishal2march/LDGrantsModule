package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.NarrativeType;
import gov.nysed.oce.ldgrants.user.domain.User;

public class NarrativeTypeDao extends GenericDao<NarrativeType, Long> {

	public NarrativeTypeDao() {

	}

	@Override
	public List<NarrativeType> selectAll() {

		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       CAT_ID AS catId, " +
				"       CREATED_BY AS createdBy, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       DISPLAY_INSTRUCTION AS displayInstruction, " +
				"       DISPLAY_NAME AS displayName, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       NARRATIVE_NAME AS narrativeName, " +
				"       SORT_ORDER AS sortOrder " +
				"       FROM NARRATIVE_TYPES ";
			
		try {

			ArrayList<NarrativeType> narrativeTypeList = (ArrayList<NarrativeType>) jt.query(sql,
					new BeanPropertyRowMapper<NarrativeType>(NarrativeType.class));

			return narrativeTypeList;
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}
		
		return null;
	}
	
	@Override
	public NarrativeType select(Long id) {
		
		//@formatter:off
		String sql = "  SELECT ID AS id, " +
				"       CAT_ID AS catId, " +
				"       CREATED_BY AS createdBy, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       DISPLAY_INSTRUCTION AS displayInstruction, " +
				"       DISPLAY_NAME AS displayName, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       NARRATIVE_NAME AS narrativeName, " +
				"       SORT_ORDER AS sortOrder " +
				"       FROM NARRATIVE_TYPES " +
				"       WHERE ID = ? "; 	
		try{
		@SuppressWarnings("unchecked")
		NarrativeType typeRecords = (NarrativeType) jt.queryForObject(sql, new Object[] { id },
        new BeanPropertyRowMapper<NarrativeType>(NarrativeType.class));
		
		return typeRecords;
		
	}catch (Exception e){
		System.out.println("NarrativeTypeDao.select()" + e.getMessage());
	}
		return null;
	}
	@Override
	public Long insert(NarrativeType narrative, User user) {
		
		//@formatter:off
		String sql =  "INSERT INTO NARRATIVE_TYPES (ID, " +
				"                             CAT_ID, " +
				"                             CREATED_BY, " +
				"                             DATE_CREATED, " +
				"                             DATE_MODIFIED, " +
				"                             DISPLAY_INSTRUCTION, " +
				"                             DISPLAY_NAME, " +
				"                             MODIFIED_BY, " +
				"                             NARRATIVE_NAME, " +
				"                             SORT_ORDER) " +
				"     VALUES (?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE, " +
				"             SYSDATE, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?) "; 
				
				try{
					Long pk  = getNextId("PROJ_NARRATIVE_SEQ");
					
			 int rowAdd = jt.update(sql, new Object[] { pk, narrative.getCatId(),
					 user.getCreatedBy(),narrative.getDisplayInstruction(),narrative.getDisplayName(),
					 user.getModifiedBy(),narrative.getNarrativeName(),narrative.getSortOrder()});
				
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
	public Long update(NarrativeType narrative, User user) {
		
		//@formatter:off
		int rows=0 ;
		String sql = "  UPDATE NARRATIVE_TYPES " +
				"       SET DISPLAY_INSTRUCTION = ?, " +
				"       DISPLAY_NAME = ?, " +
				"       NARRATIVE_NAME = ?, " +
				"       SORT_ORDER = ?, " +
				"       DATE_MODIFIED = SYSDATE, " +
				"       MODIFIED_BY = ? " +
				"       WHERE ID = ?  " ;
		try{
  
		rows = jt.update(sql, new Object[] { narrative.getDisplayInstruction(),narrative.getDisplayName(),
				narrative.getSortOrder(),user.getModifiedBy(),narrative.getId()});
		if(rows == 1){
			  System.out.println("1 row updated");
				 return (long) rows;
		  }
			} catch (Exception e)
				{
				System.err.println("error updateGrant() " + e.toString());
				}
				
		return null;
	}

	@Override
	public boolean delete(Long id) {
		
		 String sql = "DELETE FROM NARRATIVE_TYPES WHERE id=?";		
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
