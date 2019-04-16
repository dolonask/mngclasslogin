package kg.infoservice.mngclass.service.impl;

import kg.infoservice.mngclass.dao.RoleRepository;
import kg.infoservice.mngclass.dao.UserRepository;
import kg.infoservice.mngclass.model.User;
import kg.infoservice.mngclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(roleRepository.getOne(1));
        return userRepository.save(user);
    }


}
