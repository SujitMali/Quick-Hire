package com.byteBusters.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
import com.byteBusters.model.Order;
import com.byteBusters.model.ServiceProvider;
import com.byteBusters.model.User;

@SuppressWarnings("unused")
@Controller
public class ServiceProviderController 
{
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	ServiceProvider serviceProvider = (ServiceProvider) context.getBean("serviceProvider");
	ServiceProviderDao serviceProviderDao = (ServiceProviderDao) context.getBean("serviceProviderDao");
	Order order = (Order) context.getBean("order");
	OrderDao orderDao =  (OrderDao) context.getBean("orderDao");
	
	
	@RequestMapping("/")
	public String openRegisterPageSP()
	{
		return "registerPageServiceProvider";
	}
	
	@RequestMapping("/adminToSP")
	public String adminToSP()
	{
		return "registerPageServiceProvider";
	}
	
	@RequestMapping(path="/afterServiceProviderRegisterSubmit", method= RequestMethod.POST)
	public String addServiceProviderTemp(@ModelAttribute ServiceProvider serviceProvider)
	{
		String i = serviceProviderDao.addServiceProvider(serviceProvider);			
		System.out.println("Wait till Your Verification is Done !");
		return "wait";	
	}
	
	@RequestMapping("/providerToUser")
	public String providerToUser()
	{
		return "userRegister";
	}
	
	@RequestMapping("/providerRegisterToLogin")
	public String providerRegisterToLogin()
	{
		return "serviceProviderLogin";
	}
	
	@RequestMapping(path = "/afterServiceProviderLogin", method = RequestMethod.POST)
	public String afterServiceProviderLogin(@ModelAttribute ServiceProvider serviceProvider, Model model) {
	    ServiceProvider loggedInServiceProvider = serviceProviderDao.getServiceProviderByContactAndPassword(
	            serviceProvider.getContact(), serviceProvider.getPassword());

	    if (loggedInServiceProvider != null) {
	        System.out.println("Retrieved Status: " + loggedInServiceProvider.getServiecProviderStatus());

	        if ("approve".equalsIgnoreCase(loggedInServiceProvider.getServiecProviderStatus())) {
	            System.out.println("Provider is approved. Redirecting to serviceProviderDashboard.");
	            return "serviceProviderDashboard";
	        } else {
	            System.out.println("Provider is not approved. Redirecting to wait page.");
	            return "redirect:/wait";
	        }
	    } else {
	        System.out.println("User does not exist. Redirecting to error page.");
	        return "error";
	    }
	}

	
	@RequestMapping("/wait")
	public String waitPage() {
	    return "wait";
	}
	
	@RequestMapping("/providerDashboardToLogin")
	public String providerDashboardToLogin()
	{
		return "serviceProviderDashboard";
	}
//--------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping("/viewPendingOrders")
	public String viewPendingOrders(Model m)
	{
		List<Order> order = orderDao.getOrders();
		m.addAttribute("pendingOrders", order);
		return"serviceProviderPendingOrder";
	}


	
	@RequestMapping("/fromPendingOrdersToDashboard")
	public String fromPendingOrdersToDashboard()
	{
		return"serviceProviderDashboard";
	}
	
//===========================================================================================================
//	
//	@RequestMapping(path = "/providerAcceptsOrNot", method = RequestMethod.POST)
//	public String providerAcceptsOrNot(HttpServletRequest request)
//	{
//		
//	}
//===========================================================================================================
	@RequestMapping(path = "/providerAcceptsOrNot", method = RequestMethod.POST)
	public String providerAcceptsOrNot(HttpServletRequest request) 
	{
		
	    int orderId = Integer.parseInt(request.getParameter("orderId"));
	    String selectedAction = request.getParameter("orderStatus");


	    if (selectedAction.equals("Approve")) 
	    {	    
	    	orderDao.updateOrderStatus(orderId, "Approve");
	        return "redirect:/providerAcceptedView";
	    } 
	    else if (selectedAction.equals("Disapprove")) 
	    {
	    	orderDao.updateOrderStatus(orderId, "Disapprove");
	        return "redirect:/providerAcceptedView";
	    } 
	    else 
	    {
	        return "redirect:/providerAcceptedView";
	    }
	}

	
	@RequestMapping(path="/providerAcceptedView")
	public String providerAcceptedView(Model m)
	{
		List<Order> order = orderDao.getOrdersByStatus("Pending");
		m.addAttribute("pendingOrders", order);
		
		return "serviceProviderPendingOrder";
	}
	
	
	
//===========================================================================================================
	
	
	@RequestMapping(path="/viewApprovedOrders")
	public String viewApprovedOrders(Model m)
	{
		List<Order> order = orderDao.getOrdersByStatus("Approve");
		m.addAttribute("pendingOrders", order);
		
		return "serviceProviderApproveOrder";
	}
	
//===========================================================================================================

	
	@RequestMapping(path="/viewDisapprovedOrders")
	public String viewDisapprovedOrders(Model m)
	{
		List<Order> order = orderDao.getOrdersByStatus("Disapprove");
		m.addAttribute("pendingOrders", order);
		
		return "serviceProviderDisapproveOrder";
	}
	
//===========================================================================================================
	
	@RequestMapping(path = "/viewTodaysOrders")
	public String viewTodaysOrders (Model m)
	{
		List<Order> order = orderDao.getOrdersByStatus("Approve");
		List<Order> orders = new ArrayList<Order>();
		LocalDate currentDate = LocalDate.now();
		System.out.println("Current Date : " +currentDate);
		
		for(Order od : order)
		{
			String bookingDate = od.getBookingDate();
			LocalDate newBookingDate = LocalDate.parse(bookingDate);
//			order = orderDao.getOrdersByStatus("Approve");
			
			int result = currentDate.compareTo(newBookingDate);
			if(result == 0)
			{
				orders.add(od);
			}
		}
		m.addAttribute("orders", orders);
		return "serviceProviderTodayOrder";
	}

//==========================================================================================================
	
	
	@RequestMapping(path = "/viewNextSevenDayOrders")
	public String viewNextSevenDayOrders (Model m)
	{
		List<Order> order = orderDao.getOrdersByStatus("Approve");
		List<Order> orders = new ArrayList<Order>();
		LocalDate currentDate = LocalDate.now();
		System.out.println("Current Date : " +currentDate);
		LocalDate newDate = currentDate.plusDays(7);
		for(Order od : order)
		{
			String bookingDate = od.getBookingDate();
			LocalDate newBookingDate = LocalDate.parse(bookingDate);
//			order = orderDao.getOrdersByStatus("Approve");
			
			long daysDifference = ChronoUnit.DAYS.between(newDate, newBookingDate);
			System.out.println(daysDifference);
			if(daysDifference >= 0 || daysDifference <= -7)
			{
				
			}
			else
			{
				orders.add(od);
			}
		}
		m.addAttribute("orders", orders);
		return "serviceProviderNextSevenOrder";
	}



}
	
	
