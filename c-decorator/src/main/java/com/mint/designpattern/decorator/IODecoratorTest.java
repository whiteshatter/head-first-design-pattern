package com.mint.designpattern.decorator;

import java.io.*;

public class IODecoratorTest {
    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(IODecoratorTest.class.getClassLoader().getResource("test.txt").getPath())));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
