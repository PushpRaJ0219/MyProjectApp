package in.nit.service;

import java.util.List;

import in.nit.model.Uom;

public interface IUomService {
	Integer saveUom(Uom ob);
	List<Uom> getAllUom();
	void deleteUom(Integer id);
	Uom getOneUom(Integer id);
    void updateUom(Uom ob);
    List<Object[]> getUomIdAndUomModel();
}
