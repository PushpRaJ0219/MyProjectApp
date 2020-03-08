package in.nit.dao;

import java.util.List;

import in.nit.model.OrderMethod;


public interface IOrderMethodDao {
	Integer saveOrderMethod(OrderMethod orderMethod);
	void updateOrderMethod(OrderMethod orderMethod);
	void deleteOrderMethod(Integer id);
	OrderMethod getOneOrderMethod(Integer id);
	List<OrderMethod> getAllOrderMethod();
	List<Object[]> getOrderIdAndCode(String mode);
}
