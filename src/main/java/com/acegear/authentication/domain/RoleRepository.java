package com.acegear.authentication.domain;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface RoleRepository extends PagingAndSortingRepository<User,Long> {
}
