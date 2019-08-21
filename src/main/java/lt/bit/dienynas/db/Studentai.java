/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.dienynas.db;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sars
 */
@Entity
@Table(name = "studentai")
@NamedQueries({
    @NamedQuery(name = "Studentai.findAll", query = "SELECT s FROM Studentai s")
    , @NamedQuery(name = "Studentai.findById", query = "SELECT s FROM Studentai s WHERE s.id = :id")
    , @NamedQuery(name = "Studentai.findByVardas", query = "SELECT s FROM Studentai s WHERE s.vardas = :vardas")
    , @NamedQuery(name = "Studentai.findByPavarde", query = "SELECT s FROM Studentai s WHERE s.pavarde = :pavarde")
    , @NamedQuery(name = "Studentai.findByElPastas", query = "SELECT s FROM Studentai s WHERE s.elPastas = :elPastas")})
public class Studentai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "vardas")
    private String vardas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pavarde")
    private String pavarde;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "el_pastas")
    private String elPastas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentasId")
    private List<Pazymiai> pazymiaiList;

    public Studentai() {
    }

    public Studentai(Integer id) {
        this.id = id;
    }

    public Studentai(Integer id, String vardas, String pavarde, String elPastas) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.elPastas = elPastas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getElPastas() {
        return elPastas;
    }

    public void setElPastas(String elPastas) {
        this.elPastas = elPastas;
    }

    public List<Pazymiai> getPazymiaiList() {
        return pazymiaiList;
    }

    public void setPazymiaiList(List<Pazymiai> pazymiaiList) {
        this.pazymiaiList = pazymiaiList;
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
        if (!(object instanceof Studentai)) {
            return false;
        }
        Studentai other = (Studentai) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Studentai{" + "id=" + id + ", vardas=" + vardas + ", pavarde=" + pavarde + ", elPastas=" + elPastas +  '}';
    }

 
    
}
