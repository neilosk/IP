import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class SmartGarden {
    private int roomLight;
    private int waterTankLevel;
    private List<Plant> plants;
    private Map<Plant, Integer> numerMap;

    public SmartGarden(int roomLight, int waterTankLevel){
        this.roomLight = roomLight;
        this.waterTankLevel = waterTankLevel;
        plants = new ArrayList<>();
        
    }

    public void addPlant(Plant p){
        plants.add(p);
    }

    public void waterPlants(){
        for (Plant plant : plants) {
            if(plant.getRequiredWater() <= waterTankLevel){
                plant.water(plant.getRequiredWater());
                waterTankLevel = waterTankLevel - plant.getRequiredWater();
            } else{
                throw new LowWaterLevelException("there is not enough water");
            }
        }
    }


    public void checkLighting(){
        for (Plant plant : plants) {
            if(roomLight < plant.getOptimalLightingLevel()){
                System.out.println("plant " + plant.getName() + "requires more light");
            } else if (roomLight == plant.getOptimalLightingLevel()){
                System.out.println("plant " + plant.getName() + "has the perfect amount of light");
            } else {
            System.out.println("plant " + plant.getName() + "requires less light");
            }
        }
    }

    public Map<Plant,Integer> numberOfPlants(){
        numerMap = new HashMap<>();
        for (Plant plant : plants) {
            int count = numerMap.getOrDefault(plant, 0);
            numerMap.put(plant, count + 1);
        }
        return numerMap;
    }

    public void printReport(){
        // numerMap.entrySet()
        // .stream()
        // // .sorted(Map.Entry.comparingByKey())
        // .forEach(System.out :: println);
        // for(Map.Entry<Plant, Integer> m : numerMap.entrySet()){
        //     printReport();

        for(Plant key : numberOfPlants().keySet()){
            key.printReport();
        }

        }

 }



