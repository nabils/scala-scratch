package org.shuhaiber

class Rational(n: Int, d:Int) {
	require(d != 0)

	private val divisor = gcd(n.abs, d.abs)

	val numerator: Int = n / this.divisor
	val denominator: Int = d / this.divisor

	def this(n: Int) = this(n, 1)

	override def toString = numerator + "/" + denominator

	override def equals(that: Any) : Boolean = {
		that.isInstanceOf[Rational] && (this.hashCode() == that.asInstanceOf[Rational].hashCode())
	}

	override def hashCode = numerator.hashCode ^ denominator.hashCode

	private def gcd(a: Int, b: Int): Int =
		if (b == 0) a else gcd(b, a % b)

	def +(that: Rational): Rational = {
		val first = new Rational(this.numerator * that.denominator, this.denominator * that.denominator)
		val second = new Rational(that.numerator * this.denominator, that.denominator * this.denominator)

		new Rational(first.numerator + second.numerator, first.denominator)
	}

	def +(i: Int): Rational =
		new Rational(this.numerator + i * this.denominator, this.denominator)

	def <(that: Rational): Boolean = {
		this.numerator * that.denominator < that.denominator * this.denominator
	}

	def max(that: Rational) = 
		if (this < that) that else this
}