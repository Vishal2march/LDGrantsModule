package gov.nysed.oce.ldgrants.grants.grant.service;

import java.util.List;

import gov.nysed.oce.ldgrants.user.domain.User;

public interface GenericDaoService<T, PK>
{
	public Long insert(T t,User user);
	public Long update(T t, User user);
	public boolean delete(PK id);
	public T select(PK id);
	public List<T> selectAll();
}
