package com.dmaker.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dmaker.auxiliar.sortByNameProduct;
import com.dmaker.dao.ProductoDAOImpl;
import com.dmaker.dao.TiendaDAOImpl;
import com.dmaker.viewmodel.Producto;
import com.dmaker.viewmodel.Tienda;

/**
 * Servlet implementation class VerTiendaServlet
 */
@WebServlet(urlPatterns = "/VerTiendaServlet.do")
public class VerTiendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerTiendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getAttribute("lProductos") != null) {
			request.removeAttribute("lProductos");
		}
		
		String id = request.getParameter("id_tienda");
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		TiendaDAOImpl tiendaDAOImpl = new TiendaDAOImpl();
		tiendaDAOImpl.setConnection(conn);
		
		Tienda tienda = tiendaDAOImpl.getTienda(id);
		
		request.setAttribute("tienda", tienda);
		
		String buscado = request.getParameter("buscado");
		
		ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl ();
		productoDAOImpl.setConnection(conn);
		
		
		
		List <Producto> lProductos = productoDAOImpl.getProductos(id);
		Collections.sort(lProductos, new sortByNameProduct());
		
		List <Producto> lProductoFin = new ArrayList <Producto> ();
		for (int i = 0; i < lProductos.size(); i++) {
			if (lProductos.get(i).getNombreProducto().contains(buscado)) {
				lProductoFin.add(lProductos.get(i));
			}
		}
		
		request.setAttribute("lProductos", lProductoFin);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/tiendapagina.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getAttribute("lProductos") != null) {
			request.removeAttribute("lProductos");
		}
		String id = request.getParameter("id_tienda");
		
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		TiendaDAOImpl tiendaDAOImpl = new TiendaDAOImpl();
		tiendaDAOImpl.setConnection(conn);
		
		Tienda tienda = tiendaDAOImpl.getTienda(id);
		
		request.setAttribute("tienda", tienda);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/tiendapagina.jsp");
		view.forward(request, response);
	}

}
