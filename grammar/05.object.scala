/* オブジェクト
  Scalaではすべての値がオブジェクトであり、全てのメソッドは何らかのオブジェクトに所属している
  そのためクラスに所属するstaticフィールドやstaticメソッドを定義することはできない
  代わりに object式によりシングルトンオブジェクトを定義し、固有メソッドやフィールドを定義することができる
  ```
  object <オブジェクト名> (extends <クラス名>)? (with <トレイト名>)* {
    (<フィールド定義> | <メソッド定義>)*
  }

  => defined object <オブジェクト名>
  ```
*/
object Calculator {
  def add(x: Int, y: Int): Int = x + y
  def sub(x: Int, y: Int): Int = x - y
  def mul(x: Int, y: Int): Int = x * y
  def div(x: Int, y: Int): Int = x / y
}

// (3 * 3) / (1 + 2)
Calculator.div(Calculator.mul(3, 3), Calculator.add(1, 2))
/* <REPL>
  defined object Calculator
  res: Int = 3
*/


/* コンパニオンオブジェクト
  クラスと同じ名前のオブジェクトは、そのクラスのprivateフィールド, メソッドにアクセス可能
  ※ 以下のサンプルをREPLで実行する場合は、`:paste`コマンドで貼り付けて実行しないとREPLがコンパニオン関係を認識できない
*/
// Humanクラスのnameフィールドをprivateとする
// => 外部からnameにはアクセス不可
class Human(private val name: String)

object Human {
  // HumanオブジェクトからHumanクラスのnameにはアクセス可能
  def hello(human: Human): Unit = println("I'm " + human.name)
}

Human.hello(new Human("Mery"))
/* <REPL :paste>
  I'm Mery
  defined class Human
  defined object Human
*/
