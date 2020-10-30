package james_gosling.projects.kotlin_mvvm.di.module;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import james_gosling.projects.kotlin_mvvm.data.local.db.AppDatabase;

@Module
public class AppModule {

    @Provides
    @Singleton
    AppDatabase providerAppDataBase(Context context , String dbName){
        return Room.databaseBuilder(context , AppDatabase.class , dbName)
                .fallbackToDestructiveMigration().build();
    }



}
