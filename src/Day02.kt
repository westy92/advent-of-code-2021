fun main() {
    val name = "Day02"
    fun part1(lines: List<String>): Int {
        var position = 0
        var depth = 0
        val regex = """(up|down|forward) (\d+)""".toRegex()

        for (line in lines) {
            val (_, direction, numString) = regex.find(line)!!.groupValues
            val num = numString.toInt()
            when (direction) {
                "up" -> depth -= num
                "down" -> depth += num
                "forward" -> position += num
            }
        }

        return position * depth
    }

    fun part2(lines: List<String>): Int {
        var position = 0
        var depth = 0
        var aim = 0
        val regex = """(up|down|forward) (\d+)""".toRegex()

        for (line in lines) {
            val (_, direction, numString) = regex.find(line)!!.groupValues
            val num = numString.toInt()
            when (direction) {
                "up" -> aim -= num
                "down" -> aim += num
                "forward" -> {
                    position += num
                    depth += aim * num
                }
            }
        }

        return position * depth
    }

    val testInput = readInput("${name}_test")
    val lines = readInput(name)
    check(part1(testInput) == 150)
    println(part1(lines))

    check(part2(testInput) == 900)
    println(part2(lines))
}
