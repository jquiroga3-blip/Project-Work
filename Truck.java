public class Truck{
    //attributes and constants 
    private int truckID;
    private int truckType; // this is what is needed to determine the following below

    private double currentWeight;// this depends on the packages added to the truck along with the volume
    private double currentVolume;
    private double maxWeight;
    private double maxVolume;//this and the max weight is determined by the truck used 
    private Arraylist<Pack> pack;
    private int hoursUsed;// this will get calculated and updated 
    private int companiesStoppedAt;
    
    private static final int smallTruck=1;
    private static final int medTruck=2;
    private static final int largeTruck=3;

    public static int nextID=1;

//constructors
public Truck (){
    setTruckID();
    setTruckType(smallTruck); //the default truck is small 

    setCurrentWeight(0);
    setCurrentVolume(0);
    
    setPack(new ArrayList<>());
    setHoursUsed(0);
}
//non default constructor 
public Truck(int newTruckType){
    setTruckID();
    setTruckType(newTruckType);

    setCurrentWeight(0);
    setCurrentVolume(0);
    
    setPack(new ArrayList<>());
    setHoursUsed(0);
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

/*public double getMaxWeight(){  this might not be needed bc it is determined
    return maxWeight;               by the truck type. The setter will do this 
}

public double getMaxVolume(){
    return maxVolume;
}*/

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

public void setTruckType(int newTruckType){
    if(newTruckType==smallTruck){
        truckType=smallTruck;
        maxWeight=2000;
        maxVolume=1000;
    }
    else if (newTruckType == medTruck){
        truckType=medTruck;
        maxWeight=4000;
        maxVolume=2000;
    }
    else if(newTruckType==largeTruck){
        truckType=largeTruck;
        maxWeight=8000;
        maxVolume=4000;
    }
    else{
        truckType=smallTruck;
        maxWeight=2000;
        maxVolume=1000;
    }
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

public void setPack(ArrayList<Pack> newPack){
    if(newPack==null){
        pack=new ArrayList<>();
    }
    else{
        pack=newPack;
    }
}

public void setHoursUsed(int newHoursUsed){
    if(newHoursUsed>=0){
        hoursUsed=newHoursUsed;
    }
    else{
        hoursUsed=0;
    }
}

//methods needed 
public boolean addPackage (Package newPack){
    if(newPack==null){
        return false;
    } 
    else if(newPack.getWeight()+currentWeight<maxWeight && newPack.getVolume()+currentVolume<maxVolume){
        pack.add(newPack);
        setCurrentWeight(currentWeight+ newPack.getWeight());
        setCurrentVolume( currentVolume+ newPack.getVolume());
        return true;
    }
    else{
        return false;
    }
}

public int calculateHoursUsed(){
    hoursUsed=0;
    for(int i=0;  ){

    }
} 
}


