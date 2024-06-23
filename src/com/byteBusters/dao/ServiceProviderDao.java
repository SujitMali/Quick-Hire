package com.byteBusters.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.byteBusters.model.ServiceProvider;

@Component
public class ServiceProviderDao 
{
	@Autowired
	HibernateTemplate hibernateTemplate;

	//Adding the Service Provider
	
	@Transactional
	public String addServiceProvider(ServiceProvider serviceProvider)
	{
		String i =  (String) hibernateTemplate.save(serviceProvider);
		return i;
	}
	
	public ServiceProvider getServiceProviderByContactAndPassword(String contact, String password) {
        @SuppressWarnings({ "unchecked", "deprecation" })
		List<ServiceProvider> providers = (List<ServiceProvider>) hibernateTemplate.findByNamedParam(
                "from ServiceProvider where contact = :contact and password = :password",
                new String[]{"contact", "password"},
                new Object[]{contact, password});

        if (providers != null && !providers.isEmpty()) {
            return providers.get(0);
        }

        return null;
    }

	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public String toString() {
		return "ServiceProviderDao [hibernateTemplate=" + hibernateTemplate + "]";
	}

	public ServiceProviderDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public ServiceProviderDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//======================================================================================================================
	
	public List<ServiceProvider> getProvidersByServiceTypeAndCity(String serviceType, String city) {
        @SuppressWarnings({ "unchecked", "deprecation" })
        List<ServiceProvider> providers = (List<ServiceProvider>) hibernateTemplate.findByNamedParam(
                "from ServiceProvider where serviceType = :serviceType and city = :city",
                new String[] { "serviceType", "city" }, new Object[] { serviceType, city });

        return providers;
    }
	
//==========================================================================================================================
	
	
	
}
