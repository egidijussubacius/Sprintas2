import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class input {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Įveskite savo vardą");
        String userName = myObj.nextLine();  // Read user input
        System.out.println("Įveskite savo pavardę");
        String userSurname = myObj.nextLine();
        System.out.println("Įveskite savo norimą atlyginimą");
        String userAge = myObj.nextLine();





        // ... writting to files
        File relativeFile2 = new File("./data/primary.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(relativeFile2);
            BufferedWriter bw = new BufferedWriter(fw);
            // writting file with newline
            String fileLine2 = userName;
            bw.write(fileLine2 + " " + userSurname + " " + userAge);
            bw.newLine();

//            bw.write("\n");
//
//            bw.write(userSurname);
//            bw.newLine();
//
//            bw.write(userAge);
//            bw.write("\n");

            // bw.flush();
            bw.close(); // close automatically flushes the buffer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

