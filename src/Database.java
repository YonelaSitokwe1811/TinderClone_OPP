import java.io.*;
import java.util.*;

public class Database{



    ArrayList<Profile> profiles = new ArrayList<Profile>();
    FileWriter csvWriter;


    public Database(){
        try {
            csvWriter = new FileWriter("Swipes.csv");
        }
        catch(Exception e) {
            System.out.print("Error: " + e.toString());
        }
        
        this.csvWriter = csvWriter;
    }

    public ArrayList<Profile> getProfiles(String csvfile){

        
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvfile));
            int i = 0;
            while ((line = br.readLine()) != null) {

                if(i>0) {
                    // use comma as separator
                    String[] splitLine  = line.split(cvsSplitBy);

                    // System.out.println(splitLine[0] + " " + splitLine[1] + " " + splitLine[2] + " " + splitLine[3] + " " + splitLine[4] );
                    Person p = new Person(splitLine[0],Integer.parseInt(splitLine[1]),splitLine[2],splitLine[3],splitLine[4]);
                    Image first = new Image (splitLine[5],splitLine[6],splitLine[7]);
                    Image second = new Image (splitLine[8],splitLine[9],splitLine[10]);
                    Image third = new Image (splitLine[11],splitLine[12],splitLine[13]);


                    Image[] images = new Image[3];
                    images[0] = first;
                    images[1] = second;
                    images[2] = third;

                    Profile profile = new Profile(p,images);

                    this.profiles.add(profile);
                }
                i++;
                
            }

            // System.out.println(this.profiles);
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return this.profiles;
        
    }

    public ArrayList<Profile> getProfilesByPreference(String preference) {
        ArrayList<Profile> newList = new ArrayList<Profile>();

        if(preference.toUpperCase().charAt(0) == 'N') 
            return this.profiles;

        for(Profile p: this.profiles) {
            // System.out.println(p.getPerson().getGender().toUpperCase());
            if((p.getPerson().getGender().toUpperCase().charAt(0) == preference.toUpperCase().charAt(0))) {
                newList.add(p);
            }
        }

        return newList;
    }

    public void WritetoCSV(Profile p){

        Person person = p.getPerson();
        List<List<String>> rows = Arrays.asList(
            Arrays.asList(person.getName(),person.getAge()+"",person.getGender(),person.getLocation(),person.getBio())
        );

            

        try {
           

            for (List<String> rowData : rows) {
                this.csvWriter.append(String.join(",", rowData));
                this.csvWriter.append("\n");
            }
    
            this.csvWriter.flush();
            // this.csvWriter.close();
        }
        catch(Exception e) {
            System.out.print("Error: " + e.toString());
        }
        
        
    }
}