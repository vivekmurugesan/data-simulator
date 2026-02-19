package com.test.datasim.app;

import com.test.data.model.CustProfile;
import org.springframework.data.repository.CrudRepository;

public interface CustProfileRepository extends CrudRepository<CustProfile, Long> {
}
