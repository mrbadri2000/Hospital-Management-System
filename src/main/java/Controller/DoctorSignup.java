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
import Dto.Doctor;


	@WebServlet("/doctorsignup")
	public class DoctorSignup extends HttpServlet {
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
			Doctor doctor=new Doctor();
			doctor.setName(name);
			doctor.setMobile(mobile);
			doctor.setEmail(email);
			doctor.setPassword(password);
			doctor.setDob(dob);
			doctor.setGender(gender);
			doctor.setAge(age);
			
			
			dao.saveDoctor(doctor);
			
			resp.getWriter().print("<h1>Doctor Account Created Successfully , Wait for Admin approval</h1>");
			resp.getWriter().print("<h1>Your Doctor Id is : "+doctor.getId()+"</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);  
		}
		else {
				resp.getWriter().print("<h1>Mobile number or email already exist</h1>");
				req.getRequestDispatcher("Doctor Signup.html").include(req, resp);
		}
		}	
	}
