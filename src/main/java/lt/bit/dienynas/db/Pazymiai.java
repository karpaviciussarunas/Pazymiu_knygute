/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.dienynas.db;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sars
 */
@Entity
@Table(name = "pazymiai")
@NamedQueries({
    @NamedQuery(name = "Pazymiai.findAll", query = "SELECT p FROM Pazymiai p")
    , @NamedQuery(name = "Pazymiai.findById", query = "SELECT p FROM Pazymiai p WHERE p.id = :id")
    , @NamedQuery(name = "Pazymiai.findByData", query = "SELECT p FROM Pazymiai p WHERE p.data = :data")
    , @NamedQuery(name = "Pazymiai.findByPazymys", query = "SELECT p FROM Pazymiai p WHERE p.pazymys = :pazymys")})
public class Pazymiai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "pazymys")
    private Integer pazymys;
    @JoinColumn(name = "studentas_id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Studentai studentasId;

    public Pazymiai() {
    }

    public Pazymiai(Integer id) {
        this.id = id;
    }

    public Pazymiai(Integer id, Date data) {
        this.id = id;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getPazymys() {
        return pazymys;
    }

    public void setPazymys(Integer pazymys) {
        this.pazymys = pazymys;
    }

    public Studentai getStudentasId() {
        return studentasId;
    }

    public void setStudentasId(Studentai studentasId) {
        this.studentasId = studentasId;
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
        if (!(object instanceof Pazymiai)) {
            return false;
        }
        Pazymiai other = (Pazymiai) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pazymiai{" + "id=" + id + ", data=" + data + ", pazymys=" + pazymys + ", studentasId=" + studentasId + '}';
    }

    
    
}
