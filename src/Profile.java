public class Profile{

    Person person;
    Image[] images;

    Profile(Person person, Image[] images){
        this.person = person;
        this.images = images;
    }

    public Person getPerson() {
        return this.person;
    }
    public void setPerson(Person person){
        this.person = person;
    }

    public Image[] getImages() {
        return this.images;
    }
    public void setImages(Image[] images){
        this.images = images;
    }

    public String toString(){

        return "Name: " + this.person.getName() 
        +" \n Gender: " + this.person.getGender() 
        + "\n Age: " + this.person.getAge() 
        + "\n Bio: " + this.person.getBio() 
        + "\n Image1: " + this.images[0] 
        + "\n Image2: " + this.images[1]
        + "\n Image3: " + this.images[2];
    }


}