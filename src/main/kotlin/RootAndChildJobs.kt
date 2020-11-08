import kotlinx.coroutines.*

fun main() {
    val rootJob = Job()

    val childJob = GlobalScope.launch(
        start = CoroutineStart.LAZY,
        context = Dispatchers.Default + rootJob
    ) {
        println("launch")
    }

    childJob.start()
    //rootJob.start()


    Thread.sleep(1000)
}