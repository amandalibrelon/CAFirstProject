/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firstca;

/**
 *
 * @author amand
 */
public class Student {
    
    private String secondName;
    private String studentNumber;
    private String numberOfClasses;
    
    public Student() {
        this.secondName = null;
        this.studentNumber = null;
        this.numberOfClasses = null;
    }
    
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    
    public String getSecondName() {
        return this.secondName;
    }
    
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    
    public String getStudentNumber() {
        return this.studentNumber;
    }
    
    public void setWorkload(String workload) {
        this.numberOfClasses = workload;
    }
    
    public String getWorkload() {
        return this.numberOfClasses;
    }
    
    public boolean isValid() {
        return this.secondName != null && this.studentNumber != null && this.numberOfClasses != null;
    }
}
