package com.dmaker.controllers;

import java.io.IOException;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dmaker.dao.PedidosDAOImpl;
import com.dmaker.viewmodel.Pedido;

import java.util.List;

/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet(urlPatterns = "/CarritoServlet.do")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean mismopedido = (boolean) session.getAttribute("mismopedido");
		
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		PedidosDAOImpl pedidosDAOImpl = new PedidosDAOImpl ();
		pedidosDAOImpl.setConnection(conn);
		if (mismopedido) {
			List <Pedido> pedidos = pedidosDAOImpl.getAllProductsByNumberDelivery();
			request.setAttribute("pedidos", pedidos);
		}
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/listaCompra.jsp");
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
