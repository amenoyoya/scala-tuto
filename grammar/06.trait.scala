/* トレイト定義
  トレイトは、クラスからコンストラクタを抜いたようなもので、以下のような特徴を持つ
    - 複数のトレイトを1つのクラスやオブジェクトにミックスインできる
    - 直接インスタンス化できない
    - コンストラクタを定義できない
  ```
  trait <トレイト名> (extends <親トレイト名>)? (with <トレイト名>)* {
    (<フィールド定義> | <メソッド定義>)*
  }
  ```

  ※ 以下のサンプルをREPLで実行する場合は :paste モードで行う
*/
trait Job {
  protected val job: String
}

trait Human {
  protected val name: String
  protected val gender: Int
  // メソッドも定義できる
  def getGender(): String = {
    gender match {
      case 0 => "Female"
      case 1 => "Male"
      case _ => "UnknownGender"
    }
  }
}

// 仕事を持つ人間で gender=1 の WorkManクラスを定義
class WorkMan(_name: String, _job: String) extends Human with Job {
  val name = _name
  val gender = 1
  val job = _job
  def say() {
    println("I'm " + name + " (" + getGender() + ")")
    println("Job: " + job)
  }
}

new WorkMan("AmenoYoya", "Programmer").say()
/* <REPL :paste>
  I'm AmenoYoya (Male)
  Job: Programmer

  defined trait Job
  defined trait Human
  defined class Man
*/
