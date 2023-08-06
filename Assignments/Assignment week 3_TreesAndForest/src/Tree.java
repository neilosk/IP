public class Tree {
        
    public int age;
    public double height;
    public double growthPct;
        
    public Tree(double growthPct){
    height = 0.25;
    age = 1;
    this.growthPct = growthPct;
    }

    public String toString(){
        return "Tree(age = " + age +", height = " + height +")";
        }

    public void growOneYear(){
    this.age = age + 1;
    if((this.height * (1 + growthPct / 100)) <= 20){
    this.height = height * (1 + growthPct / 100);
    } else{
        this.height = 20;}
    }
}