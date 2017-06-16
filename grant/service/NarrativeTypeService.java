package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;
import gov.nysed.oce.ldgrants.grants.grant.dao.NarrativeTypeDao;
import gov.nysed.oce.ldgrants.grants.grant.domain.NarrativeType;
import gov.nysed.oce.ldgrants.user.domain.User;

public class NarrativeTypeService implements GenericDaoService<NarrativeType, Long> {

	NarrativeTypeDao dao = new NarrativeTypeDao();

	@Override
	public Long insert(NarrativeType t, User user) {

		return dao.insert(t, user);
	}

	@Override
	public Long update(NarrativeType t, User user) {

		return dao.update(t, user);
	}

	@Override
	public boolean delete(Long id) {

		return dao.delete(id);
	}

	@Override
	public NarrativeType select(Long id) {

		return dao.select(id);
	}

	@Override
	public List<NarrativeType> selectAll() {

		return dao.selectAll();
	}

}
