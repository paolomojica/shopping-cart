package com.www.amaysim.util;

/**
 * Created by wsl-paolo on 06/06/2017.
 */
public class MathUtil {

    private MathUtil() {}

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
