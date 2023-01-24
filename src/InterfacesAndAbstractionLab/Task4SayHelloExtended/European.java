package InterfacesAndAbstractionLab.Task4SayHelloExtended;

import InterfacesAndAbstractionLab.Task4SayHelloExtended.BasePerson;

public class European  extends BasePerson {


    public European(String name) {
        super(name);
    }


    @Override
    public String sayHello() {
        return "Hello";
    }
}
