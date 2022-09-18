package sucursales;

import sucursales.presentation.empleados.Controller;
import sucursales.presentation.empleados.Model;
import sucursales.presentation.empleados.View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Application {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
        catch (Exception ex) {};

        Model empleadosModel= new Model();
        View empleadosView = new View();
        empleadosController = new Controller(empleadosView,empleadosModel);

        sucursales.presentation.empleado.Model empleadoModel= new sucursales.presentation.empleado.Model();
        sucursales.presentation.empleado.View empleadoView = new sucursales.presentation.empleado.View();
        empleadoController = new sucursales.presentation.empleado.Controller(empleadoView,empleadoModel);

        sucursales.presentation.main.Model mainModel= new sucursales.presentation.main.Model();
        sucursales.presentation.main.View mainView = new sucursales.presentation.main.View();
        mainController = new sucursales.presentation.main.Controller(mainView, mainModel);

        mainView.getPanel().add("Empleados",empleadosView.getPanel());

        window = new JFrame();
        window.setSize(400,300);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("SISTEMA...");
        window.setVisible(true);
        mainController.show();
    }

    public static Controller empleadosController;
    public static sucursales.presentation.empleado.Controller empleadoController;

    public static sucursales.presentation.main.Controller mainController;

    public static JFrame window;

    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;

    public static Border BORDER_ERROR = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED);

}
