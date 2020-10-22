package onlyatest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class T1 {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.aspxfans.com:8080/news/index.asp?boardID=5&ID=24618&page=1#name");
        System.out.println(url.getProtocol());
        System.out.println(url.getPort());
        System.out.println(url.getAuthority());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
        System.out.println(url.getFile());
        System.out.println(url.getRef());
    }
}
