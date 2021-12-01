fun main() {
    fun part1(lines: List<String>): Int {
        var increases = 0
        var previous = lines.firstOrNull()?.toIntOrNull() ?: return 0
        for (line in lines.drop(1)) {
            val current = line.toIntOrNull() ?: return increases
            if (current > previous) increases++
            previous = current
        }
        return increases
    }

    fun part2(lines: List<String>): Int {
        var increases = 0
        val intLines = lines.mapNotNull { it.toIntOrNull() }
        val group = intLines.take(3).toMutableList()
        var previous = group.sum()
        for (line in intLines.drop(3)) {
            group.removeFirst()
            group.add(line)
            val current = group.sum()
            if (current > previous) increases++
            previous = current
        }
        return increases
    }

    val testInput = readInput("Day01_test")
    val lines = readInput("Day01")
    check(part1(testInput) == 7)
    println(part1(lines))

    check(part2(testInput) == 5)
    println(part2(lines))
}
