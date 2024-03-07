package com.webapi.StudentsManager.Controller;

import com.webapi.StudentsManager.Model.Student;
import com.webapi.StudentsManager.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/StudentController")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/AllStudents")
    public ResponseEntity<List<Student>> viewAllStudent()
    {
        try{
            List<Student> students = studentService.displayAllStudent();
            if(students.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/SortByGPA")
    public ResponseEntity<List<Student>> sortByGPA()
    {
        try{
            List<Student> students = studentService.sortByGPA();
            if(students.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/SortByName")
    public ResponseEntity<List<Student>> sortByName()
    {
        try{
            List<Student> students = studentService.sortByName();
            if(students.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/AddStudent")
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student)
    {
        try{
            Student result = studentService.addStudent(student);
            if(result == null)
            {
                return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/searchById/{id}")
    public ResponseEntity<Student> searchById(@PathVariable int id)
    {
        try{
            Student result = studentService.searchById(id);
            if(result == null)
            {
                return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/searchByName/{name}")
    public ResponseEntity<List<Student>> searchById(@PathVariable String name)
    {
        try{
            List<Student> result = studentService.searchByName(name);
            if(result.isEmpty())
            {
                return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id)
    {
        try{
            String result = studentService.deleteById(id);
            if(!result.equals("Delete Successful"))
            {
                return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateById(@RequestBody Student student)
    {
        try{
            String result = studentService.updateStudent(student);
            if(!result.equals("Update Successful"))
            {
                return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
