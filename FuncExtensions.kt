// реализуйте функцию toInt() для класса Boolean
// true.toInt() -> Результат '1'
// false.toInt() -> Результат '0'
fun Boolean.toInt(): Int{
    if (this) return 1
    else return 0
}

// реализуйте функцию printLn() для класса String
// "Hello".printLn() -> Вывод в лог 'Hello'
fun String.printLn(){
    println("$this")
}

// реализуйте функцию percentOf() для класса Int
// val value = 5
// value.percentOf(10) -> Результат '50'
fun Int.percentOf(value: Int): Int{
    return (this*100 / value)
    
}

// реализуйте функцию divideBySeparator() для класса String
// "Привет мир".divideBySeparator('_') -> Результат 'Привет_мир'
fun String.divideBySeparator(separator: Char): String{
    val array = toCharArray()
    var result = ""
    for (i in array.indices) {
        if(array[i] == ' ') array[i] = separator
        result += array[i]
    }
    return result
}
