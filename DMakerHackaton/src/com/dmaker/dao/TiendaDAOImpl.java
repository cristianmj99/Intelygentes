package com.dmaker.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dmaker.viewmodel.Tienda;

import java.util.ArrayList;


public class TiendaDAOImpl implements TiendaDAO {
	
	private Connection conn;

	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;		
	}
	
	@Override
	public Tienda getTienda(String id_tienda) {
		if (conn == null) return null;
		
		Tienda tienda = null;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM HWM67262.TIENDAS WHERE id_tienda =" + id_tienda);			 
			if (!rs.next()) return null; 
			tienda  = new Tienda();	 
			tienda.setId_tienda(rs.getString("id_tienda"));
			tienda.setNombre_tienda(rs.getString("nombre_tienda"));
			tienda.setMunicipio(rs.getString("municipio"));
			tienda.setProvincia(rs.getString("provincia"));
			tienda.setCalle(rs.getString("calle"));
			tienda.setCp(rs.getString("cp"));
			tienda.setCasos(rs.getString("casos"));
			tienda.setAforo(rs.getInt("aforo"));
			tienda.setAforomaximo(rs.getInt("aforomaximo"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tienda;
	}


	@Override
	public List<Tienda> getAll() {
		if (conn == null) return null;
	
		ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
		try {
			Statement stmt;
			ResultSet rs;
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM HWM67262.TIENDAS");
			while ( rs.next() ) {
				Tienda tienda = new Tienda();
				tienda.setId_tienda(rs.getString("id_tienda"));
				tienda.setNombre_tienda(rs.getString("nombre_tienda"));
				tienda.setMunicipio(rs.getString("municipio"));
				tienda.setProvincia(rs.getString("provincia"));
				tienda.setCalle(rs.getString("calle"));
				tienda.setCp(rs.getString("cp"));
				tienda.setCasos(rs.getString("casos"));
				tienda.setAforo(rs.getInt("aforo"));
				tienda.setAforomaximo(rs.getInt("aforomaximo"));
				tiendas.add(tienda);								
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return tiendas;
	}


	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
