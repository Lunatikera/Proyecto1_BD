/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package utilerias;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Usuario
 */
public enum DiasEnum {
    Lunes,
    Martes,
    Miércoles,
    Jueves,
    Viernes,
    Sábado,
    Domingo;

    public static List<DiasEnum> obtenerTodoslosDias() {
        return Arrays.asList(DiasEnum.values());
    }

}
