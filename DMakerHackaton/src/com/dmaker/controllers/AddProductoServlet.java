package com.dmaker.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dmaker.dao.PedidosDAOImpl;
import com.dmaker.dao.ProductoDAOImpl;
import com.dmaker.viewmodel.Pedido;


/**
 * Servlet implementation class AddProductoServlet
 */
@WebServlet(urlPatterns = "/AddProductoServlet.do")
public class AddProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id_producto");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		
		HttpSession session = request.getSession();
		boolean mismopedido = (boolean) session.getAttribute("mismopedido");
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
	    PedidosDAOImpl pedidosDAOImpl = new PedidosDAOImpl();
	    pedidosDAOImpl.setConnection(conn);
	    int ultimo = 0;
	    ultimo = pedidosDAOImpl.devolverUltimoNumeroPedido();
		
		if (mismopedido == false) {
			mismopedido = true;
			session.removeAttribute("mismopedido");
			session.setAttribute("mismopedido", mismopedido);
		    ultimo = ultimo + 1;
		}
	    ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl();
	    productoDAOImpl.setConnection(conn);
		
		Pedido pedido = new Pedido ();
		pedido.setNumero_pedido(Integer.toString(ultimo));
		pedido.setCantidad(cantidad);
		pedido.setId_producto(id);
		pedido.setPrecio_producto(productoDAOImpl.getProducto(id).getPrecio());
		
		pedidosDAOImpl.save(pedido);
		
    	response.sendRedirect("CarritoServlet.do");
		
	}

}
