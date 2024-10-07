package br.com.ideltech.api_rest.service;

import br.com.ideltech.api_rest.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
