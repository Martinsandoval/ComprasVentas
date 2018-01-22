/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marti
 */
@Entity
@Table(name = "articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a")
    , @NamedQuery(name = "Articulos.findByArticuloId", query = "SELECT a FROM Articulos a WHERE a.articuloId = :articuloId")
    , @NamedQuery(name = "Articulos.findByCodigoArticulo", query = "SELECT a FROM Articulos a WHERE a.codigoArticulo = :codigoArticulo")
    , @NamedQuery(name = "Articulos.findByPrecioCompra", query = "SELECT a FROM Articulos a WHERE a.precioCompra = :precioCompra")
    , @NamedQuery(name = "Articulos.findByPrecioVenta", query = "SELECT a FROM Articulos a WHERE a.precioVenta = :precioVenta")
    , @NamedQuery(name = "Articulos.findByDescripcion", query = "SELECT a FROM Articulos a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Articulos.findByFamilia", query = "SELECT a FROM Articulos a WHERE a.familia = :familia")})
public class Articulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "articulo_id")
    private Integer articuloId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_articulo")
    private int codigoArticulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_compra")
    private float precioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private float precioVenta;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "familia")
    private String familia;
    @JoinColumn(name = "compra_id", referencedColumnName = "compra_id")
    @ManyToOne(optional = false)
    private Compras compraId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articuloId")
    private List<Inventarios> inventariosList;

    public Articulos() {
    }

    public Articulos(Integer articuloId) {
        this.articuloId = articuloId;
    }

    public Articulos(Integer articuloId, int codigoArticulo, float precioCompra, float precioVenta) {
        this.articuloId = articuloId;
        this.codigoArticulo = codigoArticulo;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public Integer getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Integer articuloId) {
        this.articuloId = articuloId;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public Compras getCompraId() {
        return compraId;
    }

    public void setCompraId(Compras compraId) {
        this.compraId = compraId;
    }

    @XmlTransient
    public List<Inventarios> getInventariosList() {
        return inventariosList;
    }

    public void setInventariosList(List<Inventarios> inventariosList) {
        this.inventariosList = inventariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articuloId != null ? articuloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        if ((this.articuloId == null && other.articuloId != null) || (this.articuloId != null && !this.articuloId.equals(other.articuloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Articulos[ articuloId=" + articuloId + " ]";
    }
    
}
