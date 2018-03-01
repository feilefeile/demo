package com.acegear.authentication.domain;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface AclRepository extends PagingAndSortingRepository<User,Long> {
}
