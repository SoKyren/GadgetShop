public class MP3 extends Gadget // Extends gadget class and adds a memory management system
{
    private int availableMemory; // Adds the memory attribute (MP3 specific)

    public MP3(String model, double price, int weight, String size, int memory  ) // Constructor for MP3, also uses super()
    {
        super(model, price, weight, size); // Calls parent constructor

        this.availableMemory = memory; // Initialises MP3 specific attribute

    }

    public int getAvailableMemory() 
    {
        return availableMemory; // returns the current available memory.
    }

    public void downloadMusic(int size)
    {
        if (size <= 0)
        {
            System.out.println("Download size must be greater than 0.");
            return;
        }

        if (size > availableMemory)
        {
            System.out.println("Insufficient memory available.");
            return;
        }

        availableMemory -= size;

        System.out.println("Music downloaded successfully.");
        System.out.println("Remaining memory: " + availableMemory);
    }

    public void deleteMusic(int size) // Adds memory back when music is deleted
    {
        availableMemory += size;
        System.out.println("Music successfully deleted!");
    }

    @Override

    public void display()
    {
        super.display();
        System.out.println("Available Memory: " + availableMemory);
    }
}

