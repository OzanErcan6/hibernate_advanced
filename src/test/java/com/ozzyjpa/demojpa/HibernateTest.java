package com.ozzyjpa.demojpa;

import com.ozzyjpa.demojpa.entities.*;
import com.ozzyjpa.demojpa.repository.ProductRepository;
import com.ozzyjpa.demojpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class HibernateTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void studentCreateSetTest() {
        Student student = new Student("ozan2","ercan2","ozan@ercan2");

        Set<String> theImages = student.getImages();

        theImages.add("p1.png");
        theImages.add("p2.png");
        theImages.add("p3.png");
        theImages.add("p4.png");
        theImages.add("p4.png");
        theImages.add("p5.png");
        theImages.add("p5.png");

        studentRepository.save(student);

        Student student2 = entityManager.find(Student.class, student.getId());
        assert student2!= null ;
        assert Objects.equals(student2.getEmail(), "ozan@ercan2");
        assert Objects.equals(student2.getFirstName(), "ozan2");
    }

    @Test
    void productCreateListTest() {
        Product product = new Product("product1");

        List<String> theImages = product.getImages();

        theImages.add("p1.png");
        theImages.add("p2.png");
        theImages.add("p3.png");
        theImages.add("p4.png");
        theImages.add("p4.png");
        theImages.add("p5.png");
        theImages.add("p5.png");
        theImages.add("p0.png");

        productRepository.save(product);

        Product product2= entityManager.find(Product.class, product.getId());
        assert product2!= null ;
        assert Objects.equals(product.getName(), "product1");
    }

    @Test
    void studentCreateMapTest() {
        Student student = new Student("ozan","ercan","ozan@ercan");

        Map<String, String> grades = student.getGrades();

        grades.put("math", "100");
        grades.put("history", "22");
        grades.put("literature", "90");
        grades.put("science", "100");
        grades.put("science2", "100");

        studentRepository.save(student);

        Student student2 = entityManager.find(Student.class, student.getId());
        assert student2!= null ;
        assert Objects.equals(student2.getEmail(), "ozan@ercan");
        assert Objects.equals(student2.getFirstName(), "ozan");
    }

    @Test
    @Transactional
    void studentCreateSortedSetTest() {
        Student student = new Student("ozanSortedSet","ercan","ozan@ercan");

        Set<String> theHobbies = student.getHobbies();

        theHobbies.add("trekking");
        theHobbies.add("playing computer games");
        theHobbies.add("coding");
        theHobbies.add("watching movies");

        studentRepository.save(student);


    }
    @Test
    @Transactional
    void studentQuerySortedSetTest() {
        Student student2 = entityManager.find(Student.class, 8L);

        for (String hobby : student2.getHobbies()) {
            System.out.println(hobby);
        }
    }

    @Test
    @Transactional
    void studentCreateSortedMapTest() {
        Student student = new Student("ozan","ercan","ozan@ercan");

        Map<String, String> grades = student.getSortedGrades();

        grades.put("math", "100");
        grades.put("history", "22");
        grades.put("literature", "90");
        grades.put("science", "100");
        grades.put("science2", "100");

        studentRepository.save(student);

        Student student2 = entityManager.find(Student.class, student.getId());
        assert student2!= null ;
        assert Objects.equals(student2.getEmail(), "ozan@ercan");
        assert Objects.equals(student2.getFirstName(), "ozan");

        System.out.println(student2.getSortedGrades());
    }

    @Test
    @Transactional
    void studentQuerySortedMapTest() {
        Student student2 = entityManager.find(Student.class, 11L);

        System.out.println(student2.getSortedGrades());
    }

    @Test
    void studentCreateEmbeddedTest() {
        Student student = new Student("ozan","ercan","ozan@ercan");

        Address address = new Address("street", "ankara", "12345");
        student.setHomeAddress(address);

        studentRepository.save(student);

        Student student2 = entityManager.find(Student.class, student.getId());
        assert student2!= null ;
        assert Objects.equals(student2.getEmail(), "ozan@ercan");
        assert Objects.equals(student2.getFirstName(), "ozan");

    }

    @Test
    void studentCreateTwoEmbeddedTest() {
        Student student = new Student("ozan","ercan","ozan@ercan");

        Address address = new Address("street", "ankara", "12345");
        student.setHomeAddress(address);

        Address billingAddress = new Address("billingstreet", "billingankara", "billing12345");
        student.setBillingAddress(billingAddress);

        studentRepository.save(student);

        Student student2 = entityManager.find(Student.class, student.getId());
        assert student2!= null ;
        assert Objects.equals(student2.getEmail(), "ozan@ercan");
        assert Objects.equals(student2.getFirstName(), "ozan");

    }

    @Test
    void studentCreateEnumTest() {
        Student student = new Student("ozan","ercan","ozan@ercan");
        student.setStatus(Status.ACTIVE);
        studentRepository.save(student);

        Student student2 = entityManager.find(Student.class, student.getId());
        assert student2!= null ;
        assert Objects.equals(student2.getEmail(), "ozan@ercan");
        assert Objects.equals(student2.getFirstName(), "ozan");
    }

    @Test
    void workerCreateSingleTableStrategyTest() {
        FieldWorker fieldWorker = new FieldWorker("ozan","ercan","ozan@ercan", 1.0);
        AdminWorker adminWorker = new AdminWorker("admin","ercan","admin@ercan", "HIGH");

        studentRepository.saveWorker(fieldWorker);
        studentRepository.saveWorker(adminWorker);
    }

    @Test
    void workerCreateTablePerClassStrategyTest() {
        FieldWorkerTablePerClass fieldWorker = new FieldWorkerTablePerClass("ozan","ercan","ozan@ercan", 1.0);
        AdminWorkerTablePerClass adminWorker = new AdminWorkerTablePerClass("admin","ercan","admin@ercan", "HIGH");

        studentRepository.saveWorkerTablePerClass(fieldWorker);
        studentRepository.saveWorkerTablePerClass(adminWorker);
    }

    @Test
    void workerCreateJoinedStrategyTest() {
        FieldWorkerJoined fieldWorker = new FieldWorkerJoined("ozan","ercan","ozan@ercan", 1.0);
        AdminWorkerJoined adminWorker = new AdminWorkerJoined("admin","ercan","admin@ercan", "HIGH");

        studentRepository.saveWorkerJoined(fieldWorker);
        studentRepository.saveWorkerJoined(adminWorker);
    }

    @Test
    void workerCreateMappedStrategyTest() {
        FieldWorkerMapped fieldWorker = new FieldWorkerMapped("ozan","ercan","ozan@ercan", 1.0);
        AdminWorkerMapped adminWorker = new AdminWorkerMapped("admin","ercan","admin@ercan", "HIGH");

        studentRepository.saveWorkerMapped(fieldWorker);
        studentRepository.saveWorkerMapped(adminWorker);
    }
}
