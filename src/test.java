import com.sun.tools.javac.Main;

import java.util.Scanner;
import java.lang.reflect.Method;
public class test {




        public static void main(String[] args) throws Exception {
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            int lastDotPos = input.lastIndexOf('.');
            String className = input.substring(0, lastDotPos);
            String methodName = input.substring(lastDotPos+1);
            Class klass = Main.class.getClassLoader().loadClass(className);
            Method method = klass.getMethod(methodName);
            method.invoke(null);
        }

        public static class NestedClass {
            public static void callMe() {
                System.out.println("You called!");
            }
        }
    }

