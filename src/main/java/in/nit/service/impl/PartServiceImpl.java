package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPartDao;
import in.nit.model.Part;
import in.nit.model.Uom;
import in.nit.service.IPartService;

@Service
public class PartServiceImpl implements IPartService {

	@Autowired
	private IPartDao dao;
	
	@Transactional
	public Integer savePart(Part ob) {
		return dao.savePart(ob);
	}
	

	@Transactional(readOnly = true)
	@Override
	public List<Part> getAllParts() {
		List<Part> list = dao.getAllParts();
		Collections.sort(list, (u1, u2)->u1.getId()-u2.getId());
		return list;
	}

}
