package NestedClasses.challange.PlayList_Challange;

public class Song{
    private String title; 
    private double duration;
    
    public Song(String title, double duration){
        this.duration = duration;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", title, duration);
    }

}