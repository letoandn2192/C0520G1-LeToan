package case_study;

import java.io.Serializable;

public class Word implements Serializable {
    private String keyWord;
    private Entities entities = new Entities();

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public void showWord(){
        System.out.println("Keyword: " + this.keyWord);
        this.entities.showEntities();
    }

    @Override
    public String toString() {
        return "KeyWord: " + keyWord + '\n' + entities;
    }
}


