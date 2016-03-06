package pl.touk.id_scanner.dagger

interface HasComponent<out T> {
    val component: T
}
