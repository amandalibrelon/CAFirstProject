/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firstca;

/**
 *
 * @author amand
 */
public enum WorkloadEnum {
    VERY_LIGHT("Very light"),
    LIGHT("Light") , 
    PART_TIME("Part time"),
    FULL_TIME("Full time");
    
    private final String message;

    private WorkloadEnum(String message) {
        this.message = message;
    }
    
    private String getMessage() {
        return this.message;
    }
    
    public static String findWorkload(String numOfClasses) {
        Integer value = Integer.valueOf(numOfClasses);
        if (value == 1) {
            return VERY_LIGHT.getMessage();
        } else if (value == 2) {
            return LIGHT.getMessage();
        } else if (value >= 3 && value <= 5) {
            return PART_TIME.getMessage();
        } else {
            return FULL_TIME.getMessage();
        }
    }
}