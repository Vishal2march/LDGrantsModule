package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.SuppMatEquip;
import gov.nysed.oce.ldgrants.user.domain.User;

public class SuppMatEquipDao extends GenericDao<SuppMatEquip,Long> {

	
	@Override
	public SuppMatEquip select(Long id) {
		
		//@formatter:off
		String sql = "  SELECT AMEND_AMOUNT AS amendAmount, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       EXP_APROVED AS expApproved, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       FY_CODE AS fyCode, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       GRA_ID AS graId, " +
				"       ID AS id, " +
				"       INST_CONT AS instCont, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       QUANTITY AS quantity, " +
				"       SMET_CODE AS smetCode, " +
				"       UNIT_PRICE AS unitPrice, " +
				"       CREATED_BY AS createdBy, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       DESCRIPTION AS description, " +
				"       IS_TOTAL AS isTotal, " +
				"       JOURNAL_ENTRY AS journalEntry, " +
				"       VENDOR AS vendor, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       ENCUMBRANCE_DATE AS encumbranceDate " +
				"       FROM SUPP_MAT_EQUIPS where ID=? "; 
		
		try{
			SuppMatEquip suppRecords = (SuppMatEquip) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<SuppMatEquip>(SuppMatEquip.class));
				
				return suppRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}


		return null;
	}

	@Override
	public List<SuppMatEquip> selectAll() {
		
		//@formatter:off
		String sql = "  SELECT AMEND_AMOUNT AS amendAmount, " +
				"       AMOUNT_APPROVED AS amountApproved, " +
				"       EXP_APROVED AS expApproved, " +
				"       EXP_SUBMITTED AS expSubmitted, " +
				"       FY_CODE AS fyCode, " +
				"       GRANT_REQUEST AS grantRequest, " +
				"       GRA_ID AS graId, " +
				"       ID AS id, " +
				"       INST_CONT AS instCont, " +
				"       PROJ_TOTAL AS projTotal, " +
				"       QUANTITY AS quantity, " +
				"       SMET_CODE AS smetCode, " +
				"       UNIT_PRICE AS unitPrice, " +
				"       CREATED_BY AS createdBy, " +
				"       MODIFIED_BY AS modifiedBy, " +
				"       DESCRIPTION AS description, " +
				"       IS_TOTAL AS isTotal, " +
				"       JOURNAL_ENTRY AS journalEntry, " +
				"       VENDOR AS vendor, " +
				"       DATE_CREATED AS dateCreated, " +
				"       DATE_MODIFIED AS dateModified, " +
				"       ENCUMBRANCE_DATE AS encumbranceDate " +
				"       FROM SUPP_MAT_EQUIPS "; 
		
		try{
			ArrayList<SuppMatEquip> suppList = (ArrayList<SuppMatEquip>) jt.query(sql,
					new BeanPropertyRowMapper<SuppMatEquip>(SuppMatEquip.class));

			return suppList;
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}
	
	@Override
	public Long insert(SuppMatEquip equip, User user) {
		
		//@formatter:off
		String sql = "INSERT INTO SUPP_MAT_EQUIPS (ID, " +
				"                             AMEND_AMOUNT, " +
				"                             AMOUNT_APPROVED, " +
				"                             EXP_APROVED, " +
				"                             EXP_SUBMITTED, " +
				"                             FY_CODE, " +
				"                             GRANT_REQUEST, " +
				"                             GRA_ID, " +
				"                             INST_CONT, " +
				"                             PROJ_TOTAL, " +
				"                             QUANTITY, " +
				"                             SMET_CODE, " +
				"                             UNIT_PRICE, " +
				"                             CREATED_BY, " +
				"                             DESCRIPTION, " +
				"                             IS_TOTAL, " +
				"                             JOURNAL_ENTRY, " +
				"                             VENDOR, " +
				"                             DATE_CREATED, " +
				"                             ENCUMBRANCE_DATE) " +
				"                VALUES (?, " +
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
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE, " +
				"             SYSDATE) "; 

		try{
			Long pk  = getNextId("PROJ_BUDG_SEQ");
			
			 int rowAdd = jt.update(sql, new Object[] { pk,equip.getAmendAmount(),equip.getAmountApproved(),
					 equip.getExpApproved(),equip.getExpSubmitted(),equip.getFyCode(),equip.getGrantRequest(),
					 equip.getGraId(),equip.getInstCont(),equip.getProjTotal(),equip.getQuantity(),
					 equip.getSmetCode(),equip.getUnitPrice(),user.getCreatedBy(),equip.getDescription(),
					 equip.getIsTotal(),equip.getJournalEntry(),equip.getVendor()});
			 
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
	public Long update(SuppMatEquip equip, User user) {
		
		//@formatter:off
		String sql = "  UPDATE SUPP_MAT_EQUIPS " +
				"       SET AMEND_AMOUNT = ?, " +
				"       AMOUNT_APPROVED = ?, " +
				"       EXP_APROVED = ?, " +
				"       EXP_SUBMITTED = ?, " +
				"       FY_CODE = ?, " +
				"       GRANT_REQUEST = ?, " +
				"       GRA_ID = ?, " +
				"       INST_CONT = ?, " +
				"       PROJ_TOTAL = ?, " +
				"       QUANTITY = ?, " +
				"       SMET_CODE = ?, " +
				"       UNIT_PRICE = ?, " +
				"       MODIFIED_BY = ?, " +
				"       DESCRIPTION = ?, " +
				"       IS_TOTAL = ?, " +
				"       JOURNAL_ENTRY = ?, " +
				"       VENDOR = ?, " +
				"       DATE_MODIFIED = SYSDATE, " +
				"       ENCUMBRANCE_DATE = SYSDATE " +
				"       WHERE ID = ? "; 
		

		try{
			  int rows = jt.update(sql, new Object[] {user.getModifiedBy(),equip.getAmendAmount(),equip.getAmountApproved(),
					  equip.getExpApproved(),equip.getExpSubmitted(),equip.getFyCode(),equip.getGrantRequest(),
					  equip.getGraId(),equip.getInstCont(),equip.getProjTotal(),equip.getQuantity(),
					  equip.getSmetCode(),equip.getUnitPrice(),equip.getDescription(),equip.getIsTotal(),
					  equip.getJournalEntry(),equip.getVendor(),equip.getId()});
			  
			  
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
		
		String sql = "DELETE FROM SUPP_MAT_EQUIPS WHERE id=?";		
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
