package net.java.ems.repository;

import net.java.ems.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;




public interface StudentRepository extends JpaRepository<Student, Long> {

}
