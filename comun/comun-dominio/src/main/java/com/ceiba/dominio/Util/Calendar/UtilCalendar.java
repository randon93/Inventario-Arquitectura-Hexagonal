package com.ceiba.dominio.Util.Calendar;

import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionObjectoNoEncontrado;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

public class UtilCalendar {

    private static final String SUPERA_DIAS_DEL_MES = "la cantidad de dias asignados superan los dias que tiene el mes";

    public static Date getDate() {
        return Calendar.getInstance().getTime();
    }

    public static LocalDate getLocalDate() {
        Date input = UtilCalendar.getDate();
        LocalDate da = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return da;
    }

    public static LocalDate getLocalDate(Calendar c) {
        Date input = c.getTime();
        LocalDate da = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return da;
    }

    public static String formatearCalendar(Calendar c) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
        return df.format(c.getTime());
    }

    public static boolean isDomingo(Calendar c) {
        int dia = c.get(Calendar.DAY_OF_WEEK);
        return dia == Calendar.SUNDAY;
    }

    // formato de fecha:  13 de diciembre de 2020
    public static String agregarQuinceDias(Calendar c) {
        c.add(Calendar.DAY_OF_YEAR, 15);
        return formatearCalendar(c);
    }

    public static Date agregarQuinceDiasDate(Calendar c) {
        c.add(Calendar.DAY_OF_YEAR, 15);
        return c.getTime();
    }

    public static boolean seEncuentraEn(Integer losUltimosDias, LocalDate diaActual) {
//        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//        int ultimoDiaMes = cal.get(Calendar.DAY_OF_MONTH);
//        if (LosUltimosDias > ultimoDiaMes) {
//            throw new ExcepcionLongitudValor(SUPERA_DIAS_DEL_MES);
//        }
//        List<Integer> diasFinales = new ArrayList<>();
//        for (int i = 0; i <= LosUltimosDias; i++) {
//            diasFinales.add(ultimoDiaMes - i);
//        }
//        return diasFinales.contains(diaDelMes());

        LocalDate diaFinalMes  = LocalDate
                .of(diaActual.getYear(), diaActual.getMonth(), diaActual.getMonth().maxLength());
        Integer diasFaltantes = Period.between(diaActual, diaFinalMes).getDays();
        if (diasFaltantes <= losUltimosDias ) {
            throw new ExcepcionLongitudValor(SUPERA_DIAS_DEL_MES);
        }
        return false;

    }

    public static Integer diaDelMes() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

}
