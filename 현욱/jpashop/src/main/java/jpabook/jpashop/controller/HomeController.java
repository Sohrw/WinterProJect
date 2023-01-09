package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@Slf4j
public class HomeController {



    @RequestMapping(value = "/android", method = {RequestMethod.POST})
    public String androidPage(HttpServletRequest request, Model model) {
        try {
            System.out.println("안드로이드가 서버에 접속 요청");
            String androidID = request.getParameter("id");
            System.out.println("androidID = " + androidID);
            String androidPW = request.getParameter("pw");
            System.out.println("androidPW = " + androidPW);
            model.addAttribute("android", androidID);
            return "android";
        } catch (Exception e) {
            e.printStackTrace();
            return "null";
        }
    }




}
