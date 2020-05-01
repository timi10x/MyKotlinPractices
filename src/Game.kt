
fun main(){
    val game = Game()
//    println(game.path)
//    game.north()
//    game.south()
//    game.east()
//    game.west()
//    game.end()
//    println(game.path)
    while (true){
        print("Enter a direction: n/s/e/w:")
        game.makeMove(readLine())
    }
}

class Game {
    var path: MutableList<Directions> = mutableListOf(Directions.START)

    private val north = {path.add(Directions.NORTH)}
    private val south = {path.add(Directions.SOUTH)}
    private val east = {path.add(Directions.EAST)}
    private val west = {path.add(Directions.WEST)}

    private val end = {path.add(Directions.END)
        println("Game over: $path")
        path.clear()
        false
    }
    fun move(where: ()-> Boolean){
        where.invoke()
    }
    fun makeMove(command: String?){
        when (command) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }

    }
}