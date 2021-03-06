package problem17

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 */
object Problem17 extends App {
  def toText(n: Int): String = n match {
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
    case 4 => "four"
    case 5 => "five"
    case 6 => "six"
    case 7 => "seven"
    case 8 => "eight"
    case 9 => "nine"
    case 10 => "ten"
    case 11 => "eleven"
    case 12 => "twelve"
    case 13 => "thirteen"
    case 14 => "fourteen"
    case 15 => "fifteen"
    case 16 => "sixteen"
    case 17 => "seventeen"
    case 18 => "eighteen"
    case 19 => "nineteen"
    case 20 => "twenty"

    case 30 => "thirty"
    case 40 => "forty"
    case 50 => "fifty"
    case 60 => "sixty"
    case 70 => "seventy"
    case 80 => "eighty"
    case 90 => "ninety"

    case 1000 => "onethousand"

    case x if (100 <= x && x < 1000) => {
      val rest = x % 100
      val restText = if (rest != 0) " and " + toText(rest) else ""
      toText(x / 100) + " hundred" + restText
    }

    case x if (10 <= x && x < 100) => {
      val rest = x % 10
      val restText = if (rest != 0) " " + toText(rest) else ""
      toText(x - (x % 10)) + restText
    }
  }

  def lengthOfSpelled(n: Int): Int =
    toText(n).toCharArray.filter { c: Char => (c >= 'a' && c <= 'z') }.length

  def calc(n: Int) =
    (1 to n).map { x: Int => lengthOfSpelled(x) }.sum

  println(calc(1000))
}
