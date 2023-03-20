import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ItemStorage storage = new ItemStorage();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            // Prompts user to select an option 1-4
            System.out.println("Select 1, 2, 3, 4, or 5!");
            System.out.println("1. Add Item");
            System.out.println("2. Lookup Item");
            System.out.println("3. Delete Item");
            System.out.println("4. Display Item's");
            System.out.println("5. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                // User chooses option 1 - Adds an item to the list
                case 1 -> {
                        System.out.println("Enter UPC:");
                        String upc = scanner.nextLine();
                        System.out.println("Enter Description:");
                        String description = scanner.nextLine();
                        System.out.println("Enter Price:");
                        int price = scanner.nextInt();
                        scanner.nextLine();

                        // Adds item to the array
                        storage.addItem(new Item(upc, description, price));
                }

                // User chooses option 2 - Searches for an item from the list
                case 2 -> {
                    System.out.println("Enter UPC you wish to search:");
                    String upcLookup = scanner.nextLine();

                    // Looks for Item via UPC
                    Item item = storage.lookupItem(upcLookup);

                    if (item != null) {
                        System.out.println(item.getDescription() + ", $" + item.getPrice());
                        System.out.println("");
                    } else {
                        System.out.println("Item not found.");
                    }
                }

                // User chooses option 3 - Deletes an item from the list
                case 3 -> {
                    System.out.println("Enter UPC you wish to delete:");
                    String upcDelete = scanner.nextLine();

                    // Delete Item via UPC
                    storage.deleteItem(upcDelete);
                }

                // User chooses option 4 - Displays all added Item's
                case 4 -> {
                    storage.displayItems();
                }

                // User chooses option 5 - Exit's the application
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }

                // User inserts an invalid value
                default -> {
                    System.out.println("Invalid Value...");
                }
            }
        }
    }
}