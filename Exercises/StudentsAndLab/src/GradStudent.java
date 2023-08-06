public class GradStudent extends Student{                                  //Step 13

    private int maxLabs;
    private int currentLabs;

    public GradStudent(String name) {
        super(name);
        maxLabs = 3;
        currentLabs = 0;
    }
    
    @Override
    public boolean signUp(Lab lab) {
        if(currentLabs < 3 ){
            boolean success = super.signUp(lab);
            if(success){
                currentLabs++;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean signOff(Lab lab) {
        boolean success = super.signOff(lab);
        if(success){
        currentLabs --;
        return true;
        }
        return false;
    }
}
