/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.springmaven;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.POST;
import lt.bit.dienynas.dao.StudentaiDAO;
import lt.bit.dienynas.db.Pazymiai;
import lt.bit.dienynas.db.Studentai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sars
 */
@Controller
@RequestMapping("/")
public class StudentaiController {

    @Autowired
    private StudentaiDAO studentaiDAO;

//    @GetMapping
//    public ModelAndView index() {
////        mv sumodeliuoja informacija ir uzkrauna "index".jsp kuriame galima informacija pasiimti 
//        ModelAndView mv = new ModelAndView("index");
////        List<Studentai> list = studentaiDAO.findAll();
//        List<Studentai> list = studentaiDAO.findInOrder();
//        mv.addObject("studentai", list);
//        return mv;
//    }
    @GetMapping("back")
    public String back() {
        return "redirect:./";
    }

//@RequestMapping(method = RequestMethod.GET)
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        List<Studentai> list = studentaiDAO.findInOrder();
        mv.addObject("studentai", list);
        return mv;
    }

    @GetMapping("/edit")
    public ModelAndView studentEdit(@RequestParam(name = "idx", required = false) Integer id) {
//        jeigu id yra null tuomet permetame i edit puslapi
//        Studentai studentas = null;
        if (id == null) {
            return new ModelAndView("edit");
        }
//        jeigu id egzistuoja tuomet sugeneruojame lista kaip inputa ir permetam i edit 
        if (studentaiDAO.existsById(id)) {
            ModelAndView mv = new ModelAndView("edit");
//            reikia surasti Studenta pagal jo id
            Studentai studentas = studentaiDAO.getOne(id);
            mv.addObject("studentas", studentas);
            mv.addObject("idx", id);
            return mv;
        } else {
            return new ModelAndView("list");
        }
    }

//    @RequestMapping(path = "save", method = RequestMethod.POST)
    @Transactional
    @PostMapping("save")
    public String save(
            @RequestParam(name = "idx", required = false) Integer id,
            @RequestParam(name = "vardas", required = false) String vardas,
            @RequestParam(name = "pavarde", required = false) String pavarde,
            @RequestParam(name = "elPastas", required = false) String elPastas
    ) {
        Studentai studentas = null;
        try {
            studentas = studentaiDAO.getOne(new Integer(id));
        } catch (Exception ex) {
        }
        if (studentas == null) {
            studentas = new Studentai();
        }
        studentas.setId(id);
        studentas.setVardas(vardas);
        studentas.setPavarde(pavarde);
        studentas.setElPastas(elPastas);
//        Saugome objekta i duomenu baze
        studentaiDAO.save(studentas);
        return "redirect:/list";
    }

    @Transactional
    @GetMapping("delete")
    public String delete(@RequestParam(name = "idx", required = false) Integer id) {
        try {
            studentaiDAO.deleteById(id);
        } catch (Exception ex) {
//        gaudom ir nieko nedarom
        }
        return "redirect:/list";

    }

//    Dar neapsaugotas nuo nesamo idx
//    pasiimame studento objekta, išitraukiame jo pažymių sąrašą
//    perduodam i view studento objektą, pažymių sąrašą, studento id
    @GetMapping("/studentas")
    public ModelAndView studentas(@RequestParam(name = "idx", required = false) Integer id) {
        ModelAndView mv = new ModelAndView();
        Studentai studentas = studentaiDAO.getOne(id);
        List<Pazymiai> pazymiaiList = studentas.getPazymiaiList();
        mv.addObject("studentas", studentas);
        mv.addObject("pazymiai", pazymiaiList);
        mv.addObject("idx", id);
        return mv;
    }
}
