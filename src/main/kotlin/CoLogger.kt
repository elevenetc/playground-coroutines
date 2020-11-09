object CoLogger {

    fun log(prefix: String) {
        println(prefix + ": " + Thread.currentThread().name)
    }
}