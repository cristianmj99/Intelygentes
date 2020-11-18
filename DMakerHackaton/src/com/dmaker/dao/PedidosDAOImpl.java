package com.dmaker.dao;

import java.util.ArrayList;

import java.util.List;

import com.dmaker.viewmodel.Pedido;


import java.sql.*;

public class PedidosDAOImpl implements PedidosDAO {
	
	@Override
	public int devolverUltimoNumeroPedido() {
		int ultimo = 0;
		try {
			Statement stmt;
			ResultSet rs;
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Pedidos");
			while ( rs.next() ) {
				Pedido pedido = new Pedido();
				pedido.setNumero_pedido(rs.getString("numero_pedido"));
				if (ultimo < Integer.parseInt(pedido.getNumero_pedido())) {
					ultimo = Integer.parseInt(pedido.getNumero_pedido());
				}					
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ultimo;
	}

	private Connection conn;

	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;		
	}

	@Override
	public void save(Pedido pedido) {			
		if (conn != null){
			Statement stmt;								
			try {
				stmt = conn.createStatement();
				
				stmt.executeUpdate("INSERT INTO PEDIDOS (numero_pedido,id_producto,cantidad,precio) VALUES('"
									+ pedido.getNumero_pedido()+"','"+pedido.getId_producto()+"'," + pedido.getCantidad() + "," 
									+ pedido.getPrecio_producto() + ")");
				
								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}		
	}

	@Override
	public List<Pedido> getAllProductsByNumberDelivery() {
		if (conn == null) return null;
		int ultimo = devolverUltimoNumeroPedido();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM HWM67262.PEDIDOS WHERE numero_pedido =" + ultimo);
			while ( rs.next() ) {
				Pedido pedido = new Pedido();
				pedido.setNumero_pedido(rs.getString("numero_pedido"));
				pedido.setId_producto(rs.getString("id_producto"));
				pedido.setCantidad(rs.getInt("cantidad"));
				pedido.setPrecio_producto(rs.getFloat("precio"));	
				pedidos.add(pedido);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return pedidos;
	}

}
