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


import in.nit.model.WhUserType;

import in.nit.service.IWhUserTypeService;

import in.nit.util.WhUserTypeUtil;


import in.nit.view.WhUserTypeExcelView;
import in.nit.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WhUserTypeUtil util;

	@Autowired
	private IWhUserTypeService service;
	
	/**
	 * 
	 * Method 1
	 * 
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveWhUserType(
			@ModelAttribute WhUserType whUserType,
			Model model)
	{
		Integer id=service.saveWhUserType(whUserType);
		String message="WhUserType '"+id+"' saved";
		model.addAttribute("message",message);
		model.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeRegister";
	}
	
	/**
	 * 
	 * Method 2
	 * 
	 */
	@RequestMapping("/register")
	public String showRegPage(@ModelAttribute WhUserType s,Model model) {
		model.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeRegister";
	}
	
	/**
	 * 
	 * Method 3
	 * 
	 */
	@RequestMapping("/all")
	public String getAllWhUserTypes(Model model) {
		List<WhUserType> list=service.getAllWhUserTypes();
		model.addAttribute("list",list);
		return "WhUserTypeData";
	}

	/**
	 * 
	 * Method 4
	 * 
	 */
	@RequestMapping("/delete")
	public String deleteWhUserType(@RequestParam("wuid")Integer id,Model model)
	{
		service.deleteWhUserType(id);
		String message="WhUserType '"+id+"' Deleted";
		model.addAttribute("message",message);
		//fetch new data
		List<WhUserType> list=service.getAllWhUserTypes();
		model.addAttribute("list",list);
		return "WhUserTypeData";
	}
	
	/**
	 * 
	 * Method 5
	 * 
	 */
	@RequestMapping("/edit")
	public String showEditPage(
			@RequestParam("wuid")Integer id,
			Model model
			) 
	{
		WhUserType wh=service.getOneWhUserType(id);
		model.addAttribute("whUserType",wh);
		return "WhUserTypeEdit";
	}
	/**
	 * 
	 * Method 6
	 * 
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateWhUserType(
			@ModelAttribute WhUserType whUserType,
			Model model)
	{
		service.updateWhUserType(whUserType);
		String message="WhUserType '"+whUserType.getUserId()+"' Updated";
		model.addAttribute("message",message);
		List<WhUserType> list=service.getAllWhUserTypes();
		model.addAttribute("list",list);
		return "WhUserTypeData";
	}

	/**
	 * 
	 * Method 7
	 * 
	 */
	@RequestMapping("/view")
	public String showOneShipment(
			@RequestParam("wuid")Integer id,
			Model model
			) 
	{
		WhUserType wh=service.getOneWhUserType(id);
		model.addAttribute("ob",wh);
		return "WhUserTypeView";
	}

	/**
	 * 
	 * Method 8
	 * 
	 */
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="id",required =false)Integer id) {

		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypeExcelView());

		if(id==null) {
			//export all rows
			List<WhUserType> list=service.getAllWhUserTypes();
			m.addObject("list",list);

		}else {
			//fetching data from DB

			WhUserType wh=service.getOneWhUserType(id);
			m.addObject("list",Arrays.asList(wh));
		}
		return m;
	}

	/**
	 * 
	 * Method 9
	 * 
	 */
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="id",required =false)Integer id) {

		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypePdfView());
		if(id==null) {
			List<WhUserType> list=service.getAllWhUserTypes();
			//send data to PDF File
			m.addObject("list", list);
		}
		else {
			@SuppressWarnings("unused")
			WhUserType wh=service.getOneWhUserType(id);
			m.addObject("list",Arrays.asList(wh));
		}
		return m;
	}

	/**
	 * 
	 * Method 9
	 * 
	 */

	/*
	 * @RequestMapping("/charts") public String showCharts() { List<Object[]>
	 * list=service.getWhUserTypeModeCount(); String path=context.getRealPath("/");
	 * util.generatePie(path, list); util.generateBar(path, list); return
	 * "ShipmentTypeCharts"; }
	 */
}

	

