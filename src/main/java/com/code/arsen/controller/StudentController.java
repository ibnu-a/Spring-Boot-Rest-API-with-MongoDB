package com.code.arsen.controller;

import com.code.arsen.dto.StudentDto;
import com.code.arsen.entity.Student;
import com.code.arsen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerErrorException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<?> saveData(@RequestBody StudentDto studentDto) {
        try {
            Student student = studentService.saveDataStudent(studentDto);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (ServerErrorException e) {
            return new ResponseEntity<>("Error save data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/students")
    public List<Student> getAllData() {
        return studentService.getAllData();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getDataById(@PathVariable String id) {
        try {
            Student student = studentService.getDataById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> editData(@PathVariable String id, @RequestBody StudentDto studentDto) {
        try {
            Student student = studentService.editData(id, studentDto);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteData(@PathVariable String id) {
        try {
            studentService.deleteData(id);
            return new ResponseEntity<>("Success delete data", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
        }
    }
}
