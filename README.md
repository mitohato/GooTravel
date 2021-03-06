# GooTravel

## (できれば)読んで欲しいもの
[オブジェクト指向](http://pg-kura.hatenablog.com/entry/20111222/1324557014)  
[オブジェクト指向](https://eng-entrance.com/what-oop)  
[オブジェクト指向を少し知った人向け](https://qiita.com/tutinoco/items/6952b01e5fc38914ec4e)  
[このREADME](https://github.com/mitohato/GooTravel/blob/master/README.md)  
[Kotlinの文法(written by mito)](https://github.com/mitohato/kotlin-form-zero/)  
[Kotlin文法](https://qiita.com/k5n/items/cc0377b75d8537ef8a85)  
[Android概要(ちょっと難しめ？)](https://developer.android.com/guide?hl=ja)  
[プルリク1](https://qiita.com/ikuwow/items/fb52a54c086398eb5b92)  
[プルリク2](https://qiita.com/tom-ock/items/32a102ef38f037d61493)  
↑に読む順番は(基本)ありません  

## 環境
Android Studio 3.4.2  
Kotlin 1.3.41  
minSdkVersion 22  
Javaでも可(参考文献の数とか諸々考えるとこっちも良き)  

## コーディング規約
基本的に以下のリンクのコーディング規約に従う  
https://dogwood008.github.io/kotlin-web-site-ja/docs/reference/coding-conventions.html  
ここのコーディング規約はKotlinで書いていますが、Javaの場合も同じようにお願いします(valなどはないですが)  


変数名やメソッド名、クラス名などの命名はキャメルケースで書く  
変数名とメソッド名は最初小文字  
変数名は基本、名詞など  
メソッド名は動詞・目的語など  
クラス名は最初大文字  
例  
```kotlin
class HogeClass
fun doSomething()
var value
```

変数は基本的にvalを使う(変数は不変数にしましょう)  
non-null型を使いましょう  
lateinitやnullable変数は状況に合わせて  

関数などの括弧(波括弧{})は、その行に書く  
ifなども同等  
else ifはやelseはその前のifの閉じ括弧の行に空白一つ開けて書く  
1行ifなどは基本的に使用しない  
例  
```kotlin
fun do() {
}

if (a == 1) {
} else if (a == 2) {
} else {
}

for (i in 0..2) {
}
```

for文は積極的には使わず、forEachなどでしましょう  
objectはバグを生みやすくなってしまうのであまり使わずにいきましょう  

メソッドに複数の引数がある場合は  
```kotlin
fun hoge(
    a: Int,
    b: String
)

hoge(
    10,
    "hoge"
)

fun foo(c: Int)
```
のようにすること  
こうすることによって引数の数や型がぱっと見でわかりやすい  
一つの場合はそのまま  

#### サンプル
https://github.com/mitohato/shugakuryokon/  
https://github.com/mitohato/justodo  
https://github.com/mitohato/MovieRecord  

## Lint
かけるなら書く

## 設計方針
MVVM(予定)  
[Wikipedia](https://ja.wikipedia.org/wiki/Model_View_ViewModel)  
[参考1](http://blog.pionet.co.jp/experience/archives/2143)  
[参考2](https://blog.excite.co.jp/exdev/28799157/)  
[参考3](https://qiita.com/s_emoto/items/08e46b18f72c3b303b12)  

// サンプル貼る  
https://github.com/mitohato/MVVM-Sample  

## DataBinding
[参考1](https://qiita.com/Omoti/items/a83910a990e64f4dbdf1)  
[参考2](https://qiita.com/1coin178/items/9b91ca721faff192e272)  

## ライブラリ等
- Groupie
- Google Play Services
- AndroidX
- DataBinding
- Koin
- Navigation
- ViewModel
- Hyperion-Android
- Apache Commons CSV
- Room

## GitHub運営方針
Git Flowをベースにしたものを仕様  
基本、ブランチは以下の種類がありそれを利用する  
- master
- develop
- feature/hoge

### master
完成系やある程度機能ができた時にマージされる  
教授や他に見せれるバージョンのアプリがいつでも使えるようにしておく  

### develop
開発中のアプリが置かれる  
ある機能が完成した時などにマージされる  
見せられるかもしれないけどバグを含んでいるかもしれない時  

### feature/hoge
ある機能を作成中のアプリが置かれる  
基本的に、このブランチをdevelopから生やして開発を進めていく  
`git checkout -b feature/hogeなどのブランチ名`←Developブランチやmaster以外の別ブランチに居る状態で行う  
hogeの部分は今開発中の機能名が来る(feature/searchなど)  
一番最初のcommitはこのブランチでは何をするかがメッセージとして書かれた空コミット(下のコマンドそのままでできます)   
`git commit --allow-empty -m "メッセージ(searchなど)"`  
2019/8/22 追記  
feature/は正直なくてもどっちでも良いです  
ただ、ある作業ブランチからブランチを生やしてやりたいときは、{今いるブランチ名}/{作業したい内容のブランチ名}にしてくれると、どの機能で何に必要なブランチというのがわかるので、して欲しいです  
例え  
navigate/location(Navigate機能の位置情報に関することをするブランチ)  

### Pull Request(PR,プルリク)
feature/hogeブランチを作成して空コミットを作成した段階でpush、プルリクの作成をする(ただしDraft状態)  
作業を終えたらDraft状態を外してレビュー可能状態にする、レビュワーはmito+誰かをつける  
mitoのプルリクも誰か見てください〜(互いの勉強になるので)  
LGTM(Look Good To Me)を貰ったらGitHub上でマージする  
LGTMをもらった前でも後でもレビュワーになっていない人でも気になったところはお互いに勉強の機会になるのでなんでも聞くこと！

## チームとして
わからないこと・気になったことは聞く！  
リアクションすること！  
他の人のコードを見たり意見を言ったりするときは批判的になるのではなく、ちゃんと相手に敬意をもって提案・質問をする！  
体調管理に気をつけること！  
授業に出ること！  
落単しないこと！  
