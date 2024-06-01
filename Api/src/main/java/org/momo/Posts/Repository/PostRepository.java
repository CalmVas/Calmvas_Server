package org.momo.Posts.Repository;

import org.momo.Posts.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.momo.Posts.Entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Override
    <S extends Post> S save(S entity);

    @Override
    Optional<Post> findById(Long aLong);

    @Query("SELECT p FROM Post p WHERE p.category = :category")
    List<Post> findByCategory(@Param("category") Category category);

}
