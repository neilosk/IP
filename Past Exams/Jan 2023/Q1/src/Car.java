public class Car {

    private String plate;
    private int mileage;
    private int lastServiceMileage;
    private int tankCapacity;
    private int gasLevel;
    private float consumption;  


    public Car(String plate, int tankCapacity, float consumption) {
        this.plate = plate;
        this.tankCapacity = tankCapacity;
        this.consumption = consumption;
        this.mileage = 0;
        this.consumption = 0;
        this.gasLevel = 0;
    }


    public String getPlate() {
        return plate;
    }


    public int getTankCapacity() {
        return tankCapacity;
    }


    public int getGasLevel() {
        return gasLevel;
    }

    public int kmSinceService(){
        return mileage - lastServiceMileage;
    }

    public void fillTank(int gasAmount){
        if((gasAmount+gasLevel) <= tankCapacity){
            this.gasLevel += gasAmount;
        } else{
            throw new GasOverFlowException();
        }
    }

    public void service(){
        this.lastServiceMileage = mileage;
    }

    public boolean needsService(){
        if(kmSinceService()>30000){
            return true;
        }
        return false;
    }

    public boolean drive(int d){
        int gasRequired = Math.round(d*consumption);
        if(gasLevel >= gasRequired){
            this.mileage += d;
            this.gasLevel -= gasRequired;
            return true;
        }
        return false;
    }



}
