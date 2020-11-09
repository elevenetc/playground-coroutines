import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

fun main() {

}

class Presenter(override val coroutineContext: CoroutineContext) : CoroutineScope {
    init {
        launch {

        }
    }
}