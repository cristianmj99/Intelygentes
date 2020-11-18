package com.dmaker.auxiliar;

import java.util.Comparator;

import com.dmaker.viewmodel.Producto;

public class sortByNameProduct implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
       return p1.getNombreProducto().compareTo(p2.getNombreProducto());
    }
}
