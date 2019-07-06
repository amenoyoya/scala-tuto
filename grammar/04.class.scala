/* クラス定義
  'abstract' を付けると抽象クラスになる: 実体クラスとして継承されない限りオブジェクトを作成できない
  ```
  (abstract)? class <クラス名> '(' (<引数名1> : <引数型1>, <引数名2> : <引数型2>, ... )? ')' {
    (<フィールド定義> | <メソッド定義>)*
  }

  => defined class <クラス名>
  ```
*/
/* フィールド定義
  <フィールド修飾子>は、明示的に ('private' | 'protected') を指定しない限り publicになる
  <フィールド修飾子>:
    - private: そのクラス内からのみ使用可能
      - private[this]: 同じオブジェクトからのみアクセス可能
      - private[<パッケージ名>]: 同一パッケージからのみアクセス可能
    - protected: そのクラスの派生クラスからのみ使用可能
      - protected[<パッケージ名>]: 同一パッケージからのみアクセス可能
  ```
  (<フィールド修飾子>)? (val | var) <フィールド名> : <フィールド型> = <初期式>
  ```
*/
class Point(_x: Int, _y: Int) {
  val x = _x
  val y = _y
}

val point = new Point(10, 20)
/* <REPL>
  defined class Point
  point: Point = Point@e4ff2e9
*/


/*
  上記のPointクラスのように、コンストラクタ引数とフィールドが同一の場合は以下のように省略して書ける
*/
class Point(val x: Int, val y: Int)
/* <REPL>
  defined class Point
*/


/* メソッド定義
  メソッドは、<メソッド修飾子>に ('private' | 'protected') を付けない限り public となる
  <メソッド修飾子>:
    - private: そのクラス内からのみ使用可能
      - private[this]: 同じオブジェクトからのみアクセス可能
      - private[<パッケージ名>]: 同一パッケージからのみアクセス可能
    - protected: そのクラスの派生クラスからのみ使用可能
      - protected[<パッケージ名>]: 同一パッケージからのみアクセス可能
    - override: メソッドを上書きすることができる
  ```
  (<メソッド修飾子>)? def <メソッド名> '('
    (<引数名> : <引数型> (, <引数名> : <引数型>)*)?
  ')' : <戻り値型> = <本体式>
  ```
*/
class Point(val x: Int, val y: Int) {
  // Point同士を＋するメソッド
  def +(p: Point): Point = new Point(x + p.x, y + p.y)

  // toStringメソッドを上書きし、"(x, y)" を出力するように変更
  override def toString(): String = "(" + x + ", " + y + ")"
}

val p1 = new Point(1, 2)
val p2 = new Point(3, 4)
val p3 = p1 + p2
/* <REPL>
  defined class Point
  p1: Point = (1, 2) // toStringメソッドにより←のように出力される
  p2: Point = (3, 4)
  p3: Point = (4, 6)
*/


/* 複数の引数リストを持つメソッド定義
  method(x, y) という形式ではなく method(x)(y) という形式で呼び出せるメソッドを定義できる
  複数の引数リストを持つメソッドは、最初の引数だけを適用して新しい関数を作る（部分適用）ことも可能
  ```
  (<メソッド修飾子>)? def <メソッド名> '('
    (<引数名> : 引数型 (, 引数名 : <引数型>)*)?
  ')' ( '('
    (<引数名> : 引数型 (, 引数名 : <引数型>)*)?
  ')' )* : <戻り値型> = <本体式>
  ```
*/
class Adder {
  def add(x: Int)(y: Int): Int = x + y
}

val adder = new Adder()

// 2 + 3
adder.add(2)(3)

// 指定の値に100を加算する add100 関数作成（Adder.add 部分適用）
val add100 = adder.add(100)(_)

// 100 + 23
add100(23)

/* <REPL>
  defined class Adder
  adder: Adder = Adder@f0557c1
  res0: Int = 5
  add100: Int => Int = $$Lambda$4046/0x00000008023b7040@1620be8c
  res1: Int = 123
*/


/* 継承
  <スーパークラス>の実装をサブクラスで使える
  Javaと同様、複数のスーパークラスから継承することはできない
  複数の実装から機能を継承したい場合は <トレイト> を使う
  ```
  class <クラス名> <クラス引数> (extends <スーパークラス>)? (with <トレイト名>)* {
    (<フィールド定義> | <メソッド定義>)*
  }
  ```
*/
// Human抽象クラス
abstract class Human(val name: String, val gender: Int) {
  // genderの値から性別を取得するメソッド
  protected def getGender(): String = {
    this.gender match {
      case 0 => "Female"
      case 1 => "Male"
      case _ => "UnknownGender"
    }
  }
  // 名前と性別を出力するメソッド
  def print(): Unit = println(this.name + ": " + this.getGender())
}

// Humanを継承してMaleクラス実装
// - name: "<firstName>, <lastName>"
// - gender: 1 (Male)
class Male(val firstName: String, val lastName: String) extends Human(firstName + ", " + lastName, 1) {
  // printメソッドを上書き
  override def print(): Unit = {
    println("Hello!")
    // 親クラスのメソッドは super.method() で呼び出せる
    super.print()
  }
}

new Male("John", "Smith").print()
/* <REPL>
  defined class Human
  defined class Male
  
  Hello!
  John, Smith: Male
*/
