
import java.util.ArrayList; 


public class Forest{
    private ArrayList<Tree> trees;
    

    public Forest(){
    this.trees = new ArrayList<>();
    }

    public void addTree(int growthPct){
    this.trees.add(new Tree(growthPct));
    }
    

    public String toString(){
        String newForest = "Forest(";
        for(Tree t: trees){
          newForest += t.toString();
        }
        return newForest + ")";

        //Same but with for loop
        // String newForest = "Forest(";
        // for (int i = 0; i < this.trees.size(); i++) {
        //     newForest +=  this.trees.get(i) + ")";
        // }
        // return newForest;

    }

    public void growOneYear(){
    for (int i = 0; i < this.trees.size(); i++) {
    this.trees.get(i).growOneYear();;
  
    }

    }
}