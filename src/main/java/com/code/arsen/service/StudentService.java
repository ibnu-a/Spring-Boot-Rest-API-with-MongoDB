package com.code.arsen.service;

import com.code.arsen.dto.StudentDto;
import com.code.arsen.entity.Address;
import com.code.arsen.entity.Student;
import com.code.arsen.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveDataStudent(StudentDto studentDto) {

        Address address = new Address();
        address.setCountry(studentDto.getCountry());
        address.setCity(studentDto.getCity());
        address.setPostCode(studentDto.getPostCode());

        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setGender(studentDto.getGender());
        student.setAddress(address);
        student.setFavouriteSubject(studentDto.getFavouriteSubject());
        student.setTotalSpentBook(studentDto.getTotalSpentBook());
        student.setCreated(LocalDateTime.now());

        return studentRepository.insert(student);
    }

    public List<Student> getAllData() {
        return studentRepository.findAll();
    }

    public Student getDataById(String id) {
        return studentRepository.findById(id).get();
    }

    public Student editData(String id, StudentDto studentDto) {

        Student student = getDataById(id);
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setGender(studentDto.getGender());
        student.getAddress().setCountry(studentDto.getCountry());
        student.getAddress().setCity(studentDto.getCity());
        student.getAddress().setPostCode(studentDto.getPostCode());
        student.setFavouriteSubject(studentDto.getFavouriteSubject());
        student.setTotalSpentBook(studentDto.getTotalSpentBook());

        return studentRepository.save(student);
    }

    public boolean deleteData(String id) {

        studentRepository.delete(getDataById(id));
        return true;
    }
}
