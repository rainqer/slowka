package pl.edu.pjwstk.slowka.dagger.landing;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface LandingActivityScope {
}
