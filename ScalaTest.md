# ソフトウェアテスト

## What's this?

- ソフトウェアテスト:
    - ソフトウェアが**意図されたように動作**し**意図されないことは全て実行されない**ように設計されていることを検証すること、あるいはそのように設計された一連のプロセス
    -  【目標地点】
        - テストで欠陥が発見される
        - 規定した試験項目にすべて合格する
        - 規定した品質目標に到達する
- デバッグ:
    - ソフトウェアテストで見つかったプログラム中の欠陥を修正する作業

### ソフトウェアテストの7原則
- **原則1: テストは「欠陥がある」ことしか示せない**
    ```
    テストをおこなうことで、故障が起きれば、そのソフトウェアに欠陥があることは分かる
    また、その原因を究明すれば、欠陥を取り除くこともできる

    しかし、そもそもテストをしても故障が起きなかった場合があり得る
    もしかしたら、本当にそのソフトウェアには、欠陥がなかったのかもしれないが、そのテストではたまたま故障が起きなかっただけかもしれない
    あるいは、テストケースに漏れがあって、たまたま故障が起きる値でテストがされなかっただけかもしれない

    このように、テストでは「故障が起きた = 欠陥がある」という証明はできても、「故障が起きない = 欠陥がない」は証明することができない
    ```
- **原則2: 全数テストは不可能**
    - 全数テスト: ソフトウェアに入力する可能性のある、すべてのパターンをテストすること
    ```
    入力条件の全組み合わせをテストするのは、テストケースが膨大になりすぎる
    また、全数テストを考えると、テスト実行を実行する以前に、テストケースを洗い出すだけでも膨大な時間がかかる
    そのため、実際のテストでは、ソフトウェアの性質、目的、使われ方、考えられるリスクなどにより、重点的にテストをおこなう場所を絞ったり、優先順位をつけたりしてテストをおこなうことになる
    ```
- **原則3: 初期テスト**
    ```
    ソフトウェアの開発において、欠陥は作りこまないことが理想だが、人が作っている以上、完璧なソフトウェアを開発することは不可能である
    そのため、いかに早く欠陥に気付けるかが重要となる
    そこで、ソフトウェア開発の早い段階から「初期テスト」を行う必要がある
    ```
- **原則4: 欠陥の偏在**
    ```
    テストは、過去の欠陥分析や、直前のテスト結果などを参考に、欠陥位置を予測してテストの焦点を絞るのが良いとされる
    それは、不具合があった場合に、それがソフトウェア全体に均等に存在することは少なく、むしろ特定のモジュールに集中していることが多いからである
    一説には、ソフトウェアで発見される欠陥の8割は、ソフトウェア全体の２割に集中しているともいわれている
    ```
- **原則5: 殺虫剤のパラドックス**
    ```
    害虫駆除にずっと同じ殺虫剤を使っていると、そのうち虫が耐性をもつようになり、殺虫剤がだんだん効かなくなる
    ソフトウェアテストでも、同じテストを何度も繰り返していると、そのテストでは新しい欠陥が見つからなくなる
    そのため、ソフトウェアテストでは、新しいテストケース、テストデータでテストを実施する必要がある
    ```
- **原則6: テストは条件次第**
    ```
    すべてのモジュールで使える共通のテストは存在しえない
    ソフトウェアが使用される状況や、目的に合わせてテストの内容や方法を変更する必要がある
    ```
- **原則7: 「バグゼロ」の落とし穴**
    ```
    ソフトウェアテストで見つけた欠陥を全て修正したからといって、良い製品とは限らない
    欠陥を修正したことによる影響範囲や、新たな欠陥がないか確認しないと、できていたことができなくなったり、欠陥を修正したことで使いづらくなったりしている可能性もある
    テストに終わりはないと肝に命じるべし
    ```

***

## テストの分類

以下、代表的な分類

### 実践テスト駆動開発での定義
- **ユニットテスト**
    - オブジェクトは正しく振る舞っているか、またオブジェクトが扱いやすいかどうかをテストする
- **インテグレーションテスト**
    - 変更できないコードに対して、書いたコードが機能するかテストする
- **受け入れテスト**
    - システム全体が機能するかテストする

### JSTQB（ソフトウェアテスト標準用語集1での定義）
- **コンポーネントテスト**
    - ユニットテストとも呼ぶ
    - 個々のソフトウェアコンポーネントのテストを行う
    - 独立してテストできるソフトウェアの最小単位をコンポーネントと呼ぶ
- **統合テスト**
    - 統合したコンポーネントやシステムのインタフェースや相互作用の欠陥を摘出するためのテスト
- **システムテスト**
    - 統合されたシステムが、特定の要件を満たすことを実証するためのテストのプロセス
- **受け入れテスト**
    - システムがユーザのニーズ、要件、ビジネスプロセスを満足するかをチェックするためのテスト
    - このテストによって、システムが受け入れ基準を満たしているか判定したり、ユーザや顧客がシステムを受け入れるかどうかを判定できる

***

## ユニットテスト

ここでは、ユニットテストを**小さな単位で自動実行できるテスト**と定義して、ユニットテストにフォーカスする

ユニットテストはプログラムの設計にも密接にかかわってくるためである

ユニットテストを行う理由は、以下の通り大きく3つあげられる

1. 実装の前に満たすべき仕様をユニットテストとして定義し、実装を行うことで要件漏れのない機能を実装することができる
    - テストコードをプロダクトコードよりも先に書くことをテストファーストと呼ぶ
    - 失敗するテストを書きながら実装を進めていく手法のことをテスト駆動開発（TDD: Test Driven Development）という
2. ユニットテストによって満たすべき仕様がテストされた状態ならば、安心してリファクタリングすることができる
    - リファクタリング: ソフトウェアの仕様を変えること無く、プログラムの構造を扱いやすく変化させること
    - 【リファクタリングの目的】
        1. ソフトウェア設計を向上させる
        2. ソフトウェアを理解しやすくする
        3. バグを見つけやすくする
        4. 早くプログラミングできるようにする
3. 全ての機能を実装する前に、単体でテストをすることができる
    - 単体テストしやすい設計とは、各機能が独立している（疎結合である）こと
    - Unix哲学の「小さいものは美しい」「各プログラムが一つのことをうまくやるようにせよ」を意識した設計をせよ

ユニットテストを実装するにあたっては、以下の2点に気をつけておく

1. 高速に実行できるテストを実装する
    - 高速に実行できることでストレスなくユニットテストを実行できるようになる
2. 再現性のあるテストを実装する
    - 再現性を確保することでバグの原因特定を容易にする