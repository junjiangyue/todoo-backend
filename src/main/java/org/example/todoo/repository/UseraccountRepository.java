package org.example.todoo.repository;

import org.example.todoo.model.Useraccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UseraccountRepository extends PagingAndSortingRepository<Useraccount,Long> {
}
