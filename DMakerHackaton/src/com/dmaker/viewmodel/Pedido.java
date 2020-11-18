package com.dmaker.viewmodel;

public class Pedido {

	private String numero_pedido;
	private int cantidad;
	private String id_producto;
	private float precio_producto;
	
	public Pedido() {
		numero_pedido = "";
		cantidad = 0 ;
		id_producto = "";
		precio_producto = 0;
	}

	public String getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(String numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	public float getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(float precio_producto) {
		this.precio_producto = precio_producto;
	}
}
