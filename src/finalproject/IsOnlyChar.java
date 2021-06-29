/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.regex.Pattern;

/**
 * CLASS TO VALIDADE If THE STRING ONLY CONTAINS CHARS TO VALIDATE THE NAME
 *
 * @author thiag
 */
public class IsOnlyChar {

    public static boolean check(String in) {
        if (!Pattern.matches(".*[a-zA-Z]+.*[a-zA-Z]", in)) {
            return false;
        } else {
            return true;
        }

    }

}
