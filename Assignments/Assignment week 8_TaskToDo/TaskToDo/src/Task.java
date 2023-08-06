public class Task {

    private String task;                                                        //Defining Class fields
    private int priority;
    private int workload;

    Task(String task, int priority, int workload){                              //Initializing fileds as parameters
        this.task = task;
        this.priority = priority;
        this.workload = workload;
    }

    @Override

    public String toString() {                                                               //Override toString method
        String m = "";                                                                                  
        switch (priority){                                                                   //Switch/Case depending priority value
            case 1:
             m = task+" takes "+workload+" minutes and has priority very important";
             break;
            case 2:
             m = task+" takes "+workload+" minutes and has priority important";
             break;
            case 3:
             m = task+" takes "+workload+" minutes and has priority unimportant";
             break;
            case 4:
             m = task+" takes "+workload+" minutes and has priority after learn Portuguese";
             break;
        }
        return m;                                                                           //return String m
    } 

    public int getWorkload(){                                                                //method returning the workLoad of the task
        return workload;
    }

    public int getPriority(){                                                                //method returning the priority of the task
        return priority;
    }

  
}
