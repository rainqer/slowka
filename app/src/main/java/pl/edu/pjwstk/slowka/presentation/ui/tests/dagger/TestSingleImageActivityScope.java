package pl.edu.pjwstk.slowka.presentation.ui.tests.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface TestSingleImageActivityScope {
}
