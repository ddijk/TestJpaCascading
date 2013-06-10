package nl.dijkrosoft.snippets.testjpacascading.portfolio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DickD
 */
@Entity
@Table(name = "PF_TD")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "PfTd.findAll", query = "SELECT p FROM PfTd p"),
  @NamedQuery(name = "PfTd.findByPfId", query = "SELECT p FROM PfTd p WHERE p.pfTdPK.pfId = :pfId"),
  @NamedQuery(name = "PfTd.findByStartdate", query = "SELECT p FROM PfTd p WHERE p.pfTdPK.startdate = :startdate"),
  @NamedQuery(name = "PfTd.findByNaam", query = "SELECT p FROM PfTd p WHERE p.naam = :naam")
})
public class PfTd implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected PfTdPK pfTdPK;
  @Column(name = "NAAM")
  private String naam;
  @JoinColumn(name = "PF_ID", referencedColumnName = "ID", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Pf pf;

  public PfTd()
  {
  }

  public PfTd(PfTdPK pfTdPK)
  {
    this.pfTdPK = pfTdPK;
  }

  public PfTd(int pfId, Date startdate)
  {
    this.pfTdPK = new PfTdPK(pfId, startdate);
  }

  public PfTdPK getPfTdPK()
  {
    return pfTdPK;
  }

  public void setPfTdPK(PfTdPK pfTdPK)
  {
    this.pfTdPK = pfTdPK;
  }

  public String getNaam()
  {
    return naam;
  }

  public void setNaam(String naam)
  {
    this.naam = naam;
  }

  public Pf getPf()
  {
    return pf;
  }

  public void setPf(Pf pf)
  {
    this.pf = pf;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (pfTdPK != null ? pfTdPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PfTd))
    {
      return false;
    }
    PfTd other = (PfTd) object;
    if ((this.pfTdPK == null && other.pfTdPK != null) || (this.pfTdPK != null && !this.pfTdPK.equals(other.pfTdPK)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "nl.dijkrosoft.snippets.testjpacascading.portfolio.PfTd[ pfTdPK=" + pfTdPK + " ]";
  }

}
