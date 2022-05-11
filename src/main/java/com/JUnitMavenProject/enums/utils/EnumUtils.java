package com.JUnitMavenProject.enums.utils;

import com.JUnitMavenProject.enums.Operations;

public class EnumUtils {

    private EnumUtils() {
    }

    public static Operations returnOperationsFromString(String inputString) {
        return Operations.valueOf(inputString.toUpperCase());
    }
}
