package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IPartDao;
import in.nit.model.Part;
import in.nit.model.Uom;



@Repository
public class PartDaoImpl implements IPartDao {

	@Autowired
	private HibernateTemplate ht;

	public Integer savePart(Part ob) {
		return (Integer)ht.save(ob);
	}

	@Override
	public List<Part> getAllParts() {
		List<Part> list = ht.loadAll(Part.class);
		return list;
	}
	
}
