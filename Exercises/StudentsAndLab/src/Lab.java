import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Lab {
    private String name;
    private int capacity;
    private List<Student> students;
    private Set<String> availableEquipment;
    private Map<Student, Set<String>> studentEquipment;

    public Lab(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        students = new ArrayList<>();   //even if it does not say to initialize Or being an ArrayList
        availableEquipment = new TreeSet<>(); // even if it doesnt say it or specify TreeSet
        studentEquipment = new TreeMap<>();
    }

    // public boolean register(Student name){
    //     for (Student s : students){
    //         if (s != name){
    //             students.add(name);
    //             return true;
    //         }      
    //     }
    //     return false;
    // }

        //  public boolean remove(Student name){
    //     for (Student s : students){
    //         if (s == name){
    //             students.remove(name);
    //             return true;
    //         }      
    //     }
    //     return false;
    // }

        public boolean register (Student student){
            if (students.size() < capacity && !students.contains(student)){
                students.add(student);
                return true;
            }
            return false;
        }

        public boolean remove(Student student){
            if(students.contains(student)){
                students.remove(student);
                return true;    
            }
            return false;
        }

        public void addEquipment(){                                                     //Step 9
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < num; i++) {
                availableEquipment.add(sc.nextLine());
            }
            sc.close();
        }

        public boolean bookEquipment (Student student, String equipmentName){       //Step 11
            if(!availableEquipment.contains(equipmentName)){
                throw new IllegalArgumentException("Equipment is not available");
            }

            if(studentEquipment.containsKey(student)){
                studentEquipment.get(student).add(equipmentName);
                return true;
            }

            Set<String> booked = new TreeSet<>();
            booked.add(equipmentName);
            studentEquipment.put(student, booked);
            availableEquipment.remove(equipmentName);
            return true;
        }

        public void returnEquipment(Student student){                           //Step 12
            if(studentEquipment.containsKey(student)){
                for (String e : studentEquipment.get(student)) {
                    availableEquipment.add(e);
                }
                studentEquipment.remove(student);
            }
        }
}
