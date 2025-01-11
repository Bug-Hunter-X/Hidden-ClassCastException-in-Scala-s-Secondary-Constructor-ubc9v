```scala
class MyClass[T](val value: T) {
  def this(defaultValue: T) = this(defaultValue) //use default values of type T
  def this() = this(null.asInstanceOf[T]) //if you really need null use this, but you should also make T nullable by using Option[T] or similar
}
//Or better yet use a default value that makes sense for T.
class MyClass2[T](val value: T) {
  def this() = this(null.asInstanceOf[T])
}
object Main extends App{
  val myInt = new MyClass[Int](10) // Works fine.
  //val myIntNull = new MyClass[Int]() // Throws ClassCastException if you dont allow nulls 
  val myIntNull = new MyClass2[Int]()//Allows null, but its not recommended.
  val myString = new MyClass[String]("hello") // Works fine.
  val myStringNull = new MyClass[String]() // Works fine because String can be null.
  val myOptionInt = new MyClass[Option[Int]](Some(10))
  val myOptionIntNull = new MyClass[Option[Int]]()
  println(myOptionInt.value)
  println(myOptionIntNull.value)
}
```