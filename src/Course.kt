fun main() {
    val student = Student()

}


class Student(schoolName: String) {
    var name = schoolName

    constructor() : this("stealth") {
        print(name)
    }

}

interface GameObject {
    val id: String
        get() = "playerId"

    fun update(currentTime: Long) {

    }
}

class Player : GameObject {

    override fun update(currentTime: Long) {
        super.update(currentTime)
    }
}
fun `this is a function`(){

}