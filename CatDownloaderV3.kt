import kotlin.random.Random


fun main() {
    val catDownloader = CatDownloader()

    catDownloader.downloadCat(
        onSuccess = { cat -> println("Кот ${cat.name} загружен успешно") },
        onError = { error -> println(error)},
        onStart = {println("Загрузчик Котиков начинает работу")},
        false
    )
}

class CatDownloader {

    // передаём в аргументы две функции onSuccess и onError
    fun downloadCat(
        onSuccess: (Cat) -> Unit,
        onError: (String) -> Unit,
        onStart: () -> Unit,
        allowErrors: Boolean
    ) {

        onStart.invoke()
        while (!allowErrors){
        val cat: Cat? = getCatFromInternet()
        if (cat != null) {
            onSuccess.invoke(cat)
            break
        } else {
            onError("Упс, что-то пошло не так при загрузке котеек.")
        }
        }
    }

    private fun getCatFromInternet(): Cat? {
        return if (Random.nextBoolean()) Cat("Борис") else null
    }
}

class Cat(val name: String)
