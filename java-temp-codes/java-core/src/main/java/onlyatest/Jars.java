package onlyatest;

import java.io.*;
import java.net.URL;

public class Jars {
    public static void main(String[] args) throws IOException {
        URL ins = Jars.class.getResource("onlyatest/data-1.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(ins.getFile())));
        String line = null;
        while((line=br.readLine())!=null) {
            int index = line.lastIndexOf('/');
            line = line.substring(index+1);
            index = line.lastIndexOf('.');
            line = line.substring(0,index);
            System.out.println(line);
        }

    }
}
