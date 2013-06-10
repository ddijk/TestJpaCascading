/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.testjpacascading.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dick
 */
@Entity
@Table(name = "ITEM")
@NamedQueries({
  @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
  @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"),
  @NamedQuery(name = "Item.findByTitle", query = "SELECT i FROM Item i WHERE i.title = :title"),
  @NamedQuery(name = "Item.findByInitialprice", query = "SELECT i FROM Item i WHERE i.initialprice = :initialprice"),
  @NamedQuery(name = "Item.findByDescription", query = "SELECT i FROM Item i WHERE i.description = :description")})
public class Item implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "ID")
  private Long id;
  @Column(name = "TITLE")
  private String title;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "INITIALPRICE")
  private Double initialprice;
  @Column(name = "DESCRIPTION")
  private String description;
  @JoinColumn(name = "SELLER_ID", referencedColumnName = "ID")
  @ManyToOne
  private Seller sellerId;

  public Item() {
  }

  public Item(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getInitialprice() {
    return initialprice;
  }

  public void setInitialprice(Double initialprice) {
    this.initialprice = initialprice;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Seller getSellerId() {
    return sellerId;
  }

  public void setSellerId(Seller sellerId) {
    this.sellerId = sellerId;
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
    if (!(object instanceof Item)) {
      return false;
    }
    Item other = (Item) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "nl.dijkrosoft.snippets.testjpacascading.entities.Item[ id=" + id + " ]";
  }
  
}
