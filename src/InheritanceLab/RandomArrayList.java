package InheritanceLab;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList extends ArrayList<Object> {
    public Object getRandomElement() {
        int index = ThreadLocalRandom.current().nextInt(0, size());
        return this.get(index);
    }
}
