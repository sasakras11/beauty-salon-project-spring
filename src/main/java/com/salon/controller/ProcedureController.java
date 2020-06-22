package com.salon.controller;

import com.salon.service.ProcedureService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProcedureController {

  private final ProcedureService procedureService;
  private final SessionBean sessionBean;

  @GetMapping(value = {"/page"})
  public ModelAndView loggingIn(@RequestParam("pageNum") String pageNum) {

    ModelAndView mv = new ModelAndView();
    mv.addObject("procedures", procedureService.findPage(pageNum));
    mv.addObject("pagesCount", procedureService.pagesCount());
    mv.setViewName(sessionBean.getUser().getRole().name().toLowerCase() + "/procedure");

    return mv;
  }
}
