/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;

/**
 *
 * @author Usuario
 */
public class Dias {

    public static String obtenerDiaSiguiente(String dia) {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int indice = Arrays.asList(dias).indexOf(dia);
        return dias[(indice + 1) % dias.length];
    }

    public static String obtenerDiaAnterior(String dia) {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int indice = Arrays.asList(dias).indexOf(dia);
        return dias[(indice - 1 + dias.length) % dias.length];
    }

    public static String obtenerDiaActual() {
        LocalDate hoy = LocalDate.now();
        DayOfWeek dia = hoy.getDayOfWeek();
        String nombreDia = dia.getDisplayName(TextStyle.FULL, Locale.getDefault());
        String nombreDiaFormato = nombreDia.substring(0, 1).toUpperCase() + nombreDia.substring(1);
        return nombreDiaFormato;
    }
}
