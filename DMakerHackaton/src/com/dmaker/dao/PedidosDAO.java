package com.dmaker.dao;

import com.dmaker.viewmodel.*;


import java.sql.Connection;
import java.util.List;

public interface PedidosDAO {
	
	/**
	 * Establece una conexión a la base de datos.
	 * 
	 * @param conn
	 *            conexión a la base de datos.
	 */
	public void setConnection(Connection conn);

	/**
	 * Almacena un pedido en la bd.
	 * 
	 * @param pedido
	 *            Pedido que se va a almacenar en la BD.
	 */
	public void save(Pedido pedido);
	
	
	/**
	 * Obtiene todos los productos con un mismo número de pedido.
	 * 
	 */
	public List<Pedido> getAllProductsByNumberDelivery();
	
	/**
	 * Devuelve el último número pedido
	 * 
	 * @return Último número de pedido existente
	 */
	public int devolverUltimoNumeroPedido();
}
