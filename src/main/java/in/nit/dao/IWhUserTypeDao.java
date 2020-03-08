package in.nit.dao;

import java.util.List;


import in.nit.model.WhUserType;

public interface IWhUserTypeDao {

	Integer saveWhUserType(WhUserType ob);
    void deleteWhUserType(Integer id);
    void updateWhUserType(WhUserType ob);
    WhUserType getOneWhUserType(Integer id);
    List<WhUserType> getAllWhUserTypes();
    //List<Object[]> getWhUserTypeModeCount();
}
