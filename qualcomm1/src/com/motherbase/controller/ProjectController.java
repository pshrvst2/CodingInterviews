package com.motherbase.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.motherbase.service.HelloWorldService;
import com.motherbase.dbmodel.Student;
import java.net.URL;
import java.net.URLClassLoader;


@Controller
public class ProjectController {

	private final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	private final HelloWorldService helloWorldService;
	private final String url = "jdbc:mysql://uiuc-class.me:3306/classmedb";
        private final String user = "classme";
        private final String password = "cs411classme";

	@Autowired
	public ProjectController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");

		model.put("title", helloWorldService.getTitle(""));
		model.put("msg", helloWorldService.getDesc());
		
		return "index";
	}*/

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		model.addObject("title", helloWorldService.getTitle(name));
		model.addObject("msg", helloWorldService.getDesc());
		
		return model;

	}
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String login(Map<String, Object> model) {
//		return "login";
//	}	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String TempSection_1(Map<String, Object> model) {
		return "TempSection_1";
	}	
	@RequestMapping(value = "/section_2/", method = RequestMethod.GET)
	public String TempSection_2(Map<String, Object> model) {
		return "tempSection_2";
	}
	@RequestMapping(value = "/signup/", method = RequestMethod.GET)
	public String signup(Map<String, Object> model) {
		return "signUp";
	}
	@RequestMapping(value = "/profile/{email}", method = RequestMethod.GET)
	public ModelAndView profile(@PathVariable String email) {
		//DataController.userEmail = email;
		//return "profile";
		ModelAndView modelV = new ModelAndView();
		modelV.setViewName("profile");
		
		modelV.addObject("email", email);
		
		return modelV;

	}
	@RequestMapping(value = "/classes/{email}", method = RequestMethod.GET)
	public ModelAndView classes(@PathVariable String email) {
		ModelAndView modelV = new ModelAndView();
		modelV.setViewName("classes");
		modelV.addObject("email", email);
		return modelV;
	}
	
	@RequestMapping(value = "/memberlist/", method = RequestMethod.GET)
	public ModelAndView memberList(Map<String, Object> model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberList");
 		Connection con = null; Statement st = null; ResultSet rs = null;
                String returnValue = ""; ArrayList<Student> memberList = new ArrayList<Student>();

		try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
		try {
                    con = DriverManager.getConnection(url, user, password);
                    st = con.createStatement();
                    rs = st.executeQuery("SELECT name,email FROM classmedb.Student");
		    
		    while(rs.next()) {
			
			Student student = new Student();
			student.setName(rs.getString("name"));
			student.setEmail(rs.getString("email"));
			memberList.add(student);
		    }	  
                } catch(SQLException ex) {
		   System.out.println("SQL exception"); //remove this later
		   ex.printStackTrace();
		   Student sentinel = new Student();
		   sentinel.setName("sentintel");
		   memberList.add(sentinel);		
		} finally {
		   try { 
			if (rs !=  null) { rs.close();  }	
		  	if (st !=  null) { st.close();  }
			if (con != null) { con.close(); }
		    } catch(SQLException ex) { }
		}		
		mav.addObject("memberList", memberList);	
		//model.put("memberList", memberList);
		return mav;
	}
}
