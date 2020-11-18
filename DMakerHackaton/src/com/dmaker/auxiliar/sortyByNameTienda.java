package com.dmaker.auxiliar;

import java.util.Comparator;
import com.dmaker.viewmodel.Tienda;

public class sortyByNameTienda implements Comparator<Tienda> {
    @Override
    public int compare(Tienda t1, Tienda t2) {
       return t1.getNombre_tienda().compareTo(t2.getNombre_tienda());
    }
}
