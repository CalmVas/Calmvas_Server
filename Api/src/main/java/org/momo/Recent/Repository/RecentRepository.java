package org.momo.Recent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecentRepository extends JpaRepository<org.momo.Recent.Entity.Recent, Long> {

    @Override
    <S extends org.momo.Recent.Entity.Recent> S save(S entity);

    @Override
    Optional<org.momo.Recent.Entity.Recent> findById(Long aLong);

}
