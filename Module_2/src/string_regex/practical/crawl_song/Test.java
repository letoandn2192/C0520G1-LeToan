package string_regex.practical.crawl_song;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        final String LINK = "https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html";
        try {
            URL url = new URL(LINK);
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            Pattern p = Pattern.compile("name_song\">(.*?)</a>"); //class="name_song">Cung Đàn Vỡ Đôi</a>
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(1));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
