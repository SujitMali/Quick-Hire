package com.byteBusters.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.byteBusters.dao.AdminDao;
import com.byteBusters.dao.ServiceProviderDao;
import com.byteBusters.model.Admin;
import com.byteBusters.model.ServiceProvider;

@SuppressWarnings("unused")
@Controller
public class AdminController 
{
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	Admin admin = (Admin) context.getBean("admin");
	AdminDao adminDao = (AdminDao) context.getBean("adminDao");
	
	
	@RequestMapping("/adminLoginmap")
	public String adminLogin()
	{
		
		return "adminLogin";
	}

	@RequestMapping(path = "/afterAdminLogin", method=RequestMethod.POST)
	public String afterAdminLogin(Model m, HttpServletRequest request)
	{	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email.equals("admin@gmail.com") && password.equals("admin"))
		{
			m.addAttribute("uemail", email);
			m.addAttribute("upassword", password);
			return "adminDashboard";
		}
		else
		{
			return "error";
		}
	}
	
	@RequestMapping(path="/adminViewPendingProviders")
	public String adminViewPendingProviders(Model m)
	{
		
		List<ServiceProvider> allSP = adminDao.getAllAccounts();
		m.addAttribute("allAccountList", allSP);
		return "adminViewPending";
		
	}
	
	@RequestMapping(path = "/adminViewApprovedProviders")
    public String adminViewApprovedProviders(Model m) {
        List<ServiceProvider> approvedSPList = adminDao.getApprovedAccounts();
        m.addAttribute("approvedAccountList", approvedSPList);
        return "adminViewApproved";
    }
	
	
	@RequestMapping(path = "/adminViewDisapprovedProviders")
	public String adminViewDisapprovedProviders(Model m) {
	    List<ServiceProvider> disapprovedSPList = adminDao.getDisapprovedAccounts();
	    m.addAttribute("disapprovedAccountList", disapprovedSPList);
	    return "adminViewDisapproved";
	}
	

	@RequestMapping("/fromViewToDashboard")
	public String fromViewToDashboard()
	{
		return "adminDashboard";
	}
	
	
	@RequestMapping("/adminApprovesProvider")
	public String adminApprovesProvider()
	{
		
		return "";
	}
	
	@RequestMapping("/fromAppprovedToDashboard")
	public String fromAppprovedToDashboard()
	{
		return "adminDashboard";
	}
	
	
	@RequestMapping("/fromDisapprovedToDashboard")
	public String fromDisapprovedToDashboard()
	{
		return "adminDashboard";
	}
	
	@RequestMapping("/adminToUser")
	public String adminToUser()
	{
		return "userRegister";
	}
	
//============================================================================================================
	 @RequestMapping(path = "/adminChangesStatusOfProvider", method = RequestMethod.POST)
	    public String adminChangesStatusOfProvider(HttpServletRequest request) {
	        String contact = request.getParameter("contact");
	        String selectedStatus = request.getParameter("category");
	        
	        // Update provider status in the database
	        adminDao.updateProviderStatus(contact, selectedStatus);

	        // Redirect to the appropriate view based on the status change
	        if (selectedStatus.equals("Approve")) {
	            return "redirect:/adminViewPendingProviders";
	        } else if (selectedStatus.equals("Disapprove")) {
	            return "redirect:/adminViewPendingProviders";
	        } else {
	            // Handle other cases as needed
	            return "redirect:/adminViewPendingProviders";
	        }
	    }

	 
	
	
}
