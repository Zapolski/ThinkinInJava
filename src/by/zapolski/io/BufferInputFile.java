package by.zapolski.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BufferInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        //List<String> list = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        while ((s=in.readLine())!=null){
            sb.append(s).append("\n");
            //list.add(s);
        }
        in.close();

        /*ListIterator<String> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious())
            System.out.println(listIterator.previous());*/

        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        System.out.println(read(".\\src\\by\\zapolski\\io\\BufferInputFile.java"));
    }
}
