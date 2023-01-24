package InterfacesAndAbstractionLab.Task4SayHelloExtended;

import InterfacesAndAbstractionLab.Task4SayHelloExtended.BasePerson;

public class Bulgarian extends BasePerson {


    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
