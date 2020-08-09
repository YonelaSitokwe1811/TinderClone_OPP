import java.util.*;

public class TinderSwipe {

    Database db;

    TinderSwipe() {
        Database db = new Database();
        this.db = db;
    }

    public ArrayList<Profile> getProfilesByPreference(String option) {
        this.db.getProfiles("./profiles.csv");
        return db.getProfilesByPreference(option);
    }

    public void handleSwipeRight(Profile p){
        this.db.WritetoCSV(p);
    }
        
}