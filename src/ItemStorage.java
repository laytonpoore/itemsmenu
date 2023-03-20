import java.io.*;
import java.util.HashMap;

public class ItemStorage implements Serializable {

    HashMap<String, Item> items = new HashMap<>();
    private File file = new File("items.txt");

    public ItemStorage() {

        readObjectFromFile();
    }

    // Add an item to the array
    public void addItem(Item item) {

        items.put(item.getUpc(), item);
        System.out.println(item.getDescription() + ", $" + item.getPrice());
        System.out.println("Item " + items.size() + " has been added \n");

        writeObjectToFile();
    }

    // Lookup an item in the array
    public Item lookupItem(String upc) {
        return items.get(upc);
    }

    // Delete an item from the array
    public Item deleteItem(String upc) {
        System.out.println("Deleted Item \n");
        return items.remove(upc);
    }

    // Displays Items
    public void displayItems() {

        for (String upc : items.keySet()) {
            System.out.println(upc + " - " + items.get(upc).getDescription() + " - $" + items.get(upc).getPrice());
        }
        System.out.println("");
    }

    // Writes an Item to file
    public void writeObjectToFile() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(items);
            output.flush();
            output.close();
        } catch (IOException ioe) {
            System.err.println("Error saving to file");
        }
    }

    // Reads an Item from the file
    public void readObjectFromFile() {

        try {
            if (file.exists()) {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
                items = (HashMap<String, Item>) input.readObject();
                input.close();
            } else {
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
                output.close();
            }
        } catch (IOException ioe) {
            System.err.println("Error opening file");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Item.java does not exist");
        }
    }
}
