/**
 * Utility class for performing parsing operations on various numbers.
 */

package com.dobby.utils.math;

import java.util.regex.Pattern;

public class NumberParsing {

    public static boolean isValidDouble(String myString) {
		boolean retVal = false;
		final String Digits     = "(\\p{Digit}+)";
		final String HexDigits  = "(\\p{XDigit}+)";
		// an exponent is 'e' or 'E' followed by an optionally 
		// signed decimal integer.
		final String Exp        = "[eE][+-]?"+Digits;
		final String fpRegex    =
			("[\\x00-\\x20]*"+ // Optional leading "whitespace"
			"[+-]?(" +         // Optional sign character
			"NaN|" +           // "NaN" string
			"Infinity|" +      // "Infinity" string

			// Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
			"((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+

			// . Digits ExponentPart_opt FloatTypeSuffix_opt
			"(\\.("+Digits+")("+Exp+")?)|"+

			// Hexadecimal strings
			"((" +
			// 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
			"(0[xX]" + HexDigits + "(\\.)?)|" +

			// 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
			"(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

			")[pP][+-]?" + Digits + "))" +
			"[fFdD]?))" +
			"[\\x00-\\x20]*");// Optional trailing "whitespace"

		if (Pattern.matches(fpRegex, myString)){
			retVal = true; // Will not throw NumberFormatException
		}

        return retVal;
    }
}
