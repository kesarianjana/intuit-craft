package com.intuitinterview.craft.demo.book;

import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<BorrowEntity, Long> {
    public List<BorrowEntity> findByBorrowerId(String id);
}
