package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.dagger;

import dagger.Component;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.AdminImageDetailsActivity;

@AdminImageDetailsActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = AdminImageDetailsModule.class
)
public interface AdminImageDetailsActivityComponent {
        void inject(AdminImageDetailsActivity activity);
}
