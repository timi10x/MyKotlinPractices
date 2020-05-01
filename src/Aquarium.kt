data class Fish(var name: String)

fun main(){
    fishExamples()
    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    print(numbers.divisibleBy {
        it.rem(3)
    })
}


fun fishExamples() {
    val fish = Fish("splashy")

    myWith(fish.name){
        capitalize()
    }
}

fun myWith(name:String, block: String.() -> Unit){
    name.block()
}

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}
