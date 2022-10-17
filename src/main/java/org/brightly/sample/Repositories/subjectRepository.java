package org.brightly.sample.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.brightly.sample.Entities.Subject;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class subjectRepository implements PanacheRepository<Subject> {
}
