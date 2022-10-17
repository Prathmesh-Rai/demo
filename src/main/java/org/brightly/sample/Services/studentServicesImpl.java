package org.brightly.sample.Services;

import org.brightly.sample.Entities.Student;
import org.brightly.sample.Entities.Subject;
import org.brightly.sample.Repositories.studentRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Set;

@ApplicationScoped
public class studentServicesImpl implements studentServices{

    @Inject
    studentRepository studentRepo ;

    @Override
    @Transactional
    public Student createStudent(Student std){
        studentRepo.persist(std);
        return std ;
    }

    @Override
    @Transactional
    public Student findById(Long id){
        return studentRepo.findById(id) ;

    }

    @Override
    @Transactional
    public Student assignSubjects(Long id,Student dummy){
        Student s = studentRepo.findById(id) ;
        s.setSubjects(dummy.getSubjects());
        return s ;
    }

}
