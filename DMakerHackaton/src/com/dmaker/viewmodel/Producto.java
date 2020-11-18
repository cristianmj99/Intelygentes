package com.dmaker.viewmodel;


public class Producto {
	
	private String id_producto;
	private String nombreProducto;
	private String descripcion;
	private String agotado;
	private String ubicacionEnTienda;
	private int unidadesRestantes;
	private float precio;
	
	public Producto () {
		this.id_producto = "";
		this.nombreProducto = "";
		this.descripcion = "";
		this.agotado = "";
		this.ubicacionEnTienda = "";
		this.unidadesRestantes = 0;
		this.precio = 0;
	}
	
	public Producto(String id, String nombre, String desc, String agotadoP, String ubi,
		          	float precioP) {
		this.id_producto = id;
		this.nombreProducto = nombre;
		this.descripcion = desc;
		this.agotado = agotadoP;
		this.ubicacionEnTienda = ubi;
		this.precio = precioP;
	}

	public String isAgotado() {
		return agotado;
	}

	public void setAgotado(String agotado) {
		this.agotado = agotado;
	}

	public String getUbicacionEnTienda() {
		return ubicacionEnTienda;
	}

	public void setUbicacionEnTienda(String ubicacionEnTienda) {
		this.ubicacionEnTienda = ubicacionEnTienda;
	}

	public int getUnidadesRestantes() {
		return unidadesRestantes;
	}

	public void setUnidadesRestantes(int unidadesRestantes) {
		this.unidadesRestantes = unidadesRestantes;
	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
