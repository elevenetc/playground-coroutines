import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    val rootJob = Job()
    val childJob = GlobalScope.launch(context = rootJob) {
        var i = 100000
        while (i > 0) {
            i--
        }
    }
    rootJob.start()
    rootJob.wait()
}