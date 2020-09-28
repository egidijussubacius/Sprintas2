import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


//    public static void deleteLastLine() throws IOException {
//        File file = new File(getFilesDir(), "./data/testukas.txt");
//        RandomAccessFile randomAccessFile = null;
//        try {
//            randomAccessFile = new RandomAccessFile(file, "rw");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        byte b = 0;
//        long length = 0;
//        try {
//            length = randomAccessFile.length();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (length != 0) {
//            do {
//                length -= 1;
//                try {
//                    randomAccessFile.seek(length);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    b = randomAccessFile.readByte();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } while (b != 10 && length > 0);
//            randomAccessFile.setLength(length);
//            randomAccessFile.close();
//        }
//    }
//
//    private static File getFilesDir() {
//        return null;
//    }


