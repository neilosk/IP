public class Person {
    private String name;
    private String idNumber;

    public Person(String name, String idNumber){
        this.name = name;
        this.idNumber = idNumber;
    }

    public String toString(){
        String xID = idNumber.substring(0,6) + "xxxx";
        return "Name: " + name + "Id number: " + xID;
    }


}
