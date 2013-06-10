package nl.dijkrosoft.snippets.testjpacascading.cascading;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author DickD
 */
@Entity
public class Portfolio implements Serializable
{
  @Id
  int id;
}
