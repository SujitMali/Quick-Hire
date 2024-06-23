package com.byteBusters.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.byteBusters.model.ServiceProvider;
import com.byteBusters.model.User;

@SuppressWarnings("unused")
@Component
public class UserDao 
{

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public String addUser(User user)
	{
		String i =  (String) hibernateTemplate.save(user);
		return i;
	}
	
	public User getSingleUser(String contact)
	{
		return hibernateTemplate.get(User.class, contact);
	}
	
	public boolean validateUserLogin(String contact, String password)
	{
		User user = hibernateTemplate.get(User.class, contact);
		return user != null && user.getPassword().equals(password);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public String toString() {
		return "UserDao [hibernateTemplate=" + hibernateTemplate + "]";
	}

	public UserDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public UserDao() {
		super();
		
	}
	
	
	
}
