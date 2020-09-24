/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FERNANDO
 */
@Entity
@Table(name = "CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findById", query = "SELECT c FROM Cuenta c WHERE c.id = :id"),
    @NamedQuery(name = "Cuenta.findByNombreCuenta", query = "SELECT c FROM Cuenta c WHERE c.nombreCuenta = :nombreCuenta"),
    @NamedQuery(name = "Cuenta.findByFecha", query = "SELECT c FROM Cuenta c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cuenta.findByCuenta1", query = "SELECT c FROM Cuenta c WHERE c.cuenta1 = :cuenta1"),
    @NamedQuery(name = "Cuenta.findByCuenta2", query = "SELECT c FROM Cuenta c WHERE c.cuenta2 = :cuenta2")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="CUE_seq", sequenceName="seq_CUENTA", allocationSize = 1 )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUE_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "NOMBRE_CUENTA")
    private String nombreCuenta;
    @Size(max = 100)
    @Column(name = "FECHA")
    private String fecha;
    @Column(name = "CUENTA_1")
    private BigInteger cuenta1;
    @Column(name = "CUENTA_2")
    private BigInteger cuenta2;

    public Cuenta() {
    }

    public Cuenta(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public BigInteger getCuenta1() {
        return cuenta1;
    }

    public void setCuenta1(BigInteger cuenta1) {
        this.cuenta1 = cuenta1;
    }

    public BigInteger getCuenta2() {
        return cuenta2;
    }

    public void setCuenta2(BigInteger cuenta2) {
        this.cuenta2 = cuenta2;
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
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cuenta[ id=" + id + " ]";
    }
    
}
