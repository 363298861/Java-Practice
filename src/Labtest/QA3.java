package Labtest;

import java.util.ArrayList;
import java.util.List;

public class QA3<T extends Comparable> {

    public T maximal(List<T> list){
        T max;
        if(list.isEmpty())
            return null;
        else{
            max = list.get(0);
            for(int i = 0; i < list.size(); i++){
                if(max.compareTo(list.get(i)) < 0)
                    max = list.get(i);
            }
            return max;
        }
    }

    public void test(){
        List<String> l = new ArrayList<>();
        l.add("huang");
        l.add("zhi");
        l.add("yuan");
        l.add("ling");
        l.add("Ying");
    }

}
