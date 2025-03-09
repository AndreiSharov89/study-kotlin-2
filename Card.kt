import kotlin.random.Random

 // создайте класс Card, который содержит в конструкторе одно поле numbers
 class Card(val numbers: Map<Int, MutableSet<Int>>){
     // поле numbers — это Map, в которой в качестве ключа номер ряда (1 - 3), а в качестве значения набор чисел
     // набор чисел должен уметь хранить только уникальные значения и в процессе работы программы должен уметь удалять из себя числа
     // подумайте, какая структура данных лучше всего подойдёт для этой цели
 }
 class Person(val name: String){
 // создайте класс Person, который имеет лишь одно поле в конструкторе — строку name
     // в теле класса создайте поле card класса Card. При создании экземпляра класса оно должно генерироваться с помощью метода createCard()
     val card: Card = this.createCard()

     // метод createCard() должен возвращать объект класса Card
     // карточка должна содержать в себе 15 случайных чисел. Числа должны быть распределены в 3 ряда по 5 штук в каждом и не повторяться
     // числа в карточки должны быть от 1 до 99 включительно. Для генерации чисел можно использовать функцию Random.nextInt()
     fun createCard(): Card{
        val numbers = mutableSetOf<Int>()
        while (numbers.size < 15) {
            numbers.add(Random.nextInt(1, 100))
        }
        val cardNumbers = mapOf(
            1 to numbers.take(5).toMutableSet(),
            2 to numbers.drop(5).take(5).toMutableSet(),
            3 to numbers.drop(10).take(5).toMutableSet()
        )
        return Card(cardNumbers)
     }
 }
