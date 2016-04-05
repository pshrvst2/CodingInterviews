package com.motherbase.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.motherbase.dbmodel.Country;
import com.motherbase.dbmodel.Course;
import com.motherbase.dbmodel.Student;
import com.motherbase.dto.WebAPIDTO;
import com.motherbase.util.Util;
import com.mysql.jdbc.PreparedStatement;

@RestController
public class DataController {
	
	// TODO create a dao to handle the sql stuff
	private final String url = "jdbc:mysql://uiuc-class.me:3306/classmedb";
	private final String user = "classme";
	private final String password = "cs411classme";


	/**************************************************************
     * Method that get the country name and average temp
     * @return ArrayList<Country>
     * @throws ParseException
     **************************************************************/
	@RequestMapping(value = "/api/getcountryname/", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Country> getCountryName(HttpServletResponse response) throws org.json.simple.parser.ParseException 
	{
		Util util = new Util();
		util.readFile();
		
		ArrayList<Country> countryList = util.listOfCountries;
		
		return countryList;
	}

	/************************************************************************************
     * Method that get the country name and count of city under the range
     * @param max
     * @param min
     * @return ArrayList<Country>
     * @throws ParseException
     ************************************************************************************/
	@RequestMapping(value = "/api/getcountrynamewithrange/{min}/{max}", method = RequestMethod.POST,headers="Accept=application/json")
	@ResponseBody
	public ArrayList<Country> getCountryNameWithRange(@PathVariable String max ,@PathVariable String min) throws org.json.simple.parser.ParseException 
	{
		Util util = new Util();
		util.readFile();
		double maxVal = Double.parseDouble(max);
		double minVal = Double.parseDouble(min);
		ArrayList<Country> countryList = util.getCountriesInRange(minVal, maxVal);
		
		return countryList;
	}
	
	
    /****************************************
     * Method that checks the login credential
     * @param email
     * @param pw
     * @return responseDTO
     * @throws ParseException
     ****************************************/
	@RequestMapping(value="/api/login/{email}/{pw}",method = RequestMethod.GET,headers="Accept=application/json")
	public WebAPIDTO login(@PathVariable String email ,@PathVariable String pw) throws ParseException 
	{ 
		WebAPIDTO dto = new WebAPIDTO();
		dto.setMethodName("login");
		dto.setResult("bad");
				
		String pwc = "";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT password FROM classmedb.Student WHERE email ='" + email + "'");

			while (rs.next()) {

				pwc = rs.getString("password");
			}
		} catch (SQLException ex) {
			System.out.println("SQL exception"); // remove this later
			ex.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException ex) {
			}
		}
		if (pwc.equals(pw))
		{
		
			dto.setResult("good");
		}
				
		return dto;
	  }
	
	/*****************************************
	 * Method that retrieves the list of member
	 * @param response
	 * @return ArrayList<Student>
	 *****************************************/
	@RequestMapping(value = "/api/getmemberlist/", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Student> memberlist(HttpServletResponse response) 
	{
		// TODO create a dao to handle all the sql connection. 
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Student> memberList = new ArrayList<Student>();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT name,email,description FROM classmedb.Student");

			while (rs.next()) {

				Student student = new Student();
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				//student.setDescription(rs.getString("description"));
				if(rs.getString("description") ==null)
				{
					student.setDescription("");
				}
				else
				{
					student.setDescription(rs.getString("description"));
				}
				memberList.add(student);
			}
		} catch (SQLException ex) {
			System.out.println("SQL exception"); // remove this later
			ex.printStackTrace();
			//remove this later
			Student sentinel = new Student();
			sentinel.setName("sentintel");
			memberList.add(sentinel);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException ex) {
			}
		}
		return memberList;
	}
	
	/*****************************************
	 * Method that retrieves the list of classes
	 * @param response
	 * @return ArrayList<String>
	 *****************************************/
	@RequestMapping(value = "/api/getclasslist/", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> classlist(HttpServletResponse response) 
	{
		// TODO create a dao to handle all the sql connection. 
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<String> classList = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT num FROM classmedb.Course");

			while (rs.next()) {
				classList.add(rs.getString("num"));
			}
		} catch (SQLException ex) {
			System.out.println("SQL exception"); // remove this later
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException ex) {
			}
		}
		return classList;
	}
	
	/****************************************
	 * Method that allows user to register 
	 * @param memberName
	 * @param memberEmail
	 * @param memberPassword
	 * @return WebAPIDTO
	 * @throws ParseException
	 ****************************************/
	@RequestMapping(value="/api/createmember/{memberName}/{memberEmail}/{memberPassword}",method = RequestMethod.POST,headers="Accept=application/json")
	public WebAPIDTO addMember(@PathVariable String memberName,@PathVariable String memberEmail,@PathVariable String memberPassword) throws ParseException 
	{ 

	  	Connection con = null;
	  	WebAPIDTO dto = new WebAPIDTO();
	  	dto.setMethodName("addMember");
	  	dto.setResult("bad");
	
		if(memberName.isEmpty()|| memberName ==null || memberEmail.isEmpty() ||memberEmail ==null || memberPassword.isEmpty() || memberPassword ==null)			
		{
		
		}
		else
		{
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			try {
				con = DriverManager.getConnection(url, user, password);
				String query = " insert into classmedb.Student (name,email,password)"
				        + " values (?, ?, ?)";
				PreparedStatement p_statement =  (PreparedStatement) con.prepareStatement(query);
				p_statement.setString(1, memberName);
				p_statement.setString(2, memberEmail);
				p_statement.setString(3, memberPassword);
				p_statement.execute();
				
				 con.close();
				 dto.setResult("good");
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		 
		    }		  
		}		
		return dto;
	  }      	
	
	
	/****************************************
	 * Method that delete member by given email address
	 * @param email
	 * @return WebAPIDTO
	 * @throws ParseException
	 ****************************************/
	@RequestMapping(value="/api/deletemember/{email}/",method = RequestMethod.POST,headers="Accept=application/json")
	public WebAPIDTO deleteMember(@PathVariable String email) throws ParseException 
	{ 	
		WebAPIDTO dto = new WebAPIDTO();
		dto.setMethodName("deleterMember");
		dto.setResult("bad");
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();			
			String sql = "DELETE FROM classmedb.Student WHERE email = '"+email+"'";
			st.executeUpdate(sql);
			dto.setResult("good");

		} catch (SQLException ex) {
			System.out.println("SQL exception"); // remove this later
			ex.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException ex) {
			}
		}
		return dto;
	  }

	/*****************************************
	 * Method that allows the user to update the description 
	 * @param email
	 * @param desc
	 * @return WebAPIDTO
	 * @throws ParseException
	 *****************************************/

	 @RequestMapping(value="/api/updatemember/{email}/{desc}",method = RequestMethod.POST,headers="Accept=application/json")
	 public WebAPIDTO updateMember(@PathVariable String email, @PathVariable String desc) throws ParseException 
	 {  
		WebAPIDTO dto =  new WebAPIDTO();
		dto.setMethodName("updateMember");
		dto.setResult("bad");

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			
			con = DriverManager.getConnection(url, user, password);		
			String query = "update classmedb.Student set description = ? where email = ?";
			PreparedStatement p_statement =  (PreparedStatement) con.prepareStatement(query);
			p_statement.setString(1, desc);
			p_statement.setString(2, email);
			p_statement.executeUpdate();		
			 con.close();
			 dto.setResult("good");

		} catch (SQLException ex) {
			System.out.println("SQL exception"); // remove this later
			ex.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException ex) {
			}
		}
		return dto;
	  }

	
	/*****************************************
	 * Method that returns member info by given email 
	 * @param email
	 * @return Student
	 * @throws ParseException
	 *****************************************/
	@RequestMapping(value="/api/getmember/{email}/",method = RequestMethod.GET,headers="Accept=application/json")
	public Student getMember(@PathVariable String email) throws ParseException 
	{ 
		Student s = new Student();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
					
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			String query = "SELECT name,email,description FROM classmedb.Student WHERE email = '"+email+"'";
			rs = st.executeQuery(query);

			while (rs.next()) {
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setDescription(rs.getString("description"));
			}

		} catch (SQLException ex) {
			System.out.println("SQL exception"); // remove this later
			ex.printStackTrace();
			//s.setPassword(String.valueOf(ex));

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException ex) {
			}
		}	
		return s;
	  }
	
	/****************************************
	 * Method that retrieve selected course info by email
	 * @param email
	 * @return WebAPIDTO
	 * @throws ParseException
	 ****************************************/
	@RequestMapping(value="/api/getcourseinfo/{email}/",method = RequestMethod.GET,headers="Accept=application/json")
	public ArrayList<Course> selectCourseInfo(@PathVariable String email) throws ParseException 
	{ 	
		ArrayList<Course> courseList = new ArrayList<Course>();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
					
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			String query = "SELECT sas.courseNum, sas.section, s.enrollment_status FROM classmedb.StudentAndSection AS sas, classmedb.Section AS s  WHERE sas.studentEmail ='"+email+"' and sas.section = s.crn"; 
			rs = st.executeQuery(query);

			while (rs.next()) {
				Course c = new Course();
				c.setCourseNum(rs.getString("courseNum"));
				c.setSection(rs.getString("section"));
				c.setStatus(rs.getString("enrollment_status"));
				courseList.add(c);
			}

		} catch (SQLException ex) {
			System.out.println("SQL exception"); // remove this later
			ex.printStackTrace();
			//s.setPassword(String.valueOf(ex));

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException ex) {
			}
		}	
		return courseList;
	}

	/****************************************
	 * Method that gets crns for a class
	 * @param num
	 * @return WebAPIDTO
	 * @throws ParseException
	 ****************************************/
	@RequestMapping(value = "/api/getcrnforclass/{num}", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> crnlist(@PathVariable String num) 
	{
		// TODO create a dao to handle all the sql connection. 
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<String> crnList = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT crn FROM classmedb.CourseSections WHERE num ='" + num + "'");
			while (rs.next()) {
				crnList.add(rs.getString("crn"));
			}
		} catch (SQLException ex) {
			System.out.println("SQL exception"); // remove this later
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException ex) {
			}
		}
		return crnList;
	}
	
	/****************************************
	 * Method that adds a watch status for a student
	 * @return WebAPIDTO
	 * @throws ParseException
	 ****************************************/
	@RequestMapping(value = "/api/addwatch/{email}/{num}/{crn}", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<String> crnlist(@PathVariable String email, @PathVariable String num, @PathVariable String crn) 
	{
		// TODO create a dao to handle all the sql connection. 
		Connection con = null;
		Statement st = null;
		boolean rs = true;
		ArrayList<String> crnList = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.execute("INSERT INTO classmedb.StudentAndSection(studentEmail, courseNum, section) VALUES('"+email+"','"+num+"','"+crn+"');");
		} catch (SQLException ex) {
			System.out.println("SQL exception"); // remove this later
			ex.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException ex) {
			}
		}
		return crnList;
	}
	
	/****************************************
	 * Method that deletes a watch status for a student
	 * @return WebAPIDTO
	 * @throws ParseException
	 ****************************************/
	@RequestMapping(value = "/api/deletewatch/{email}/{num}/{crn}", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<String> deleteWatch(@PathVariable String email, @PathVariable String num, @PathVariable String crn) 
	{
		// TODO create a dao to handle all the sql connection. 
		Connection con = null;
		Statement st = null;
		boolean rs = true;
		ArrayList<String> crnList = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.execute("DELETE FROM classmedb.StudentAndSection WHERE studentEmail= '"+email+"' AND courseNum= '"+num+"' AND section='"+crn+"';");
		} catch (SQLException ex) {
			System.out.println("SQL exception"); // remove this later
			ex.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException ex) {
			}
		}
		return crnList;
	}
}
