package InheritanceLab;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings(){
        this.data = new ArrayList<>();
    }

    public void push(String element){
        data.add(element);
    }

    public String pop(){
        String result = data.get(data.size()-1);
        data.remove(result);
        return result;
    }

    public String peek(){
        return data.get(data.size()-1);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
}
