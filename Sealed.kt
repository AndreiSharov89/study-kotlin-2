sealed class NetworkError(val message: String){

    // реализуйте sealed класс NetworkError, который будет принимать на вход поле message типа String
// у класса NetworkError должно быть 3 наследника
class ServerError(val requestId: String, message: String?) : NetworkError("Ошибка взаимодействия с сервером для запроса: id = $requestId. Сообщение об ошибке: $message"){
}// ServerError -> принимает на вход 2 параметра: requestId: String и message: String?. Должен передавать в родительский класс NetworkError сообщение: "Ошибка взаимодействия с сервером для запроса: id = $requestId. Сообщение об ошибке: $message"

class NoData(val requestId: String) : NetworkError("Для запроса: id = $requestId нет данных"){
    } // NoData -> на вход принимает только requestId: String. Передаёт сообщение в конструктор родителя: "Для запроса: id = $requestId нет данных"

class NoInternet(val requestId: String) : NetworkError("Нет подключения к интернету."){
    } // NoInternet -> на вход принимает только requestId: String. Поле должно быть доступно за пределами класса, т. е. должно быть объявлено как val
    // Передаёт сообщение в конструктор родителя: "Нет подключения к интернету."
}

class ErrorHandler {

    fun handleError(error: NetworkError) {
        // в этот метод будут приходить ошибки, полученные при выполнении запросов
        when (error) {// обработайте ошибки:
            is NetworkError.ServerError -> showErrorMessage(error.message.toString()) // если это ошибка сервера (ServerError) - просто покажите сообщение с ошибкой
            is NetworkError.NoData -> showEmptyContent()// если данные не получены (NoData) - покажите пустой экран
            is NetworkError.NoInternet -> {
                showErrorMessage(error.message)
                reloadRequest(error.requestId)
            }
        }// при отсутствии интернета (NoInternet) - показать ошибку пользователю и заново выполнить запрос (метод reloadRequest())
    }

    private fun showErrorMessage(message: String) {
        println(message)
    }

    private fun showEmptyContent() {
        println("Показываем пустой экран")
    }

    private fun reloadRequest(requestId: String) {
        println("При появлении подключения к интернету перезапускаем запрос: id = $requestId")
    }
}

class Network {

    fun onNetworkError(code: Int?, requestId: String, error: String?): NetworkError {
        when(code) {// метод будет вызываться программой всякий раз, когда будет получена ошибка
            null -> return NetworkError.NoInternet(requestId) // возвращать ошибку NoInternet, если code = null
            200 -> return NetworkError.NoData(requestId)// возвращать ошибку NoData, если code = 200
            else -> return NetworkError.ServerError(requestId, error)
            // возвращать ошибку ServerError во всех остальных случаях
        }
    }
}
