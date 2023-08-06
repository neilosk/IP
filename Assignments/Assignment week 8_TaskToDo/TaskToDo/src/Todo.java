import java.util.List;

import javax.lang.model.util.ElementScanner6;
import javax.swing.event.SwingPropertyChangeSupport;
import javax.swing.plaf.synth.SynthScrollBarUI;

import java.util.ArrayList;
import java.util.Comparator;

public class Todo {

    private List<Task> tasks;                                                                   //Defining a List of the Tasks
    private int totalWork;                                                                      //Defining total minutes of completed Tasks

    public Todo(){                                                                              //Initializing fields with no value and totalWork with 0;
        tasks = new ArrayList<>();
        totalWork = 0;
    }

    public void addTask(String description, int priority, int minutes){                         //Define method to add a new Task to the list of Tasks
        if (priority != 1 && priority !=2 && priority !=3 && priority !=4){                     //Check if the priority is invalid
            System.out.println(description+" has invalid priority");
        } else{
                if(minutes < 0){                                                                //Check if workload is invalid
                    System.out.println(description+" has invalid workload");
                } else{
                        tasks.add(new Task(description, priority, minutes));                    //add a new task to the list of Tasks
                    }
            }
    }

    public void completeTask(int index){                                                        //Define method to remove a completed Task and increase the total work done

        try {
            this.totalWork += tasks.get(index).getWorkload();                                   //try to increase the total work done of each completed task
            tasks.remove(index);                                                                //remove that task from the list of Tasks
        }
        catch (IndexOutOfBoundsException e){                                                    //Catch Exception if index does not exists
            System.out.println("Invalid index");
        }        
    }

    public void print(){                                                                        //Define print method
        System.out.println("Todo:");
        System.out.println("-----");
        if(tasks.size() > 0){                                                                   //Check if list of Tasks is NOT empty
            tasks.forEach(System.out::println);                                                 //print each task
        }
         else {
            System.out.println("You're all done for today! #TodoZero");                         
         }
        if(totalWork > 0) System.out.println(totalWork+" minutes of work done!");               //Check if work done is not zero and print the total minutes of the completed Tasks

    }

    public void printPriority(int limit){                                                       //Define a print method that prints according to the given limit priority
        System.out.println("Filtered todo:");
        System.out.println("--------------");
        boolean hasTasks = false;                                                               //Define boolean var so if there is task with the given (limit) or higher priority
        for (Task t : tasks) {
            if(t.getPriority() <= limit) {
                System.out.println(t.toString());                                               //print that task
                hasTasks = true;                                                                //change boolean indicating that there is that task
            }   
            if(hasTasks == false) System.out.println("No tasks with the given priority");    //Check if there is not task with that priority of higher and print msg
        }
    }

    public void printPrioritized(){
        System.out.println("Prioritized todo:");
        System.out.println("-----------------");
        tasks.sort(Comparator                                                                   //sort tasks by using Comparator
        .comparing(Task :: getPriority)                                                         //by comparing the priorities of the task (natural order)
        .thenComparing(Task :: getWorkload)                                                     //if priorities are the same, then by comparing the workload of the tasks (natural order)
        );
        tasks.forEach(System.out :: println);                                                   //print each task after it is sorted as above 
    }
}
