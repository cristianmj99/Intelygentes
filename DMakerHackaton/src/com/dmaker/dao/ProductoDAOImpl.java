package com.dmaker.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dmaker.viewmodel.Producto;


public class ProductoDAOImpl implements ProductoDAO {
	
	@Override
	public Producto getProducto(String id_producto) {
		if (conn == null) return null;
		
		Producto producto = null;		
		
		try {
			Statement stmt = conn.createStatement();	 
			ResultSet rs = stmt.executeQuery("SELECT * FROM HWM67262.PRODUCTO WHERE id_producto ="+id_producto);			 
			if (!rs.next()) return null; 
			producto  = new Producto();	 
			producto.setId_producto(rs.getString("id_producto"));
			producto.setPrecio(rs.getFloat("precio"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}

	private Connection conn;

	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;	
	}

	@Override
	public List<Producto> getProductos(String id_tienda) {
			if (conn == null) return null;
			
			ArrayList<Producto> productos = new ArrayList<Producto>();
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM HWM67262.PRODUCTO WHERE id_tienda =" + id_tienda);
				while ( rs.next() ) {
					Producto producto = new Producto();
					producto.setId_producto(rs.getString("id_producto"));
					producto.setNombreProducto(rs.getString("nombre_producto"));
					producto.setDescripcion(rs.getString("descripcion"));
					producto.setUbicacionEnTienda(rs.getString("ubicacion"));
					producto.setAgotado(rs.getString("agotado"));
					producto.setUnidadesRestantes(rs.getInt("unidadesrestantes"));
					producto.setPrecio(rs.getFloat("precio"));	
					productos.add(producto);
				}
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			return productos;
		}

}
