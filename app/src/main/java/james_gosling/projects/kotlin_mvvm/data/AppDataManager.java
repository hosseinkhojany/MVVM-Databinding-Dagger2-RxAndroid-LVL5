package james_gosling.projects.kotlin_mvvm.data;//package james_gosling.projects.kotlin_mvvm.data;
//
//import android.content.Context;
//import android.util.Log;
//
//import com.google.gson.Gson;
//import com.google.gson.internal.$Gson$Types;
//import com.google.gson.reflect.TypeToken;
//import james_gosling.projects.kotlin_mvvm.data.local.db.DbHelper;
//import james_gosling.projects.kotlin_mvvm.data.local.prefs.PrefHelper;
//import james_gosling.projects.kotlin_mvvm.data.model.api.BlogResponse;
//import james_gosling.projects.kotlin_mvvm.data.model.api.LoginRequest;
//import james_gosling.projects.kotlin_mvvm.data.model.api.LoginResponse;
//import james_gosling.projects.kotlin_mvvm.data.model.api.LogoutResponse;
//import james_gosling.projects.kotlin_mvvm.data.model.api.OpenSourceResponse;
//import james_gosling.projects.kotlin_mvvm.data.model.db.Option;
//import james_gosling.projects.kotlin_mvvm.data.model.db.Question;
//import james_gosling.projects.kotlin_mvvm.data.model.db.User;
//import james_gosling.projects.kotlin_mvvm.data.model.others.QuestionCardData;
//import james_gosling.projects.kotlin_mvvm.data.remote.ApiHeader;
//import james_gosling.projects.kotlin_mvvm.data.remote.ApiHelper;
//import james_gosling.projects.kotlin_mvvm.utils.Constants;
//import io.reactivex.Observable;
//import io.reactivex.Single;
//import java.lang.reflect.Type;
//import java.util.List;
//import javax.inject.Inject;
//import javax.inject.Singleton;
//
//
//@Singleton
//public class AppDataManager implements DataManager {
//
//    private static final String TAG = "AppDataManager";
//
//    private final ApiHelper mApiHelper;
//
//    private final Context mContext;
//
//    private final DbHelper mDbHelper;
//
//    private final Gson mGson;
//
//    private final PrefHelper mPrefHelper;
//
//    @Inject
//    public AppDataManager(Context context, DbHelper dbHelper, PrefHelper PrefHelper, ApiHelper apiHelper, Gson gson) {
//        mContext = context;
//        mDbHelper = dbHelper;
//        mPrefHelper = PrefHelper;
//        mApiHelper = apiHelper;
//        mGson = gson;
//    }
//
//    @Override
//    public Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request) {
//        return mApiHelper.doFacebookLoginApiCall(request);
//    }
//
//    @Override
//    public Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request) {
//        return mApiHelper.doGoogleLoginApiCall(request);
//    }
//
//    @Override
//    public Single<LogoutResponse> doLogoutApiCall() {
//        return mApiHelper.doLogoutApiCall();
//    }
//
//    @Override
//    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
//        return mApiHelper.doServerLoginApiCall(request);
//    }
//
//    @Override
//    public String getAccessToken() {
//        return mPrefHelper.getAccessToken();
//    }
//
//    @Override
//    public void setAccessToken(String accessToken) {
//        mPrefHelper.setAccessToken(accessToken);
//        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
//    }
//
//    @Override
//    public Observable<List<Question>> getAllQuestions() {
//        return mDbHelper.getAllQuestions();
//    }
//
//    @Override
//    public Observable<List<User>> getAllUsers() {
//        return mDbHelper.getAllUsers();
//    }
//
//    @Override
//    public ApiHeader getApiHeader() {
//        return mApiHelper.getApiHeader();
//    }
//
//    @Override
//    public Single<BlogResponse> getBlogApiCall() {
//        return mApiHelper.getBlogApiCall();
//    }
//
//    @Override
//    public String getCurrentUserEmail() {
//        return mPrefHelper.getCurrentUserEmail();
//    }
//
//    @Override
//    public void setCurrentUserEmail(String email) {
//        mPrefHelper.setCurrentUserEmail(email);
//    }
//
//    @Override
//    public Long getCurrentUserId() {
//        return mPrefHelper.getCurrentUserId();
//    }
//
//    @Override
//    public void setCurrentUserId(Long userId) {
//        mPrefHelper.setCurrentUserId(userId);
//    }
//
//    @Override
//    public int getCurrentUserLoggedInMode() {
//        return mPrefHelper.getCurrentUserLoggedInMode();
//    }
//
//    @Override
//    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
//        mPrefHelper.setCurrentUserLoggedInMode(mode);
//    }
//
//    @Override
//    public String getCurrentUserName() {
//        return mPrefHelper.getCurrentUserName();
//    }
//
//    @Override
//    public void setCurrentUserName(String userName) {
//        mPrefHelper.setCurrentUserName(userName);
//    }
//
//    @Override
//    public String getCurrentUserProfilePicUrl() {
//        return mPrefHelper.getCurrentUserProfilePicUrl();
//    }
//
//    @Override
//    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
//        mPrefHelper.setCurrentUserProfilePicUrl(profilePicUrl);
//    }
//
//    @Override
//    public Single<OpenSourceResponse> getOpenSourceApiCall() {
//        return mApiHelper.getOpenSourceApiCall();
//    }
//
//    @Override
//    public Observable<List<Option>> getOptionsForQuestionId(Long questionId) {
//        return mDbHelper.getOptionsForQuestionId(questionId);
//    }
//
//    @Override
//    public Observable<List<QuestionCardData>> getQuestionCardData() {
//        return mDbHelper.getAllQuestions()
//                .flatMap(questions -> Observable.fromIterable(questions))
//                .flatMap(question -> Observable.zip(
//                        mDbHelper.getOptionsForQuestionId(question.id),
//                        Observable.just(question),
//                        (options, question1) -> new QuestionCardData(question1, options)))
//                .toList()
//                .toObservable();
//    }
//
//    @Override
//    public Observable<Boolean> insertUser(User user) {
//        return mDbHelper.insertUser(user);
//    }
//
//    @Override
//    public Observable<Boolean> isOptionEmpty() {
//        return mDbHelper.isOptionEmpty();
//    }
//
//    @Override
//    public Observable<Boolean> isQuestionEmpty() {
//        return mDbHelper.isQuestionEmpty();
//    }
//
//    @Override
//    public Observable<Boolean> saveOption(Option option) {
//        return mDbHelper.saveOption(option);
//    }
//
//    @Override
//    public Observable<Boolean> saveOptionList(List<Option> optionList) {
//        return mDbHelper.saveOptionList(optionList);
//    }
//
//    @Override
//    public Observable<Boolean> saveQuestion(Question question) {
//        return mDbHelper.saveQuestion(question);
//    }
//
//    @Override
//    public Observable<Boolean> saveQuestionList(List<Question> questionList) {
//        return mDbHelper.saveQuestionList(questionList);
//    }
//
//    @Override
//    public Observable<Boolean> seedDatabaseOptions() {
//        return mDbHelper.isOptionEmpty()
//                .concatMap(isEmpty -> {
//                    if (isEmpty) {
//                        Type type = new TypeToken<List<Option>>() {
//                        }.getType();
//                        List<Option> optionList = mGson.fromJson(CommonUtils.loadJSONFromAsset(mContext, AppConstants.SEED_DATABASE_OPTIONS), type);
//                        return saveOptionList(optionList);
//                    }
//                    return Observable.just(false);
//                });
//    }
//
//    @Override
//    public Observable<Boolean> seedDatabaseQuestions() {
//        return mDbHelper.isQuestionEmpty()
//                .concatMap(isEmpty -> {
//                    if (isEmpty) {
//                        Type type = $Gson$Types.newParameterizedTypeWithOwner(null, List.class, Question.class);
//                        List<Question> questionList = mGson
//                                .fromJson(CommonUtils.loadJSONFromAsset(mContext, AppConstants.SEED_DATABASE_QUESTIONS), type);
//                        return saveQuestionList(questionList);
//                    }
//                    return Observable.just(false);
//                });
//    }
//
//    @Override
//    public void setUserAsLoggedOut() {
//        updateUserInfo(
//                null,
//                null,
//                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
//                null,
//                null,
//                null);
//    }
//
//    @Override
//    public void updateApiHeader(Long userId, String accessToken) {
//        mApiHelper.getApiHeader().getProtectedApiHeader().setUserId(userId);
//        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
//    }
//
//    @Override
//    public void updateUserInfo(
//            String accessToken,
//            Long userId,
//            LoggedInMode loggedInMode,
//            String userName,
//            String email,
//            String profilePicPath) {
//
//        setAccessToken(accessToken);
//        setCurrentUserId(userId);
//        setCurrentUserLoggedInMode(loggedInMode);
//        setCurrentUserName(userName);
//        setCurrentUserEmail(email);
//        setCurrentUserProfilePicUrl(profilePicPath);
//
//        updateApiHeader(userId, accessToken);
//    }
//}
