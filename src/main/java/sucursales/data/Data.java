package sucursales.data;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import sucursales.logic.Empleado;
import sucursales.logic.Sucursal;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    private List<Empleado> empleados;
    private List<Sucursal> sucursales;

    public Data() {
        empleados = new ArrayList<>();

        empleados.add(new Empleado("111", "Franklin Chang"));
        empleados.add(new Empleado("222", "Sandra Cauffman"));
        empleados.add(new Empleado("333", "Ivan Vargas"));

        sucursales = new ArrayList<>();

        sucursales.add(new Sucursal("111", "Liberia","200m norte",2.2, new Point(5,5)));
        sucursales.add(new Sucursal("222", "Alajuela","diagonal",3.2, new Point(10,10)));
        sucursales.add(new Sucursal("333", "Sabana","palo de maho",1.0, new Point(15,15)));
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }


    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
}
