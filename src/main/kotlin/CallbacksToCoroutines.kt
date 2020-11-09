import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

fun main() {
    val uiConsumer = UiConsumer()

    Thread.sleep(500)
}

class UiConsumer : CoroutineScope {

    val asyncApi = AsyncApi(SyncApi())

    init {
        launch {
            CoLogger.log("UiConsumer.init-before")
            val data = asyncApi.get()
            CoLogger.log("UiConsumer.init-after")
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

}

class SyncApi(private val data: Data = Data(13)) {
    fun get(): Data {
        CoLogger.log("SyncApi.getting")
        Thread.sleep(100)
        return data
    }
}

class AsyncApi(private val api: SyncApi) {
    suspend fun get(): Data = withContext(Dispatchers.IO) {
        CoLogger.log("AsyncApi.getting")
        api.get()
    }
}
