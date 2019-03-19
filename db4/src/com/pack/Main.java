package com.pack;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");//reads cfg file
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();//acts as an interface between java appl and hibernate
		Transaction t=null;
		try{
			t=s.beginTransaction();
			Employee e1=new Employee();
			e1.setName("diksha");
			Regular_Employee r=new Regular_Employee();
			r.setSalary(20000);
			r.setBonus(2000);
			Contract_Employee c=new Contract_Employee();
			c.setContract_duration("2");
			c.setPay_hour(5);
			s.persist(e1);
			s.persist(r);
			s.persist(c);
			t.commit();
			System.out.println("successfully inserted");
		}
		catch(HibernateException ex){
			System.err.println(ex);
			t.rollback();
		}
		finally{
			s.close();
		}
	}

}
