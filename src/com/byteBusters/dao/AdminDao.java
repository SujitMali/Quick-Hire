package com.byteBusters.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.byteBusters.model.Admin;
import com.byteBusters.model.ServiceProvider;

@Component
public class AdminDao 
{
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	//Login the Admin
	public String loginAdmin(Admin admin)
	{
		String i =  (String) hibernateTemplate.save(admin);
		return i;
	}
	//---------------------------------------------------------------------------******
	
	//Only to get the pending Providers
		@Transactional
		public List<ServiceProvider> getAllAccounts() 
		{
		    DetachedCriteria criteria = DetachedCriteria.forClass(ServiceProvider.class);
		    criteria.add(Restrictions.eq("serviecProviderStatus", "pending"));
		    return (List<ServiceProvider>) hibernateTemplate.findByCriteria(criteria);
		}

	//Only to get the Approved Providers
		 @Transactional
		    public List<ServiceProvider> getApprovedAccounts() 
		 {
		        DetachedCriteria criteria = DetachedCriteria.forClass(ServiceProvider.class);
		        criteria.add(Restrictions.eq("serviecProviderStatus", "Approve"));
		        return (List<ServiceProvider>) hibernateTemplate.findByCriteria(criteria);
		 }

		 
	//Only to get the Disapproved Providers
		 @Transactional
		 public List<ServiceProvider> getDisapprovedAccounts() 
		 {
		     DetachedCriteria criteria = DetachedCriteria.forClass(ServiceProvider.class);
		     criteria.add(Restrictions.eq("serviecProviderStatus", "Disapprove")); 
		     return (List<ServiceProvider>) hibernateTemplate.findByCriteria(criteria);
		 }
		 
	//---------------------------------------------------------------------------******
		 
	//Get the Single Customer and change it Status
	 @Transactional
	    public void updateProviderStatus(String contact, String newStatus) 
	 {
	        ServiceProvider provider = hibernateTemplate.get(ServiceProvider.class, contact);
	            provider.setServiecProviderStatus(newStatus);
	            hibernateTemplate.update(provider);
	 }
	 
	 
	 
}