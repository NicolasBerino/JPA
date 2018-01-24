package Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entites.Personne;
import entites.Sport;
import entites.TypeAdresse;
import entites.Adresse;
import entites.Article;
import entites.Civilite;
import entites.Commande;

public class Test {
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static void main(String[] args){
		debutTest();
		//testPartie1();
		//testAssociation();
		testAssociation2();
		finTest();
	}
	
	void testPartie1(){
		Personne p1 = CreationPersonne();
		ModificationPersonne(p1);
		RecuperationModification();
		Supression();
	}
	
	static void testAssociation(){
		initialisationAssociation();
		recherchePersonneAssociation();
		
	}
	
	static void testAssociation2(){
		initialisationAssociation2();	
		rechercheAssociation2();
	}


	public static void debutTest(){
	emf=Persistence.createEntityManagerFactory("unite persistance");
	em = emf.createEntityManager();
	}

	public static Personne CreationPersonne(){
		HashMap<TypeAdresse,Adresse> adresses = new HashMap<TypeAdresse,Adresse>();
		adresses.put(TypeAdresse.PRINCIPALE, new Adresse("rue1","codepostale1","ville1"));
		adresses.put(TypeAdresse.SECONDAIRE, new Adresse("rue2","codepostale2","ville2"));
		ArrayList<String> prenoms = new ArrayList<String>();
		prenoms.add("Nicolas");
		prenoms.add("Thierry");
		prenoms.add("Prenom3");
		Personne p1 = new Personne(1, "Berino", prenoms,adresses,new Date(810296089000l),Civilite.CELIBATAIRE);
		em.getTransaction().begin();
		em.persist(p1);
		em.getTransaction().commit();
		return p1;
	}
	
	public static void ModificationPersonne(Personne p){
		p.getPrenoms().remove(0);
		p.setCivilite(Civilite.DIVORCE);
		p.getAdresses().get(TypeAdresse.PRINCIPALE).setVille("VIlle3");
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public static void RecuperationModification(){
		em.getTransaction().begin();
		Personne p = new Personne();
		p.setId(1);
		p=em.find(Personne.class,p.getId() );
		em.getTransaction().commit();
		finTest();
		debutTest();
		em.getTransaction().begin();
		p.setCivilite(Civilite.CELIBATAIRE);
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public static void Supression(){
		em.getTransaction().begin();
		Personne p = new Personne();
		p.setId(1);
		p=em.find(Personne.class, 1);
		em.remove(p);
		em.getTransaction().commit();
	}
	
	public static void finTest(){
		em.close();
		emf.close();
	}
	
	private static void initialisationAssociation() {
		HashMap<TypeAdresse,Adresse> adresses = new HashMap<TypeAdresse,Adresse>();
		adresses.put(TypeAdresse.PRINCIPALE, new Adresse("rue1","codepostale1","ville1"));
		adresses.put(TypeAdresse.SECONDAIRE, new Adresse("rue2","codepostale2","ville2"));
		ArrayList<String> prenoms = new ArrayList<String>();
		prenoms.add("Nicolas");
		prenoms.add("Thierry");
		prenoms.add("Prenom3");
		Personne p1 = new Personne(1, "Berino", prenoms,adresses,new Date(810296089000l),Civilite.CELIBATAIRE);
		Sport s1 = new Sport(1, "Basket");
		Sport s2 = new Sport(2, "Foot");
		
		Set<Sport> sport = new HashSet<>();
		sport.add(s1);
		sport.add(s2);
		p1.setSports(sport);
		
		Set<Personne> pers = new HashSet<>();
		pers.add(p1);
		s1.setPersonnes(pers);
		s2.setPersonnes(pers);
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(s1);
		em.persist(s2);
		em.getTransaction().commit();
	}
	
	static void recherchePersonneAssociation(){
		em.getTransaction().begin();
		Personne p = new Personne();
		p=em.find(Personne.class,1 );
	    Iterator<Sport> it = p.getSports().iterator();
	    while(it.hasNext())
	      System.out.println(it.next());
	    
	    Sport s = em.find(Sport.class, 1);
	    Iterator<Personne> it2 = s.getPersonnes().iterator();
	    while(it.hasNext())
	    	System.out.println(it.next());
		em.getTransaction().commit();
	}
	
	static void initialisationAssociation2(){
		HashMap<TypeAdresse,Adresse> adresses = new HashMap<TypeAdresse,Adresse>();
		adresses.put(TypeAdresse.PRINCIPALE, new Adresse("rue1","codepostale1","ville1"));
		adresses.put(TypeAdresse.SECONDAIRE, new Adresse("rue2","codepostale2","ville2"));
		ArrayList<String> prenoms = new ArrayList<String>();
		prenoms.add("Nicolas");
		prenoms.add("Thierry");
		prenoms.add("Prenom3");
		Personne p1 = new Personne(1, "Berino", prenoms,adresses,new Date(810296089000l),Civilite.CELIBATAIRE);
		
		Article a1 = new Article(1,"a1",10d);
		Article a2 = new Article(2,"a2",11d);
		
		
		Set<Article> art = new HashSet<>();
		art.add(a1);
		Commande c1 = new Commande(1,art,p1);
		Set<Article> art2 = new HashSet<>();
		art2.add(a1);
		art2.add(a2);
		Commande c2 = new Commande(2,art2,p1);
		
		Set<Commande> comm = new HashSet<>();
		comm.add(c1);
		comm.add(c2);
		p1.setCommandes(comm);
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(a1);
		em.persist(a2);
		em.persist(c1);
		em.persist(c2);
		em.getTransaction().commit();
	}
	
	static void rechercheAssociation2(){
		em.getTransaction().begin();
		Personne p = new Personne();
		p=em.find(Personne.class,1 );
	    Set<Commande> comm = p.getCommandes();
	    Commande[] comm2= new Commande[comm.size()];
	    comm.toArray(comm2);
	    
	    for(int i = 0;i< comm.size();i++){
	    	System.out.println(comm2[i].getLignesCommande());
	    	
	    }
	   
	    		
	    em.getTransaction().commit();
	}
}
