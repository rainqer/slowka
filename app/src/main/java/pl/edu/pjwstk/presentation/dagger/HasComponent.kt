package pl.edu.pjwstk.presentation.dagger

interface HasComponent<out T> {
    val component: T
}
