class Emitter<T>(val items: List<T>) {

    fun get(idx: Int): T {
        return items[idx]
    }
}