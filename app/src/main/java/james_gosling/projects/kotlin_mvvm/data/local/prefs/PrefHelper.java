package james_gosling.projects.kotlin_mvvm.data.local.prefs;

import james_gosling.projects.kotlin_mvvm.utils.LoginState;

public interface PrefHelper {
    String getAccessToken();

    void setAccessToken(String accessToken);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(LoginState mode);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);
}
