import javax.swing.*; // Imports all Swing classes (JFrame, JButton, JTextField and more)
import java.awt.*; // Imports layout managers like FlowLayout GridLayout and BorderLayout
import java.awt.event.*; // Imports event handling classes like ActionListener
import java.util.ArrayList; // Imports ArrayList to store Gadget objects

public class GadgetShop extends JFrame implements ActionListener // class extends JFrame to become GUI window. Implements ActionListener - responds to button clicks
{
    // Text fields for common Gadget details
    // Labels stay as local variables as they do not change and nothing is read from them
    private ArrayList<Gadget> gadgets = new ArrayList<>(); // ArrayList to store gadget objects
    private JTextField modelField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField sizeField;
    // Text fields for Mobile-specific details
    private JTextField creditField;
    private JTextField phoneField;
    private JTextField durationField;
    // Text fields for MP3-specific details
    private JTextField memoryField;
    private JTextField downloadField;
    // Text field for selecting a gadget from the ArrayList
    private JTextField displayField; // Stores the display number (index of gadget in ArrayList)
    // Buttons for performing system actions
    private JButton addMobileButton;    
    private JButton addMP3Button;       
    private JButton clearButton;       
    private JButton displayAllButton;   
    private JButton makeCallButton;     
    private JButton downloadButton;
    public GadgetShop() // Constructor
    {
        gadgets = new ArrayList<>(); // Initialise ArrayList to hold gadgets
        setTitle("Gadget Shop"); // Set window title
        setSize(700, 600); // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes properly
        setLayout(new BorderLayout()); // Layout manager
        // Creating a panel for the title
        JPanel titlePanel = new JPanel(); // New panel to hold title
        JLabel titleLabel = new JLabel("Gadget Shop Management System"); // Creates title text
        titlePanel.add(titleLabel); // Add title to panel
        add(titlePanel, BorderLayout.NORTH); // Add title panel to top of window
        // Center Panel
        JPanel centerPanel = new JPanel(); // Center panel will hold all input sections
        centerPanel.setLayout(new GridLayout(4, 1)); // 3 rows and 1 column
        // Panel for common gadget details
        JPanel gadgetPanel = new JPanel();
        gadgetPanel.setLayout(new GridLayout(4, 2)); // 4 rows (model, price, weight, size) 2 columns
        gadgetPanel.setBorder(BorderFactory.createTitledBorder("Gadget Details")); // Adds section title
        // Labels and text fields
        JLabel modelLabel = new JLabel("Model:");
        modelField = new JTextField(15);

        JLabel priceLabel = new JLabel("Price(£):");
        priceField = new JTextField(15);

        JLabel weightLabel = new JLabel("Weight(g):");
        weightField = new JTextField(15);

        JLabel sizeLabel = new JLabel("Size(mm):");
        sizeField = new JTextField(15);

        // Add components to gadget panel
        gadgetPanel.add(modelLabel);
        gadgetPanel.add(modelField);

        gadgetPanel.add(priceLabel);
        gadgetPanel.add(priceField);

        gadgetPanel.add(weightLabel);
        gadgetPanel.add(weightField);

        gadgetPanel.add(sizeLabel);
        gadgetPanel.add(sizeField);

        //Mobile-specific panel
        JPanel mobilePanel = new JPanel();
        mobilePanel.setLayout(new GridLayout(3, 2));
        mobilePanel.setBorder(BorderFactory.createTitledBorder("Mobile Details"));

        JLabel creditLabel = new JLabel("Initial Credit(minutes):");
        creditField = new JTextField(15);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneField = new JTextField(15);

        JLabel durationLabel = new JLabel("Call Duration(minutes):");
        durationField = new JTextField(15);

        // Add components to mobile panel
        mobilePanel.add(creditLabel);
        mobilePanel.add(creditField);

        mobilePanel.add(phoneLabel);
        mobilePanel.add(phoneField);

        mobilePanel.add(durationLabel);
        mobilePanel.add(durationField);

        //MP3-specific panel
        JPanel mp3Panel = new JPanel();
        mp3Panel.setLayout(new GridLayout(2, 2));
        mp3Panel.setBorder(BorderFactory.createTitledBorder("MP3 Details"));

        JLabel memoryLabel = new JLabel("Initial Memory(MB):");
        memoryField = new JTextField(15);

        JLabel downloadLabel = new JLabel("Download Size(MB):");
        downloadField = new JTextField(15);

        // Add components to MP3 panel
        mp3Panel.add(memoryLabel);
        mp3Panel.add(memoryField);

        mp3Panel.add(downloadLabel);
        mp3Panel.add(downloadField);

        // Display Number Panel 

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout());
        displayPanel.setBorder(BorderFactory.createTitledBorder("Select Gadget"));

        JLabel displayLabel = new JLabel("Display Number:");
        displayField = new JTextField(5);

        displayPanel.add(displayLabel);
        displayPanel.add(displayField);
        // Sectioning center panel
        centerPanel.add(gadgetPanel);
        centerPanel.add(mobilePanel);
        centerPanel.add(mp3Panel);
        centerPanel.add(displayPanel);

        add(centerPanel, BorderLayout.CENTER); // Add center panel to window

        // Button section
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3)); // 2 rows, 3 columns for buttons

        addMobileButton = new JButton("Add Mobile");
        addMP3Button = new JButton("Add MP3");
        clearButton = new JButton("Clear");
        displayAllButton = new JButton("Display All");
        makeCallButton = new JButton("Make Call");
        downloadButton = new JButton("Download Music");

        buttonPanel.add(addMobileButton);
        buttonPanel.add(addMP3Button);
        buttonPanel.add(clearButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(makeCallButton);
        buttonPanel.add(downloadButton);

        add(buttonPanel, BorderLayout.SOUTH); // Add button section to bottom
        // Register buttons with ActionListener so clicks are detected
        addMobileButton.addActionListener(this);
        addMP3Button.addActionListener(this);
        clearButton.addActionListener(this);
        displayAllButton.addActionListener(this);
        makeCallButton.addActionListener(this);
        downloadButton.addActionListener(this); 
        setVisible(true); // Makes window visible
    }

    public void addMobile (String model, double price, int weight, String size, int credit) // Method adding mobile
    {
        Mobile mobile = new Mobile(model, price, weight, size, credit); // Create a new Mobile object using the provided detail
        gadgets.add(mobile); // Adds the mobile object to the gadgets list
    }

    public void addMP3 (String model, double price, int weight, String size, int memory)
    {
        MP3 mp3 = new MP3(model, price, weight, size, memory);
        gadgets.add(mp3); 
    }

    public void displayAll() // Method to display all gadgets
    {

        if (gadgets.isEmpty()) // Checks if list has no gadgets
        {
            JOptionPane.showMessageDialog(this, "No gadgets have been added yet.");
            return;
        }

        for (int i = 0; i < gadgets.size(); i++) // Loop through all gadgets stored in the ArrayList 
        {
            System.out.println("Gadget number: " + (i + 1)); // Displays index of gadget
            gadgets.get(i).display(); // Retrieve the gadget at position i and call its display method
            System.out.println(); // readability
        }
    }

    public void makeCall(int index, String number, int duration) // Method to make a call
    {
        if (index >= 0 && index < gadgets.size()) // Validity checks for index
        {
            Gadget gadget = gadgets.get(index);

            if (gadget instanceof Mobile) // Check type - prevents crash if MP3 is called to makeCall
            {
                Mobile mobile = (Mobile) gadget; // Sends gadget at index to mobile
                mobile.makeCall(number, duration); // Executes the call
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Selected gadget is not a mobile.");
            }
        }
    }

    public void downloadMusic(int index, int size)
    {
        if (index >= 0 && index < gadgets.size())
        {
            Gadget gadget = gadgets.get(index);

            if (gadget instanceof MP3) // Check type - Prevents crash is mobile is called to download
            {
                MP3 mp3 = (MP3) gadget; 
                mp3.downloadMusic(size); // Downloads music of specified size
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Selected gadget is not an MP3 player.");
            }
        }
    }


    public String getModel() // Returns model entered by user
    {
        return modelField.getText(); // Get text from model text field
    }

    public String getGadgetSize() 
    {
        return sizeField.getText();
    }

    public String getPhoneNumber() 
    {
        return phoneField.getText();
    }

    public double getPrice() // Returns price entered by user as a double
    {
        return Double.parseDouble(priceField.getText()); // Converts price from String to Double

    }

    public int getWeight()
    {
        return Integer.parseInt(weightField.getText());
    }

    public int getCredit()
    {
        return Integer.parseInt(creditField.getText());

    }

    public int getMemory()
    {
        return Integer.parseInt(memoryField.getText());
    }

    public int getDuration() 
    {
        return Integer.parseInt(durationField.getText());

    }

    public int getDownloadSize() 
    {
        return Integer.parseInt(downloadField.getText());

    }

    // Returns display number and returns -1 if input is invalid
    public int getDisplayNumber()
    {
        int displayNumber = -1; // Initialise display number to -1

        try
        {
            displayNumber = Integer.parseInt(displayField.getText()) -1; // Convert text input to integer

            if (displayNumber < 0 || displayNumber >= gadgets.size()) // Check if number is within arraylist
            {
                JOptionPane.showMessageDialog(this, "Display number is out of range.");

                displayNumber = -1; //Reset to -1 if invalid
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Display number must be an integer"); // If input is not an integer
        }

        return displayNumber; // Return valid number or -1
    }

    public void actionPerformed(ActionEvent e) // Required for ActionListener. Will run whenever a registered button is pressed
    {
        if (e.getSource() == addMobileButton) // Check if "Add Mobile" button was clicked
        // Get input values using input methods
            try
            {
                String model = getModel(); 
                if (model.trim().isEmpty()) // checks if model field is empty. trim() prevents spaces passing as valid inputs
                {
                    JOptionPane.showMessageDialog(this, "Model cannot be empty.");
                    return; // Stops method if invalid
                }
                double price = getPrice();
                int weight = getWeight();
                String size = getGadgetSize();
                int credit = getCredit();
                if (price < 0 || weight < 0 || credit < 0)
                {
                    JOptionPane.showMessageDialog(this, "Values cannot be negative.");
                    return;
                }

                // Call existing method to add the mobile object
                addMobile(model, price, weight, size, credit);

                JOptionPane.showMessageDialog(this, "Mobile added successfully.");
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
            }

        else if (e.getSource() == addMP3Button) 
            try
            {
                String model = getModel(); 
                if (model.trim().isEmpty()) // checks if model field is empty. trim() prevents spaces passing as valid inputs
                {
                    JOptionPane.showMessageDialog(this, "Model cannot be empty.");
                    return; // Stops method if invalid
                }
                double price = getPrice();
                int weight = getWeight();
                String size = getGadgetSize();
                int memory = getMemory();
                if (price < 0 || weight < 0 || memory < 0) // Prevents negative values
                {
                    JOptionPane.showMessageDialog(this, "Values cannot be negative.");
                    return;
                }

                // Call existing method to add the mobile object
                addMP3(model, price, weight, size, memory);

                JOptionPane.showMessageDialog(this, "MP3 Player added successfully.");
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
            }

        else if (e.getSource() == displayAllButton)
        {
            displayAll(); // Call method to display all gadgets
        }

        else if (e.getSource() == makeCallButton)
        {
            try
            {
                int index = getDisplayNumber();
                if (index == -1) 
                return; // Stop if invalid

                String phoneNumber = getPhoneNumber();
                int duration = getDuration();

                if (duration <= 0)
                {
                    JOptionPane.showMessageDialog(this, "Duration must be greater than 0.");
                    return;
                }
                makeCall(index, phoneNumber, duration);
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
            }
        }

        else if (e.getSource() == downloadButton)
        {
            try
            {
                int index = getDisplayNumber();  // Get selected gadget index
                if (index == -1) 
                return;  // Stop if invalid
                int downloadSize = getDownloadSize();  // Get download size from textbox
                if (downloadSize <= 0) // Prevent negative or zero values
                {
                    JOptionPane.showMessageDialog(this, "Download size must be greater than 0.");
                    return;
                }
                downloadMusic(index, downloadSize);  // Call method
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric download size.");
            }
        }  

        else if (e.getSource() == clearButton)
        {
            // Clear all text fields
            modelField.setText("");
            priceField.setText("");
            weightField.setText("");
            sizeField.setText("");

            creditField.setText("");
            phoneField.setText("");
            durationField.setText("");

            memoryField.setText("");
            downloadField.setText("");

            displayField.setText("");
        }

    }

    public static void main(String[] args) // Main method to test class
    {
        new GadgetShop(); // Launches GUI window
    }
}

