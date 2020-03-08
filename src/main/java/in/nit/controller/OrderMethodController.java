package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.OrderMethod;
import in.nit.model.ShipmentType;
import in.nit.model.Uom;
import in.nit.service.IOrderMethodService;


@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;

	/**
	 * 
	 * Method 1
	 * 
	 */
	@RequestMapping("/register")
	public String showRegPage(@ModelAttribute OrderMethod orderMethod,Model model) {
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}

	/**
	 * 
	 * Method 2
	 * 
	 */

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveOrderMethodData(
			@ModelAttribute OrderMethod orderMethod,
			Model model 
			) 
	{
		Integer id = service.saveOrderMethod(orderMethod);
		String message = "OrderMethod-"+id+" saved";
		model.addAttribute("message",message);
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";

	}

	/**
	 * 
	 * Method 3
	 * 
	 */

	@RequestMapping("/all")
	public String getAllOrderData(Model model) {
		List<OrderMethod> list = service.getAllOrderMethod();
		model.addAttribute("list",list);		

		return "OrderMethodData";
	}

	/**
	 * 
	 * Method 4
	 * 
	 */
	@RequestMapping("/delete")
	public String deleteOrderMethodData(@RequestParam("omid")Integer id, Model model) {
		service.deleteOrderMethod(id);
		String message = "OrderMethod-"+id+" deleted";
		model.addAttribute("message", message);

		//fetch new data
		List<OrderMethod> list = service.getAllOrderMethod();
		model.addAttribute("list", list);
		return "OrderMethodData";

	}

	/**
	 * 
	 * Method 5
	 * 
	 */
	@RequestMapping("/edit")
	public String showEditOrderMethodPage(
			@RequestParam("omid")Integer id,
			Model model
			) 
	{
		OrderMethod om=service.getOneOrderMethod(id);
		model.addAttribute("orderMethod",om);
		return "OrderMethodEdit";
	}
	/**
	 * 
	 * Method 6
	 * 
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateOrderMethod(
			@ModelAttribute OrderMethod orderMethod,
			Model model)
	{
		service.updateOrderMethod(orderMethod);
		String message="OrderMethod '"+orderMethod.getOrderId()+"' Updated";
		model.addAttribute("message",message);
		List<OrderMethod> list=service.getAllOrderMethod();
		model.addAttribute("list",list);
		return "OrderMethodData";
	}

	/**
	 * 
	 * Method 7
	 * 
	 */
	@RequestMapping("/view")
	public String showOneOrderMethod(
			@RequestParam("omid")Integer id,
			Model model
			) 
	{
		OrderMethod om=service.getOneOrderMethod(id);
		model.addAttribute("ob",om);
		return "OrderMethodView";
	}

}


