package com.salon.controller;

import com.salon.entity.User;
import com.salon.service.PasswordEncoder;
import com.salon.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

  private final UserService userService;
  private final UserBean userBean;

  @GetMapping(value = {"/"})
  public ModelAndView getLoginPage() {

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("login");

    return modelAndView;
  }

  @PostMapping(value = {"/salons"})
  public ModelAndView loggingIn(
      @RequestParam("username") String username, @RequestParam("password") String password) {

    ModelAndView modelAndView = new ModelAndView();
    User user = userService.login(username, password);
    userBean.setUser(user);

    modelAndView.setViewName("salons");

    return modelAndView;
  }

  @GetMapping(value = "/registration")
  public ModelAndView registerPage() {

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("registration");

    return modelAndView;
  }

  @PostMapping(value = {"/register"})
  public ModelAndView registration(
      @RequestParam("username") String username, @RequestParam("password") String password) {

    ModelAndView modelAndView = new ModelAndView();
    User user = userService.register(username, password);
    userBean.setUser(user);

    modelAndView.setViewName("salons");

    return modelAndView;
  }
}
