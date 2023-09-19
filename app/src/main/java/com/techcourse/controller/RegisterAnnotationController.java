package com.techcourse.controller;

import com.techcourse.domain.User;
import com.techcourse.repository.InMemoryUserRepository;
import context.org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.org.springframework.web.bind.annotation.RequestMapping;
import web.org.springframework.web.bind.annotation.RequestMethod;
import webmvc.org.springframework.web.servlet.ModelAndView;
import webmvc.org.springframework.web.servlet.view.JspView;

@Controller
public class RegisterAnnotationController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(final HttpServletRequest request, final HttpServletResponse response) {
        final var user = new User(2,
                request.getParameter("account"),
                request.getParameter("password"),
                request.getParameter("email"));
        InMemoryUserRepository.save(user);

        final String redirectUrl = "redirect:/index.jsp";
        final JspView jspView = new JspView(redirectUrl);
        return new ModelAndView(jspView);
    }

    @RequestMapping(value = "/register/view", method = RequestMethod.GET)
    public ModelAndView showRegisterPage(final HttpServletRequest request, final HttpServletResponse response) {
        final String viewName = "/register.jsp";
        final JspView jspView = new JspView(viewName);
        return new ModelAndView(jspView);
    }
}
