package codesquad.session;

import codesquad.domain.User;
import codesquad.exception.NotLoginException;

import javax.servlet.http.HttpSession;

public class Session {
    public static final String SESSION_KEY = "sessionID";

    public static User getUser(HttpSession session) {
        User user = (User) session.getAttribute(SESSION_KEY);
        if(user == null){
            throw new NotLoginException();
        }
        return user;
    }

    public static void setUser(HttpSession session, User user) {
        session.setAttribute(SESSION_KEY, user);
    }
}
