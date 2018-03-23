/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.recursos;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Formatter;

/**
 *
 * @author vicente
 */
public class Formato {

    public static Formatter numFact(Integer num) {
        Formatter fmt = new Formatter();
        fmt.format("%010d", num);
        return fmt;
    }

    public static DecimalFormat precio() {
        DecimalFormatSymbols simb = new DecimalFormatSymbols();
        simb.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#######.##", simb);
        return df;
    }

    public static DecimalFormat cambioCarater() {
        //DecimalFormatSymbols simb = new DecimalFormatSymbols();
        //simb.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###,###.##");
        return df;
    }
}
