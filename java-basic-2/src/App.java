import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Create an ArrayList to store integers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements to the ArrayList
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Access elements in the ArrayList
        System.out.println("First element: " + numbers.get(0));
        System.out.println("Second element: " + numbers.get(1));
        System.out.println("Third element: " + numbers.get(2));

        // Update an element in the ArrayList
        numbers.set(1, 25);
        System.out.println("Updated second element: " + numbers.get(1));

        // Remove an element from the ArrayList
        numbers.remove(0);
        System.out.println("After removing first element: " + numbers);

        // Check if the ArrayList contains a specific element
        System.out.println("Contains 30? " + numbers.contains(30));

        // Get the size of the ArrayList
        System.out.println("Size of the ArrayList: " + numbers.size());
    }
}
