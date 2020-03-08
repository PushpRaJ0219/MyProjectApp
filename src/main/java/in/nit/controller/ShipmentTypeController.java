package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.util.ShipmentTypeUtil;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtil util;

//****************************************SHIPMENT TYPE MODEL***********************************************************	
	/*
	 * 1.This method is used to display ShipmentType Register page on URL:-
	 * /register , GET
	 */
	@RequestMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}

	/*
	 * 2.This method is used to save ShipmentType data on URL:- /save , POST
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveShipment(@ModelAttribute ShipmentType shipmentType, Model model) {
		Integer id = service.saveShipmentType(shipmentType);
		String message = "ShipmentType '" + id + "' Saved";
		model.addAttribute("message", message);
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}

	/*
	 * 3. This method is used to Fetch the Data from ShipmentType table on URL:-
	 * /all, GET
	 */
	@RequestMapping("/all") // GET
	public String getAllShipmentTypes(Model model) {
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	/*
	 * 4. This method is used to delete 1 row from ShipmentType table on URL: -
	 * /delete, GET
	 */
	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam("sid") Integer id, Model model) {
		service.deleteShipmentType(id);
		String message = "Shipment Id '" + id + "' is Deleted";
		model.addAttribute("message", message);

		// 5.--Fetch New Data-----
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	/*
	 * this method is used to edit particular row from shipmentType table on url :-
	 * /edit, GET
	 */
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid") Integer id, Model model) {
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("shipmentType", st);
		return "ShipmentTypeEdit";
	}

	/*
	 * this method is used to update
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {
		service.updateShipmentType(shipmentType);
		String message = "ShipmentType '" + shipmentType.getShipId() + "' Updated";
		model.addAttribute("message", message);
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	/*
	 * this method is used to view one row in a seporate page
	 */
	@RequestMapping("/view")
	public String showOneShipment(@RequestParam("sid") Integer id, Model model) {
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("ob", st);
		return "ShipmentTypeView";
	}

	/*
	 * Export DB to Excel Sheet
	 * 
	 * @RequestMapping("/excel") public ModelAndView showExcel() { ModelAndView m =
	 * new ModelAndView(); m.setView(new ShipmentTypeExcelView());
	 * 
	 * // fetching data from DB List<ShipmentType> list =
	 * service.getAllShipmentTypes(); m.addObject("list",list); return m;
	 * 
	 * }
	 */
	
	
	/**
     * 
     * Method 8
     * 
     */
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="id",required =false)Integer id) {
		
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		
		if(id==null) {
			//export all rows
			List<ShipmentType> list=service.getAllShipmentTypes();
			m.addObject("list",list);
			
		}else {
		//fetching data from DB
		
		ShipmentType st=service.getOneShipmentType(id);
		m.addObject("list",Arrays.asList(st));
		}
		return m;
	}

	/**
	 * 
	 * Method 9
	 * 
	 */
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value = "id", required = false) Integer id) {

		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		if (id == null) {
			List<ShipmentType> list = service.getAllShipmentTypes();
			// send data to PDF File
			m.addObject("list", list);
		} else {
			@SuppressWarnings("unused")
			ShipmentType st = service.getOneShipmentType(id);
			m.addObject("list", Arrays.asList(st));
		}
		return m;
	}
	
	/**
	 * 10..chart genetare
	 */
	@RequestMapping("/charts")
	public String ShowCharts()
	{
		List<Object[]> list=service.getShipmentModeCount();
		String path=context.getRealPath("/");
		util.generateBar(path, list);
		util.generatePie(path, list);
		return "ShipmentTypeCharts";
		
	}
}
