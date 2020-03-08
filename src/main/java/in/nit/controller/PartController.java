package in.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.nit.model.Part;
import in.nit.model.Uom;
import in.nit.service.IOrderMethodService;
import in.nit.service.IPartService;
import in.nit.service.IUomService;
import in.nit.util.CommonUtil;


@Controller
@RequestMapping("/part")
public class PartController {

	@Autowired
	private IPartService service;
	@Autowired
	private IUomService uomService;
	@Autowired
	private IOrderMethodService orderMethodService;

	private void commonUi(Model model)
	{
		//UOM RELATED
		List<Object[]>uomList = uomService.getUomIdAndUomModel();
		Map<Integer,String> uomMap=CommonUtil.convert(uomList);
		model.addAttribute("uomMap", uomMap);

		
		//ORDERMETHOD RELATED
		List<Object[]> omSaleList=orderMethodService.getOrderIdAndCode("Sale");
		Map<Integer,String> omSaleMap=CommonUtil.convert(omSaleList);
		model.addAttribute("omSaleMap", omSaleMap);

		//ORDERMETHOD RELATED
		List<Object[]> omPurchaseList=orderMethodService.getOrderIdAndCode("Purchase");
		Map<Integer,String> omPurchaseMap=CommonUtil.convert(omPurchaseList);
		model.addAttribute("omPurchaseMap", omPurchaseMap);

	}


	/*
	 * 1.This method is used to display Part Register page on URL:-
	 * /register , GET
	 */
	@RequestMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("part", new Part());
		commonUi(model);
		return "PartRegister";
	}

	/*
	 * 2.This method is used to save Part data on URL:- /save , POST
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePart(@ModelAttribute Part part, Model model) {
		Integer id = service.savePart(part);
		String message = "Part '" + id + "' Saved";
		model.addAttribute("message", message);
		model.addAttribute("part", new Part());
		commonUi(model);
		return "PartRegister";
	}

	@RequestMapping("/all")
	public String getAllPartData(Model model) {
		List<Part> list = service.getAllParts();
		model.addAttribute("list",list);		

		return "PartData";



	}
}

