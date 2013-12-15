package org.shuhaiber

import org.scalatest._

class RationalSpec extends FlatSpec with Matchers {
  "1/2" should "be output as 1/2" in {
    new Rational(1, 2).toString should be ("1/2")
  }

  it should "not allow denominator to be 0" in {
    a [IllegalArgumentException] should be thrownBy {
      new Rational(2, 0)
    }
  }

  "1/2 + 2/3" should "be 7/6" in {
    new Rational(1, 2) + new Rational(2, 3) should be (new Rational(7, 6))
  }

  "1/2 + 2" should "be 5/2" in {
    new Rational(1, 2) + 2 should be (new Rational(5, 2))
  }


  // "2 + 1/2" should "be 5/2" in {
  //   2 + new Rational(1, 2) should be (new Rational(5, 2))
  // }

  "1/2 < 2/3" should "be true" in {
    new Rational(1, 2) < new Rational(2, 3) should be (true)
  }

  "max of 1/2 and 2/3" should "2/3" in {
    new Rational(1, 2)max(new Rational(2, 3)) should be (new Rational(2, 3))
  }

  "rational of 5" should "be 5/1" in {
    new Rational(5) should be (new Rational(5, 1))
  }

  "66/42" should "be normalised to 11/7" in {
    new Rational(66, 42) should be (new Rational(11, 7))
  }
}