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
public class EditPortfolio {
  
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    EntityManager em = emf.createEntityManager();


    List<Pf> pfList = em.createNamedQuery("Pf.findAll",Pf.class).getResultList();
    System.out.println("Lengte van pfList is " + pfList.size());
    for ( Pf pf : pfList) {
      System.out.println("pf met id " + pf.getId());
      List<PfTd> tdList = pf.getPfTdList();
      em.getTransaction().begin();
      
      System.out.println("td removed " +tdList.remove(1));
      Pf pf2 = em.merge(pf);
      print(pf2);
      em.getTransaction().commit();
    }
     em.close();
    emf.close();
  }

  private static void print(Pf pf2) {
    System.out.println("pf "+ pf2);
    System.out.println("aantal tds " + pf2.getPfTdList());
    for ( PfTd td : pf2.getPfTdList()) {
      System.out.println("td: " + td);
    }
  }
}
