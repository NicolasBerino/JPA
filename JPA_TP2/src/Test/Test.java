package Test;


import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Entites.Reservation;
import Entites.Vol;


public class Test {
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static void main(String[] args){
		debutTest();
		//test1();
		//test2();
		test3();
		finTest();
	}
	
	public static void debutTest(){
	emf=Persistence.createEntityManagerFactory("unite_persistance");
	em = emf.createEntityManager();
	}
	
	public static void finTest(){
		em.close();
		emf.close();
	}
	
	public static void test1(){
		Query quer = em.createQuery("Select count(v) from VOLS v where v.pilote.NumPil =5050");
		List result = quer.getResultList();
		ListIterator<Vol> it = result.listIterator();
	      while(it.hasNext()){
	         System.out.println(it.next());

	      }
	}
	
	public static void test2(){
		Query quer = em.createQuery("Select sum(r.nbPlace) from Reservations r join r.defC.vol v where v.NumVol ='V101'");
		List result = quer.getResultList();
		ListIterator<Vol> it = result.listIterator();
	      while(it.hasNext()){
	         System.out.println(it.next());

	      }
	}
	
	public static void test3(){
		Query quer = em.createQuery("Select distinct(c1.nom) from Reservations r1 join r1.cli c1 join r1.defC.vol v1,Reservations r2 join r2.cli c2 join r2.defC.vol v2  where c2.nom='Lorentz' and v1.NumVol = v2.NumVol");
		List result = quer.getResultList();
		ListIterator<Object> it = result.listIterator();
	      while(it.hasNext()){
	         System.out.println(it.next());

	     }
	}
}	