package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.ArrayList;
import java.util.List;
import gov.nysed.oce.ldgrants.grants.grant.dao.PersonalServiceDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.PersonalService;
import gov.nysed.oce.ldgrants.user.domain.User;

public class PersonalServiceService implements GenericDaoService<PersonalService,Long>{

	PersonalServiceDao dao = new PersonalServiceDao();
	
	@Override
	public Long insert(PersonalService t, User user) {
		
		return dao.insert(t, user);
	}

	@Override
	public Long update(PersonalService t, User user) {
	
		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {
		
		return dao.delete(id);
	}

	@Override
	public PersonalService select(Long id) {
		
		return dao.select(id);
	}

	@Override
	public List<PersonalService> selectAll() {
		
		return dao.selectAll();
	}
	
	public ArrayList<PersonalService> searchByTitle (String title){
		
		return dao.searchByTitle(title);
	}

}
