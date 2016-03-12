package pl.edu.pjwstk.slowka.dagger

interface HasComponent<out T> {
    val component: T
}
