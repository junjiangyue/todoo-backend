package org.example.todoo.repository;
import org.example.todoo.model.Course;
import org.example.todoo.model.Scheme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CoursesRepository extends PagingAndSortingRepository<Course,Integer>  {

    List<Course> findByUserId(Long user_id);
}
