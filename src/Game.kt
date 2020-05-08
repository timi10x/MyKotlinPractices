import kotlin.math.absoluteValue

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
        println(game.map.getDescription())
    }
}

class Game {
    var path: MutableList<Directions> = mutableListOf(Directions.START)
    var map = Location()

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
    fun makeMove(command:String?) {

        when {
            command.equals("n") -> { move(north); map.updateLocation(Directions.NORTH) }
            command.equals("s") -> { move(south); map.updateLocation(Directions.SOUTH) }
            command.equals("e") -> { move(east); map.updateLocation(Directions.EAST) }
            command.equals("w") -> { move(west); map.updateLocation(Directions.WEST) }
            else -> move(end)
        }
    }

    }


class Location(private val width: Int = 4, private val height: Int = 4){
    var map = Array(width){ arrayOfNulls<String>(height)}

    var currentLocation = Pair(0,0)

    fun updateLocation(direction: Directions){
        when (direction) {
            Directions.NORTH -> {
                currentLocation = Pair(currentLocation.first, (currentLocation.second + 1).rem(height))}
            Directions.SOUTH -> {
                currentLocation = Pair(currentLocation.first, (currentLocation.second - 1).absoluteValue.rem(height))}
            Directions.EAST -> {
                currentLocation = Pair((currentLocation.first + 1).rem(width), currentLocation.second)}
            Directions.WEST -> {
                currentLocation = Pair((currentLocation.first - 1).absoluteValue.rem(width), currentLocation.second)}
        }
    }

    fun getDescription(): String?{
        return map[currentLocation.first.rem(width)][currentLocation.second.rem(height)]
    }

    init {
        map[0][0] = "You are at the start of this curfew-corona virus survival journey. [n / e]"
        map[0][1] = "It's a long road ahead to your house. And you are still outside during curfew. [ n / s / e]"
        map[0][2] = "The road still stretches before you. Clouds begin to form. [ n / s / e]"
        map[0][3] = "It is getting much darker, and you begin to wish that you left that club early. [ s / e]"

        map[1][0] = "You head for the narrow path, where you think no task official would get hold of you. You are glad and at the same time scared. [ n / e /w]"
        map[1][1] = "It is getting colder. You feel very frightened. then you hit your leg on a big stone. [ n / s / e / w]"
        map[1][2] = "You decide to ease the pain by taking a rest or you decide to push through with a bad leg. [ n / s / e /w]"
        map[1][3] = "You have taken a seat on the floor, as you allow the pain to subside. [ w / s / e]"

        map[2][0] = "Finally, you have come to the end of the narrow path . Your hear the sounds of moving vehicles. And another grumbling sound of footsteps. [ n / e / w]"
        map[2][1] = "A flash light  appears. heading towards you. You begin to blame yourself for staying this long outside. [ n / s / e  /w]"
        map[2][2] = "It is getting more scary. You can hear strange voices. [ n / s / e / w]"
        map[2][3] = "The foothills promise a strenuous journey. You thread your way around gigantic boulders. [ s / e / w ]"

        map[3][0] = "Your journey continues. you limp your way to where you can hide, till all these sounds reduces.[ n / e ]"
        map[3][1] = "In the distance, you see a shop with a little light. You head towards the shop. They pay you no heed. [ n / s / w ]"
        map[3][2] = "Now that you're in trouble, you begin to regret this day. You think of all the memorable moments you'll be having, if at home.[ n / s / w ]"
        map[3][3] = "You have almost reached the shop. It also seem like the moving vehicle is fast approaching your direction. GBAM!!! you are spotted and mistaken as the owner of the sho.[ s / w ] "
    }

}
enum class Directions{
    NORTH, SOUTH, EAST, WEST, START, END
}