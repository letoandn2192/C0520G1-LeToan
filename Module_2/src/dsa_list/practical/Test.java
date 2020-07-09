package dsa_list.practical;

import java.util.*;

public class Test {
    public	static	void	main(String[]	args)	{
        ArrayList<String> set = new ArrayList<>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");
        System.out.println(set);
        Iterator<String> a = set.iterator();
//        for (int i = 0; i < set.size(); i++){
//            System.out.println(set.get(i));
//        }
        while (a.hasNext()){
            System.out.println(a.next());
        }
    }
}
