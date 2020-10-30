package james_gosling.projects.kotlin_mvvm.di.component;

import android.app.Application;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import james_gosling.projects.kotlin_mvvm.App;
import james_gosling.projects.kotlin_mvvm.data.DataManager;
import james_gosling.projects.kotlin_mvvm.di.module.AppModule;
import james_gosling.projects.kotlin_mvvm.utils.rx.SchedulerProvider;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(App app);

    DataManager getDataManager();

    SchedulerProvider getSchedulerProvider();

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder getInstance(Application application);

        AppComponent build();

    }

}
