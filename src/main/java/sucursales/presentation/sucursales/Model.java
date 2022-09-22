package sucursales.presentation.sucursales;

import sucursales.logic.Sucursal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

public class Model extends java.util.Observable{
    List<Sucursal> sucursales;

    public Model() {
        this.setSucursals(new ArrayList<Sucursal>());
    }

    public void setSucursals(List<Sucursal> sucursales){
        this.sucursales = sucursales;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        commit();
    }

    public void commit(){
        setChanged();
        notifyObservers(null);
    }
}
