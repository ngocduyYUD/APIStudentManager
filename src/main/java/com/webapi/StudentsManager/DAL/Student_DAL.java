package com.webapi.StudentsManager.DAL;

import com.webapi.StudentsManager.Model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student_DAL {
    public List<Student> getData()
    {
        List<Student> students = new ArrayList<>();
        try {
            File myFile = new File("src/main/resources/data");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data =line.split("-");
                Student student = new Student();
                student.setId(Integer.parseInt(data[0]));
                student.setName(data[1]);
                student.setSex(data[2]);
                student.setAge(Integer.parseInt(data[3]));
                student.setMathResult(Float.parseFloat(data[4]));
                student.setPhysResult(Float.parseFloat(data[5]));
                student.setChemistryResult(Float.parseFloat(data[6]));
                student.setAverage(Float.parseFloat(data[7]));
                student.setAcademic(data[8]);
                students.add(student);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return students;
    }
    public void saveData(List<Student> students)
    {
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/data");
            for(Student student: students)
            {
                myWriter.write(student.getId()+ "-" + student.getName() + "-" + student.getSex() + "-" + student.getAge() + "-" + student.getMathResult() + "-" + student.getPhysResult() + "-" + student.getChemistryResult() + "-" + student.getAverage()+ "-" + student.getAcademic()+"\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
