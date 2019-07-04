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
