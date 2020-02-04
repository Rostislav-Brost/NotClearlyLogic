package presentation

import java.util.Random

val random = Random()
fun main(args: Array<String>) {
//val m= Model()

    var list = initData(5000)
    println(list.size)
    addGarbige(list)
println(list.size)
    println(list.size)
    cleanData(list)
    println(list.size)
   println(printList(list))

}

fun cleanData(input: ArrayList<Human>) {
    var i=0;
    while (i<=input.lastIndex){

        if (
            (
                    (input[i].age == "")or
                    (input[i].pulse == "")or
                    (input[i].stress == "")or
                    (input[i].weigh == "")
                    ) or(!
            Human().RANGE_AGE.contains(input[i]._age )and
            Human().RANGE_PULSE.contains(input[i]._pulse )and
            Human().RANGE_STRESS.contains(input[i]._stress)and
            Human().RANGE_WEIGHT.contains(input[i]._weigh ))
        ) {input.removeAt(i)
        i--}
        i++}
}


fun rand(from: Int, to: Int) = random.nextInt(to - from) + from
fun findMax(input: ArrayList<Human> = initData()){input.maxBy { it.age }}
data class Human(
    val _age: Int=0,
    val _weigh: Int=0,
    val _pulse: Int=0,
    val _stress: Int=0,
    val age: String=_age.toString(),
    val weigh: String= _weigh.toString(),
    val pulse: String=_pulse.toString(),
    val stress: String=_stress.toString()
) {
    val RANGE_AGE = 1..101
    val RANGE_WEIGHT = 3..140
    val RANGE_PULSE = 40..180
    val RANGE_STRESS = 60..150

}

fun initData(count: Int = 500): ArrayList<Human> {
    var r: ArrayList<Human> = ArrayList()
    for (i in 0..count) {
        r.add(
            Human(
                _age = 1 + rand(1, 100),
                _weigh = 20 + rand(0, 20),
                _pulse = 40 + rand(40, 70),
                _stress = 60 + rand(10, 20)
            )
        )
    }
    return r
}

fun printList(input: ArrayList<Human> = initData()):String {
    var r=""
    var d="\t"
    var sd="\n"
    r+="age"+d+"pulse"+d+"stress"+d+"weight"+sd
    for (i in input) r+=i.age.toString() + d + i.pulse + d + i.stress + d + i.weigh+sd
    return r
}

fun addGarbige(input: ArrayList<Human> = initData()) {
    for (i in 5..100) if(i/2==0){input[rand(0, input.lastIndex)] =
        Human(
            rand(-1000, 1000),
            rand(-1000, 1000),
            rand(-1000, 1000),
            rand(-1000, 1000)
        )}else{input[rand(0, input.lastIndex)] = Human(age="",weigh = "",pulse = "",stress = "" )}

}


