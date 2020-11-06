import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    val api = Api()
    val loader = Loader(api)

    GlobalScope.launch {
        loader.load().collect {
            println(it)
        }
    }

    Thread.sleep(1000)

}

class Api {
    suspend fun load(): Data {
        delay(100)
        return Data(13)
    }
}

class Loader(val api: Api) {

    fun load(): Flow<Item<Data>> {
        return flow {
            emit(Item.Init())
            emit(Item.Progress(10))
            emit(Item.Progress(20))
            emit(Item.Progress(50))
            emit(Item.Progress(90))
            emit(Item.Progress(100))
            emit(Item.Result(api.load()))
        }
    }

    sealed class Item<T> {
        class Init<T> : Item<T>()
        data class Progress<T>(val progress: Int) : Item<T>()
        data class Error<T>(val throwable: Throwable) : Item<T>()
        data class Result<T>(val result: T) : Item<T>()
    }
}

data class Data(val value: Int)