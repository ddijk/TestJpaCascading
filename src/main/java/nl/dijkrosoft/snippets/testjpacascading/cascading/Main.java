package nl.dijkrosoft.snippets.testjpacascading.cascading;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DickD
 */
public class Main
{
  public static void main(String[] args)
  {
    System.out.println("about to create Portf");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    Portfolio p = new Portfolio();
    p.id = 3;

    PortfolioTd td = new PortfolioTd();

    TdKeyClass tdKey = new TdKeyClass(3, new Date());
    td.key = tdKey;
    td.descr = "myDescr";



    em.persist(td);
    em.getTransaction().commit();

    em.close();
    emf.close();
  }
}
