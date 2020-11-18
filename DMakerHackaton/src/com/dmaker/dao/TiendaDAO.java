package com.dmaker.dao;

import com.dmaker.viewmodel.Tienda;

import java.sql.Connection;

import java.util.List;

public interface TiendaDAO {
	
	/**
	 * Establece una conexión a la base de datos.
	 * 
	 * @param conn
	 *            conexión a la base de datos.
	 */
	public void setConnection(Connection conn);
	
	/**
	 * Obtiene una tienda por un id
	 * 
	 * @param id_tienda String con el id de la tienda
	 * @return Tienda con el id de los parámetros
	 */
	public Tienda getTienda(String id_tienda);
	
	/**
	 * Obtiene todas las tiendas de la base de datos
	 * 
	 * @return Lista de todas las tiendas de la base de datos
	 */
	public List <Tienda> getAll();

}
