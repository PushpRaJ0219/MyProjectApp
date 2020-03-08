package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;
import in.nit.model.Uom;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao{

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethod(OrderMethod orderMethod) {
		return (Integer)ht.save(orderMethod);	}

	@Override
	public List<OrderMethod> getAllOrderMethod() {
		List<OrderMethod> list = ht.loadAll(OrderMethod.class);
		return list;	}

	@Override
	public void deleteOrderMethod(Integer id) {
		ht.delete(new OrderMethod(id));
	}

	@Override
	public void updateOrderMethod(OrderMethod orderMethod) {
		ht.update(orderMethod);

	}

	@Override
	public OrderMethod getOneOrderMethod(Integer id) {

		return ht.get(OrderMethod.class, id);
	}



	public List<Object[]> getOrderIdAndCode(String mode) {
		String hql=" select orderId,orderCode from in.nit.model.OrderMethod where orderMode=?0 ";
		List<Object[]> list=(List<Object[]>) ht.find(hql, mode);
		return list;
	}



}
