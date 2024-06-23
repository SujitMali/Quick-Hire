package com.byteBusters.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.byteBusters.dao.OrderDao;
import com.byteBusters.dao.ServiceProviderDao;
import com.byteBusters.dao.UserDao;
import com.byteBusters.model.Order;
import com.byteBusters.model.ServiceProvider;
import com.byteBusters.model.User;

@Controller
public class UserController 
{
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	User user = (User) context.getBean("user");
	UserDao userDao = (UserDao) context.getBean("userDao");
	ServiceProvider serviceProvider = (ServiceProvider) context.getBean("serviceProvider");
	ServiceProviderDao serviceProviderDao = (ServiceProviderDao) context.getBean("serviceProviderDao");
	Order order = (Order) context.getBean("order");
	OrderDao orderDao =  (OrderDao) context.getBean("orderDao");
	
	@RequestMapping("/userToServiceProvider")
	public String userToServiceProvider()
	{
		return "registerPageServiceProvider";
	}
	
	
	@RequestMapping("/userToAdmin")
	public String userToAdmin()
	{
		return "adminLogin";
	}
		
	
	@RequestMapping(path = "/afterUserRegister", method= RequestMethod.POST )
	public String afterUserRegister(@ModelAttribute User user)
	{
		@SuppressWarnings("unused")
		String i = userDao.addUser(user);			
		System.out.println("You are Registered Successfully !");
		return "userLogin";
	}
//=====================================================================================================		
//	
//	@RequestMapping(path="/afterUserLogin", method= RequestMethod.POST)
//	public String afterUserLogin(HttpServletRequest request)
//	{
//		String contact = request.getParameter("contact");
//		String password = request.getParameter("password");
//		user = userDao.getSingleUser(contact);
//		
//		if(userDao.validateUserLogin(contact, password))
//		{	
//			
//			return "userDashboard";	
//		}
//		else
//		{
//			return "error";
//		}
//	}
	
	
	@RequestMapping(path="/afterUserLogin", method= RequestMethod.POST)
	public String afterUserLogin(HttpServletRequest request) {
	    String contact = request.getParameter("contact");
	    String password = request.getParameter("password");
	    user = userDao.getSingleUser(contact);
	    
	    if(userDao.validateUserLogin(contact, password)) {
	        // Set the user object in the session attribute "user"
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	        
	        return "userDashboard";   
	    } else {
	        return "error";
	    }
	}

//=====================================================================================================	
	@RequestMapping("/UserregisterToLogin")
	public String UserregisterToLogin()
	{
		return "userLogin";
	}
	

	@RequestMapping("/userLoginToRegister")
	public String userLoginToRegister()
	{
		return "userRegister";
	}
	
	@RequestMapping("/userLogout")
	public String userLogout()
	{
		return "userLogin";
	}
	
	@RequestMapping("/userBookServices")
	public String userBookServices()
	{
		return "userBooksServices";
	}
//================================================================================================================
//	@RequestMapping(path = "/bookService", method = RequestMethod.POST)
//    public String bookService(@ModelAttribute Order order, Model model) 
//	{
//			order.setUserName(user.getName());
//			order.setUserContact(user.getContact());
//			order.setUserArea(user.getArea());
//			System.out.println(order.toString());
//			model.addAttribute("user", user);
//			request.setAttribute("user", user);
//            orderDao.saveOrder(order);
//            return "bookingSuccess";     
//    }

	
	@RequestMapping(path = "/bookService", method = RequestMethod.POST)
	public String bookService(@ModelAttribute Order order, Model model, HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");

	    // Set user details to the order object
	    order.setUserName(user.getName());
	    order.setUserContact(user.getContact());
	    order.setUserArea(user.getArea());

	    System.out.println(order.toString());

	    // Add the user object to the model and request attributes
	    model.addAttribute("user", user);
	    request.setAttribute("user", user);

	    // Save the order
	    orderDao.saveOrder(order);

	    return "bookingSuccess";
	}

//=====================================================================================================
	
	 @RequestMapping("/showSearchedProviders")
	    public String showSearchedProviders(
	            @RequestParam("serviceType") String serviceType,
	            @RequestParam("city") String city,
	            Model model) 
	 {
	        
	        // Fetch ServiceProvider entries based on serviceType and city
	        List<ServiceProvider> searchedProviders = serviceProviderDao.getProvidersByServiceTypeAndCity(serviceType, city);

	        // Check if any ServiceProvider entries are found
	        if (searchedProviders != null && !searchedProviders.isEmpty()) {
	            // Add the list of searched providers to the model
	            model.addAttribute("searchedProviders", searchedProviders);
	            return "showSearchedProviders"; // Return the view to display the searched providers
	        } else {
	            // No ServiceProvider found for the given criteria, redirect to an appropriate page
	            return "redirect:/noResults"; // Assuming you have a mapping for displaying no results
	        }
	    }
	//=====================================================================================================		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
