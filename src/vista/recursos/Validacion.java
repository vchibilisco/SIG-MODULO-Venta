/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.recursos;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author vicente
 */
public class Validacion {

    public static MaskFormatter mascara() {
        try {
            return new MaskFormatter("###.##");
        } catch (ParseException ex) {
            Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //validacion para valores como la cantidad en unidad de un producto
    public static boolean validacion(String cadFloat) {
        Pattern pattern = Pattern.compile("[0-9]*.[0-9]{2}");
        Matcher matcher = pattern.matcher(cadFloat);
        if (matcher.matches()) {
            return true;
        } else {
            pattern = Pattern.compile("[1-9]*.[0-9]{1}");
            matcher = pattern.matcher(cadFloat);
            if (matcher.matches()) {
                return true;
            } else {
                pattern = Pattern.compile("[1-9]*");
                matcher = pattern.matcher(cadFloat);
                if (matcher.matches()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}