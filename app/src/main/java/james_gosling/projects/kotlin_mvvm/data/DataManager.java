package james_gosling.projects.kotlin_mvvm.data;

import java.util.List;

import io.reactivex.Observable;
import james_gosling.projects.kotlin_mvvm.data.local.db.DbHelper;
import james_gosling.projects.kotlin_mvvm.data.local.prefs.PrefHelper;
import james_gosling.projects.kotlin_mvvm.data.model.others.QuestionCardData;
import james_gosling.projects.kotlin_mvvm.data.remote.ApiHelper;
import james_gosling.projects.kotlin_mvvm.utils.LoginState;

public interface DataManager extends DbHelper , PrefHelper, ApiHelper {

    Observable<List<QuestionCardData>> getQuestionCardData();

    Observable<Boolean> seedDatabaseOptions();

    Observable<Boolean> seedDatabaseQuestions();

    void setUserAsLoggedOut();

    void updateApiHeader(Long userId, String accessToken);

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoginState loggedInMode,
            String userName,
            String email,
            String profilePicPath);



}
