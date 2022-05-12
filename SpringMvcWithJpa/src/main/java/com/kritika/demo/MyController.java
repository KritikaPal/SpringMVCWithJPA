package com.kritika.demo;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kritika.demo.model.Emp;
import com.kritika.demo.repoistory.EmpRepoistory;

@Controller
public class MyController 
{
	@Autowired
	private EmpRepoistory empRepoistory;
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("Hello...");
		return "index";
	}
	@GetMapping("/add")
	public String add()
	{
		return "add";
	}
	@PostMapping("/addRecord")
	public String addRecord(@ModelAttribute Emp emp, Model m)
	{
		empRepoistory.save(emp);
		m.addAttribute("msg","Record is addedd sucessfully...");
		return "add";
	}
	@GetMapping("/update")
	public String update()
	{
		return "update";
	}
	@PostMapping("/updateRecord")
	public String updateRecord(@ModelAttribute Emp emp, Model m)
	{
		Optional<Emp> o = empRepoistory.findById(emp.getEmpNo());
		if(!o.isEmpty())
		{
			Emp e = o.get();
			e.setEmpName(emp.getEmpName());
			e.setEmpSal(emp.getEmpSal());
			empRepoistory.save(e);
			m.addAttribute("msg","Record update sucessfully...");
		}
		else
		{
			m.addAttribute("msg","Record Not Found..");
		}
		return "update";
	}
	@GetMapping("/delete")
	public String delete()
	{
		return "delete";
	}
	@GetMapping("/deleteRecord/{empNo}")
	public String deleteRecord(@PathVariable("empNo")Integer empNo, Model m)
	{
		empRepoistory.deleteById(empNo);
		List<Emp> list = empRepoistory.findAll();
		m.addAttribute("records","list");
		if(list.isEmpty())
		{
			m.addAttribute("msg","Table is Empty");
		}
		return "findAll";
	}
	@GetMapping("/find")
	public String find()
	{
		return "find";
	}
	@PostMapping("/findRecord")
	public String findRecord(@ModelAttribute Emp emp, Model m)
	{
		Optional<Emp>o = empRepoistory.findById(emp.getEmpNo());
		if(!o.isEmpty())
		{
			Emp ee = o.get();
			m.addAttribute("msg1", ee.getEmpNo());
			m.addAttribute("msg2", ee.getEmpName());
			m.addAttribute("msg3", ee.getEmpSal());
		}
		else
		{
			m.addAttribute("msg1","Record is Found...");
		}
		return "find";
	}
	@GetMapping("/findAllRecord")
	public String findAllRecord(Model m)
	{
		List<Emp> list = empRepoistory.findAll();
		m.addAttribute("records", list);
		if(list.isEmpty())
		{
			m.addAttribute("msg","Table is empty");
		}
		return "findAll";
	}
	/*
	@GetMapping("deleted")
	public String deleted(HttpServletRequest req, Model m)
	{
		Integer empNo = Integer.parseInt(req.getParameter("empNo"));
		System.out.println("deleted app..."+empNo);
		return "deleted";
	}
	*/
	
}
