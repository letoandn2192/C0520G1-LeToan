package case_study;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Entities implements Serializable {
    private String pronoun;
    private List<Noun> noun = new LinkedList<>();
    private List<Adjective> adjective = new LinkedList<>();
    private List<Verb> verb = new LinkedList<>();
    private String synonymous;

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public List<Noun> getNoun() {
        return noun;
    }

    public void setNoun(List<Noun> noun) {
        this.noun = noun;
    }

    public List<Adjective> getAdjective() {
        return adjective;
    }

    public void setAdjective(List<Adjective> adjective) {
        this.adjective = adjective;
    }

    public List<Verb> getVerb() {
        return verb;
    }

    public void setVerb(List<Verb> verb) {
        this.verb = verb;
    }

    public String getSynonymous() {
        return synonymous;
    }

    public void setSynonymous(String synonymous) {
        this.synonymous = synonymous;
    }

    public void showEntities(){
        System.out.println("Pronoun: " + this.pronoun);
        if(!noun.isEmpty()){
            System.out.println("Noun");
            for (Noun element: noun){
                System.out.println("* " + element.getDefinition());
                System.out.println("- " + element.getDescription() + ": " + element.getSentenceMeaning());
            }
        }
        if(!adjective.isEmpty()){
            System.out.println("Adjective");
            for (Adjective element: adjective){
                System.out.println("* " + element.getDefinition());
                System.out.println("- " + element.getDescription() + ": " + element.getSentenceMeaning());
            }
        }
        if(!verb.isEmpty()){
            System.out.println("Verb");
            for (Verb element: verb){
                System.out.println("* " + element.getDefinition());
                System.out.println("- " + element.getDescription() + ": " + element.getSentenceMeaning());
            }
        }
        System.out.println("Synonymous: " + this.synonymous);
    }

    @Override
    public String toString() {
        return "pronoun: " + pronoun + "\n" + noun + "\n" + adjective + "\n" + verb + "\n" + "Synonymous: " + synonymous;
    }
}
