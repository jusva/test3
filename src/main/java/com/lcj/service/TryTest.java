package com.lcj.service;

import java.io.FileWriter;

public class TryTest {

    /*
        FileWriter需要执行flush()的时候才会输出。
        如果try（）释放括号里的资源的时候FileWriter会自动执行flush()所以能输出文字.
        而方法1没有及时释放，但是也会回收资源，不过很慢。
     */

    public void tryNoBracket(){
        try{
            FileWriter fw = new FileWriter("deom.txt");
            fw.write("hello world");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void tryBracket(){
        try(FileWriter fw = new FileWriter("deom.txt");){
            fw.write("hello world");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TryTest t = new TryTest();
        t.tryNoBracket();



    }

}
