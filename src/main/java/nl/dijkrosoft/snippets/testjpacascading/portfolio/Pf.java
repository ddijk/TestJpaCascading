package nl.dijkrosoft.snippets.testjpacascading.portfolio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DickD
 */
@Entity
@Table(name = "PF")
@XmlRootElement
@NamedQueries(
  {
  @NamedQuery(name = "Pf.findAll", query = "SELECT p FROM Pf p"),
  @NamedQuery(name = "Pf.findById", query = "SELECT p FROM Pf p WHERE p.id = :id"),
  @NamedQuery(name = "Pf.findByDsc", query = "SELECT p FROM Pf p WHERE p.dsc = :dsc")
})
public class Pf implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Column(name = "DSC")
  private String dsc;
  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "pf")
  private List<PfTd> pfTdList;

  public Pf()
  {
  }

  public Pf(Integer id)
  {
    this.id = id;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getDsc()
  {
    return dsc;
  }

  public void setDsc(String dsc)
  {
    this.dsc = dsc;
  }

  @XmlTransient
  public List<PfTd> getPfTdList()
  {
    return pfTdList;
  }

  public void setPfTdList(List<PfTd> pfTdList)
  {
    this.pfTdList = pfTdList;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Pf))
    {
      return false;
    }
    Pf other = (Pf) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Pf[ id=" + id + " ]";
  }
}
