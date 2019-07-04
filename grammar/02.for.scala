/* for式
  基本的な使い方: <ジェネレータ>で表現されるループ範囲で<本体式>の評価を繰り返す
  ```
  for '(' (<ジェネレータ>;)+ ')' <本体式>
  # <ジェネレータ> = <変数> '<-' <コレクション式>
  => ()
  ```
*/
/* to, until式
  to式:    <始値> から <終値> までの範囲を構築する
  until式: <始値> から <終値>-1 までの範囲を構築する
  ```
  <始値> ('to'|'until') <終値>
  => to: scala.collection.immutable.Range.Inclusive = Range <始値> to <終値>
  => until: scala.collection.immutable.Range = Range <始値> until <終値>
  ```
*/
/* <example>
  以下の範囲で変数 x, y の値を出力する
  - x: 1 to 3
  - y: 1 until 3
*/
for (x <- 1 to 3; y <- 1 until 3) {
  println("x = " + x + " y = " + y)
}
/* <REPL>
  x = 1 y = 1
  x = 1 y = 2
  x = 2 y = 1
  x = 2 y = 2
  x = 3 y = 1
  x = 3 y = 2
*/


/* <example>
  以下の条件・範囲で変数 x, y の値を出力する
  - x: 1 to 3
  - y: 1 until 3
  - 条件: x と y の値が異なる場合
*/
for (x <- 1 to 3; y <- 1 until 3 if x != y) {
  println("x = " + x + " y = " + y)
}
/* <REPL>
  x = 1 y = 2
  x = 2 y = 1
  x = 3 y = 1
  x = 3 y = 2
*/


/* List関数
  引数に指定した複数の値をまとめたListコレクションを返す
  ```
  List '(' (<引数1>, <引数2>, ...) ')'
  => List[<型名>] = List(<引数1>, <引数2>, ...)
  ```
*/
for (e <- List("apple", "banana", "chocolate")) println(e)
/* <REPL>
  apple
  banana
  chocolate
*/


/*  for-yield式
  for式でたどった要素を加工して新しいコレクションを作って返す
  ```
  for '(' <変数> '<-' <コレクション> ')' yield <コレクション加工式>
  => scala.collection: <加工済みのコレクション>
  ```
*/