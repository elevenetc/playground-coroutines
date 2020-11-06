import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test

class LoaderTests {
    @Test
    fun load() {

        val api = Api()

        runBlockingTest {
            val load = api.load()
        }
    }
}