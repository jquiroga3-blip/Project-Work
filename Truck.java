public class Truck{
    //attributes and constants 
    private int truckID;
    private double currentWeight;
    private double currentVolume;
    private double maxWeight;
    private double maxVolume;
    private Arraylist<Package> pack;
    private int hoursUsed;

    private static final int smallTruck=1;
    private static final int medTruck=2;
    private static final int largeTruck=3;

    public static int nextID=1;

    /*private static final int smallTruckVolumeLimit=1000;
    private static final int smallTruckWeightLimit=2000;
    private static final int mediumTruckVolumeLimit=2000;
    private static final int mediumTruckWeightLimit= 4000;
    private static final int largeTruckVolumeLimit=4000;
    private static final int largeTruckWeightLimit= 8000;
*/

//constructors
public Truck (){
    setTruckID();
    setCurrentWeight();
    setCurrentVolume();
    setMaxWeight();
    setMaxVolume();
    setPack(new ArrayList<>());
    setHoursUsed();
}
//non default constructor 
public Truck(double newCurrentWeight, double newCurrentVolume, double newMaxWeight, double newMaxVolume,  int newHoursUsed){
    setTruckID();
    setCurrentWeight(newCurrentWeight);
    setCurrentVolume(newCurrentVolume);
    setMaxWeight(newMaxWeight);
    setMaxVolume(newMaxVolume);
    //setPack(new ArrayList<>());
    setHoursUsed(newHoursUsed);
}

//getters
public int getTruckID(){
    return truckID;
}

public double getCurrentWeight(){
    return currentWeight;
}

public double getCurrentVolume(){
    return currentVolume;
}

public double getMaxWeight(){
    return maxWeight;
}

public double getMaxVolume(){
    return maxVolume;
}

public ArraryList<Package> getPack(){
    return pack;
}

public int getHoursUsed(){
    return hoursUsed;
}

//setters 
public void setTruckID(){
    truckID= nextID++;
}

public void setCurrentWeight(double newCurrentWeight){
    if(newCurrentWeight>=0){
        currentWeight=newCurrentWeight;
    }
    else{
        currentWeight=0;
    }
    }

public void setCurrentVolume(double newCurrentVolume){
    if(newCurrentVolume>=0){
        currentVolume=newCurrentVolume;
    }
    else{
        currentVolume=0;
    }
    }

public void setMaxWeight(double newMaxWeight){
    if()

}

public void setMaxVolume(double newMaxVolume){


}

public void setPack(ArrayList<Package> newPack){


}

public void setHoursUsed(int newHoursUsed){


}

public void setHoursUsed(){


}
}
