package WorkingWithAbstractionExercise.Task4TrafficLights;

public class TrafficLight {
    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    public Color getColor(){
        return  this.color;
    }
    public void changeColor(){
        switch (color.name()){
            case "RED":
                color = Color.GREEN;
                break;
            case "GREEN":
                color = Color.YELLOW;
                break;
            case "YELLOW":
                color = Color.RED;
                break;

        }
    }
}
