import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ServiceCenter {
    
    private List<Car> serviceQueue;
    private Map<String,Integer> carsPriority;
    private int gasPrice;
    

    public ServiceCenter(int gasPrice) {
        this.gasPrice = gasPrice;
        serviceQueue = new ArrayList<>();
        carsPriority = new TreeMap<>();
    }

    public void addToServiceQueue(Car c){
        
        if(carsPriority.containsKey(c.getPlate())){
            serviceQueue.add(c);
        } else{
            System.out.println("Car " + c.getPlate() + " not found");
        }
    }

    public int fillGas(Car c){
        int gasRequired = c.getTankCapacity() - c.getGasLevel();
        int value = gasRequired * gasPrice;
        c.fillTank(gasRequired);
        return value;
    }

    public void updatePriority(Car c, int p){
        carsPriority.put(c.getPlate(), p);
    }


    public void serviceCar(Car c){
        int value = fillGas(c);
        if(c.needsService()){
            c.service();
            int price = value + 500;
            System.out.println("Car " + c.getPlate() + " serviced for " + price + " dollars");
        } else{
            System.out.println("Car " + c.getPlate() + " serviced for " + value + " dollars");
        }
    }

    public void serviceAll(){
        Iterator<Car> iter = serviceQueue.iterator();
        while(iter.hasNext()){
            serviceCar(iter.next());
            iter.remove();
        }
    }


    public int findHighestPriority(){
        int maxPriority = 0;
        int index = -1;
        for (Car car : serviceQueue) {
            if(carsPriority.get(car.getPlate()) > maxPriority){
                maxPriority = carsPriority.get(car.getPlate());
            }
        }
        for (Car car : serviceQueue) {
            if(carsPriority.get(car.getPlate()) == maxPriority){
                return index = serviceQueue.indexOf(car);
            }
        }
        return index;
    }
    

    public void serviceAllWithPriority(){
        Iterator<Car> iter = serviceQueue.iterator();
        while(iter.hasNext()){
            if(serviceQueue.indexOf(iter.next()) == findHighestPriority()){
                serviceCar(iter.next());
                iter.remove();
            }
        }
    }
}
