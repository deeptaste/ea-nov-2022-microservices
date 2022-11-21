package edu.miu.service;

import edu.miu.entity.User;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {

    Iterable<User> getAll();

    User getById(int id);
}
