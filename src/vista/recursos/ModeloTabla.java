/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.recursos;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vicente
 */
public class ModeloTabla extends DefaultTableModel {

    public ModeloTabla() {
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
