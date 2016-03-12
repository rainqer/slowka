package pl.edu.pjwstk.presentation.dagger.landing;

import dagger.Component;
import pl.edu.pjwstk.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.presentation.ui.landing.LandingActivity;

@LandingActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = LandingModule.class
)
public interface LandingActivityComponent {
        void inject(LandingActivity activity);
}
