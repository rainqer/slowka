package pl.edu.pjwstk.slowka.presentation.ui.single_category.dagger;

import android.app.Application;

import pl.edu.pjwstk.slowka.presentation.dagger.Components;

public class SingleCategoryActivityComponentAssembler {

    private SingleCategoryActivityComponentAssembler() {
        throw new AssertionError("No instances.");
    }

    public static SingleCategoryActivityComponent assemble(Application application) {
        return DaggerSingleCategoryActivityComponent.builder()
                .applicationComponent(Components.from(application))
                .singleCategoryModule(new SingleCategoryModule())
                .build();
    }
}
