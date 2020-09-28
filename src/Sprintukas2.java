import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Sprintukas2 {
    public static void main(String[] args) {

        while (true) {
            System.out.println("Choose the number?");
            System.out.println("1. Input your name / lastname and desirable salary\n2. Read the file\n3. Delete last line \n4. Sort by salary\n5. Sort by name\n6. Sort by surname\n7. Read sorted file \n8. Exit program");
            Scanner userInput = new Scanner(System.in);
            String userAction;
            try {
                userAction = userInput.nextLine().trim();
                if (userAction.equals("1")) {
                    inputYour();
                } else if (userAction.equals("2")) {
                    readTxtFile();
                } else if (userAction.equals("3")) {
                    deleteLastLine();
                } else if (userAction.equals("4")) {
                    sortBySalary();
                } else if (userAction.equals("5")) {
                    sortByName();
                } else if (userAction.equals("6")) {
                    sortBySurname();
                } else if (userAction.equals("7")) {
                    readSortedTxtFile();
                } else if (userAction.equals("8")) {
                    System.exit(0);
                } else {
                    System.out.println("Sorry, your selection wasn't valid.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void inputYour() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Įveskite savo vardą");
        String userName = myObj.nextLine();  // Read user input
        System.out.println("Įveskite savo pavardę");
        String userSurname = myObj.nextLine();
        System.out.println("Įveskite savo norimą atlyginimą");
        String userSalary = myObj.nextLine();
        // ... writting to files
        File relativeFile2 = new File("./data/primary.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(relativeFile2, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(userName + " " + userSurname + " " + userSalary);
            bw.newLine();
            bw.close(); // close automatically flushes the buffer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readTxtFile() {
        System.out.println("Reading unsorted file, from .txt file. Data will display on console.");
        // ... skaitome failą, kuriame daug eilučių (vieną po kitos)
        File relativeFileMultiLine = new File("./data/primary.txt");
        try {
            FileReader fileReader = new FileReader(relativeFileMultiLine);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileLine = bufferedReader.readLine();
            while (fileLine != null) { // žiūrome ar perskaityta eilutė nėra tuščia
                // System.out.println(fileLine); // spausdiname visą eilutę
                // String[] splitString = fileLine.split(" ");
                String[] splitString = fileLine.split("\\s;|\\s|;");
                System.out.println(Arrays.toString(splitString));
                fileLine = bufferedReader.readLine(); // skaitome sekančią eilutę
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readSortedTxtFile() {
        System.out.println("Reading sorted file, from .txt file. Data will display on console.");

        // ... skaitome failą, kuriame daug eilučių (vieną po kitos)
        File relativeFileMultiLine = new File("./data/output.txt");
        try {
            FileReader fileReader = new FileReader(relativeFileMultiLine);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileLine = bufferedReader.readLine();
            while (fileLine != null) { // žiūrome ar perskaityta eilutė nėra tuščia
                // System.out.println(fileLine); // spausdiname visą eilutę
                // String[] splitString = fileLine.split(" ");
                String[] splitString = fileLine.split("\\s;|\\s|;");
                System.out.println(Arrays.toString(splitString));
                fileLine = bufferedReader.readLine(); // skaitome sekančią eilutę
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortBySalary() throws IOException {
        //Creating BufferedReader object to read the input text file
        BufferedReader reader = new BufferedReader(new FileReader("./data/primary.txt"));
        ArrayList<Student> studentRecords = new ArrayList<Student>();
        //Reading Student records one by one
        String currentLine = reader.readLine();
        while (currentLine != null) {
            String[] studentDetail = currentLine.split(" ");
            String name = studentDetail[0];
            String surname = studentDetail[1];
            int salary = Integer.valueOf(studentDetail[2]);
            //Creating Student object for every student record and adding it to ArrayList
            studentRecords.add(new Student(name, surname, salary));
            currentLine = reader.readLine();
        }
        //Sorting ArrayList studentRecords based on marks
        Collections.sort(studentRecords, new salaryCompare());
        //Creating BufferedWriter object to write into output text file
        BufferedWriter writer = new BufferedWriter(new FileWriter("./data/output.txt"));
        //Writing every studentRecords into output text file
        for (Student student : studentRecords) {
            writer.write(student.name + " ");
            writer.write(student.surname);
            writer.write(" " + student.salary);
            writer.newLine();
        }
        //Closing the resources
        reader.close();
        writer.close();
    }

    public static void sortByName() throws IOException {
        //Creating BufferedReader object to read the input text file
        BufferedReader reader = new BufferedReader(new FileReader("./data/primary.txt"));
        ArrayList<Student> studentRecords = new ArrayList<Student>();
        //Reading Student records one by one
        String currentLine = reader.readLine();
        while (currentLine != null) {
            String[] studentDetail = currentLine.split(" ");
            String name = studentDetail[0];
            String surname = studentDetail[1];
            int salary = Integer.valueOf(studentDetail[2]);
            //Creating Student object for every student record and adding it to ArrayList
            studentRecords.add(new Student(name, surname, salary));
            currentLine = reader.readLine();
        }
        //Sorting ArrayList studentRecords based on marks
        Collections.sort(studentRecords, new nameCompare());
        //Creating BufferedWriter object to write into output text file
        BufferedWriter writer = new BufferedWriter(new FileWriter("./data/output.txt"));
        //Writing every studentRecords into output text file
        for (Student student : studentRecords) {
            writer.write(student.name + " ");
            writer.write(student.surname);
            writer.write(" " + student.salary);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    public static void sortBySurname() throws IOException {
        //Creating BufferedReader object to read the input text file
        BufferedReader reader = new BufferedReader(new FileReader("./data/primary.txt"));
        ArrayList<Student> studentRecords = new ArrayList<Student>();
        //Reading Student records one by one
        String currentLine = reader.readLine();
        while (currentLine != null) {
            String[] studentDetail = currentLine.split(" ");
            String name = studentDetail[0];
            String surname = studentDetail[1];
            int salary = Integer.valueOf(studentDetail[2]);
            //Creating Student object for every student record and adding it to ArrayList
            studentRecords.add(new Student(name, surname, salary));
            currentLine = reader.readLine();
        }
        //Sorting ArrayList studentRecords based on marks
        Collections.sort(studentRecords, new surnameCompare());
        //Creating BufferedWriter object to write into output text file
        BufferedWriter writer = new BufferedWriter(new FileWriter("./data/output.txt"));
        //Writing every studentRecords into output text file
        for (Student student : studentRecords) {
            writer.write(student.name + " ");
            writer.write(student.surname);
            writer.write(" " + student.salary);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    public static void deleteLastLine() throws IOException {
        File file = new File(getFilesDir(), "./data/primary.txt");
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte b = 0;
        long length = 0;
        try {
            length = randomAccessFile.length();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (length != 0) {
            do {
                length -= 1;
                try {
                    randomAccessFile.seek(length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    b = randomAccessFile.readByte();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (b != 10 && length > 0);
            randomAccessFile.setLength(length);
            randomAccessFile.close();
        }
    }

    private static String getFilesDir() {
        return null;
    }
}

    class Student {
        String name;
        String surname;
        int salary;

        public Student(String name, String surname, int salary) {
            this.name = name;
            this.surname = surname;
            this.salary = salary;
        }
    }
//nameCompare Class to compare the names
    class nameCompare implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);
        }
    }
    //salaryCompare Class to compare the salary
    class salaryCompare implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s2.salary - s1.salary;
        }
    }
//surnameCompare Class to compare the surnames
    class surnameCompare implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.surname.compareTo(s2.surname);
        }
    }




