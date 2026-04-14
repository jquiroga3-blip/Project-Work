public class SpecPack extends Pack {
	// Copy your SpecPack.java from lab 06 here 
	//attributes and constants 
    private int timeDeadline;
	public static final int DEFAULT_TIME_DEADLINE=9;
    
    //constructors
    //default
    public SpecPack() throws InvalidSpecPackException  {
        super();// this one calls the default one in the parent class Pack 
        setTime(DEFAULT_TIME_DEADLINE);
    }

    public SpecPack(String newCompName, String newDeliveryZone, Date newDeliveryDate, int newWeight, int newVolume, int newTimeDeadline) throws InvalidSpecPackException{
        super(newCompName, newDeliveryZone, newDeliveryDate, newWeight,newVolume);
        setTime(newTimeDeadline);
    }

    public int getTime(){
        return timeDeadline;
    }

    public void setTime(int newTimeDeadline) throws InvalidSpecPackException{
        if(newTimeDeadline >= 9 && newTimeDeadline<=16){
        timeDeadline= newTimeDeadline;
        }
        else{
           throw new InvalidSpecPackException(newTimeDeadline);
        }
    }

    public String toString(){
        return super.toString() +" Time:"+ getTime();// here we are calling the tostring method from the parent class
    }


}






