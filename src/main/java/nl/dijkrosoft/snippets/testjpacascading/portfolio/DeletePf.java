package nl.dijkrosoft.snippets.testjpacascading.portfolio;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DickD
 */
public class DeletePf
{
  public static void main(String[] args)
  {
    System.out.println("about to delete Portf");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU2");
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();


    Pf pf = em.find(Pf.class, new Integer(3));
    System.out.println("Pf found:" + pf);
    em.remove(pf);
    em.getTransaction().commit();

    em.close();

    emf.close();
  }
}
