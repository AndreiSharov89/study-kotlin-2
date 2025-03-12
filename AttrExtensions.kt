class Person(val name: String, val surname: String, val thirdName: String)

// реализуйте свойство firstSymbol для класса String
// "Белка".firstSymbol -> Результат 'Б'
// "автомобиль".firstSymbol -> Результат 'а'
val String.firstSymbol: Char
    get() = this.first()


// реализуйте свойство firstDigit для класса Int
// val a = 435
// a.firstDigit -> Результат 4
val Int.firstDigit: Int 
    get() {
    var value: Int = this
    while (value >= 10) {
        value /=10
    }
    return value
    }

// реализуйте свойство fio для класса Person
// Person("Андрей", "Стрельцов", "Александрович") -> Результат "Стрельцов Андрей Александрович"
val Person.fio: String
    get() = "${this.surname} ${this.name} ${this.thirdName}"


// реализуйте свойство biggestDigit для класса Int
// val a = 435
// a.biggestDigit -> Результат 5
val Int.biggestDigit: Int
    get() {
    var result = 0
    var value = this
    while (value > result){
        result = if (result > value %10) result else value%10
        value /= 10
    }
    return result
    }
