package InterfacesAndAbstractionLab.Task4SayHelloExtended;

import InterfacesAndAbstractionLab.Task4SayHelloExtended.BasePerson;

public class Chinese extends BasePerson {

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
