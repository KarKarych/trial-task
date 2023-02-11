package com.example.kameleoon.persistence;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.example.kameleoon.persistence.entity")
@EnableJpaRepositories("com.example.kameleoon.persistence.repository")
@EnableJpaAuditing
public class PersistenceConfiguration {
}
