import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;


public class sprintas2<line> {
    public sprintas2() throws IOException {
    }

    public static void main(String[] args) throws Exception {

        try {
            System.out.println("Reading the file ");
            File myObjRaw = new File("\\C:\\Users\\Egidijus\\Desktop\\java2020\\Sprinto_darbai_java\\sprinto_darbas_2\\data\\sort.txt");
            Scanner myReaderRaw = new Scanner(myObjRaw);
            while (myReaderRaw.hasNextLine()) {
                String data = myReaderRaw.nextLine();
                System.out.println(data);
            }
            myReaderRaw.close();

//  sort
            System.out.println("----------------------Sort-----------------------");
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Egidijus\\Desktop\\java2020\\Sprinto_darbai_java\\sprinto_darbas_2\\data\\sort.txt"));
            Map<String, String> map = new TreeMap<String, String>();
            String line = "";
            while ((line = reader.readLine()) != null) {
                map.put(getField(line), line);
            }
            reader.close();
            FileWriter writer = new FileWriter("C:\\Users\\Egidijus\\Desktop\\java2020\\Sprinto_darbai_java\\sprinto_darbas_2\\data\\sorted.txt");
            for (String val : map.values()) {
                writer.write(val);
                writer.write('\n');
            }
            writer.close();
            System.out.println();

            // display file in console

            File myObj = new File("\\C:\\Users\\Egidijus\\Desktop\\java2020\\Sprinto_darbai_java\\sprinto_darbas_2\\data\\sorted.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getField(String line) {
        return line.split(" ")[0];//extract value you want to sort on
    }


}

