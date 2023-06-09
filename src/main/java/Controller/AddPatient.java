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
import javax.servlet.http.Part;

import Dao.MyDao;
import Dto.Patient;
@WebServlet(urlPatterns = "/addpatient")
public class AddPatient extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String name = req.getParameter("name");
    	long mobile=Long.parseLong(req.getParameter("mobile"));
    	Date dob=Date.valueOf(req.getParameter("dob"));
    	int age=Period.between(dob.toLocalDate(),LocalDate.now()).getYears();
    	Part picture=req.getPart("picture");
    	byte[] image =new byte[picture.getInputStream().available()];
    	picture.getInputStream().read();    	
    	Patient patient =new Patient();
    	patient.setName(name);
    	patient.setAge(age);
    	patient.setDob(dob);
    	patient.setMobile(mobile);
    	patient.setPicture(image);
    	
    	MyDao dao=new MyDao();
    	dao.savePatient(patient);
    	
    	resp.getWriter().print("<h1>Patient Enrolled</h1>");
		req.getRequestDispatcher("StaffHome.html").include(req, resp);
    }
 
}
