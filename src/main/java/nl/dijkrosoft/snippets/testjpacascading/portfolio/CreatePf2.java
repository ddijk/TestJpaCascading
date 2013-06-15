/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.testjpacascading.portfolio;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dick
 */
public class CreatePf2 {
  
   public static void main(String[] args)
  {
    System.out.println("about to create Portf");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU2");
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    int pfId = 3;

    Pf pf = new Pf(pfId);
    pf.setDsc("LANDEN (pf2)");
    PfTd td1 = new PfTd(pfId, new Date());
    td1.setNaam("FRANKRIJK (pf2)");

    Date now = new Date();
    long l = now.getTime();
    PfTd td2 = new PfTd(pfId, new Date(l - 24 * 3600 * 1000));
    td2.setNaam("DUITSLAND (pf2)");

    List tds = Arrays.asList(td1, td2);

    pf.setPfTdList(tds);

    Pf pf2 = em.merge(pf);
     Printer.print(pf2);
    em.getTransaction().commit();

    em.close();
    emf.close();
  }
}
