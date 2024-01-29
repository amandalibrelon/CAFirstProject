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
    
    private static final String FILE_PATH = "C:\\Users\\amand\\OneDrive\\Desktop\\POOA\\students.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try ( BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                lineCount = lineCount + 1;

                try {
                    switch (lineCount % 3) {
                        case 1:
                            // We are reading the name`s line
                            //1 - Validar se nome so tem letras -> [a-zA-Z]
                            validateFirstName(line);
                            validateSecondName(line);
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
                    System.out.println(line);
                    //2 - pode numeros e letras e devem estar separados por espaco
                    //3 - classes tem q ser um int d 1-8
                    //4 - no min 6 chars, 2 sendo numero, 3-4-5 sendo letra e o 5 nao eh obrigatorio e tudo apos isso sendo num 

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

    private static void validateSecondName(String name) {
        String[] nameSplit = name.split(" ");
        if (nameSplit.length > 1) {
            String secondName = nameSplit[1];
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
            Matcher matcher = pattern.matcher(secondName);
            if (!matcher.find()) {
                throw new ValidationException("Second name invalid, name : " + secondName);
            }
        }
    }
}
