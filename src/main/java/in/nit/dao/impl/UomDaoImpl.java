package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomDao;
import in.nit.model.ShipmentType;
import in.nit.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao{
	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUom(Uom uom) {
		return (Integer)ht.save(uom);
	}

	@Override
	public List<Uom> getAllUom() {
		List<Uom> list = ht.loadAll(Uom.class);
		return list;
	}

	@Override
	public void deleteUom(Integer id) {
		
		ht.delete(new Uom(id));
		
	}

	@Override
	public Uom getOneUom(Integer id) {
		
		return ht.get(Uom.class,id);
		
	}

	public void updateUom(Uom ob) {

		 ht.update(ob);
		
	}
	
	@Override
	public List<Object[]> getUomIdAndUomModel() {
		String hql= " Select id,uomModel from in.nit.model.Uom";
		List<Object[]> list= (List<Object[]>) ht.find(hql);
		return list
				;
	}

	
	

}
	