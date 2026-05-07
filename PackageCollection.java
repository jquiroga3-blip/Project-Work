
import java.util.*;
import java.io.*;
public class PackageCollection {
	public static ArrayList<Pack> readPackages (String fileName, ArrayList<String> errors) throws IOException{
	
		File file = new File(fileName);
		Scanner readFile = new Scanner(file);// this will read the file the user entered 
		ArrayList<Pack> data= new ArrayList<>(); // creating the array where the packages/specpac will be stored
		//ArrayList<String> errors= new ArrayList<>(); // this will store the errors that we will write to the log file
		//now we must add it to the Pack object while the file has more values
		while(readFile.hasNextLine()){
			
			// we put this inside the loop bc we want it for one line at a time not the whole thing 
			String stringFile= readFile.nextLine();// this will store the file contents into a string
			try{
			String [] stringData = stringFile.split(",");// this will split the file contents by the comma 

		//remember we need the date objects not string 
			String dateValues[]= stringData[3].split("/");
			int month = Integer.parseInt(dateValues[0]);
			int day= Integer.parseInt(dateValues[1]);
			int year= Integer.parseInt(dateValues[2]);
			Date date= new Date(month, day, year);
			
				if(stringData[0].equals("R")){
					data.add(new Pack( stringData[1], 
						stringData[2], date,
						 Integer.parseInt(stringData[4]),
						  Integer.parseInt(stringData[5])));// here we must change the last two things in the object to ints
					//slotsUsed++;
				}
				else{
					data.add(new SpecPack(stringData[1], 
						stringData[2], date,
						 Integer.parseInt(stringData[4]), 
						 Integer.parseInt(stringData[5]), 
						 Integer.parseInt(stringData[6]) ));
					//slotsUsed++;
				}
			}catch(Exception e){
				//data.add(null);
				errors.add( e.getClass().getSimpleName() + " - " + e.getMessage());
    			continue;
		}
	}
			return data;
}

}