# Scalaの基本

## REPLの起動・終了

```bash
# REPL起動
$ sbt console

# => projectディレクトリがないディレクトリで実行すると「projectディレクトリがない」という旨の警告が出る
# => 「c」（continue）と打って継続する

# REPL終了
> :quit
```

***

## General

### 標準出力
```bash
# 文字列出力
## 文字列は "..."
## '...' は使えない
> println("Hello, World!")
Hello, World!

# 数値の出力
> println(3.14)
3.14

> println(0xff)
255

# UTF-8エンコーディング文字列の出力
> println("\u3042")
あ

> println("\u3042" == "あ")
true
```

---

### 演算と型
```bash
# 整数(Int)の計算
> 1 + 2
res1: Int = 3

> 10 / 3
res2: Int 3

> 10 % 3
res3: Int = 1

# 浮動小数点の計算
> 10.0 - 8.2
res4: Double = 1.8000000000000007

> 2.2 * 2
res5: Double = 4.4

# 型キャスト
## 値.asInstanceOf[型]
> (4.5).asInstanceOf[Int]
res6: 4
```

---

### 変数
- 変数の種類
    - **var**:
        - 型推論あり（値が代入された時点で型を決定する）
        - 再代入可能
        - 一度型推論された後は別の型の値を代入することは出来ない
            ```bash
            > var x = 3 * 3
            x: Int = 9

            > x = 10
            x: Int = 10

            > x = "3 * 3"
            <console>:8: error: type mismatch;
            found   : String("3 * 3")
            required: Int
            ```
    - **val**:
        - 型推論あり（値が代入された時点で型を決定する）
        - 再代入不可（定数）
            ```bash
            > val x = 3 * 3
            x: Int = 9

            > x = 10
            <console>:12: error: reassignment to val
            ```
- 変数の宣言
    ```bash
    # 型推論させる場合
    (val | var) <変数名> = <式>

    # 型を明示的に指定する場合
    (val | var) <変数名> : <型名> = <式>
    ```

***

## Practice

- ¥3,950,000を年利率2.3％の単利で8か月間借り入れた場合の利息はいくらか（円未満切り捨て）
    ```bash
    # 利率の計算式を 定数ans に代入
    > val ans = 3950000 * 0.023 * 8 / 12
    ans: Double = 60566.666666666664

    # Int型にキャスト
    scala> ans.asInstanceOf[Int]
    res1: Int = 60566

    ## => ￥60,566
    ```
-  定価¥1,980,000の商品を値引きして販売したところ、原価1.6％にあたる¥26,400の損失となった。割引額は定価の何パーセントであったか
    ```bash
    # 原価
    > val cost: Int = (26400 * 100 / 1.6).asInstanceOf[Int]
    cost: Int = 1650000

    # 売値
    > val sell: Int = cost - 26400
    sell: Int = 1623600

    # 割引額
    > val discount: Int = 1980000 - sell
    discount: Int = 356400

    # 割引額が定価の何％か
    > val ans: Int = val ans = discount.asInstanceOf[Double] / 1980000 * 100
    ans: Double = 18.0

    ## => 18％
    ```

***

## Scalaプログラムのコンパイル・実行

### Scalaプログラムの作成
ここでは`sandbox`ディレクトリにコードを作成することにする

なお、Scalaのインデント幅はスペース2つ分が推奨値である

参考: [Scalaスタイルガイド](http://yanana.github.io/scala-style/)

- **sandbox/HelloWorld.scala**
    ```scala
    /*
      "Hello, World!"を出力するプログラム
    */
    object HelloWorld {
      def main(args: Array[String]): Unit = {
        println("Hello, World!");
      }
    }
    ```

---

### ビルド設定ファイルの作成
コンパイルオプション等を記述する

- **sandobox/build.sbt**
    ```scala
    /*
      Scalaのバージョンを指定
      バージョンは `sbt console` で REPLを起動した時に表示される
    */
    scalaVersion := "2.12.7"
    
    /*
      コンパイルオプションを追加
      - deprecation: 今後廃止予定のAPIを使用する
      - feature: 明示的に仕様を宣言する必要のある機能を使用する
      - unchecked: パターンマッチが有効に機能しない場合に指定
      - Xlint: 推奨する書き方などの情報を出力
    */
    scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")
    ```

---

### コンパイル＆実行
- `sandbox`ディレクトリに入り`sbt`を起動する
    ```bash
    $ cd sandbox
    $ sbt
    ```
- sbtプロンプト上でコマンドが打てるようになるため、HelloWorldプログラムを実行するために`run`コマンドを実行
    ```bash
    # コンパイル・実行
    ## runコマンドは、mainメソッドを持つオブジェクトを探して実行する
    > run

    ## => コンパイルが実行される
    ## ～略～
    [info] Done packaging.
    [info] Running HelloWorld
    Hello, World!
    
    # sbtプロンプト終了
    > exit
    ```

***

## REPLからScalaプログラム呼び出し

sbt管理下のScalaプログラムはREPLから呼び出すことが可能

- **sandbox/User.scala**
    ```scala
    /*
      名前と年齢を持つ Userクラス定義
    */
    class User(val name: String, val age: Int)    

    /*
      Userの名前と年齢を出力する printメソッドを持つ Userオブジェクト定義
    */
    object User {
      def print(user: User) = println(user.name + ": " + user.age + "歳")
    }
    ```
- ディレクトリ構成
    ```conf
    sandbox/
     |- project/
     |- target/
     |- build.sbt        # ビルド設定
     |- HelloWorld.scala # "Hello, World!"出力プログラム
     `- User.scala       # Userクラス・オブジェクト定義
    ```
- REPLを起動し、Userを使ってみる
    ```bash
    # sandboxディレクトリでREPL起動
    $ cd sandbox
    $ sbt console

    # new User: name => "yoya", age => 31
    > val user = new User("yoya", 31)
    user: User = User@4c6fdb55

    # call User.print
    > User.print(user)
    yoya: 31歳

    # REPL終了
    > :quit
    ```
