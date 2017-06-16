package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;
import gov.nysed.oce.ldgrants.grants.grant.dao.TravelExpenseDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.TravelExpense;
import gov.nysed.oce.ldgrants.user.domain.User;

public class TravelExpenseService implements GenericDaoService<TravelExpense,Long>{

	
	TravelExpenseDao dao = new TravelExpenseDao();
	@Override
	public Long insert(TravelExpense t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(TravelExpense t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public TravelExpense select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<TravelExpense> selectAll() {
		
		return dao.selectAll();
	}

}
