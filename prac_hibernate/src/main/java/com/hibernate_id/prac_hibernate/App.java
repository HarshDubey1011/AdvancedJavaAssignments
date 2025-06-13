package com.hibernate_id.prac_hibernate;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate_id.prac_hibernate.entity.Category;
import com.hibernate_id.prac_hibernate.entity.ProductID;
import com.hibernate_id.prac_hibernate.entity.Products;
import com.hibernate_id.prac_hibernate.entity.Users;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration hibernateConfiguration = null;
        SessionFactory hibernateFactory = null;
        Session hibernateSession = null;
       try {
    	   hibernateConfiguration = new Configuration();
    	   Properties properties = new Properties();
    	   properties.load(App.class.getClassLoader().getResourceAsStream("application.properties"));
    	   hibernateConfiguration.addProperties(properties);
    	   hibernateConfiguration.addAnnotatedClass(Category.class);
    	   hibernateConfiguration.addAnnotatedClass(Products.class);
    	   //hibernateConfiguration.configure("firstapp.cfg.xml");
    	   hibernateFactory = hibernateConfiguration.buildSessionFactory();
    	   hibernateSession = hibernateFactory.openSession();
    	   Category cat = hibernateSession.find(Category.class, 2);
    	   System.out.println("=========Using Relationship In MySQL============");
    	   System.out.println(cat);
    	   
    	   Set<Products> prod = cat.getProd();
    	   prod.forEach(System.out::println);
    	   System.out.println("=========Using Relationship In MySQL============");
    	   try(Scanner sc = new Scanner(System.in);) {
//    		   System.out.println("Enter the name: ");
//    		   String name = sc.next();
//    		   System.out.println("Enter the userName: ");
//    		   String userName = sc.next();
//    		   System.out.println("Enter the email: ");
//    		   String email = sc.next();
//    		   System.out.println("Enter the age: ");
//    		   int age = sc.nextInt();
//    		   
//    		   Users objUser = new Users(name,userName,email,age);
    		   Query<Category> query = hibernateSession.createQuery("from Category", Category.class);
    		   Query<Object[]> query2 = hibernateSession.createQuery("select c.id,c.categoryName,c.categoryDescription from Category as c",Object[].class);
    		   Query<Category> query3 = hibernateSession.createNamedQuery("getAllCategories",Category.class);
    		   Query<Object[]> query4 = hibernateSession.createNamedQuery("getSpecificColumns",Object[].class);
    		   query4.setParameter("cid", 1);
//    		   query3.setParameter("cid", 1);
    		   System.out.println("--------Using the Named Query--------");
    		   List<Category> allCategory = query3.getResultList();
    		   allCategory.forEach(System.out::println);
    		   System.out.println("--------Using the Named Query---------");
    		   
    		   List<Object[]> resultSet = query4.getResultList();
    		   System.out.println("-------Using set parameter-------");
    		   for(Object[] obj: resultSet) {
    			   System.out.println("Category ID: "+obj[0]);
    			   System.out.println("Category Name: "+obj[1]);
    		   }
    		   System.out.println("---------Using set parameter----------");
    		   List<Object[]> specificCategories = query2.getResultList();
    		   for(Object[] objC: specificCategories) {
    			   System.out.print("Category ID: "+objC[0]);
    			   System.out.println();
    			   System.out.print("Category Name: "+objC[1]);
    			   System.out.println();
    			   System.out.println("Category Description: "+objC[2]);
    		   }
    		   List<Category> allCategories = query.getResultList();
    		   allCategories.forEach(System.out::println);
    		   
    		   
    		   ProductID pid = new ProductID(8);
    		   Products objProducts = new Products(pid,"Cat","I am a cat",500,"Cat.png");
    		   Transaction transaction = hibernateSession.beginTransaction();
//    		   Category cobj = new Category("this category is for tables","Table.png","table");
//    				   
    		   hibernateSession.persist(objProducts);
    		   
    		   //hibernateSession.getTransaction().commit();
    		   transaction.commit();
    		   System.out.println("products registerd successfully!");
    	   }
       }catch(Exception e) {
    	   System.out.println(e.getMessage());
       }finally {
    	   if(hibernateSession!=null) {
    		   hibernateSession.close();
    	   }
    	   if(hibernateFactory!=null) {
    		   hibernateFactory.close();
    	   }
       }
    }
}
