package com.base.mvc.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.mvc.service.MVCService;

@Controller
public class MVCController {
	
	@Autowired
	MVCService mvcservice;
	
	private static final Logger logger = LoggerFactory.getLogger(MVCController.class);

	@RequestMapping("/index.do")
	public String methodCtl(Model model) throws Exception {
		//* console log 출력(info, warn, error 단계)
		logger.info("INFO level log");
        logger.warn("WARN level log");
        logger.error("ERROR level log");

        model.addAttribute("Hello", mvcservice.methodSrv());
		return "index";
	}
}
