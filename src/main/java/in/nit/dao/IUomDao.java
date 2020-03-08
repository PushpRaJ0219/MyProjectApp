package in.nit.dao;

import java.util.List;

import in.nit.model.ShipmentType;
import in.nit.model.Uom;

public interface IUomDao {
	Integer saveUom(Uom ob);
	void deleteUom(Integer id);
    void updateUom(Uom ob);
    Uom getOneUom(Integer id);
    List<Uom> getAllUom();
    List<Object[]> getUomIdAndUomModel();
}
