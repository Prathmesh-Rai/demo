package org.brightly.sample.Services;

import org.brightly.sample.Entities.Subject;
import org.brightly.sample.Repositories.subjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class subjectServicesImpl implements subjectServices{

    @Inject
    subjectRepository subjectRepo ;

    @Override
    @Transactional
    public Subject createSubject(Subject sub){
        subjectRepo.persist(sub) ;
        return sub ;
    }

}
