import java.util.ArrayList;
import java.util.HashMap;

public class ContactManager {

    public static void main(String[] args) {
    
        // Create the HashMap to store contacts
        HashMap<String, Contact> contacts = new HashMap<>();

        // Add contacts to the HashMap
        contacts.put(
            "Ada Lovelace",
            new Contact("Ada Lovelace", "+1 617 555 0101")
        );

        contacts.put(
            "Alan Turing",
            new Contact("Alan Turing", "+1 617 555 0102")
        );

        contacts.put(
            "Grace Hopper",
            new Contact("Grace Hopper", "+1 617 555 0103")
        );

        contacts.put(
            "Katherine Johnson",
            new Contact("Katherine Johnson", "+1 617 555 0104")
        );

        contacts.put(
            "Tim Berners-Lee",
            new Contact("Tim Berners-Lee", "+1 617 555 0105")
        );



        System.out.println("=== Contact lookup==="); 
         // Look up an existing contact   
        Contact foundContact = contacts.get("Ada Lovelace");

        // found contact
       if(foundContact == null) {
            System.out.println("Contact not found.");
       }else {
            System.out.println(foundContact);
       }

        // Test a contact that does not exist
        Contact missingContact = contacts.get("John Smith"); 

       // missing contact 
       if ( missingContact == null){
             System.out.println("Contact not found."); 
       } else{
            System.out.println(missingContact);
        }
        
        // Create ArrayList from HashMap values
        ArrayList<Contact> sorted =  
            new ArrayList<>(contacts.values());
        
        // Sort alphabetically by Name  
        sorted.sort(
             (a,b) -> a.getName().compareTo(b.getName())
        );

        // print sorted contact list 
        System.out.println(); 
        System.out.println("=== All Contacts ===");

        // Print all contacts
        for (Contact contact: sorted){
            System.out.println(contact);
        }
    }
}