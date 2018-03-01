package com.TsugaruInfo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.TsugaruInfo.bean.MyBean;
import com.TsugaruInfo.bean.MyBeanEve;
import com.TsugaruInfo.sample1.MyBeanEventService;

/**
 * Servlet implementation class MySampleServlet
 * web3.1なのでサーブレットマッピングの記述不要
 */
@WebServlet("/sample")
public class MySampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext app;
	
	@Autowired
	private MyBeanEve myBeanEve;
	
	@Autowired
	private MyBeanEventService myService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init() throws ServletException{
        super.init();
        SpringBeanAutowiringSupport
        	.processInjectionBasedOnCurrentContext(this);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("mybean", myBeanEve);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = request.getParameter("message");
		myService.doService(message);
		response.sendRedirect("sample");
	}

}
