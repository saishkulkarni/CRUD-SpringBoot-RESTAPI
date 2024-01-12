package org.jsp.crud_rest.repository;

import java.util.List;

import org.jsp.crud_rest.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

	List<Student> findByName(String name);

	Student findByMobile(long mobile);

	List<Student> findByResult(String result);

	List<Student> findByPercentageGreaterThanEqual(double percentage);

	List<Student> findByPercentageBetween(double percentage1, double percentage2);

	List<Student> findByPercentageLessThan(double percentage);

	List<Student> findByMathsGreaterThanEqualAndEnglishGreaterThanEqual(int marks, int marks2);

	List<Student> findByNameOrMobile(String name, long number);

}
