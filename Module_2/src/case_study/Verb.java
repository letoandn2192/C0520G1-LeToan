package case_study;

import java.io.Serializable;

public class Verb implements Serializable {
    private String definition;
    private String description;
    private String sentenceMeaning;

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSentenceMeaning() {
        return sentenceMeaning;
    }

    public void setSentenceMeaning(String sentenceMeaning) {
        this.sentenceMeaning = sentenceMeaning;
    }

    @Override
    public String toString() {
        return "Verb\n" +
                "- " + definition + "\n" +
                "- " + description + ": " + sentenceMeaning + "\n";
    }
}
