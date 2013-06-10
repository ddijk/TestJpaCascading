/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.testjpacascading.entities;

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

/**
 *
 * @author dick
 */
@Entity
@Table(name = "SELLER")
@NamedQueries({
  @NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s"),
  @NamedQuery(name = "Seller.findById", query = "SELECT s FROM Seller s WHERE s.id = :id"),
  @NamedQuery(name = "Seller.findByLastname", query = "SELECT s FROM Seller s WHERE s.lastname = :lastname"),
  @NamedQuery(name = "Seller.findByEmail", query = "SELECT s FROM Seller s WHERE s.email = :email"),
  @NamedQuery(name = "Seller.findByFirstname", query = "SELECT s FROM Seller s WHERE s.firstname = :firstname")})
public class Seller implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "ID")
  private Long id;
  @Column(name = "LASTNAME")
  private String lastname;
  @Column(name = "EMAIL")
  private String email;
  @Column(name = "FIRSTNAME")
  private String firstname;
  //@OneToMany(mappedBy = "sellerId", cascade=CascadeType.ALL)
  @OneToMany(mappedBy = "sellerId")
  private List<Item> itemList;
  @OneToMany(cascade = CascadeType.PERSIST)
  private List<Adres> adresList;

  public Seller() {
  }

  public Seller(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

  public List<Adres> getAdresList() {
    return adresList;
  }

  public void setAdresList(List<Adres> adresList) {
    this.adresList = adresList;
  }

  
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Seller)) {
      return false;
    }
    Seller other = (Seller) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "nl.dijkrosoft.snippets.testjpacascading.entities.Seller[ id=" + id + " ]";
  }
  
}
