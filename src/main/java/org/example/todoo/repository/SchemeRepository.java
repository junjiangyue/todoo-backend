package org.example.todoo.repository;

import org.example.todoo.model.Scheme;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SchemeRepository extends PagingAndSortingRepository<Scheme,Long> {
}
