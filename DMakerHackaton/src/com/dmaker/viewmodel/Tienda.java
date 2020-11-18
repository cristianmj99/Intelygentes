package com.dmaker.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

	private String id_tienda;
	private String nombre_tienda;
	private String calle;
	private String municipio;
	private String provincia;
	private String cp;
	private String casos;
	private int aforo;
	private int aforomaximo;
	private List <Producto> listaProductos;
	private List <Pedido> listaPedidos;
	
	public Tienda () {
		this.id_tienda = "";
		this.nombre_tienda = "";
		this.calle = "";
		this.municipio = "";
		this.provincia = "";
		this.cp = "";
		this.casos = "";
		this.aforo = 0;
		this.aforomaximo = 0;
		this.listaProductos = new ArrayList <Producto> ();
		this.listaPedidos = new ArrayList <Pedido> ();
	}
	
	public Tienda (String id, String nombreP, String calleP, String municipioP, String provinciaP, String cpP,
			       List <Producto> lProd, List <Pedido> lPed, String casosUlt, int af, int afm) {
		this.id_tienda = id;
		this.nombre_tienda = nombreP;
		this.calle = calleP;
		this.municipio = municipioP;
		this.provincia = provinciaP;
		this.cp = cpP;
		this.casos = casosUlt;
		this.aforo = af;
		this.aforomaximo = afm;
		this.listaProductos = lProd;
		this.listaPedidos = lPed;
	}

	public String getCasos() {
		return casos;
	}

	public void setCasos(String casos) {
		this.casos = casos;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public int getAforomaximo() {
		return aforomaximo;
	}

	public void setAforomaximo(int aforomaximo) {
		this.aforomaximo = aforomaximo;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public String getId_tienda() {
		return id_tienda;
	}

	public void setId_tienda(String id_tienda) {
		this.id_tienda = id_tienda;
	}

	public String getNombre_tienda() {
		return nombre_tienda;
	}

	public void setNombre_tienda(String nombre_tienda) {
		this.nombre_tienda = nombre_tienda;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}
	
}
