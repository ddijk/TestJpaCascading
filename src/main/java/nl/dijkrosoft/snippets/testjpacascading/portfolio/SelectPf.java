/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.testjpacascading.portfolio;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dick
 */
public class SelectPf {
  
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    EntityManager em = emf.createEntityManager();


    List<Pf> pfList = em.createNamedQuery("Pf.findAll",Pf.class).getResultList();
    System.out.println("Lengte van pfList is " + pfList.size());
    for ( Pf pf : pfList) {
      System.out.println("pf met id " + pf.getId());
      for ( PfTd td : pf.getPfTdList()) {
	System.out.println("td met name " + td.getNaam());
      }
    }
     em.close();
    emf.close();
  }
}
