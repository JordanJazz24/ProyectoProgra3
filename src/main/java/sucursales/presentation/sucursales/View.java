package sucursales.presentation.sucursales;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    private JPanel panel;
    private JTextField nombreFld;
    private JButton buscarFld;
    private JButton agregarFld;
    private JTable sucursalesFld;
    private JLabel nombreLbl;

    public View() {
        buscarFld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.buscar(nombreFld.getText());
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    Controller controller;
    Model model;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Observable updatedModel, Object parametros) {
            int[] cols = {TableModel.CODIGO, TableModel.REFERENCIA,TableModel.DIRECCION,TableModel.ZONAJE};
        sucursalesFld.setModel(new TableModel(cols, model.getSucursals()));
        sucursalesFld.setRowHeight(30);
        this.panel.revalidate();
    }

}
