package org.example.todoo.repository;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.todoo.model.Scheme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SchemeRepository extends PagingAndSortingRepository<Scheme,Long> {

    List<Scheme> findByUserId(Long req);

    @Select("SELECT * FROM scheme WHERE scheme_start_time < CAST('#{today}' AS DATETIME) AND scheme_end_time >CAST('#{today}' AS DATETIME)")
    List<Scheme> findBySchemeDate(@Param("today") Date req);

}
