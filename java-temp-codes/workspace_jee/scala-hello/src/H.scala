import scala.io.StdIn
import scala.reflect.io.File
import scala.io.Source

object HelloWorld {
  
  def sayHello(name: String): Unit = {
    println("你好" + name + "，欢迎来到Scala世界！")
  }
  
  def main(args: Array[String]): Unit = {
    print("请您输入你的名字：")
    var line = StdIn.readLine()
    sayHello(line)
    var fpath = "D:\\workspace_jee\\scala-hello\\src\\H.scala"
    Source.fromFile(fpath).foreach{
      print
    }
    // we can also use : ...foreach(print). it works well.
  }
}