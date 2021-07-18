/* Copyright (c) 2020 Tech Rohila, All Rights Reserved.
 *
 * This code is confidential to Rohila Technologies and shall not be disclosed
 * outside the organisation without the prior written permission of the IT Director of
 * the organisation.
 *
 * In the event that such disclosure is permitted the code shall not be copied
 * or disclosed other than a need-to-know basis and any recipients may be
 * required to sign a confidentiality undertaking in favour of Rohila
 * Technologies.
 */

package com.rohila.api.util;

import java.util.Collection;

/**
 * Class file to provide methods for validator
 *
 * @author Tarun Rohila
 */
public final class ValidatorUtils {

    /**
     * Constructor declaration
     */
    private ValidatorUtils() {
    }

    /**
     * Method to check if type is empty
     *
     * @param t   - type
     * @param <T> - generic type
     * @return true if empty else false
     */
    public static <T> boolean isEmpty(T[] t) {
        if (t == null || t.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * Method to check if string is empty
     *
     * @param str - string value
     * @return true if empty else false
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Method to check if object is empty
     *
     * @param obj - Object
     * @return true if empty else false
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    /**
     * Method to check if collection is empty
     *
     * @param col - collection
     * @return true if empty else false
     */
    public static boolean isEmpty(Collection<?> col) {
        if (col == null || col.isEmpty()) {
            return true;
        }
        return false;
    }
}
