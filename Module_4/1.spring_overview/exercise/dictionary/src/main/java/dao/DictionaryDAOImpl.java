package dao;

import dictionary.Dictionary;

import java.util.Map;
import java.util.TreeMap;

public class DictionaryDAOImpl implements DictionaryDAO {
    private static Map<String, Dictionary> dictionary;

    static {
        dictionary = new TreeMap<>();
        dictionary.put("hello", new Dictionary("hello", "xin chao"));
        dictionary.put("house", new Dictionary("house", "ngoi nha"));
        dictionary.put("beautiful", new Dictionary("beautiful", "xinh dep"));
        dictionary.put("dictionary", new Dictionary("dictionary", "tu dien"));
        dictionary.put("school", new Dictionary("school", "truong hoc"));
        dictionary.put("villa", new Dictionary("villa", "biet thu"));
    }
    @Override
    public String search(String search) {
        for (String keyword: dictionary.keySet()) {
            if (keyword.equals(search.toLowerCase())) {
                return dictionary.get(keyword).getMeaning();
            }
        }
        return null;
    }
}
