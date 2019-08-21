/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.dienynas.dao;

import java.util.List;
import lt.bit.dienynas.db.Pazymiai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Sars
 */
public interface PazymiaiDAO extends JpaRepository<Pazymiai, Integer> {

    @Query("select p from Pazymiai p order by p.pazymys, p.data")
    public List<Pazymiai> findInPazymys();

//    @Query("SELECT p FROM Pazymiai p WHERE p.studentas_id = :id")
//    public List<Pazymiai> findByStudentId(Integer id);
//    @Query ("select p from pazymiai p order by p.studentas_id")
//    public List<Pazymiai> findByStudenatasId(Integer id);
}
