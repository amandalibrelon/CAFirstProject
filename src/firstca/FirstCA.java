/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package firstca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author amand
 */
public class FirstCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try ( BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\amand\\OneDrive\\Desktop\\POOA\\students.txt"))) {
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                lineCount = lineCount + 1;
                System.out.println(line);
                try {
                    switch (lineCount % 3) {
                        case 1:
                            // We are reading the name`s line
                            validateFirstName(line);
                            break;
                        case 2:
                            // We are reading the number of classes
                            break;
                        case 0:
                            // We are reading the student number
                            break;
                        default:
                            break;
                    }
                } catch (ValidationException e) {
                    System.out.println(e.getMessage());
                }
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
}
