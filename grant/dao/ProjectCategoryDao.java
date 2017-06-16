package gov.nysed.oce.ldgrants.grants.grant.dao;

import java.util.*;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import gov.nysed.oce.ldgrants.grants.grant.domain.ProjectCategory;
import gov.nysed.oce.ldgrants.user.domain.User;

public class ProjectCategoryDao extends GenericDao<ProjectCategory, Long> {

	public ProjectCategoryDao() {
	}

	@Override
	public ProjectCategory select(Long id) {

		//@formatter:off
			String sql = "  SELECT s.ID, " +
					"       s.DESCR, " +
					"       s.DATE_CREATED, " +
					"       s.INACTIVE_DATE " +
					"       FROM PROJECT_CATEGORIES s " +
					"       WHERE s.ID = ? " ;
			try{

			ProjectCategory category = (ProjectCategory) jt.queryForObject(sql, new Object[] { id },
					new BeanPropertyRowMapper<ProjectCategory>(ProjectCategory.class));

			return category;
		} catch (Exception e)
		{
			System.err.println("error selectProjectCategory() " + e.toString());
		}
		return null;
	}

	public ArrayList<ProjectCategory> searchProjectCategoryByDescr(String Descr) {
		

			//@formatter:off
	String sql = "  SELECT s.ID, " +
			"       s.DESCR, " +
			"       s.DATE_CREATED, " +
			"       s.INACTIVE_DATE " +
			"       FROM PROJECT_CATEGORIES s " +
			"       WHERE UPPER (s.DESCR) LIKE UPPER (?) " ;

 try{
			List<ProjectCategory> descr = jt.query(sql, new Object[] { '%' + Descr + '%' },
					new BeanPropertyRowMapper<ProjectCategory>(ProjectCategory.class));

			if (descr.size() > 0) 
			{
				return (ArrayList<ProjectCategory>) descr;
			} else 
			{
				System.out.println("Getting no results");
				return null;
			}

		} catch (Exception e) {
			System.err.println("error searchProjectCategoryByDescr() " + e.toString());
		}
		return null;
	}

	@Override
	public Long insert(ProjectCategory obj, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long update(ProjectCategory obj, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProjectCategory> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
