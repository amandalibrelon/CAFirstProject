/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package firstca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author amand
 */
public class FirstCA {

    private static final String FILE_PATH = "C:\\Users\\amand\\OneDrive\\Desktop\\POOA\\students.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try ( BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int lineCount = 0;
            Student currentStudent = new Student();
            List<Student> validStudents = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                lineCount = lineCount + 1;
                try {
                    switch (lineCount % 3) {
                        case 1:
                            currentStudent = new Student();
                            // Reading the name`s line
                            validateFirstName(line);
                            String secondName = validateSecondName(line);
                            if (secondName != null) {
                                currentStudent.setSecondName(secondName);
                            }
                            break;
                        case 2:
                            // Reading the number of classes
                            validateNumOfClasses(line);
                            currentStudent.setWorkload(line);
                            break;
                        case 0:
                            // Reading the student number
                            validateStudentNumber(line);
                            currentStudent.setStudentNumber(line);
                            if (currentStudent.isValid()) {
                                validStudents.add(currentStudent);
                            }
                            break;
                    }
                    System.out.println(line);
                } catch (ValidationException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (!validStudents.isEmpty()) {
                writingStudentStatus(validStudents);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void validateFirstName(String name) {
        String[] nameSplit = name.split(" ");
        String firstName = nameSplit[0];

        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(firstName);
        if (!matcher.find()) {
            throw new ValidationException("First name doesn`t contain only characters, name : " + firstName);
        }
    }

    private static String validateSecondName(String name) {
        String[] nameSplit = name.split(" ");
        String secondName = null;
        if (nameSplit.length > 1) {
            secondName = nameSplit[1];
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
            Matcher matcher = pattern.matcher(secondName);
            if (!matcher.find()) {
                throw new ValidationException("Second name invalid, name : " + secondName);
            }
        }
        return secondName;
    }

    private static void validateNumOfClasses(String numOfClasses) {
        Pattern pattern = Pattern.compile("^[1-8]{1,1}$");
        Matcher matcher = pattern.matcher(numOfClasses);
        if (!matcher.find()) {
            throw new ValidationException("Number of classes is invalid, value : " + numOfClasses);
        }
    }

    private static void validateStudentNumber(String studentNumber) {
        /*Pattern pattern = Pattern.compile("{6,*}");
        Matcher matcher = pattern.matcher();
        if (!matcher.find()) {
            throw new ValidationException("Student number is invalid, value : " + );
        }*/
    }

    public static void writingStudentStatus(List<Student> validStudents) {
        File f = new File("status.txt");
        if (f.exists() && !f.isDirectory()) {
            f.delete();
            System.out.println("File already exists, it`s being deleted.");
        }
        try ( FileWriter fstream = new FileWriter("status.txt");  BufferedWriter info = new BufferedWriter(fstream)) {
            for (Student student : validStudents) {
                info.write(student.getStudentNumber() + " - " + student.getSecondName());
                info.newLine();
                info.write(WorkloadEnum.findWorkload(student.getWorkload()));
                info.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
