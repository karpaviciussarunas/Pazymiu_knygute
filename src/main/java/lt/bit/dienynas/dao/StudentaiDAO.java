/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.dienynas.dao;

import java.util.List;
import lt.bit.dienynas.db.Studentai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Sars
 */
public interface StudentaiDAO extends JpaRepository<Studentai, Integer> {

    @Query("select s from Studentai s order by s.pavarde, s.vardas")
    public List<Studentai> findInOrder();

    @Query("select s from Studentai s order by s.id")
    public List<Studentai> findAllById(Integer id);

}
