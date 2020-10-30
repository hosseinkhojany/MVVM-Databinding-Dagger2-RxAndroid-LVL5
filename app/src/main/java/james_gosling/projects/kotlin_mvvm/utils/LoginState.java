package james_gosling.projects.kotlin_mvvm.utils;

public enum LoginState {

        LOGIN_STATE_MODE_LOGGED_OUT(0),
        LOGIN_STATE_MODE_GOOGLE(1),
        LOGIN_STATE_MODE_FB(2),
        LOGIN_STATE_MODE_SERVER(3);

        private final int mType;

        LoginState(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }

}
