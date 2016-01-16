package simplifier

import java.lang.Integer

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

  def simplifyAssignment(x: Node, y: Node): Node = {
    (x, y) match {
      case (x, y) if x == y => NodeList(List())
      case (x, y) => Assignment(x, y)
    }
  }

  def simplifyWhileInstr(cond: Node, body: Node): Node = {
    (cond, body) match {
      case (FalseConst(), b) => NodeList(List())
      case (c, b) => WhileInstr(c, b)
    }
  }

  def simplifyNegation(x: Node): Node = {
    x match {
      case TrueConst() => FalseConst()
      case FalseConst() => TrueConst()
      case Unary("not", x) => x
      case x => Unary("not", x)
    }
  }

  def simplifyNegative(x: Node): Node = {
    x match {
      case Unary("-", x) => x
      case x => Unary("-", x)
    }
  }

  def simplifyAddition(left: Node, right: Node): Node = {
    (left, right) match {
      case (NodeList(list1), NodeList(list2)) => NodeList(list1 ::: list2)
      case (ElemList(list1), ElemList(list2)) => ElemList(list1 ::: list2)
      case (IntNum(x), y) if x == 0 => y
      case (x, IntNum(y)) if y == 0 => x
      case (IntNum(x), IntNum(y)) => IntNum(x+y)
      case (Unary("-", x), y) if x == y => IntNum(0)
      case (x, Unary("-", y)) if x == y => IntNum(0)
      case (n1, n2) => BinExpr("+", n1, n2)
    }
  }

  def simplifySubtraction(left: Node, right: Node): Node = {
    (left, right) match {
      case (x, y) if x == y => IntNum(0)
      case (n1, n2) => BinExpr("-", n1, n2)
    }
  }

  def simplifyMultiplication(left: Node, right: Node): Node = {
    (left, right) match {
      case (BinExpr("**", a1, b), BinExpr("**", a2, c)) if a1 == a2 => BinExpr("**", a1, BinExpr("+", b, c))
      case (x, IntNum(y)) if y == 1 => x
      case (IntNum(y), x) if y == 1 => x
      case (IntNum(x), IntNum(y)) => IntNum(x*y)
      case (n1, n2) => BinExpr("*", n1, n2)
    }
  }

  def simplifyDivision(left: Node, right: Node): Node = {
    (left, right) match {
      case (n1, n2) if n1 == n2 => IntNum(1) // Shall work only for n2 neq 0
      case (n1, n2) => BinExpr("*", n1, n2)
    }
  }

  def simplifyExponentiation(left: Node, right: Node): Node = {
    (left, right) match {
      case (_, IntNum(b)) if b == 0 => IntNum(1) // Shall work only for a neq 0
      case (n1, IntNum(b)) if b == 1 => n1
      case (IntNum(a), _) if a == 0 => IntNum(0) // Shall work only for b neq 0
      case (IntNum(a), IntNum(b)) => IntNum(Math.pow(a.toDouble, b.toDouble).toInt) // Weird
      case (BinExpr("**", x, a), b) => BinExpr("**", x, BinExpr("*", a, b))
      case (n1, n2) => BinExpr("**", n1, n2)
    }
  }

  def simplifyIfElseInstr(conds: List[Node], suits: List[Node]): Node = {
    if (conds.head == TrueConst())
      return suits.head
    if (conds.head == FalseConst()) {
      if (conds.size == 1) { // last condition before (possible) else suit
        if (suits.size == 2) { //else follows
          return suits(1)
        } else {
          assert(suits.size == 1) // no else
          return NodeList(List())
        }
      } else {
        return IfElseInstr(conds.tail, suits.tail)
      }
    }
    //todo revursive opt.
    return IfElseInstr(conds, suits)
  }

  def simplifyIfElseExpr(cond: Node, left: Node, right: Node): Node = {
    cond match {
      case TrueConst() => left
      case FalseConst() => right
      case _ => IfElseExpr(cond, left, right)
    }
  }

  def simplify(node: Node): Node = {
    node match {
      case NodeList(list) => simplifyNodeList(list)
      case BinExpr("+", left, right) => simplifyAddition(simplify(left), simplify(right))
      case BinExpr("-", left, right) => simplifySubtraction(simplify(left), simplify(right))
      case BinExpr("*", left, right) => simplifyMultiplication(simplify(left), simplify(right))
      case BinExpr("/", left, right) => simplifyDivision(simplify(left), simplify(right))
      case BinExpr("**", left, right) => simplifyExponentiation(simplify(left), simplify(right))
      case Unary("not", v) => simplifyNegation(simplify(v))
      case Unary("-", v) => simplifyNegative(simplify(v))
      case Assignment(x, y) => simplifyAssignment(simplify(x), simplify(y))
      case WhileInstr(cond, body) => simplifyWhileInstr(simplify(cond), simplify(body))
      case IfElseInstr(conds, suits) => simplifyIfElseInstr(conds.map(simplify), suits.map(simplify))
      case IfElseExpr(cond, left, right) => simplifyIfElseExpr(simplify(cond), simplify(left), simplify(right))
      case n => n
    }
  }

}
