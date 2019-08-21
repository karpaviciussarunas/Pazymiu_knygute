/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.springmaven;

import java.util.List;
import lt.bit.dienynas.dao.PazymiaiDAO;
import lt.bit.dienynas.db.Pazymiai;
import lt.bit.dienynas.db.Studentai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sars
 */
@Controller
@RequestMapping("/")
public class PazymiaiController {

    @Autowired
    private PazymiaiDAO pazymiaiDAO;

    @GetMapping("/test")
    public ModelAndView test(@RequestParam(name = "idx", required = false) Integer id) {
        ModelAndView mav = new ModelAndView();
        List<Pazymiai> pList = pazymiaiDAO.findInPazymys();
        mav.addObject("pazymiai", pList);
        return mav;
    }
//    public Studentai getStudentasId() {
//        return studentasId;
//    }
// išsitraukti pazymiu lista pagal studentasId     



}
