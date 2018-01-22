/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marti
 */
@Entity
@Table(name = "inventarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventarios.findAll", query = "SELECT i FROM Inventarios i")
    , @NamedQuery(name = "Inventarios.findByInventarioId", query = "SELECT i FROM Inventarios i WHERE i.inventarioId = :inventarioId")
    , @NamedQuery(name = "Inventarios.findByStockMin", query = "SELECT i FROM Inventarios i WHERE i.stockMin = :stockMin")
    , @NamedQuery(name = "Inventarios.findByStockIdeal", query = "SELECT i FROM Inventarios i WHERE i.stockIdeal = :stockIdeal")
    , @NamedQuery(name = "Inventarios.findByStockActual", query = "SELECT i FROM Inventarios i WHERE i.stockActual = :stockActual")})
public class Inventarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventario_id")
    private Integer inventarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_min")
    private int stockMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_ideal")
    private int stockIdeal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_actual")
    private int stockActual;
    @JoinColumn(name = "articulo_id", referencedColumnName = "articulo_id")
    @ManyToOne(optional = false)
    private Articulos articuloId;

    public Inventarios() {
    }

    public Inventarios(Integer inventarioId) {
        this.inventarioId = inventarioId;
    }

    public Inventarios(Integer inventarioId, int stockMin, int stockIdeal, int stockActual) {
        this.inventarioId = inventarioId;
        this.stockMin = stockMin;
        this.stockIdeal = stockIdeal;
        this.stockActual = stockActual;
    }

    public Integer getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(Integer inventarioId) {
        this.inventarioId = inventarioId;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public int getStockIdeal() {
        return stockIdeal;
    }

    public void setStockIdeal(int stockIdeal) {
        this.stockIdeal = stockIdeal;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public Articulos getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Articulos articuloId) {
        this.articuloId = articuloId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioId != null ? inventarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventarios)) {
            return false;
        }
        Inventarios other = (Inventarios) object;
        if ((this.inventarioId == null && other.inventarioId != null) || (this.inventarioId != null && !this.inventarioId.equals(other.inventarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Inventarios[ inventarioId=" + inventarioId + " ]";
    }
    
}
