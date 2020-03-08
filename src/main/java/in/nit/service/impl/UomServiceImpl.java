package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
import in.nit.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {
	
	@Autowired
	private IUomDao dao;

	@Transactional
	@Override
	public Integer saveUom(Uom uom) {
		return dao.saveUom(uom);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Uom> getAllUom() {
		List<Uom> list = dao.getAllUom();
		Collections.sort(list, (u1, u2)->u1.getid()-u2.getid());
		return list;
	}
	
	@Transactional
	
	public void deleteUom(Integer id) {
		dao.deleteUom(id);
	}
	
	@Transactional(readOnly = true)

	public Uom getOneUom(Integer id) {
		
		return dao.getOneUom(id);
	}

	@Transactional
	public void updateUom(Uom uom) {
		dao.updateUom(uom);
		
	}
	
	@Transactional
	public List<Object[]> getUomIdAndUomModel() {
		
		return dao.getUomIdAndUomModel();
	}

}
