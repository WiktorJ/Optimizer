package simplifier

import AST._

// to implement
// avoid one huge match of cases
// take into account non-greedy strategies to resolve cases with power laws
object Simplifier {

  def simplifyNodeList(list: List[Node]): Node = {
    list match {
      case List(x) => simplify(x)
      case y::ys => val x = y::ys
        val l = x.foldLeft(List.empty[Node])((nodeList, node) => node match {
        case (a @ Assignment(x1, y1)) => val newList = nodeList.filter {
          case (Assignment(x2, y2)) if x1 == x2 => false
          case _ => true
        }
          newList.::(a)
        case n => nodeList.::(n)
      })
        if (l.size == 1) return l.head else NodeList(l.reverse)
      case x => NodeList(x)
    }
  }

  def simplifyMap(list: List[KeyDatum]): Node = {
    val uniqueKeys = list.foldLeft(Map.empty[Node, KeyDatum])((map, keyDatum) => map + (keyDatum.key -> keyDatum))
    KeyDatumList(uniqueKeys.values.toList)
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
    val oppositeComparison = Map(
      "==" -> "!=",
      "!=" -> "==",
      ">" -> "<=",
      "<" -> ">=",
      "<=" -> ">",
      ">=" -> "<")
    x match {
      case BinExpr(op, n1, n2) if oppositeComparison.get(op).isDefined => BinExpr(oppositeComparison.get(op).get, n1, n2)
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
      case (IntNum(x), IntNum(y)) => IntNum(x + y)
      case (Unary("-", x), y) if x == y => IntNum(0)
      case (x, Unary("-", y)) if x == y => IntNum(0)
      case (n1, n2) => distributiveSimplifier("+", left, right)
    }
  }

  def simplifySubtraction(left: Node, right: Node): Node = {
    (left, right) match {
      case (x, y) if x == y => IntNum(0)
      case (BinExpr(op, n1, n2), v @ Variable(x)) if List("+", "-").contains(op) => simplify(BinExpr(op, BinExpr("-", n1, v), n2)) //Well, it's enough to pass first commutativity test...
      case (n1, n2) => distributiveSimplifier("-", left, right)
    }
  }

  def distributiveSimplifier(op: String, left: Node, right: Node): Node ={

    (left, right) match {
      case (n1 @ BinExpr("*",IntNum(y), v1), n2)  =>
        val var1 = simplify(v1)
        val var2 = simplify(n2)
        if(var1 == var2) {
          return if (y != 1) simplify(BinExpr("*", IntNum(evalOp(op, y, 1)), var1)) else var1
        }
        BinExpr(op, simplify(n1), simplify(n2))
      case (l @ BinExpr("*", n1, n2), r @  BinExpr("*", n3, n4))=>
        val var1 = simplify(n1)
        val var2 = simplify(n2)
        val var3 = simplify(n3)
        val var4 = simplify(n4)

        if(var1 == var3) {
          return BinExpr("*", var1, simplify(BinExpr(op, var2, var4)))
        }
        if(var2 == var4) {
          return BinExpr("*", simplify(BinExpr(op, var1, var3)), var2)
        }
        BinExpr(op, simplify(l), simplify(r))
      case (n1, n2) => BinExpr(op, n1, n2)
    }
  }

  def evalOp(op: String, a: Integer, b:Integer): Integer = {
    op match {
      case "+" => a+b
      case "-" => a-b
      case _ => 0
    }
  }

  def simplifyMultiplication(left: Node, right: Node): Node = {
    (left, right) match {
      case (BinExpr("**", a1, b), BinExpr("**", a2, c)) if a1 == a2 => BinExpr("**", a1, BinExpr("+", b, c))
      case (x, IntNum(y)) if y == 1 => x
      case (x, IntNum(y)) if y == 0 => IntNum(0)
      case (IntNum(y), x) if y == 1 => x
      case (IntNum(y), x) if y == 0 => IntNum(0)
      case (IntNum(x), IntNum(y)) => IntNum(x * y)
      case (n1, BinExpr("/", IntNum(x), n2)) if x == 1 => BinExpr("/", n1, n2)
      case (n1, n2) => BinExpr("*", n1, n2)
    }
  }

  def simplifyDivision(left: Node, right: Node): Node = {
    (left, right) match {
      case (n1, n2) if n1 == n2 => IntNum(1) // Shall work only for n2 neq 0
      case (IntNum(y), BinExpr("/", IntNum(x), n1)) if y == 1 && x == 1 => n1
      case (n1, n2) => BinExpr("/", n1, n2)
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


  def simplifyOtherBinary(op: String, left: Node, right: Node): Node = {
    (left, right) match {
      case (n1, n2) if (n1 == n2) && List("==", ">=", "<=").contains(op) => TrueConst()
      case (n1, n2) if (n1 == n2) && List("!=", ">", "<").contains(op) => FalseConst()
      case (n1, n2) => BinExpr(op, n1, n2)
    }
  }


  def simplifyAlternative(left: Node, right: Node): Node = {
    (left, right) match {
      case (n1, n2) if n1 == n2 => n1
      case (n1, TrueConst()) => TrueConst()
      case (TrueConst(), n1) => TrueConst()
      case (FalseConst(), n1) => n1
      case (n1, FalseConst()) => n1
      case (n1, n2) => BinExpr("or", n1, n2)
    }
  }

  def simplifyConjunction(left: Node, right: Node): Node = {
    (left, right) match {
      case (n1, n2) if n1 == n2 => n1
      case (TrueConst(), n1) => n1
      case (n1, TrueConst()) => n1
      case (FalseConst(), n1) => FalseConst()
      case (n1, FalseConst()) => FalseConst()
      case (n1, n2) => BinExpr("and", n1, n2)

    }
  }


  def simplifyIfElseInstr(conds: List[Node], suits: List[Node]): Node = {
    if (conds.head == TrueConst())
      return suits.head
    if (conds.head == FalseConst()) {
      if (conds.size == 1) {
        // last condition before (possible) else suit
        if (suits.size == 2) {
          //else follows
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
      case KeyDatumList(list) => simplifyMap(list)
      case BinExpr("+", left, right) => simplifyAddition(simplify(left), simplify(right))
      case BinExpr("-", left, right) => simplifySubtraction(simplify(left), simplify(right))
      case BinExpr("*", left, right) => simplifyMultiplication(simplify(left), simplify(right))
      case BinExpr("/", left, right) => simplifyDivision(simplify(left), simplify(right))
      case BinExpr("**", left, right) => simplifyExponentiation(simplify(left), simplify(right))
      case BinExpr("or", left, right) => simplifyAlternative(simplify(left), simplify(right))
      case BinExpr("and", left, right) => simplifyConjunction(simplify(left), simplify(right))
      case BinExpr(op, left, right) => simplifyOtherBinary(op, simplify(left), simplify(right))
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
