import java.util.*;

public class TinderApp {

    public static String getPreferenceAsFull(String letter) {
        if(letter.equals("M")) 
            return "Male";
        if(letter.equals("F")) 
            return "Female";
        return "No preference";
        
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Tinder App java basic edition\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("Select your preference before swiping - Type 'm' for Male, 'f' for Female and 'n' for No preference");
        String preference = sc.nextLine().toUpperCase();

        System.out.println("Awesome! You have selected a preference of " + getPreferenceAsFull(preference) + ".");
        
        System.out.println("\nLets get started with swiping. Swipe right (r) to match, Swipe left (l) to skip. Press (q) to exit app.");
        
        Person akhil = new Person("Akhil", 22, "Male", "Nairobi", "Sizzling and spicy ;)");
        Image first = new Image
        ("testurl", 
        "Me being happy",
        "happy");
        Image second = new Image
        ("testurl", 
        "Me being angry",
        "angry");
        Image third = new Image
        ("testurl", 
        "Me being funny",
        "funny");

        Image[] images = new Image[3];
        images[0] = first;
        images[1] = second;
        images[2] = third;

        Profile signedInUser = new Profile(akhil, images);

        TinderSwipe ts = new TinderSwipe();
        ArrayList<Profile> profiles = ts.getProfilesByPreference(preference);

        String input = "";
        
        Iterator<Profile> iterator = profiles.iterator();

        System.out.println("PROFILE DATA");
        Profile activeProfile = iterator.next();
        System.out.println(activeProfile);
        input = sc.nextLine();
       
        while (iterator.hasNext()) {
            
            System.out.println("\n\nPROFILE DATA");
            if(input.toUpperCase().equals("R")) {
                ts.handleSwipeRight(activeProfile);
            }

            activeProfile = iterator.next();
            System.out.println(activeProfile);   
            
            input = sc.nextLine();       
        } 

        if(input.toUpperCase().equals("R")) {
            ts.handleSwipeRight(activeProfile);
        }

        System.out.println("Your swipes have been recorded!");
        System.out.println("Thank you so much for using Tinder clone!");





    }
}