public class Image {

    private String url;
    private String description;
    private String title;

    Image (String url, String description, String title) {
        this.url = url;
        this.description = description;
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){
        return "Image title: " + this.title +
                "\n Image url :" + this.url +
                "\n Image description: " + this.description;
    }

}