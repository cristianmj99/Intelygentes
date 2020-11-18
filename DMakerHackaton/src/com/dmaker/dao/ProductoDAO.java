package com.dmaker.dao;

import java.sql.Connection;
import java.util.List;
import com.dmaker.viewmodel.Producto;


public interface ProductoDAO {
	/**
	 * Establece una conexión a la base de datos.
	 * 
	 * @param conn
	 *            conexión a la base de datos.
	 */
	public void setConnection(Connection conn);
	
	/**
	 * Obtiene una lista de productos de una tienda
	 * 
	 * @param id_tienda String con el id de la tienda
	 * @return Lista de productos con el id de la tienda
	 */
	public List<Producto> getProductos(String id_tienda);
	
	/**
	 * Obtiene un producto a partir de un id
	 * 
	 * @param id del producto
	 * @return Producto con el id correspondiente
	 */
	public Producto getProducto(String id_producto);
	
}
