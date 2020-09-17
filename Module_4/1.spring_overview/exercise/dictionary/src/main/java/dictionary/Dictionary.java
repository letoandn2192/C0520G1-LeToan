package dictionary;

import org.springframework.stereotype.Controller;

@Controller
public class Dictionary {
    private String keyword;
    private String meaning;

    public Dictionary() {
    }

    public Dictionary(String keyword, String meaning) {
        this.keyword = keyword;
        this.meaning = meaning;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
