package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Staff;

public class Changestaffstatus extends HttpServlet
{
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		int id = Integer.parseInt(req.getParameter("id"));
		MyDao dao = new MyDao();
		Staff staff = dao.fetchStaff(id);
		if (staff.isStatus())
			staff.setStatus(false);
		else
			staff.setStatus(true);

		dao.updateStaff(staff);

		resp.getWriter().print("<h1 style='color:green'>Status Updated</h1>");
		req.setAttribute("list", dao.FetchAllStaff());
		req.getRequestDispatcher("ApproveStaff.jsp").include(req, resp);

		}
}
