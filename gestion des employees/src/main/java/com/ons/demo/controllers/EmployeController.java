package com.ons.demo.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ons.demo.entities.Employe;
import com.ons.demo.services.EmployeService;

@Controller
public class EmployeController {
	
	@Autowired
	EmployeService employeService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "ajouteEmploye";
	}
	
	@RequestMapping("/saveEmploye")
	public String saveEmploye(@ModelAttribute("employe") Employe employe,@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateNaissance = dateformat.parse(String.valueOf(date)); 
	employe.setDateNaissance(dateNaissance);
	Employe saveEmploye = employeService.saveEmploye(employe);
	String msg ="employe enregistré avec Id "+saveEmploye.getIdEmploye();
	modelMap.addAttribute("msg", msg);
	return "addEmploye";
	}
	
	@RequestMapping("/ListeEmployees")
	public String listeEmployees(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
	{
		Page<Employe> emp = employeService.getAllEmployeesParPage(page, size);
		modelMap.addAttribute("employees", emp);
		 modelMap.addAttribute("pages", new int[emp.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeEmployees";

	}
	@RequestMapping("/supprimerEmploye")
	public String supprimerEmploye(@RequestParam("id") Long id,
	 ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)
	{ 
	employeService.deleteEmployeById(id);
	Page<Employe> emp = employeService.getAllEmployeesParPage(page, size);
			modelMap.addAttribute("employees", emp);
			modelMap.addAttribute("pages", new int[emp.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);

	return "listeEmployees";
	}
	@RequestMapping("/modifierEmploye")
	public String editerEmploye(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Employe e= employeService.getEmploye(id);
	modelMap.addAttribute("employe", e);
	return "editerEmploye";
	}
	@RequestMapping("/updateEmploye")
	public String updateEmploye(@ModelAttribute("employe") Employe employe,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
	{
		//conversion de la date 
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateNaissance = dateformat.parse(String.valueOf(date));
		 employe.setDateNaissance(dateNaissance);
		 
		 employeService.updateEmploye(employe);
		 List<Employe> emp = employeService.getAllEmployes();
		 modelMap.addAttribute("employees", emp);
		return "listeEmployees";
		}

}
