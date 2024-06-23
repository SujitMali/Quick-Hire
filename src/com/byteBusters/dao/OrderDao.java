package com.byteBusters.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.byteBusters.model.Order;

@Component
public class OrderDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void saveOrder(Order order) {
        order.setOrderStatus("Pending"); // Set default status to "Pending" if not provided
        hibernateTemplate.save(order);
    }
//===================================================================================================================
    public List<Order> getOrders() 
    {	
        return hibernateTemplate.loadAll(Order.class);
    }

    public List<Order> getOrdersByStatus(String status) {
        @SuppressWarnings({ "unchecked", "deprecation" })
        List<Order> orders = (List<Order>) hibernateTemplate.findByNamedParam(
            "from Order where orderStatus = :status",
            "status",
            status
        );
        return orders;
    }
 
//=================================================================================================================
    @Transactional
    public void updateOrderStatus(int orderId, String newStatus)
	{
		Order order = hibernateTemplate.get(Order.class, orderId);
		order.setOrderStatus(newStatus);
		hibernateTemplate.update(order);
	}
	
  
//=================================================================================================================
    
  

    
    
    
    
    
    

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public String toString() {
        return "OrderDao [hibernateTemplate=" + hibernateTemplate + "]";
    }

    public OrderDao(HibernateTemplate hibernateTemplate) {
        super();
        this.hibernateTemplate = hibernateTemplate;
    }

    public OrderDao() {
        super();
    }
}
