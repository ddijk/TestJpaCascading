package nl.dijkrosoft.snippets.testjpacascading.cascading;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 *
 * @author DickD
 */
@Entity
public class PortfolioTd implements Serializable
{
  @EmbeddedId
  TdKeyClass key;
  String descr;
}
