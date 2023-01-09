package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Join;
import jpabook.jpashop.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class JoinController {


    private final JoinService joinService;

    @GetMapping("/join/new")
    public String createForm(Model model) {
        model.addAttribute("form", new JoinForm());
        return "createJoinForm";
    }

    @PostMapping(value = "/join/new")
    public String create(@Valid JoinForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "createJoinForm";
        }

        Join join = new Join();
        join.setUser_name(form.getId());
        join.setPw(form.getPw());

        joinService.join(join);
        return "redirect:/";

    }

//    @RequestMapping(value = "/login", method = {RequestMethod.POST})
//    public String loginPermission(HttpServletRequest request) {
//
//
//        try {
//            String user_name = request.getParameter("id");
//            String pw = request.getParameter("pw");
//            System.out.println("request = " + request);
//            if (joinService.permissionLoginJoin(user_name, pw) == true) {
//                return "200";
//            }
//            else {
//                return "444";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
}
