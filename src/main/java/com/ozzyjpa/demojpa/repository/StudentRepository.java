package com.ozzyjpa.demojpa.repository;

import com.ozzyjpa.demojpa.entities.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class StudentRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Student save(Student student){
        if(student.getId() == null){ // insert
            entityManager.persist(student);
        }
        else { // update
            entityManager.merge(student);
        }
        return student;
    }
    public Worker saveWorker(Worker worker){
        if(worker.getId() == null){ // insert
            entityManager.persist(worker);
        }
        else { // update
            entityManager.merge(worker);
        }
        return worker;
    }

    public WorkerTablePerClass saveWorkerTablePerClass(WorkerTablePerClass worker){
        if(worker.getId() == null){ // insert
            entityManager.persist(worker);
        }
        else { // update
            entityManager.merge(worker);
        }
        return worker;
    }
    public WorkerJoined saveWorkerJoined(WorkerJoined worker){
        if(worker.getId() == null){ // insert
            entityManager.persist(worker);
        }
        else { // update
            entityManager.merge(worker);
        }
        return worker;
    }

    public WorkerMapped saveWorkerMapped(WorkerMapped worker){
        if(worker.getId() == null){ // insert
            entityManager.persist(worker);
        }
        else { // update
            entityManager.merge(worker);
        }
        return worker;
    }
}
