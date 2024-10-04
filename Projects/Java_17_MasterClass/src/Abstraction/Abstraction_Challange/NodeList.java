package Abstraction.Abstraction_Challange;

public interface NodeList {
    
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
    
}