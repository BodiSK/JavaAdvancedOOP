package InterfacesAndAbstractionExercise.Task5;

import java.util.List;
import java.util.stream.Collectors;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        return urls.stream().
                map(url -> hasDigits(url) ? "Invalid URL!" : "Browsing: " + url + "!").
                collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String call() {
        return numbers.stream().
                map(number -> !digitsOnly(number) ? "Invalid number!" : "Calling... " + number).
                collect(Collectors.joining(System.lineSeparator()));
    }

    private boolean hasDigits(String string){
        for(int i=0; i<string.length(); i++)
            if(Character.isDigit(string.charAt(i)))
                return true;

        return false;
    }
    private boolean digitsOnly(String string){
        for(int i=0; i<string.length(); i++)
            if(!Character.isDigit(string.charAt(i)))
                return false;

        return true;
    }

}
