package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;
import gov.nysed.oce.ldgrants.grants.grant.dao.SystemFiscalYearDetailDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.SystemFiscalYearDetail;
import gov.nysed.oce.ldgrants.user.domain.User;

public class SystemFiscalYearDetailService implements GenericDaoService<SystemFiscalYearDetail,Long> {

	
	SystemFiscalYearDetailDao dao = new SystemFiscalYearDetailDao();
	
	@Override
	public Long insert(SystemFiscalYearDetail t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(SystemFiscalYearDetail t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public SystemFiscalYearDetail select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<SystemFiscalYearDetail> selectAll() {
		
		return dao.selectAll();
	}
	public List<SystemFiscalYearDetail> searchByFyCode (Long fyCode){
		
		return dao.searchByFyCode(fyCode);
	}

}
