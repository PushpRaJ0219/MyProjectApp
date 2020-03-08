package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lowagie.text.Document;

import in.nit.dao.IDocumentDao;
import in.nit.service.IDocumentService;


@Service
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	private IDocumentDao dao;

	@Transactional(readOnly = true)
	@Override
	public List<Object[]> getFileIdAndNames() {

		return dao.getFileIdAndNames();
	}

	@Transactional
	@Override
	public Integer saveDocument(in.nit.model.Document doc) {
		return dao.saveDocument(doc);
	}

	@Transactional(readOnly = true)
	@Override
	public in.nit.model.Document getOneDocument(Integer id) {
		return dao.getOneDocument(id);
	}

}
