public class Gadget
{
    // Instance variables (attributes shared by all gadgets)
    private String model;
    private double price;
    private int weight;
    private String size;

    public Gadget(String model, double price, int weight, String size) // Constructor - Initialises all common attributes
    {
        // 'this' refers to the current object, differentiating between attributes and parameters
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;

    }
    // Accessor methods (getters)

    public String getModel()
    {
        return model;
    }

    public double getPrice()
    {
        return price;
    }

    public int getWeight()
    {
        return weight;
    }

    public String getSize()
    {
        return size;
    }

    public void display() // Displays the gadget's basic information (can be overriden in subclasses)
    {
        System.out.println("Model: " + model);
        System.out.println("Price(£): " + price);
        System.out.println("Weight(g): " + weight);
        System.out.println("Size: " + size);
    }
}