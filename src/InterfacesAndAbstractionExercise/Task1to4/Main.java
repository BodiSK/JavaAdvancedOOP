package InterfacesAndAbstractionExercise.Task1to4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyers = new HashMap<>();
        while (numberOfPeople-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            if(data.length==3)
                buyers.put(name,new Rebel(name, age, data[2]));
            else
                buyers.put(name, new Citizen(name, age, data[2], data[3]));
        }
        String name;
        while(!"End".equals(name = scanner.nextLine())){
            if(buyers.containsKey(name))
                buyers.get(name).buyFood();
        }
        int bought = buyers.values().stream().map(Buyer::getFood).mapToInt(Integer::valueOf).sum();
        System.out.println(bought);
    }
}
