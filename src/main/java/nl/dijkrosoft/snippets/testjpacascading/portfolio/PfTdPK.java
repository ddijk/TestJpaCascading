package nl.dijkrosoft.snippets.testjpacascading.portfolio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DickD
 */
@Embeddable
public class PfTdPK implements Serializable {
  @Basic(optional = false)
  @Column(name = "PF_ID")
  private int pfId;
  @Basic(optional = false)
  @Column(name = "STARTDATE")
  @Temporal(TemporalType.DATE)
  private Date startdate;

  public PfTdPK()
  {
  }

  public PfTdPK(int pfId, Date startdate)
  {
    this.pfId = pfId;
    this.startdate = startdate;
  }

  public int getPfId()
  {
    return pfId;
  }

  public void setPfId(int pfId)
  {
    this.pfId = pfId;
  }

  public Date getStartdate()
  {
    return startdate;
  }

  public void setStartdate(Date startdate)
  {
    this.startdate = startdate;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (int) pfId;
    hash += (startdate != null ? startdate.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PfTdPK))
    {
      return false;
    }
    PfTdPK other = (PfTdPK) object;
    if (this.pfId != other.pfId)
    {
      return false;
    }
    if ((this.startdate == null && other.startdate != null) || (this.startdate != null && !this.startdate.equals(other.startdate)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "nl.dijkrosoft.snippets.testjpacascading.portfolio.PfTdPK[ pfId=" + pfId + ", startdate=" + startdate + " ]";
  }

}
