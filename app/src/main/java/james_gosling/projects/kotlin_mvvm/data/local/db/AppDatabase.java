package james_gosling.projects.kotlin_mvvm.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import james_gosling.projects.kotlin_mvvm.data.local.db.dao.OptionDao;
import james_gosling.projects.kotlin_mvvm.data.local.db.dao.QuestionDao;
import james_gosling.projects.kotlin_mvvm.data.local.db.dao.UserDao;
import james_gosling.projects.kotlin_mvvm.data.model.db.Option;
import james_gosling.projects.kotlin_mvvm.data.model.db.Question;
import james_gosling.projects.kotlin_mvvm.data.model.db.User;

@Database(entities = {User.class, Option.class, Question.class} , version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract QuestionDao questionDao();
    public abstract UserDao userDao();
    public abstract OptionDao optionDao();

}
