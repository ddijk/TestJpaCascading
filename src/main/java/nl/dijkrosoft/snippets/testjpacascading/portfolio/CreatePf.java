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
public class CreatePf
{
  public static final int pfId = 2;

  public static void main(String[] args)
  {
    System.out.println("about to create Portf");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU2");
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    Pf pf = new Pf(pfId);
    PfTd td1 = new PfTd(pfId, new Date());
    td1.setNaam("teedee een");

    Date now = new Date();
    long l = now.getTime();
    PfTd td2 = new PfTd(pfId, new Date(l - 24 * 3600 * 1000));
    td2.setNaam("teedee twee");

    List tds = Arrays.asList(td1, td2);

    pf.setPfTdList(tds);

    em.persist(pf);
    em.getTransaction().commit();

    em.close();
    emf.close();
  }
}
