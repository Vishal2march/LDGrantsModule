package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;

import gov.nysed.oce.ldgrants.grants.grant.dao.FiscalYearDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.FiscalYear;
import gov.nysed.oce.ldgrants.user.domain.User;

public class FiscalYearService implements GenericDaoService<FiscalYear, Long> {

	FiscalYearDao dao = new FiscalYearDao();

	public FiscalYear selectDescription(Long description) {

		return dao.selectFiscalYearByDescription(description);
	}

	@Override
	public FiscalYear select(Long code) {

		return dao.select(code);
	}

	// Extra methods, not currently using them.

	@Override
	public Long insert(FiscalYear t, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long update(FiscalYear t, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FiscalYear> selectAll() {
		
		return dao.selectAll();
	}
}
