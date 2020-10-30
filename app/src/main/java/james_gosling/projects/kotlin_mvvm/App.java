package james_gosling.projects.kotlin_mvvm;

import android.app.Application;

import james_gosling.projects.kotlin_mvvm.di.component.AppComponent;

public class App extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();


    }


}
