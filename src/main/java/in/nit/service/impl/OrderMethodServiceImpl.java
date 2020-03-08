package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService{
	
	@Autowired
	private IOrderMethodDao dao;

	@Transactional
	@Override
	public Integer saveOrderMethod(OrderMethod orderMethod) {
		return dao.saveOrderMethod(orderMethod);
	}

	@Transactional(readOnly = true)
	@Override
	public List<OrderMethod> getAllOrderMethod() {
		List<OrderMethod> list = dao.getAllOrderMethod();
		Collections.sort(list, (o1, o2)->o1.getOrderId()-o2.getOrderId());
		return list;
	}
	
	@Transactional
	@Override
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);		
	}
	@Transactional
	@Override
	public void updateOrderMethod(OrderMethod orderMethod) {
		dao.updateOrderMethod(orderMethod);
		
	}
	@Transactional(readOnly = true)
	@Override
	public OrderMethod getOneOrderMethod(Integer id) {
		    
		return  dao.getOneOrderMethod(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Object[]> getOrderIdAndCode(String mode) {
		
		return dao.getOrderIdAndCode(mode);
	}
	
}
