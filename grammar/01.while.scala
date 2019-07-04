/* while式
  <条件式>がtrueの間 <本体式>の評価を続ける
  Unit型の値 () を返す
  ```
  while '(' <条件式> ')' <本体式>

  res: ()
  ```
*/
var i = 1

while (i <= 10) {
  println("i = " + i)
  i = i + 1
}
/* <REPL>
  i: Int = 1
  i = 1
  i = 2
    :
  i = 10
*/


/* do-while式
  while式と同じだが、<条件式>の評価を<本体式>の後に行う
  ```
  do <本体式> while '(' <条件式> ')'

  res: ()
  ```
*/

/* def式
  関数（式）を定義する
  - 関数は渡された<引数>に従って、<本体式>を評価する
  - 関数の戻り値は<本体式>の評価結果となる
  def式は定義した関数を返す
  ```
  def <関数名> '(' <引数> ')' (: <戻り値の型>)? = <本体式>

  res: <関数名>: (<引数>) <戻り値の型>
  ```
*/

/* <practice>
  - 使用構文:
    - do-while式
  - 定義関数:
    - 関数名: loopFrom0To9
    - 引数: () ※Unit型（引数なし）
    - 戻り値: () ※Unit型（戻り値なし）
    - 出力: 0..9
*/
def loopFrom0To9(): Unit = {
  var i = 0
  do {
    println(i)
    i += 1
  } while (i < 10)
}

loopFrom0To9()
