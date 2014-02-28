/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dominio;

import db.Controlador_DB;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author vicente-dell
 */
public class REPORTE {

    public REPORTE() {
    }

    public JasperViewer verReporte(Integer numeroFactura) {
        try {
            Map parametro = new HashMap();
            parametro.put("numeroFactura", numeroFactura);
            JasperReport reporte = (JasperReport) JRLoader.loadObject("Factura.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, Controlador_DB.getConexion().getConexion());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setTitle("Factura numero: " + numeroFactura);
            return jasperViewer;
        } catch (JRException ex) {
            Logger.getLogger(REPORTE.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se encuentra el Reporte", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
