package com.dmaker.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Implementación del Servlet de la Index
 */

@WebServlet(urlPatterns = "/IndexServlet.do")
public class IndexServlet extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName(), null);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Handling GET");
   	 	HttpSession session = request.getSession();
   	 	boolean mismopedido = true;
   	 	if (session.getAttribute("mismopedido") == null) {
   	 		mismopedido = false;
   	 	}
   	 	session.setAttribute("mismopedido", mismopedido);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
