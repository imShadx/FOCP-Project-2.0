import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class passGen extends JFrame implements ActionListener {
    //Declaring the following outside the constructor method to use them in the actionListener class

    //checkboxes to customize the generated password
    JCheckBox Upper;
    JCheckBox Special;
    JCheckBox Num;

    //Buttons to do stuff
    JButton generate;
    JButton Home;

    //JLabels to be used in the actionListener instance
    JLabel result1;

    JLabel result2;

    JLabel result3;

    //Strings to customize the password character pool
    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower ="abcdefghijklmnopqrstuvwxyz";
    String num="1234567890";
    String special="<>@#$&*!";
    String characters = lower;
    String Final;

    //Text field to enter the character length
    JTextField in;

    //File where we gonna use the generated passwords
    File file = new File("C:\\Users\\jyath\\Documents\\FOCP Project 2.0 file.txt");

    passGen(){
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(1000,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(45,45,45));

        //declaring all the panels
        JPanel header = new JPanel();
        JPanel button = new JPanel();
        JPanel display = new JPanel();
        JPanel home = new JPanel();

        //setting the panel properties
        header.setBounds(250, 10, 500, 90);
        header.setBackground(new Color(45,45,45));

        button.setBounds(350,330 , 300, 70);
        button.setBackground(new Color(45,45,45));

        display.setBounds(10, 450, 500, 300);
        display.setBackground(new Color(45,45,45));

        home.setBounds(0, 5, 100, 100);
        home.setBackground(new Color(45,45,45));

        //Resizing and Declaring an image icon for the home button
        ImageIcon raw = new ImageIcon("home icon.png");
        Image pro = raw.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(pro);

        //setting up the button for home
        Home = new JButton();
        Home.setIcon(img);
        Home.addActionListener(this);
        Home.setPreferredSize(new Dimension(50, 50));
        Home.setBounds(0,0,50,50);
        Home.setBorder(BorderFactory.createLineBorder(new Color(45,45,45), 2));

        //putting the home button in the home panel
        home.setLayout(null);
        home.add(Home);

        //JLabel for the header ( and its code )
        JLabel Header = new JLabel();

        Header.setText("PASSWORD GENERATOR");
        Header.setHorizontalAlignment(JLabel.CENTER);
        Header.setVerticalAlignment(JLabel.CENTER);
        Header.setForeground(new Color(255,160,11));
        Header.setFont(new Font("Agency FB", Font.BOLD, 45));

        //adding the Header label to the header panel
        header.setLayout(new BorderLayout());
        header.add(Header);

        //JLabel for a simple instruction
        JLabel warn = new JLabel("Please enter the password length:");
        warn.setForeground(new Color(255,160,11));
        warn.setBackground(Color.GREEN);
        warn.setFont(new Font("Agency FB",Font.ITALIC,25));
        warn.setBounds(350,140,500,80);

        //adding the label to the frame
        this.add(warn);

        //adding the text field for input
        in = new JTextField();
        in.setPreferredSize(new Dimension(400, 80));
        in.setBounds(300, 200, 400, 80);
        in.setBackground(new Color(38,38,38));
        in.setForeground(new Color(255,160,11));
        in.setFont(new Font("Agency FB", Font.BOLD,20));
        in.setCaretColor(new Color(255,160,11));
        in.setBorder(BorderFactory.createLineBorder(new Color(255,160,11),5));

        //adding the text field to the frame
        this.add(in);

        //setting up the generate button
        generate = new JButton("Generate");
        generate.addActionListener(this);
        generate.setForeground(new Color(255,160,11));
        generate.setBackground(new Color(38,38,38));
        generate.setFont(new Font("Agency FB",Font.BOLD,30));
        generate.setBounds(0,0,300,70);
        generate.setBorder(BorderFactory.createLineBorder(new Color(255,160,11), 8));
        generate.setFocusable(false);

        //adding the button to the button panel
        button.setLayout(null);
        button.add(generate);

        //adding the statements inside the display Panel
        JLabel fixed  = new JLabel("your passwords: ");
        fixed.setForeground(new Color(255,160,11));
        fixed.setFont(new Font("Agency FB",Font.BOLD,25));
        fixed.setBounds(10,10,500,70);

        result1 = new JLabel();
        result2 = new JLabel();
        result3 = new JLabel();  //declared outside the method

        result1.setForeground(new Color(255,160,11));
        result1.setFont(new Font("Agency FB",Font.BOLD,25));
        result1.setBounds(20,100,500,40);

        result2.setForeground(new Color(255,160,11));
        result2.setFont(new Font("Agency FB",Font.BOLD,25));
        result2.setBounds(20,160,500,40);

        result3.setForeground(new Color(255,160,11));
        result3.setFont(new Font("Agency FB",Font.BOLD,25));
        result3.setBounds(20,220,500,40);

        //adding all this to the display panel

        display.setLayout(null);
        display.add(fixed);
        display.add(result1);
        display.add(result2);
        display.add(result3);

        //adding the check boxes to help customize the generated password

        Upper = new JCheckBox("Include Upper Case Characters");
        Upper.setFont(new Font("Agency FB", Font.ITALIC, 25));
        Upper.setForeground(new Color(255,113,11));
        Upper.setFocusable(false);
        Upper.setBackground(new Color(45,45,45));
        Upper.setBounds(710, 280, 300, 50);



        Special = new JCheckBox("Include Special Characters");
        Special.setFont(new Font("Agency FB", Font.ITALIC, 25));
        Special.setFocusable(false);
        Special.setBackground(new Color(45,45,45));
        Special.setForeground(new Color(255,113,11));
        Special.setBounds(710, 340, 250, 50);

        Num = new JCheckBox("Include Numerical Characters");
        Num.setFont(new Font("Agency FB", Font.ITALIC, 25));
        Num.setFocusable(false);
        Num.setBackground(new Color(45,45,45));
        Num.setForeground(new Color(255,113,11));
        Num.setBounds(710, 400, 250, 50);

        //adding the check boxes to the frame
        this.add(Upper);
        this.add(Special);
        this.add(Num);

        //adding the panels to the frame
        this.add(header);
        this.add(button);
        this.add(display);
        this.add(home);
    }

    //ActionListener class used to generate the output by executing the code when the use clicks the generate button

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Home){
            this.dispose();
            SwingUtilities.invokeLater(() -> {
                // Create and show the frame on the EDT
                new Home();
            });
        }

        if(e.getSource()==generate) { //the source of the action being the generate button
            String n = in.getText();
            result1.setText("");
            result2.setText("");
            result3.setText(""); //setting the result labels empty for when the loop starts over again
            try {
                int a = Integer.parseInt(n);//converting the string into an integer for the password length
                result1.setForeground(new Color(255,160,11));

                if (a < 5 || a > 15) {
                    result1.setText("length must be between 5 and 15");
                } else {
                    char[] password1 = new char[a];
                    char[] password2 = new char[a];
                    char[] password3 = new char[a]; //creating three arrays for three different outputs
                    Random r = new Random();  //rabdom class used to select random characters in a given limit
                    Upper.setForeground(new Color(255,113,11));
                    Num.setForeground(new Color(255,113,11));
                    Special.setForeground(new Color(255,113,11));
                    characters = lower;

                    //adding characters as the user checks the different check boxes

                    if(Upper.isSelected()){
                        Upper.setForeground(new Color(85,107,47));
                        characters+= upper;
                    }
                    if(Special.isSelected()){
                        Special.setForeground(new Color(85,107,47));
                        characters+= special;
                    }
                    if(Num.isSelected()){
                        Num.setForeground(new Color(85,107,47));
                        characters+= num;
                    }
                    for(int i=0;i<a;i++){
                        password1[i] = characters.charAt(r.nextInt(characters.length())); //choosing a random character from the whole length of the characters array
                        password2[i] = characters.charAt(r.nextInt(characters.length()));
                        password3[i] = characters.charAt(r.nextInt(characters.length()));
                    }
                    result1.setText(Final = new String(password1));
                    result2.setText(Final = new String(password2));
                    result3.setText(Final = new String(password3)); //produces the output by turning the generated password array into a String

                    //File Writer code for saving the generated passwords in the specified file

                    try{
                        FileWriter file = new FileWriter("C:\\Users\\jyath\\Documents\\FOCP Project 2.0 file.txt");
                        file.write(String.valueOf(password1)+"\n");
                        file.write(String.valueOf(password2)+"\n");
                        file.write(String.valueOf(password3)+"\n");
                        file.close();
                    }
                    catch(IOException exception){
                        result1.setText("File could not be saved");
                    }


                }

            }

            catch(NumberFormatException exception){
                result1.setForeground(new Color(255,113,11));
                result1.setText("Enter a valid Input");
            }

        }
    }
}
