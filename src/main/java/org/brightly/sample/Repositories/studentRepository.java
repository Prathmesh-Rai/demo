package org.brightly.sample.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.brightly.sample.Entities.Student;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class studentRepository implements PanacheRepository<Student> {
}
