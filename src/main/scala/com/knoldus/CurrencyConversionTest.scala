package com.knoldus

/**
 * This Class converts from given currency state to INR first.
 * Then it takes the previous value and convert it into given future state currency.
 */
class CurrencyConversionTest {
  /**
   * @param currentState - represents the currency state that is to be converted
   * @param futureState - represents the currency state that is to be converted into
   * @param inputAmount- given value in double
   * @return - calculated currency converted value
   */
  def convert(currentState: String, futureState: String, inputAmount: Double): Double = {
    if (inputAmount < 0) {
      throw new Exception("Negative values not allowed")
    } else {
      val tempInr = currencyConversion(currentState.toUpperCase, "to", inputAmount)
      val finalValue = currencyConversion(futureState.toUpperCase, "from", tempInr)
      finalValue
    }
  }

  val map1 = Map("USD" -> 71, "INR" -> 1, "EURO" -> 40, "MRN RUPEE" -> 10, "PAK RUPEE" -> 12, "SED" -> 30, "GBP" -> 50, "SYP" -> 33, "YEN" -> 60)

  /**
   * @param currentState - represents the currency state that is to be converted
   * @param operation - represents "to" or "from" state
   * @param inputAmount - given value in double
   * @return - calculated currency converted value
   */
  def currencyConversion(currentState: String, operation: String, inputAmount: Double): Double = {
    if (map1.contains(currentState)) {
      if (operation.equals("to")) {
        inputAmount * map1(currentState)
      } else {
        inputAmount / map1(currentState)
      }
    }
    else {
      throw new Exception("Currency Not Valid")
    }
  }
}
