package com.socin.web;

import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * TODO: Switch application from frontend to Angular.
 */
@Controller
@RequestMapping("/web")
public class UserWebController {

    @RequestMapping("/")
    public String users() {
        return "users";
    }

    @RequestMapping("/users/form")
    public String usersForm() {
        return "users_form";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
        session.setAttribute(
                "error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION")
        );

        return "login";
    }

    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "Usuário e senha inválidos!";

        if (exception instanceof LockedException) {
            error = exception.getMessage();
        }

        return error;
    }
}
