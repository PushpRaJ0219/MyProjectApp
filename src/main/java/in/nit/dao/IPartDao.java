package in.nit.dao;

import java.util.List;

import in.nit.model.Part;
import in.nit.model.Uom;



public interface IPartDao {
	Integer savePart(Part ob);
	List<Part> getAllParts();
	
}
