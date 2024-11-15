package com.test.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin("*")
@RequestMapping(value = "/api")
@Controller
public class apiCtrl {


    /**
     *********************************************************************************
     * <pre>
     * @함  수  명 : main
     * @작  성  일 : 2021. 7. 2. 오후 6:02:43
     * @작  성  자 : eunae
     * @return 
     * @설       명 : 
     *  메인페이지
     * </pre>
     *********************************************************************************
     */
    @RequestMapping(value= {"/index.do"})
    public ModelAndView main(HttpServletRequest request,
			HttpServletResponse response,
			SessionStatus status,
			ModelAndView modelAndView) {
    	
    	modelAndView.setViewName("api/index");
    	
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	
    	
    	
    	resultMap.put("API-Test", "This is api test.");

    	modelAndView.addObject("resultMap", resultMap);
    	
    	
    	return modelAndView;
    }
}
