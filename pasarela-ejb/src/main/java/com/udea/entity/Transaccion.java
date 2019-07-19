/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastián
 */
@Entity
@Table(name = "TRANSACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t")
    , @NamedQuery(name = "Transaccion.findById", query = "SELECT t FROM Transaccion t WHERE t.id = :id")
    , @NamedQuery(name = "Transaccion.findByValor", query = "SELECT t FROM Transaccion t WHERE t.valor = :valor")
    , @NamedQuery(name = "Transaccion.findByMarcaTiempo", query = "SELECT t FROM Transaccion t WHERE t.marcaTiempo = :marcaTiempo")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private int valor;
    @Column(name = "MARCA_TIEMPO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date marcaTiempo;
    @JoinColumn(name = "TARJETA_CREDITO", referencedColumnName = "ID")
    @ManyToOne
    private Creditcard tarjetaCredito;
    @JoinColumn(name = "CLIENTE", referencedColumnName = "ID")
    @ManyToOne
    private Customer cliente;

    public Transaccion() {
    }

    public Transaccion(Integer id) {
        this.id = id;
    }

    public Transaccion(Integer id, int valor) {
        this.id = id;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getMarcaTiempo() {
        return marcaTiempo;
    }

    public void setMarcaTiempo(Date marcaTiempo) {
        this.marcaTiempo = marcaTiempo;
    }

    public Creditcard getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(Creditcard tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public Customer getCliente() {
        return cliente;
    }

    public void setCliente(Customer cliente) {
        this.cliente = cliente;
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
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Transaccion[ id=" + id + " ]";
    }
    
}
