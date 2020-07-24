package string_regex.exercises.crawl_news;

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
        final String LINK = "https://dantri.com.vn/the-gioi.htm";
        try {
            URL url = new URL(LINK);
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            Pattern p = Pattern.compile("title=\">(.*?)\"<"); //title=\"Chấm dứt “kỷ nguyên vàng”, Trung Quốc thành “cơn đau đầu mới” của nước Anh?"
            Matcher m = p.matcher(content);
//            while (m.find()) {
//                System.out.println(m.group(1));
//            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
