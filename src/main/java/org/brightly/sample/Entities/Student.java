package org.brightly.sample.Entities;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;

    private int grade ;

    @ManyToMany( fetch = FetchType.EAGER )
            @JoinTable( name = "STUDENT_SUBJECTS_TABLE" ,
            joinColumns = {
                    @JoinColumn(name = "student_id" , referencedColumnName = "id" )
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "subject_id" , referencedColumnName = "id" )
            })
    private Set<Subject> subjects ;

    public Student(Long id, String name, int grade, Set<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.subjects = subjects;
    }

    public Student(){
        super() ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
