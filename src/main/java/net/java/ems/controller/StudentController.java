package net.java.ems.controller;

import lombok.AllArgsConstructor;
import net.java.ems.dto.StudentDto;
import net.java.ems.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {
  private StudentService studentService;

  @PostMapping
  public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
      StudentDto savedStudent =studentService.createStudent(studentDto);
      return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
  }

    @GetMapping("/{id}")
  public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId) {
      StudentDto studentDto = studentService.getStudentById(studentId);
      return ResponseEntity.ok(studentDto);
  }

  @GetMapping
  public ResponseEntity<List<StudentDto>> getAllStudents() {
      List<StudentDto> students = studentService.getAllStudents();
      return ResponseEntity.ok(students);
  }

    @PutMapping("/{id}")
  public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId,
                                                  @RequestBody StudentDto updatedStudent) {
      StudentDto studentDto = studentService.updateStudent(studentId, updatedStudent);
      return ResponseEntity.ok(studentDto);
  }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted");
    }


}
