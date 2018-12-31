package java8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClassLoaderDevelop {
    public static void main(String[] args) throws ClassNotFoundException {
           MyClassLoader myClassLoader=new MyClassLoader();
           Class classA=myClassLoader.loadClass("org.xiafei.A");
           System.out.println(classA);
    }


}

class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classBytes = Files.readAllBytes(Paths.get(ClassLoaderDevelop.class.getResource("/A.class").toURI()));
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

    }
}
