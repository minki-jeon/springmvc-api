package com.test.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
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

	//* api.key.properties
	@Value("${key.MAPLE}")
	private String __mapleKey__;
	@Value("${key.MAPLEM}")
	private String __maplemKey__;
	@Value("${key.PUBLIC.3038817}")
	private String __publicKey1__;
	
    @RequestMapping(value= {"/sampleMaple.do"})
    public ModelAndView sampleMaple(HttpServletRequest request,
			HttpServletResponse response,
			SessionStatus status,
			ModelAndView modelAndView) {
    	
    	modelAndView.setViewName("api/sampleMaple");
    	
    	Map<String, Object> resultMap = new HashMap<String, Object>();

    	try {
    		String API_KEY = __mapleKey__;
//          String characterName = URLEncoder.encode("CHARACTER NAME", StandardCharsets.UTF_8);
//          String urlString = "https://open.api.nexon.com/heroes/v1/id?character_name=" + characterName;
            String urlString = "https://open.api.nexon.com/maplestory/v1/character/list";
            URL url = new URL(urlString);
      
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-nxopen-api-key", API_KEY);
      
            int responseCode = connection.getResponseCode();
      
            BufferedReader in;
            if(responseCode == 200) {
              in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
              in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
      
            String inputLine;
            StringBuffer responseData = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
            	responseData.append(inputLine);
            }
            in.close();
      
            System.out.println(responseData.toString());
            modelAndView.addObject("resultApi", responseData);
            
          } catch (Exception exception) {
            System.out.println(exception);
          }
    	
    	modelAndView.addObject("resultMap", resultMap);
    	
    	
    	return modelAndView;
    }

    @RequestMapping(value= {"/sampleMapleM.do"})
    public ModelAndView sampleMapleM(HttpServletRequest request,
			HttpServletResponse response,
			SessionStatus status,
			ModelAndView modelAndView) {
    	
    	modelAndView.setViewName("api/sampleMapleM");
    	
    	Map<String, Object> resultMap = new HashMap<String, Object>();

    	try {
    		String API_KEY = __maplemKey__;
//          String characterName = URLEncoder.encode("CHARACTER NAME", StandardCharsets.UTF_8);
//          String urlString = "https://open.api.nexon.com/heroes/v1/id?character_name=" + characterName;
    		String ocid = "9aa8425eb305ff231a632c6507ab63ccc583003eb0448898768cf5ad982a332b";	/* 캐릭터 고유ID */
    		String urlString = "https://open.api.nexon.com/maplestorym/v1/character/basic" + "?ocid=" + ocid;
            URL url = new URL(urlString);
      
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-nxopen-api-key", API_KEY);
      
            int responseCode = connection.getResponseCode();
      
            BufferedReader in;
            if(responseCode == 200) {
              in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
              in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
      
            String inputLine;
            StringBuffer responseData = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
            	responseData.append(inputLine);
            }
            in.close();
      
            System.out.println(responseData.toString());
            modelAndView.addObject("resultApi", responseData);
            
          } catch (Exception exception) {
            System.out.println(exception);
          }
    	
    	modelAndView.addObject("resultMap", resultMap);
    	
    	
    	return modelAndView;
    }


    @RequestMapping(value= {"/samplePublicData.do"})
    public ModelAndView samplePublicData(HttpServletRequest request,
			HttpServletResponse response,
			SessionStatus status,
			ModelAndView modelAndView) {
    	
    	modelAndView.setViewName("api/samplePublicData");
    	
    	Map<String, Object> resultMap = new HashMap<String, Object>();

    	try {
    		String API_KEY = __publicKey1__;
    		API_KEY = URLEncoder.encode(API_KEY, "UTF-8");
    		Integer pageIdx = 1;
    		Integer pageSize = 2;
    		String returnType = "JSON";
    		String uddi = "77d5f727-417a-4f07-a1de-bb342426bb38";
    		String urlString = "https://api.odcloud.kr/api/3038817/v1/"
    						+ "uddi:" + uddi + "?"
    						+ "page=" + pageIdx + "&"
    						+ "perPage=" + pageSize + "&"
    						+ "returnType=" + returnType + "&"
    						+ "serviceKey=" + API_KEY
    						;
    		
            URL url = new URL(urlString);
      
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
//          connection.setRequestProperty("Content-type", "application/json");
      
            int responseCode = connection.getResponseCode();
      
            BufferedReader in;
            if(responseCode == 200) {
              in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
              in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String inputLine;
            StringBuffer responseData = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
            	responseData.append(inputLine);
            }
            in.close();
      
            System.out.println(responseData.toString());
            modelAndView.addObject("resultApi", responseData);
            
          } catch (Exception exception) {
            System.out.println(exception);
          }
    	
    	modelAndView.addObject("resultMap", resultMap);
    	
    	
    	return modelAndView;
    }
    
    @RequestMapping(value= {"/index.do"})
    public ModelAndView main(HttpServletRequest request,
			HttpServletResponse response,
			SessionStatus status,
			ModelAndView modelAndView) {
    	
    	modelAndView.setViewName("api/index");
    	
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	
    	resultMap.put("API-Test", "Here is api test.");

    	modelAndView.addObject("resultMap", resultMap);
    	
    	
    	return modelAndView;
    }
}
