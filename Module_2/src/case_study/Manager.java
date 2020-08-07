package case_study;

import java.io.*;
import java.util.*;

public class Manager {
    private static Map<String, Word> dictionary = new TreeMap<>();
    public final String FILE_PATH = "D:\\C0520G1-LeToan\\Module_2\\dictionary.txt";

    public void define() {
        boolean isFinish = false;
        Scanner input = new Scanner(System.in);
        Word word = new Word();
        Entities entities = new Entities();
        System.out.println("Enter your word: ");
        word.setKeyWord(input.nextLine().toLowerCase());
        System.out.println("Enter pronoun");
        entities.setPronoun(input.nextLine().trim());
        List<Noun> nounList = new ArrayList<>();
        List<Adjective> adjectiveList = new ArrayList<>();
        List<Verb> verbList = new ArrayList<>();
        while (!isFinish) {
            System.out.println("1. Noun");
            System.out.println("2. Adjective");
            System.out.println("3. Verb");
            System.out.println("4. Next step");
            System.out.println("Enter word type: ");
            int select = Regex.checkInputFormat(input.nextLine());
            switch (select) {
                case 1:
                    nounList.add(addNewNoun());
                    break;
                case 2:
                    adjectiveList.add(addNewAdjective());
                    break;
                case 3:
                    verbList.add(addNewVerb());
                    break;
                case 4:
                    entities.setNoun(nounList);
                    entities.setAdjective(adjectiveList);
                    entities.setVerb(verbList);
                    isFinish = true;
                    break;
                default:
                    System.out.println("Invalid value !!!");
            }
        }
        System.out.println("Enter synonymous");
        entities.setSynonymous(input.nextLine());
        word.setEntities(entities);
        dictionary.put(word.getKeyWord(), word);
        word.showWord();
    }

    public void lookUp() {
        Scanner input = new Scanner(System.in);
        boolean isExist = false;
        System.out.println("Enter word you want to search: ");
        String searchWord = input.nextLine().toLowerCase();
        for (String keyWord : dictionary.keySet()) {
            if (keyWord.equals(searchWord)) {
                isExist = true;
                break;
            }
        }

        if (isExist) {
            dictionary.get(searchWord).showWord();
        } else {
            System.out.println("Not Found!!!");
            System.out.println("Do you want to add this word (Yes/No): ");
            char choose = input.next().toLowerCase().charAt(0);
            if (choose == 'y' || choose == 'Y') {
                define();
            }
        }
    }

    public void drop() {
        Scanner input = new Scanner(System.in);
        boolean isExist = false;
        System.out.println("Enter word you want to drop: ");
        String removeWord = input.nextLine().toLowerCase();
        for (String keyWord : dictionary.keySet()) {
            if (keyWord.equals(removeWord)) {
                isExist = true;
                break;
            }
        }

        if (isExist) {
            dictionary.remove(removeWord);
        } else {
            System.out.println("Not Found!!!");
        }
    }

    public void addDefinition(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter word");
        String keyWord = input.nextLine();
        boolean isFinish = false;
        Word word = dictionary.get(keyWord);
        Entities entities = word.getEntities();
        List<Noun> nounList = entities.getNoun();
        List<Adjective> adjectiveList = entities.getAdjective();
        List<Verb> verbList = entities.getVerb();
        while (!isFinish) {
            System.out.println("1. Noun");
            System.out.println("2. Adjective");
            System.out.println("3. Verb");
            System.out.println("4. Finish");
            System.out.println("Enter word type: ");
            int select = Regex.checkInputFormat(input.nextLine());
            switch (select) {
                case 1:
                    nounList.add(addNewNoun());
                    break;
                case 2:
                    adjectiveList.add(addNewAdjective());
                    break;
                case 3:
                    verbList.add(addNewVerb());
                    break;
                case 4:
                    entities.setNoun(nounList);
                    entities.setAdjective(adjectiveList);
                    entities.setVerb(verbList);
                    word.setEntities(entities);
                    dictionary.put(keyWord, word);
                    isFinish = true;
                    break;
                default:
                    System.out.println("Invalid value !!!");
            }
        }
    }


    public void showDictionary(){
        int count = 0;
        for (String keyWord: dictionary.keySet()){
            System.out.printf("%-20s", keyWord);
            count++;
            if(count == 8){
                System.out.println();
                count = 0;
            }
        }
        System.out.println();
    }

    public Adjective addNewAdjective() {
        Scanner input = new Scanner(System.in);
        Adjective adjective = new Adjective();
        System.out.println("Adjective");
        System.out.println("Enter definition: ");
        adjective.setDefinition(input.nextLine());
        System.out.println("Do you want enter sentence (Yes/No): ");
        char choose = input.next().toLowerCase().charAt(0);
        input.nextLine();
        if (choose == 'y') {
            System.out.println("Enter sentence: ");
            adjective.setDescription(input.nextLine());
            System.out.println("Enter sentence's meaning: ");
            adjective.setSentenceMeaning(input.nextLine());
        }
        return adjective;
    }

    public Verb addNewVerb() {
        Scanner input = new Scanner(System.in);
        Verb verb = new Verb();
        System.out.println("Verb");
        System.out.println("Enter definition: ");
        verb.setDefinition(input.nextLine());
        System.out.println("Do you want enter sentence (Yes/No): ");
        char choose = input.next().toLowerCase().charAt(0);
        input.nextLine();
        if (choose == 'y') {
            System.out.println("Enter sentence: ");
            verb.setDescription(input.nextLine());
            System.out.println("Enter sentence's meaning: ");
            verb.setSentenceMeaning(input.nextLine());
        }
        return verb;
    }

    public Noun addNewNoun() {
        Scanner input = new Scanner(System.in);
        Noun noun = new Noun();
        System.out.println("Noun");
        System.out.println("Enter definition: ");
        noun.setDefinition(input.nextLine());
        System.out.println("Do you want enter sentence (Yes/No): ");
        char choose = input.next().toLowerCase().charAt(0);
        input.nextLine();
        if (choose == 'y') {
            System.out.println("Enter sentence: ");
            noun.setDescription(input.nextLine());
            System.out.println("Enter sentence's meaning: ");
            noun.setSentenceMeaning(input.nextLine());
        }
        return noun;
    }

    public void writeFile() {
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

    public void readFile() {
        File file = new File(FILE_PATH);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            dictionary = (Map<String, Word>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
