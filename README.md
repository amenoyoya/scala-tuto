# Scala｜入門

## What's this?

[Ruby->Go->Scalaという習得順序がエンジニアの爆速の成長に最適である理由](https://qiita.com/poly_soft/items/1feaa1ec5ecab08dc6db)に触発されてScalaに入門することにした、その備忘録

入門教材として[ドワンゴの研修資料](http://dwango.github.io/scala_text/)を拝借（感謝）

### 現時点のスキルセット（2019/07/03）
- Webプログラマ歴: 3か月
- プログラミングスキル:
    - C++:
        - Win32API＋DirectXで2Dゲームを作れる程度
        - Win32APIラッパーライブラリ作成経験あり
    - Lua:
        - C++とSDLを使った2Dゲームエンジン制作経験あり
    - Python:
        - Flaskを使ったWeb API制作（Slackボット用）経験あり
        - Djangoを使ったWebサイト作成経験あり
        - Keras＋TensorflowでFXのトレード予測プログラム制作経験あり
        - 機械学習・ディープラーニングの基礎的プログラム制作可能
    - JavaScript:
        - jQuery使える
        - node.jsを使ったスクレイピングプログラム制作経験あり
        - React＋Webpackでのフロントエンド開発可能
    - PHP:
        - フレームワークを使わず簡単なブログシステムを制作可能
        - CakePHP, Laravelを一応使える程度
    - Ruby:
        - Rails＋Google Custom Search APIを使ったキーワード検索ユーティリティ作成経験あり
        - 人工無能制作経験あり

***

## Setup

### Environment
- OS:
    - Windows 10 x64
    - Ubuntu 18.04 LTS

---

### Setup on Windows

#### Javaのインストール
ScalaはJavaVM上で動作するため、まずJavaSDKをインストールする

OracleJDKはライセンスが厳しくなったらしいので、今回はオープンソースのOpenJDKを採用する（Java界隈のことは全く分からない。。。）

- 現時点で最新の12系を[OpenJDK公式サイト](http://jdk.java.net/12/)からダウンロードしてくる
- `openjdk-12.0.1_windows-x64_bin.zip`を解凍
    - 以降、`C:\App\jdk-12`に解凍したと想定
- パスを通す
    - `Win + Pause/Break` => システム > システムの詳細 > 環境変数
        - PATH: `C:\App\jdk-12.0.1\bin`を追加
- コマンドプロンプトを起動し、Javaが使えるか確認
    ```bash
    # Javaバージョン確認
    > java -version
    openjdk version "12.0.1" 2019-04-16
    OpenJDK Runtime Environment (build 12.0.1+12)
    OpenJDK 64-Bit Server VM (build 12.0.1+12, mixed mode, sharing)

    # Javaコンパイラのバージョン確認
    > javac -version
    javac 12.0.1
    ```

#### Scalaインストール
一般に、Scalaプログラムを手動でコンパイルすることは稀で、標準的なビルドツールであるsbt（Scala Buid Tool）を用いることが多い

sbtのインストールは、Windowsの場合、[chocolatey](https://chocolatey.org/)（Windows用パッケージマネージャ）を使うと楽

- 管理者権限でPowerShell起動
    ```powershell
    # chocolateyインストール
    > Set-ExecutionPolicy Bypass -Scope Process -Force; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))

    # バージョン確認
    > choco -v
    0.10.15

    # sbtインストール
    > choco install sbt
    ## => Do you want to run the script? というプロンプトに対しては「A」(All)と打ってOK
    ```
- 無事インストールされたら、`./`ディレクトリでPowerShellかコマンドプロンプトを起動
    ```bash
    # ScalaをREPL（Read Eval Print Loop）モードで起動
    > sbt console

    ## => 初回起動時は環境構築のため少し時間がかかる

     : (略)
    [info] Starting scala interpreter...
    Welcome to Scala 2.12.7 (OpenJDK 64-Bit Server VM, Java 12.0.1).
    Type in expressions for evaluation. Or try :help.

    # 無事起動したら終了
    scala> :quit
    ```
    - ※ `project`ディレクトリがないディレクトリで `sbt console` を実行しようとすると「projectディレクトリがない」という旨の警告が出る
        - => 「c」と打ってcontinueすれば、自動的に`project`ディレクトリが作成される

---

### Setup on Ubuntu 18.04 LTS
```bash
# OpenJDK 11 のインストール
$ sudo apt install openjdk-11-jdk

# Javaバージョン確認
$ java -version
openjdk version "11.0.3" 2019-04-16
OpenJDK Runtime Environment (build 11.0.3+7-Ubuntu-1ubuntu218.04.1)
OpenJDK 64-Bit Server VM (build 11.0.3+7-Ubuntu-1ubuntu218.04.1, mixed mode, sharing)

# Javaコンパイラのバージョン確認
$ javac -version
javac 11.0.3

# sbtインストール
## 公式サイトを参考に: https://www.scala-sbt.org/download.html
$ echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
$ sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
$ sudo apt update && sudo apt install sbt

# ScalaをREPL（Read Eval Print Loop）モードで起動
$ sbt console

## => 初回起動時は環境構築のため少し時間がかかる

 : (略)
[info] Starting scala interpreter...
Welcome to Scala 2.12.7 (OpenJDK 64-Bit Server VM, Java 12.0.1).
Type in expressions for evaluation. Or try :help.

# 無事起動したら終了
scala> :quit
```

***

## Scalaの基本

See [Scalaの基本.md](./Scalaの基本.md)

***

## Scalaの構文

### 構文表現のための記法
See [構文記法.md](./構文記法.md)

---

### Scalaの構文
Sample codes in [grammar](./grammar) directory
