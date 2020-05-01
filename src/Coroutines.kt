
fun main(){
    //foo()

}

fun foo() {
    run loop@{
        listOf(1,2,3,4,5).forEach{
            if(it==5)return@loop
            println(it)
        }
    }
    print("done with nested loop")
}
fun String.isKotlin() = this == "Kotlin"


