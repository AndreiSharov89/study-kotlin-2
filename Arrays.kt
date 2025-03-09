import kotlin.math.abs

fun average(vararg inp: Int): Double{
    var sum: Int = 0
    var amt: Int = 0
    for (i in inp){
        sum += i
        amt++
    }
    return sum.toDouble()/amt
}

// реализуйте функцию average()
// average(1, 4, 4) -> Результат 3

fun longestWord(vararg words: String): String {
    var longest: String = ""
    for (word in words){
        if (longest.length < word.length) longest = word
    }
    return longest
}

// реализуйте функцию longestWord()
// longestWord("Я", "люблю", "гулять") -> Результат "гулять"

fun nearestNumber(number: Int, vararg numbers: Int): Int{
    var nearest: Int = numbers[0]
    var delta: Int = kotlin.math.abs(number - nearest)
    for (i in numbers){
        if (kotlin.math.abs(number - i) < delta) {
            delta = kotlin.math.abs(number - i)
            nearest = i
        }
    }

    return nearest
}

// реализуйте функцию nearestNumber()
// nearestNumber(10, 4, 12, 9) -> Результат 9
