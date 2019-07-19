/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sebastián
 */
@Entity
@Table(name = "CREDITCARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creditcard.findAll", query = "SELECT c FROM Creditcard c")
    , @NamedQuery(name = "Creditcard.findById", query = "SELECT c FROM Creditcard c WHERE c.id = :id")
    , @NamedQuery(name = "Creditcard.findByCvv", query = "SELECT c FROM Creditcard c WHERE c.cvv = :cvv")
    , @NamedQuery(name = "Creditcard.findByFechaVencimiento", query = "SELECT c FROM Creditcard c WHERE c.fechaVencimiento = :fechaVencimiento")})
public class Creditcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CVV")
    private int cvv;
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @OneToMany(mappedBy = "tarjetaCredito")
    private Collection<Transaccion> transaccionCollection;
    @JoinColumn(name = "OWNER", referencedColumnName = "ID")
    @ManyToOne
    private Customer owner;

    public Creditcard() {
    }

    public Creditcard(Integer id) {
        this.id = id;
    }

    public Creditcard(Integer id, int cvv) {
        this.id = id;
        this.cvv = cvv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @XmlTransient
    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
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
        if (!(object instanceof Creditcard)) {
            return false;
        }
        Creditcard other = (Creditcard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Creditcard[ id=" + id + " ]";
    }
    
}
