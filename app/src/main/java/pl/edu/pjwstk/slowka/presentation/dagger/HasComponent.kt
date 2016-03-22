package pl.edu.pjwstk.slowka.presentation.dagger

interface HasComponent<out T> {
    val component: T
}
