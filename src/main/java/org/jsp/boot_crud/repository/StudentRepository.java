package org.jsp.boot_crud.repository;

import java.util.List;

import org.jsp.boot_crud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByName(String name);

	List<Student> findByMobile(long no);

	List<Student> findByResult(String result);

	List<Student> findByPercentageGreaterThanEqual(double percentage);

	List<Student> findByPercentageLessThan(double percentage);

}
