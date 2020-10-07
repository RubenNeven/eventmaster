package com.eventmaster.backend.repository.event;

import com.eventmaster.backend.entity.event.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
