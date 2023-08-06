public class Student {
    private String name;
    private int age;

    public Student(String name){
        this.name = name;
    }


    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }


    public boolean signUp (Lab lab){
        return lab.register(this);
    }
    public boolean signOff (Lab lab){
        return lab.remove(this);
    }

    // public boolean signUp(Lab lab){
    //     boolean s = lab.register(null);
    //     return s;
    // }
    // public boolean signOff(Lab lab){
    //     boolean s = lab.remove(null);
    //     return s;
    // }

}
