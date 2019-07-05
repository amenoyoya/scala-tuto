/* ブロック式
  Scalaでは {} で複数の式を囲むと、それ全体が式（ブロック式）になる
  ```
  { <式1>(;|<改行>) <式2>(;|<改行>) ... }
  => <最後の式>の評価結果
  ```
*/
{
  println("A")
  println("B")
  1 + 2
}
/* <REPL>
  A
  B
  res: Int = 3
*/


/*
  Scalaにおいて、あらゆる式は値を返す
  ブロック式では、最後に評価された式の評価結果が戻り値となる
*/

/* 変数定義
  <変数名>で定義される変数に<値>を代入する
  var式, val式は変数を返す
  ```
  ('var' | 'val') <変数名> = <値>
  => <変数名>: <型名> = <値>
  ```
*/

/* if式
  <条件式>がtrueの場合に<then式>を評価
  （そうでないなら<else式>を評価）
  if式は <then式>|<else式> の評価結果を返す
  ```
  if '(' <条件式> ')' <then式> (else <else式>)?
  => <then式>|<else式> の評価結果
  ```
*/
var age = 17

if (age < 18) {
  "18歳未満"
} else {
  "18際以上"
}
/* <REPL>
age: Int = 17
res: String = 18歳未満
*/


/* <practice>
- 使用変数:
  - age: Int = 5 @年齢
  - isSchoolSatarted: Boolean = false @就学中?
- 出力:
  - 1歳から6歳までの就学以前の子どもの場合:
    - "幼児です"
  - それ以外:
    - "幼児ではありません"
- 戻り値:
  (): Unit型（何も返さない）
*/
var age: Int = 5
var isSchoolSatarted: Boolean = false

// println関数は 引数を出力し ()を返す
if (1 <= age && age <= 6 && !isSchoolSatarted) {
  println("幼児です")
} else {
  println("幼児ではありません")
}
