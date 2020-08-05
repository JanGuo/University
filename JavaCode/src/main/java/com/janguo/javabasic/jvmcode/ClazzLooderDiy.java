package com.janguo.javabasic.jvmcode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ClazzLooderDiy extends ClassLoader {
    private String classLoaderName;
    private String path;
    private final String fileExtension = ".class";

    public ClazzLooderDiy(String LoaderName) {
        super();
        this.classLoaderName = LoaderName;
    }

    public ClazzLooderDiy(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] data = this.loadClassData(className);
        return this.defineClass(className,data,0,data.length);
    }

    private byte[] loadClassData(String className){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        className = className.replace(".","/");
        try {
            //this.classLoaderName = this.classLoaderName.replace(".","/");
            is = new FileInputStream(new File(this.path+className + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read()))
            {
                baos.write(ch);
            }
            data = baos.toByteArray();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                is.close();
                baos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        ClazzLooderDiy loader1 = new ClazzLooderDiy("loader1");
        loader1.setPath("/Users/janguo/Desktop/");
        Class<?> clazz = loader1.loadClass("jvmcode.JvmText03");
        System.out.println(clazz.getClassLoader());
        System.out.println("class:"+clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

        ClazzLooderDiy loader2 = new ClazzLooderDiy("loader2");
        loader2.setPath("/Users/janguo/Desktop/");
        Class<?> clazz2 = loader2.loadClass("jvmcode.JvmText03");
        System.out.println(clazz2.getClassLoader());
        System.out.println("class:"+clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2);

    }

}
