package sucursales.presentation.sucursales;

import sucursales.Application;
import sucursales.logic.Sucursal;
import sucursales.logic.Service;

import java.util.List;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        model.setSucursals(Service.instance().sucursalesSearch(""));
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }


    public void preAgregar(){
        Application.sucursalController.preAgregar();
    }

    public void editar(int row){
        String codigo = model.getSucursales().get(row).getCodigo();
        Sucursal e=null;
        try {
            e= Service.instance().sucursalGet(codigo);
            Application.sucursalController.editar(e);
        } catch (Exception ex) {}
    }

    public void borrar(int row){
        String codigo = model.getSucursales().get(row).getCodigo();
        Sucursal e=null;
        try {
            e= Service.instance().sucursalGet(codigo);
            Service.instance().sucursalDelete(e);
            this.buscar("");
        } catch (Exception ex) {}
    }

    public void buscar(String filtro){
        List<Sucursal> rows = Service.instance().sucursalesSearch(filtro);
        model.setSucursals(rows);
        model.commit();
    }

    public void show(){
        Application.window.setContentPane(view.getPanel());
    }
}
