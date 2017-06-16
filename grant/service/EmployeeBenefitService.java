package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;
import gov.nysed.oce.ldgrants.grants.grant.dao.EmployeeBenefitDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.EmployeeBenefit;
import gov.nysed.oce.ldgrants.user.domain.User;

public class EmployeeBenefitService  implements GenericDaoService<EmployeeBenefit,Long> {

	EmployeeBenefitDao dao = new EmployeeBenefitDao();
	
	@Override
	public Long insert(EmployeeBenefit t, User user) {
	
		return dao.insert(t, user);
	}

	@Override
	public Long update(EmployeeBenefit t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public EmployeeBenefit select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<EmployeeBenefit> selectAll() {
		
		return dao.selectAll();
	}

}
