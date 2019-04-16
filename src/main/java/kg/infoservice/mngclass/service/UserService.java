package kg.infoservice.mngclass.service;

import kg.infoservice.mngclass.model.User;

public interface UserService {

    User findUserByLogin(String login);

    User saveUser(User user);
}
