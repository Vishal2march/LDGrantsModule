package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.SpMtEqType;
import gov.nysed.oce.ldgrants.user.domain.User;

public class SpMtEqTypeDao extends GenericDao<SpMtEqType,Long> {

	@Override
	public List<SpMtEqType> selectAll() {
		
		String sql = "  SELECT CODE, " +
				"       CREATED_BY, " +
				"       DATE_CREATED, " +
				"       DATE_MODIFIED, " +
				"       DESCRIPTION, " +
				"       MODIFIED_BY " +
				"       FROM SP_MT_EQ_TYPES "; 
		
		try{
			ArrayList<SpMtEqType> list = (ArrayList<SpMtEqType>) jt.query(sql,
					new BeanPropertyRowMapper<SpMtEqType>(SpMtEqType.class));

			return list;
			
		} catch (Exception e) {
			System.err.println("selectAll()" + e.getMessage());
		}
		return null;
	}
	@Override
	public Long insert(SpMtEqType obj, User user) {
		
		return null;
	}

	@Override
	public Long update(SpMtEqType obj, User user) {
		
		return null;
	}

	@Override
	public boolean delete(Long id) {
		
		return false;
	}

	@Override
	public SpMtEqType select(Long id) {
			
		return null;
	}

	

}
