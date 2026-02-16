package com.test.datasim;

import org.springframework.data.repository.CrudRepository;

public interface ProductRatingRepository extends CrudRepository<ProductRating,Long> {
    long count();
}
