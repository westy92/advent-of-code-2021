fun main() {
    val name = "Day03"
    fun part1(lines: List<String>): Int {
        val length = lines[0].length
        val bits = MutableList(length) { 0 }
        for (line in lines) {
            line.forEachIndexed { index, char ->
                if (char == '0') bits[index]--
                else bits[index]++
            }
        }

        val mostCommonBits = bits.map { if (it > 0) '1' else '0' }.joinToString(separator = "")
        val gamma = Integer.parseInt(mostCommonBits, 2)
        val mask = Integer.parseInt("1".repeat(length), 2)
        val epsilon = gamma.xor(mask)

        return gamma * epsilon
    }

    fun part2(lines: List<String>): Int {
        fun findRating(numbers: List<String>, commonBit: String, uncommonBit: String): Int {
            var results = numbers.toList()
            var prefix = ""
            while (results.size > 1) {
                var bitCount = 0
                for (number in results) {
                    if (number[prefix.length] == '0') bitCount--
                    else bitCount++
                }
                prefix += if (bitCount >= 0) commonBit else uncommonBit
                results = results.filter { it.startsWith(prefix) }
            }

            return Integer.parseInt(results.first(), 2)
        }

        val oxygen = findRating(lines, "1", "0")
        val co2 = findRating(lines, "0", "1")

        return oxygen * co2
    }

    val testInput = readInput("${name}_test")
    val lines = readInput(name)
    check(part1(testInput) == 198)
    println(part1(lines))

    check(part2(testInput) == 230)
    println(part2(lines))
}
