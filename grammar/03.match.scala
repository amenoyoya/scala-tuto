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


/* 中置パターン
  ```
  <リストの最初の要素> :: <リストの次の要素> :: ...
  ```
*/
val lst = List("A", "B", "C")
// 以下のパターンマッチングを中置パターンで書くことが可能
lst match {
  case List("A", b, c) => {
    println("b = " + b)
    println("c = " + c)
  }
  case _ => println("nothing")
}

// 上記を中置パターンで書くと以下のようになる
lst match {
  case "A" :: b :: c :: _ => {
    println("b = " + b)
    println("c = " + c)
  }
  case _ => println("nothing")
}
/*
  中置パターンでは、'::'の後ろの要素はリストの残り全てを示すため、リストの末尾を無視するためには、パターンの最後に'_'を挿入する必要がある
  なお、上記の例で ("A" :: b :: c) というパターン式を書くと
  ```
  b = B
  c = List(C)  // 期待した出力は c = C
  ```
  という出力になってしまう
*/


/* 型になるパターンマッチング
  対象が特定の型に所属しているかマッチングすることも可能
  ```
  <変数名> : <型>
  ```
*/
val obj: AnyRef = "hoge"

obj match {
  case v: java.lang.Integer => println("obj is Integer")
  case v: java.lang.String => println("obj is String")
}
/* <REPL>
  obj: AnyRef = hoge
  obj is String
*/


/* <practice>
  - 使用関数:
    - new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList
      - ランダムな5個の文字（Char型）のリストを返す
  - 出力:
    - 以下の条件を満たすランダムなアルファベット5文字を100回出力
      - 条件: 最後の文字と最後の文字が同じ
      - ただし: 生成されたリストの一部だけ利用することを許可する
        - 例) List(a, b, c, d, e) を List(a, b, c, d, a) とすることを許可する
*/
// 100回繰り返す
for (i <- 1 to 100) {
  // ランダムな5個のアルファベットから成るリストに対してパターンマッチング
  // => パターンマッチングの評価結果が lst に代入される
  val lst = new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList match {
    // 5個の要素から成るリストにマッチング
    // => 最初の要素で最後の要素を置換したリストを返す
    case List(a, b, c, d, _) => List(a, b, c, d, a)
  }
  println(lst)
}
