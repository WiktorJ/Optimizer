package simplifier

import AST._

// to implement
// avoid one huge match of cases
// take into account non-greedy strategies to resolve cases with power laws
object Simplifier {

  def simplifyNodeList(list: List[Node]): Node = {
    list match {
      case List(x) => simplify(x)
      case x => NodeList(x)
    }
  }

  def simplifyAddition(left: Node, right: Node): Node = {
    (left, right) match {
      case (NodeList(list1), NodeList(list2)) => NodeList(list1 ::: list2)
      case (n1, n2) => BinExpr("+", n1, n2)
    }
  }

  def simplifyMultiplication(left: Node, right: Node): Node = {
    (left, right) match {
      case (BinExpr("**", a1, b), BinExpr("**", a2, c)) if a1 == a2 => BinExpr("**", a1, BinExpr("+", b, c))
      case (n1, n2) => BinExpr("*", n1, n2)
    }
  }

  def simplifyExponentiation(left: Node, right: Node): Node = {
    (left, right) match {
      case (IntNum(a), IntNum(b)) => IntNum(Math.pow(a toDouble, b toDouble) toInt) // Weird
      case (n1, n2) => BinExpr("**", n1, n2)
    }
  }

  def simplify(node: Node): Node = {
    node match {
      case NodeList(list) => simplifyNodeList(list)
      case BinExpr("+", left, right) => simplifyAddition(simplify(left), simplify(right))
      case BinExpr("*", left, right) => simplifyMultiplication(simplify(left), simplify(right))
      case BinExpr("**", left, right) => simplifyExponentiation(simplify(left), simplify(right))
      case n => n
    }
  }

}
