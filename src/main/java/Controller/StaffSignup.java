package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Staff;



@WebServlet("/staffsignup")
public class StaffSignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Date dob=Date.valueOf(req.getParameter("dob"));
		String gender=req.getParameter("gender");
		int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		
		
		MyDao dao=new MyDao();
		if(dao.fetchStaff(mobile)== null && dao.fetchStaff(email)== null && dao.fetchDoctor(mobile)== null && dao.fetchDoctor(email)== null) {
		Staff staff=new Staff();
		staff.setName(name);
		staff.setMobile(mobile);
		staff.setEmail(email);
		staff.setPassword(password);
		staff.setDob(dob);
		staff.setGender(gender);
		staff.setAge(age);
		
		
		dao.saveStaff(staff);
		
		resp.getWriter().print("<h1>Staff Account Created Successfully, Wait for Admin Approval</h1>");
		resp.getWriter().print("<h1>Your Staff Id is : "+staff.getId()+"</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);  
	}
	else {
			resp.getWriter().print("<h1>Mobile number or email already exist</h1>");
			req.getRequestDispatcher("StaffSignup.html").include(req, resp);
	}
	}	
}