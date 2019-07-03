# Scala｜入門

## What's this?

[Ruby->Go->Scalaという習得順序がエンジニアの爆速の成長に最適である理由](https://qiita.com/poly_soft/items/1feaa1ec5ecab08dc6db)に触発されてScalaに入門することにした、その備忘録

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
- Editor:
    - VSCode: `1.35.1`

---

### Javaのインストール
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

---

### Scalaインストール
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
    ```
- 無事インストールされたら、通常権限でPowerShellかコマンドプロンプトを起動
    ```bash
    # ScalaをREPL（Read Eval Print Loop）モードで起動
    > sbt console

    ## => projectディレクトリがないと言われるが続行する
    ## ? 「c」と打ってエンター

     : (略)
    [info] Starting scala interpreter...
    Welcome to Scala 2.12.7 (OpenJDK 64-Bit Server VM, Java 12.0.1).
    Type in expressions for evaluation. Or try :help.

    # 無事起動したら終了
    scala> :quit
    ```
