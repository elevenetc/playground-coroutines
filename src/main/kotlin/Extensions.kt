import kotlinx.coroutines.Job

fun Job.wait() {
    while (!isCompleted) {

    }
}