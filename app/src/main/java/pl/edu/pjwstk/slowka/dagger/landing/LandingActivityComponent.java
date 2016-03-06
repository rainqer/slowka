package pl.edu.pjwstk.slowka.dagger.landing;

import dagger.Component;
import pl.edu.pjwstk.slowka.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.ui.landing.LandingActivity;

@LandingActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = LandingModule.class
)
public interface LandingActivityComponent {
        void inject(LandingActivity activity);
}
