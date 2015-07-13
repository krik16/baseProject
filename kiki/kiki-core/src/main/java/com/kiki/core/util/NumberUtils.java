package com.kiki.core.util;

import java.text.NumberFormat;

/**
 * Created by Breggor on 2015/6/18.
 */
public class NumberUtils {
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance();

    public static String doubleDigits(double num, int digit) {
        NUMBER_FORMAT.setMaximumFractionDigits(digit);
        return NUMBER_FORMAT.format(num);
    }

    public static void main(String[] args) {
        System.out.println(NumberUtils.doubleDigits(3.323, 2));
    }
}
