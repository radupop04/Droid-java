import java.util.Scanner;

public class Droid {
    String name;
    int batteryLevel;
    public Droid(String nameOfDroid) {
        name = nameOfDroid;
        batteryLevel= 100;
    }
    public void performTask(String task) {
        if(batteryLevel > 0) {
            batteryLevel -= 10;
            System.out.println(name + " is performing : " + task);
        } else {
            System.out.println(name + "cannot perform " + task + " because he has no battery left and needs recharging");
        }
    }
    public void energyLevel() {
        System.out.println(name + " has left " + batteryLevel + "%");
    }
    public void rechargeBattery() {
        int upgradeBatteryLevel = 100 - batteryLevel;
        batteryLevel += upgradeBatteryLevel;
    }
    public String toString() {
        return "Hello! I am " + name + " and I am a droid!";
    }
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String newDroid = scan.next();
            Droid myDroid = new Droid(newDroid);
            System.out.println(myDroid);
            boolean stayInLoop = true;
            System.out.println("Enter a task that " + myDroid.name + " can perform : ");
            String taskToPerform = scan.next();
            myDroid.performTask(taskToPerform);
            while(stayInLoop) {
                System.out.println("What do you want next?");
                String nextOpertion = scan.next();
                switch(nextOpertion) {
                    case "Close" : {
                            System.out.println("See you next time! Good Bye!");
                            stayInLoop = false;
                        }
                        break;
                    case "Check_battery" : {
                            myDroid.energyLevel();
                        }
                        break;
                    case "Recharge" : {
                            myDroid.rechargeBattery();
                            System.out.println("Droid recharged successfully!");
                        }
                        break;
                    case "New_task" : {
                        System.out.println("Enter a task that " + myDroid.name + " can perform : ");
                        String newTask = scan.next();
                        myDroid.performTask(newTask);
                    }
                    break;
                    default:
                        System.out.println(myDroid.name + " doesn't know what to do!");
                }                
            }
        }
    }
}