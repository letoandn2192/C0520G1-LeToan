package case_study;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;

public class Manager {
    private static Map<String, Word> dictionary = new TreeMap<>();
    public final String FILE_PATH = "D:\\C0520G1-LeToan\\Module_2\\dictionary.txt";
    public void define(){
        Scanner input = new Scanner(System.in);
        Word word = new Word();
        Entities entities = new Entities();
        System.out.println("Enter your word: ");
        word.setKeyWord(input.nextLine());
        System.out.println("Enter pronoun");
        entities.setPronoun(input.nextLine());
        entities.setNoun(addNewNoun());
        entities.setAdjective(addNewAdjective());
        entities.setVerb(addNewVerb());
        System.out.println("Enter synonymous");
        entities.setSynonymous(input.nextLine());
        word.setEntities(entities);
        dictionary.put(word.getKeyWord(), word);
        word.showWord();
    }

    public void lookUp(){
        Scanner input = new Scanner(System.in);
        boolean isExist = false;
        System.out.println("Enter word you want to search: ");
        String searchWord = input.nextLine();
        for (String keyWord: dictionary.keySet()){
            if (keyWord.equals(searchWord)) {
                isExist = true;
                break;
            }
        }

        if(isExist){
            dictionary.get(searchWord).showWord();
        } else {
            System.out.println("Not Found!!!");
            System.out.println("Do you want to add this word (Yes/No): ");
            char choose = input.next().toLowerCase().charAt(0);
            if(choose == 'y' || choose == 'Y'){
                define();
            }
        }
    }

    public void drop(){
        Scanner input = new Scanner(System.in);
        boolean isExist = false;
        System.out.println("Enter word you want to drop: ");
        String removeWord = input.nextLine();
        for (String keyWord: dictionary.keySet()){
            if (keyWord.equals(removeWord)) {
                isExist = true;
                break;
            }
        }

        if(isExist){
            dictionary.remove(removeWord);
        } else {
            System.out.println("Not Found!!!");
        }
    }

    public List<Noun> addNewNoun(){
        Scanner input = new Scanner(System.in);
        List<Noun> nounList = new ArrayList<>();
        do {
            System.out.println("Do you want enter Noun (Yes/No): ");
            char choose = input.next().toLowerCase().charAt(0);
            if(choose == 'y' || choose == 'Y'){
                Noun noun = new Noun();
                System.out.println("Noun");
                System.out.println("Enter definition: ");
                input.nextLine();
                noun.setDefinition(input.nextLine());
                System.out.println("Enter sentence: ");
                noun.setDescription(input.nextLine());
                System.out.println("Enter sentence's meaning: ");
                noun.setSentenceMeaning(input.nextLine());
                nounList.add(noun);
            } else {
                break;
            }
        } while (true);
        return nounList;
    }

    public List<Verb> addNewVerb(){
        Scanner input = new Scanner(System.in);
        List<Verb> verbList = new ArrayList<>();
        do {
            System.out.println("Do you want enter Verb (Yes/No): ");
            char choose = input.next().toLowerCase().charAt(0);
            if(choose == 'y' || choose == 'Y'){
                Verb verb = new Verb();
                System.out.println("Verb");
                System.out.println("Enter definition: ");
                input.nextLine();
                verb.setDefinition(input.nextLine());
                System.out.println("Enter sentence: ");
                verb.setDescription(input.nextLine());
                System.out.println("Enter sentence's meaning: ");
                verb.setSentenceMeaning(input.nextLine());
                verbList.add(verb);
            } else {
                break;
            }
        } while (true);
        return verbList;
    }

    public List<Adjective> addNewAdjective(){
        Scanner input = new Scanner(System.in);
        List<Adjective> adjectiveList = new ArrayList<>();
        do {
            System.out.println("Do you want enter adjective (Yes/No): ");
            char choose = input.next().toLowerCase().charAt(0);
            if(choose == 'y' || choose == 'Y'){
                Adjective adjective = new Adjective();
                System.out.println("Adjective");
                System.out.println("Enter definition: ");
                input.nextLine();
                adjective.setDefinition(input.nextLine());
                System.out.println("Enter sentence: ");
                adjective.setDescription(input.nextLine());
                System.out.println("Enter sentence's meaning: ");
                adjective.setSentenceMeaning(input.nextLine());
                adjectiveList.add(adjective);
            } else {
                break;
            }
        } while (true);
        return adjectiveList;
    }

    public void writeFile(){
        File file = new File(FILE_PATH);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(dictionary);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(){
        File file = new File(FILE_PATH);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            dictionary = (Map<String, Word>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
