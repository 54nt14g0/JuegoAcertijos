package org.santi.Repository;

import org.santi.Entity.Acertijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcertijoRepository extends JpaRepository <Acertijo, Long> {




}
