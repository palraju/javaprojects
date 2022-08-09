package com.cognizant.ordermanagement.mainapp;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.cognizant.ordermanagement.dao.entity.Customer;
import com.cognizant.ordermanagement.model.Address;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;



public class Application
{
	private static Cluster cluster;
    private static Session session;
		public static void main(String[] args)
		{
			cluster = Cluster.builder().addContactPoint("127.0.0.1").build();			 
            session = cluster.connect("order_mgmt_db"); 
            Mapper<Customer> mapper = new MappingManager(session).mapper(Customer.class);            
			Set emailset = new HashSet<String>();
			Address address = new Address();
			Customer customer = new Customer();
			customer.setId("123467");
			customer.setFirstName("Rupavv");
			customer.setLastName("Pal");
			emailset.add("mail.rajupal@gmail.com");
			customer.setEmails(emailset);
			address.setCity("Kolkata");
			address.setStreet("SRCM Road");
			address.setState("West Bengal");
			address.setCountry("India");
			address.setZip("700136");
			customer.setAddress(address);
			mapper.save(customer);
			session.close();
			cluster.close();
		}
}

