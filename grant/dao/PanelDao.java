package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.Panel;
import gov.nysed.oce.ldgrants.user.domain.User;

public class PanelDao extends GenericDao<Panel,Long> {

	public PanelDao(){
		
	}
	
	public ArrayList<Panel> searchByFyCode (Long fyCode){
		
		String sql = "  SELECT NAME, " +
				"       FY_CODE, " +
				"       STATUS, " +
				"       DESCR, " +
				"       MODIFIED_BY, " +
				"       CREATED_BY, " +
				"       AMT_AVAILABLE, " +
				"       FUND_RATIO, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM ldgrants.PANELS " +
				"       WHERE UPPER (fy_code) LIKE (?) "; 

				
				try{
					List<Panel> names = jt.query(sql, new Object[] { '%' + fyCode + '%' },
							new BeanPropertyRowMapper<Panel>(Panel.class));

					if (names.size() > 0) {
						return (ArrayList<Panel>) names;
					} else
					{
						System.out.println("Getting no results");
						return null;
					}			
				}
				catch (Exception e) 
				{
					System.err.println("error searchByFyCode() " + e.toString());
				}
		return null;
		
	}
	@Override
	public Panel select(Long id) {
		
		String sql = "  SELECT  " +
				"       NAME, " +
				"       STATUS, " +
				"       DESCR, " +
				"       MODIFIED_BY, " +
				"       CREATED_BY, " +
				"       AMT_AVAILABLE, " +
				"       FY_CODE, " +
				"       FUND_RATIO, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM ldgrants.PANELS WHERE ID =? ";
		
		try{
			Panel panelRecords = (Panel) jt.queryForObject(sql, new Object[] { id },
		        new BeanPropertyRowMapper<Panel>(Panel.class));
				
				return panelRecords;
			}catch (Exception e){
				System.out.println("select()" + e.getMessage());
			}
		return null;
	}

	@Override
	public List<Panel> selectAll() {
		
		String sql = "  SELECT ID, " +
				"       NAME, " +
				"       STATUS, " +
				"       DESCR, " +
				"       MODIFIED_BY, " +
				"       CREATED_BY, " +
				"       AMT_AVAILABLE, " +
				"       FY_CODE, " +
				"       FUND_RATIO, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED " +
				"       FROM ldgrants.PANELS "; 
		
		try{
			ArrayList<Panel> list = (ArrayList<Panel>) jt.query(sql,
					new BeanPropertyRowMapper<Panel>(Panel.class));

			return list;
			
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}

		return null;
	}
	
	@Override
	public Long insert(Panel panel, User user) {
		
		String sql = "INSERT INTO ldgrants.PANELS (ID, " +
				"                             NAME, " +
				"                             STATUS, " +
				"                             DESCR, " +
				"                             CREATED_BY, " +
				"                             AMT_AVAILABLE, " +
				"                             FY_CODE, " +
				"                             FUND_RATIO, " +
				"                             DATE_CREATED) " +
				"     VALUES (?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             ?, " +
				"             SYSDATE) " ;

        
try{
	Long pk  = getNextId("pan_seq");
	
	 int rowAdd = jt.update(sql, new Object[] { pk,panel.getName(),panel.getStatus(),
			 panel.getDescr(),user.getCreatedBy(),panel.getAmtAvailable(),panel.getFyCode(),
			 panel.getFundRatio()});
	 
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
	public Long update(Panel panel, User user) {
		
		String sql = "  UPDATE ldgrants.PANELS " +
				"       SET NAME = ?, " +
				"       STATUS = ?, " +
				"       DESCR = ?, " +
				"       MODIFIED_BY = ?, " +
				"       AMT_AVAILABLE = ?, " +
				"       FY_CODE = ?, " +
				"       FUND_RATIO = ?, " +
				"       DATE_MODIFIED = SYSDATE " +
				"       WHERE ID = ? " ;
		
		try{
			  int rows = jt.update(sql, new Object[] {panel.getName(),panel.getStatus(),
						 panel.getDescr(),user.getModifiedBy(),panel.getAmtAvailable(),panel.getFyCode(),
						 panel.getFundRatio(),panel.getId()});
			  
			  
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
		
		String sql = "DELETE FROM ldgrants.PANELS WHERE id=?";		
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
