package com.janguo.javabasic.lambda;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 使用Lambda 封装一个迭代器 只能访问一个函数
 */
public class Use {

    static class Library {
        public void getBook() {
            System.out.println("Get Book!");
        }

        public void getRoom() {
            System.out.println("Get Room!");
        }

        public void giveBackBook() {
            System.out.println("Give BackBook!");
        }
    }

    public static void main(String[] args) throws IOException {
        List<Library> libraryList = Arrays.asList(new Library(), new Library(), new Library(), new Library(), new Library(), new Library(), new Library());
        Iterator<Closeable> iterator = libraryList.stream().map(library -> (Closeable) library::getBook).iterator();

        while (iterator.hasNext()){
            Closeable next = iterator.next();
            next.close();
        }

    }
}
