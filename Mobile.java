public class Mobile extends Gadget // Extends Gadget class and adds calling functionality
{
    private int credit; // Adds the credit attribute (mobile specific)

    public Mobile(String model, double price, int weight, String size, int credit) // Constructor for mobile, uses super() to initialise inherited attributes
    {
        super(model, price, weight, size); // Calls the constructor of the Gadget (parent) class

        this.credit = credit; // Initialises new attribute
    }

    public int getCredit() 
    {
        return credit; // returns the credit balance
    }

    public void addCredit(int amount) // Adds credit to the mobile if amount exceeds 0
    {
        if (amount > 0)
        {
            credit += amount; // Increases credit
            System.out.println("Credit added. New balance: " + credit);

        }
        else
        {
            System.out.println("Invalid credit amount");
        }

    }

    public void makeCall(String phoneNumber, int duration)
    {
        if (duration <= 0)
        {
            System.out.println("Call duration must be greater than 0.");
            return;
        }

        if (duration > credit)
        {
            System.out.println("Not enough credit to make this call.");
            return;
        }

        credit -= duration;

        System.out.println("Calling " + phoneNumber +
            " for " + duration + " minutes.");
        System.out.println("Remaining credit: " + credit);
    }

    @Override // overrides display method to include credit information

    public void display()
    {
        super.display(); // Calls Gadget display method
        System.out.println("Credit: " + credit); // Displays new credit balance after call
    }

}