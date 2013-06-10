package nl.dijkrosoft.snippets.testjpacascading.cascading;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DickD
 */
@Embeddable
public class TdKeyClass implements Serializable
{
  public TdKeyClass()
  {
  }
//  @JoinColumn(name = "Portfolio", referencedColumnName = "id")
  int id;
  @Temporal(TemporalType.DATE)
  Date startDate;

  public TdKeyClass(int id, Date startDate)
  {
    this.id = id;
    this.startDate = startDate;
  }

  @Override
  public int hashCode()
  {
    return 0;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == null)
    {
      return false;

    }

    if (!(obj instanceof TdKeyClass))
    {
      return false;
    }

    TdKeyClass other = (TdKeyClass) obj;

    return this.id == other.id && this.startDate.equals(other.startDate);

  }
}
