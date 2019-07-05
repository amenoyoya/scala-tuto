/* match式
  <対象式>を<パターン>でマッチングして処理を分岐する
  <ガード式>がある場合は <パターン> AND (<ガード式> == true) にマッチングする
  マッチングした<式>の評価結果が返る
  ```
  <対象式> match {
    (
      case <パターン> (if <ガード式>)? '=>' (<式> (;|<改行>))*
    )+
  }
  => マッチした<パターン>の<式>の評価結果
     式を省略した場合: Any = () が返る
  ```
*/
val human ="John"

human match {
  case "Taro" => "Male"
  case "John" => "Male"
  case "Daisy" => "Female"
}
/* <REPL>
  human: String = John
  res: String = Male
*/


/* match式のパターン
  - '_':
    - ワイルドカードパターン
    - 全てのパターンにマッチ
  - <パターン1> '|' <パターン2>:
    - パターン1 OR パターン2 にマッチ
*/
val x = 3

x match {
  case 1 | 2 => "one or two"
  case v if 2 < v && v < 4 => "three"
  case _ => "others"
}
/* <REPL>
  x: Int = 3
  res: String = three
*/


/* パターンマッチによる値の取り出し
  match-case式はコレクションの要素の一部にマッチさせることが可能
*/
val lst = List("A", "B", "C")

lst match {
  // 先頭が"A"で3つの要素を持つコレクションにマッチング
  case List("A", b, c) => {
    println("b = " + b)
    println("c = " + c)
  }
  case _ => println("nothing")
}
/* <REPL>
  lst: List[String] = List("A", "B", "C")
  b = B
  c = C
*/


/* asパターン
  <パターン式>を<変数名>に束縛する
  ```
  <変数名> @ <パターン式>
  ```
*/
val lst = List(List("A"), List("B", "C"))

lst match {
  // 2つの要素 a, x を持つコレクションにマッチング
  // ただし a は List("A") というパターンにマッチングしている必要がある
  case List(a@List("A"), x) => {
    println(a)
    println(x)
  }
  case _ => println("nothing")
}
/* <REPL>
  lst: List[List[String]] = List(List(A), List(B, C))
  List(A)
  List(B, C)
*/

