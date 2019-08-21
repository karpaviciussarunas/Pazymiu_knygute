/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.springmaven;

import java.util.Date;
import java.util.List;
import lt.bit.dienynas.dao.PazymiaiDAO;
import lt.bit.dienynas.dao.StudentaiDAO;
import lt.bit.dienynas.db.Pazymiai;
import lt.bit.dienynas.db.Studentai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @Autowired
    private PazymiaiDAO pazymiaiDAO;

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

    @GetMapping("/pazymysedit")
    public ModelAndView pazimysedit(
            @RequestParam(name = "idp", required = false) Integer idp,
            @RequestParam(name = "idx", required = false) Integer idx) {
//paiimane studento id ir patikriname ar toks studentas egzistuoja
//tada patikriname ar paduotas pazymio id priklauso sitam studentui
//jeigu paduotas pazymio id null, tuomet kuriame studentui nauja pazymi
//jeigy paduotas pazymio id priklauso studentui tuomet redaguojame pazymi
        if (idp == null) {
            return new ModelAndView("pazymysedit");
        }
//        jeigu id egzistuoja tuomet sugeneruojame lista kaip inputa ir permetam i edit 
        if (pazymiaiDAO.existsById(idp)) {
            ModelAndView mv = new ModelAndView("pazymysedit");
//            reikia surasti pazymi pagal jo id
            Pazymiai pazymiai = pazymiaiDAO.getOne(idp);
//            Studentai studentas = studentaiDAO.getOne(idx);
            mv.addObject("pazymiai", pazymiai);
            mv.addObject("idp", idp);
            mv.addObject("idx", idx);
//            mv.addObject("studentas", studentas);
//            
            return mv;
        } else {
            return new ModelAndView("list");
        }
    }

    @Transactional
    @PostMapping("savepazymys")
    public String savepazymys(
            @RequestParam(name = "idx", required = false) Integer id,
            @RequestParam(name = "idp", required = false) Integer idp,
            @RequestParam(name = "pazymiai", required = false) Pazymiai pazymiai,
            @RequestParam(name = "pazymys", required = false) Integer pazymys,
            @RequestParam(name = "pazymysData", required = false) String pazymysData
    ) {
//        Pazymiai pazymiai = null;
        pazymiai = null;
        try {
//            
            pazymiai = pazymiaiDAO.getOne(new Integer(idp));
        } catch (Exception ex) {
        }
        if (pazymiai == null) {
            pazymiai = new Pazymiai();
        }
        pazymiai.setId(idp);
        pazymiai.setPazymys(pazymys);
        pazymiai.setData(new Date());
//        pazymiai.setStudentasId(id);

//        Saugome objekta i duomenu baze
        pazymiaiDAO.save(pazymiai);
        return "redirect:/list";
    }
}
