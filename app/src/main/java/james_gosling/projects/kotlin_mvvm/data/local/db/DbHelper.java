package james_gosling.projects.kotlin_mvvm.data.local.db;

import java.util.List;

import io.reactivex.Observable;
import james_gosling.projects.kotlin_mvvm.data.model.db.Option;
import james_gosling.projects.kotlin_mvvm.data.model.db.Question;
import james_gosling.projects.kotlin_mvvm.data.model.db.User;

public interface DbHelper {

    Observable<List<Question>> getAllQuestions();
    Observable<List<Option>> getOptionForQuestionId(Long id);
    Observable<List<User>> getAllUsers();

    Observable<Boolean> insertUser(User user);

    Observable<Boolean> isOptionEmpty();
    Observable<Boolean> isQuestionEmpty();

    Observable<Boolean> saveOption(Option option);
    Observable<Boolean> saveOptionList(List<Option> optionList);
    Observable<Boolean> saveQuestion(Question question);
    Observable<Boolean> saveQuestionList(List<Question> questionList);

}
