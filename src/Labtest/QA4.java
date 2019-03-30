package Labtest;

import java.util.List;

public class QA4 {
    public <T> void qa(List<? super T> output, List<T> input){
        output.clear();
        if(!input.isEmpty()){
            for(int i = 0; i < input.size(); i ++)
                output.add(input.get(i));
        }
    }
}
