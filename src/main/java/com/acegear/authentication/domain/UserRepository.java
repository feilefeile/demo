package com.acegear.authentication.domain;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);



}
