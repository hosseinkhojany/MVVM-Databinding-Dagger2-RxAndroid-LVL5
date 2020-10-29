package james_gosling.projects.kotlin_mvvm.data.local.db;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import james_gosling.projects.kotlin_mvvm.data.model.db.Option;
import james_gosling.projects.kotlin_mvvm.data.model.db.Question;
import james_gosling.projects.kotlin_mvvm.data.model.db.User;

@Singleton
public class AppDbHelper implements DbHelper {

    private AppDatabase appDatabase = null;

    @Inject
    public AppDbHelper(AppDatabase appDatabase){
        this.appDatabase = appDatabase;
    }

    @Override
    public Observable<List<Question>> getAllQuestions() {
        return appDatabase.questionDao().getAll().toObservable();
    }

    @Override
    public Observable<List<Option>> getOptionForQuestionId(Long id) {
        return appDatabase.optionDao().getAllByQuestionQuery(id).toObservable();
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return appDatabase.userDao().getAll().toObservable();
    }

    @Override
    public Observable<Boolean> insertUser(User user) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                appDatabase.userDao().insert(user);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> isOptionEmpty() {
        return appDatabase.optionDao().getAll()
                .flatMapObservable(optionList -> Observable.just(optionList.isEmpty()));
    }

    @Override
    public Observable<Boolean> isQuestionEmpty() {
        return null;
    }

    @Override
    public Observable<Boolean> saveOption(Option option) {
        return null;
    }

    @Override
    public Observable<Boolean> saveOptionList(List<Option> optionList) {
        return null;
    }

    @Override
    public Observable<Boolean> saveQuestion(Question question) {
        return null;
    }

    @Override
    public Observable<Boolean> saveQuestionList(List<Question> questionList) {
        return null;
    }
}
