package org.brightly.sample.Services;

import org.brightly.sample.Entities.Student;
import org.brightly.sample.Entities.Subject;

import java.util.Set;

public interface studentServices {
    public Student createStudent(Student std) ;

    public Student findById(Long id) ;

    public Student assignSubjects(Long id ,Student dummy) ;

}
