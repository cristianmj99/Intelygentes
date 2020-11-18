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

import com.dmaker.auxiliar.sortyByNameTienda;
import com.dmaker.dao.TiendaDAOImpl;
import com.dmaker.viewmodel.Tienda;

/**
 * Servlet implementation class TiendasServlet
 */
@WebServlet(urlPatterns = "/TiendasServlet.do")
public class TiendasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiendasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if (request.getAttribute("lTiendas") != null) {
			 request.removeAttribute("lTiendas");
		 }
		 
		 RequestDispatcher view = request.getRequestDispatcher("WEB-INF/tiendas.jsp");
		 view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		TiendaDAOImpl tiendaDAOImpl = new TiendaDAOImpl();
		tiendaDAOImpl.setConnection(conn);
		
		List <Tienda> lTiendas = tiendaDAOImpl.getAll();
		Collections.sort(lTiendas, new sortyByNameTienda());
		String buscado = request.getParameter("buscar");
		boolean ambos = false;
		if (buscado.contains("-")) {
			ambos = true;
		}
		
		List <Tienda> lTiendasFin = new ArrayList <Tienda> ();
		for (int i = 0; i < lTiendas.size(); i++) {
			if (ambos) {
				String [] nombreCiudad = buscado.split("-");
				if (lTiendas.get(i).getNombre_tienda().contains(nombreCiudad[0]) && lTiendas.get(i).getMunicipio().contains(nombreCiudad[1])) {
					lTiendasFin.add(lTiendas.get(i));
				}
			}
			else {
				if (lTiendas.get(i).getMunicipio().contains(buscado) || lTiendas.get(i).getNombre_tienda().contains(buscado)) {
					lTiendasFin.add(lTiendas.get(i));
				}
			}
		}
		
		request.setAttribute("lTiendas", lTiendasFin);	
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/tiendas.jsp");
		view.forward(request, response);
	}

}
