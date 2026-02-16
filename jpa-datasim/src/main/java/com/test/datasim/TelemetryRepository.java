package com.test.datasim;

import org.springframework.data.repository.CrudRepository;

public interface TelemetryRepository extends CrudRepository<Telemetry, Long> {
    long count();
}
