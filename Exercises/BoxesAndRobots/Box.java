
// Define class Box

public class Box {

    // The class Box has three fields: position and destination of type int and
    // label of type String. The fields destination and label are initialised
    // in the constructor of the class with values of the two parameters of the
    // constructor. All boxes have 0 as initial value for their position.

    private int position;
    private int destination;
    private String label;

    public Box(int destination, String label) {

        position = 0;

        // When the field and the parameter has the same name,
        // we use 'this' to refer to the field
        this.destination = destination;
        this.label = label;

    }

    // In class Box, implement three methods: getPosition, getDestination and
    // getLabel. They take no parameters and return, respectively, the position,
    // destination and the label of a box.

    public int getPosition() {

        return position;

    }

    public int getDestination() {

        return destination;

    }

    public String getLabel() {

        return label;

    }

    // In class Box, implement a method, setPosition, that receives an int
    // parameter and sets the position of the box to the value of the parameter.

    public void setPosition(int position) {

        this.position = position;

    }

    // In class Box, implement a method, toString, such that for a box with
    // position p and label l, the method returns a String with the following
    // format:    "position: p, label: l"
    // Note that the method does not have any parameters.
    
    public String toString() {

        return "position: " + position + ", label: " + label; 
        
    }
    
}
