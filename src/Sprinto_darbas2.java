import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
class StringExample {
    public static String fileToString(String filePath) throws Exception{
        String input = null;
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer sb = new StringBuffer();
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            sb.append(input);
        }
        return sb.toString();
    }

    public static void main(String args[]) throws FileNotFoundException {
        String filePath = "./data/test.txt";
        String result = null;
        try {
            result = fileToString(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Contents of the file: "+result);
        //Replacing the word with desired one
        result = result.replaceAll("\\blabas\\b", "");
        //Rewriting the contents of the file
        PrintWriter writer = new PrintWriter(new File(filePath));
        writer.append(result);
        writer.flush();
        System.out.println("Contents of the file after replacing the desired word:");
        try {
            System.out.println(fileToString(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






//           System.out.println("Skaitome 'import.csv' faile irasytus duomenis ir juos isvedame i console.");
//
//        // ... skaitome failą, kuriame daug eilučių (vieną po kitos)
//        File relativeFileMultiLine = new File("./data/import.csv");
//        try {
//            FileReader fileReader = new FileReader(relativeFileMultiLine);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String fileLine = bufferedReader.readLine();
//            while (fileLine != null) { // žiūrome ar perskaityta eilutė nėra tuščia
//                // System.out.println(fileLine); // spausdiname visą eilutę
//                // String[] splitString = fileLine.split(" ");
//                String[] splitString = fileLine.split("\\s;|\\s|;");
//                System.out.println(Arrays.toString(splitString));
//                fileLine = bufferedReader.readLine(); // skaitome sekančią eilutę
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
