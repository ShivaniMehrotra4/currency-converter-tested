package com.knoldus

import org.scalatest._

class CurrencyConversionTestSpec extends FlatSpec with BeforeAndAfterAll{
  var currencyObject: CurrencyConversionTest = new CurrencyConversionTest
  override def beforeAll(): Unit = {
    currencyObject = new CurrencyConversionTest()
  }
  override def afterAll(): Unit = {
    if (currencyObject != null) {
      currencyObject = null
    }
  }
  "convert method" should "convert currencies " in {
    val actualResult = currencyObject.convert("USD","PAK RUPEE",1.0)
    val expectedResult = 5.916666666666667
    assert(expectedResult==actualResult)
  }
  "convert method" should "throw exception upon negative values" in {
    try{
      currencyObject.convert("USD","PAK RUPEE",-1.0)
    }
    catch
    {
      case ex : Exception => assert(ex.getMessage == "Negative values not allowed")
    }
  }
  "convert method" should "throw exception upon invalid currency values" in {
    try{
      currencyObject.convert("aaa","PAK RUPEE",9.0)
    }
    catch
      {
        case ex : Exception => assert(ex.getMessage == "Currency Not Valid")
      }
  }

}
