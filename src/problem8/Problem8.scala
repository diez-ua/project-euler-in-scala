package problem8

import scala.annotation.tailrec

import utils.CharUtils.charToInt

/**
 * Find the greatest product of five consecutive digits in the 1000-digit number.

73167176531330624919225119674426574742355349194934
96983520312774506326239578318016984801869478851843
85861560789112949495459501737958331952853208805511
12540698747158523863050715693290963295227443043557
66896648950445244523161731856403098711121722383113
62229893423380308135336276614282806444486645238749
30358907296290491560440772390713810515859307960866
70172427121883998797908792274921901699720888093776
65727333001053367881220235421809751254540594752243
52584907711670556013604839586446706324415722155397
53697817977846174064955149290862569321978468622482
83972241375657056057490261407972968652414535100474
82166370484403199890008895243450658541227588666881
16427171479924442928230863465674813919123162824586
17866458359124566529476545682848912883142607690042
24219022671055626321111109370544217506941658960408
07198403850962455444362981230987879927244284909188
84580156166097919133875499200524063689912560717606
05886116467109405077541002256983155200055935729725
71636269561882670428252483600823257530420752963450
 */
object Problem8 extends App {

  // Product of "num" consecutive numbers in "arr" starting from "pos" position
  private def prod(arr: Array[Int], num: Int, pos: Int) = {
    @tailrec
    def prod0(arr: Array[Int], num: Int, pos: Int, acc: Int): Int =
      if (num == 0)
        acc
      else
        prod0(arr, num - 1, pos + 1, acc * arr(pos))

    prod0(arr, num, pos, 1)
  }


  def calc(in: String, num: Int): Int = {
    @tailrec
    def calc0(arr: Array[Int], num: Int, pos: Int, currMax: Int): Int = {
      if (num + pos >= arr.length)
        currMax
      else
        calc0(arr, num, pos + 1, Math.max(prod(arr, num, pos), currMax))
    }

    val inWithoutSpaces = in.replace("\n", "")
    val arr = inWithoutSpaces map charToInt toArray

    calc0(arr, num, 0, 0)
  }

  val in = "73167176531330624919225119674426574742355349194934\n96983520312774506326239578318016984801869478851843\n85861560789112949495459501737958331952853208805511\n12540698747158523863050715693290963295227443043557\n66896648950445244523161731856403098711121722383113\n62229893423380308135336276614282806444486645238749\n30358907296290491560440772390713810515859307960866\n70172427121883998797908792274921901699720888093776\n65727333001053367881220235421809751254540594752243\n52584907711670556013604839586446706324415722155397\n53697817977846174064955149290862569321978468622482\n83972241375657056057490261407972968652414535100474\n82166370484403199890008895243450658541227588666881\n16427171479924442928230863465674813919123162824586\n17866458359124566529476545682848912883142607690042\n24219022671055626321111109370544217506941658960408\n07198403850962455444362981230987879927244284909188\n84580156166097919133875499200524063689912560717606\n05886116467109405077541002256983155200055935729725\n71636269561882670428252483600823257530420752963450".replace("\n", "")

  println(calc(in, 5))
}
