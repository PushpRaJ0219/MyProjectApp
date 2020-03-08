package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IWhUserTypeDao;
import in.nit.model.WhUserType;
@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveWhUserType(WhUserType ob) {
		return (Integer) ht.save(ob);
	}

	@Override
	public void deleteWhUserType(Integer id) {
		ht.delete(new WhUserType(id));
		
	}

	@Override
	public void updateWhUserType(WhUserType ob) {
		ht.update(ob);
	}

	@Override
	public WhUserType getOneWhUserType(Integer id) {
		return ht.get(WhUserType.class,id);
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}

	/*
	 * //asking doubt
	 * 
	 * @Override public List<Object[]> getWhUserTypeModeCount() { String
	 * hql=" select shipMode,count(shipMode) " + " from in.nit.model.WhUserType " +
	 * " group by shipMode ";
	 * 
	 * return (List<Object[]>) ht.find(hql); }
	 */
	
}
