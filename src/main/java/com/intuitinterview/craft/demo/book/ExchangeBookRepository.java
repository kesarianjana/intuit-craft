package com.intuitinterview.craft.demo.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ExchangeBookRepository extends JpaRepository<ExchangeBookEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE ExchangeBookEntity a " +
            "SET a.isSuccessful = TRUE WHERE a.id = ?1")
    int updateSuccess(Long id);
}
