package com.webapi.StudentsManager.Service;

import com.webapi.StudentsManager.DAL.Student_DAL;
import com.webapi.StudentsManager.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

@Service
public class StudentService {
    public Student_DAL student_DAL = new Student_DAL();
    private List<Student> students = student_DAL.getData();  //Hashmap is better
    public Student addStudent(Student student)
    {
        student.setId(students.get(students.size() - 1).getId()+1);
        students.add(student);
        student_DAL.saveData(students);
        return student;
    }
    public String updateStudent(Student updateStudent)
    {
        for(Student student: students)
        {
            if(updateStudent.getId() == student.getId())
            {
                student.setAge(updateStudent.getAge());
                student.setAcademic(updateStudent.getAcademic());
                student.setName(updateStudent.getName());
                student.setAverage(updateStudent.getAverage());
                student.setSex(updateStudent.getSex());
                student.setChemistryResult(updateStudent.getChemistryResult());
                student.setMathResult(updateStudent.getMathResult());
                student.setPhysResult(updateStudent.getPhysResult());
                student_DAL.saveData(students);
                return "Update Successful";
            }
        }
        return "!Update Successful";
    }
    public String deleteById(int id)
    {
        for(Student student: students)
        {
            if(id == student.getId())
            {
                students.remove(student);
                student_DAL.saveData(students);
                return "Delete Successful";
            }
        }
        return "!Delete Successful";
    }
    public List<Student> searchByName(String name)
    {
        List<Student> studentList = new ArrayList<>();
        for(Student student: students)
        {
            if(name.equals(student.getName()))
            {
                studentList.add(student);
            }
        }
        return studentList;
    }
    public List<Student> sortByGPA()
    {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Float.compare(s1.getAverage(), s2.getAverage());
            }
        });
        return students;
    }
    public List<Student> sortByName()
    {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                String[] name1 = s1.getName().split(" ");
                String[] name2 = s2.getName().split(" ");
                return name1[name1.length - 1].compareTo(name2[name2.length - 1]);
            }
        });
        return students;
    }
    public List<Student> displayAllStudent()
    {
        return students;
    }
    public void saveChange(List<Student> students)
    {
        student_DAL.saveData(students);
    }
    public float avg(float a, float b, float c)
    {
        float sum = a + b+ c;
        return sum/3;
    }
    public String hocLuc(float avg)
    {
        if(avg>= 8 )
        {
            return "Gioi";
        }
        else if(avg >= 6.5)
        {
            return "Kha";
        }
        else if(avg >= 5)
        {
            return "Trung Binh";
        }
        else
        {
            return "Yeu";
        }
    }
    public Student searchById(int id)
    {
        List<Student> students = student_DAL.getData();
        for(Student student: students)
        {
            if(student.getId() == id)
            {
                return student;
            }
        }
        return null;
    }
}
