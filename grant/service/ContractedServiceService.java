package gov.nysed.oce.ldgrants.grants.grant.service;
import java.util.List;
import gov.nysed.oce.ldgrants.grants.grant.dao.ContractedServiceDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.ContractedService;
import gov.nysed.oce.ldgrants.user.domain.User;

public class ContractedServiceService implements GenericDaoService<ContractedService,Long> {

	ContractedServiceDao dao = new ContractedServiceDao();
	
	@Override
	public Long insert(ContractedService t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(ContractedService t, User user) {
		
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public ContractedService select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<ContractedService> selectAll() {
		
		return dao.selectAll();
	}

}
