package com.techpeak.core.repositories;

import com.techpeak.core.models.IssueCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueCategoryRepository extends JpaRepository<IssueCategoryEntity, Long> {
}
