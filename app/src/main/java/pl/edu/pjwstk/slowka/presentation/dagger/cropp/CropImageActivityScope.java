package pl.edu.pjwstk.slowka.presentation.dagger.cropp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface CropImageActivityScope {
}
