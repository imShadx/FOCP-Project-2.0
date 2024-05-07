import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strength extends JFrame implements ActionListener{
    //Declaring variables/objects to be used in other classes outside the constructor method
    JTextField Input;
    JButton click;
    JLabel Text1;
    JLabel Text2a;
    JLabel Text2b;
    JLabel Text2c;
    JButton Home;
    String pass;

    Strength(){
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(45,45,45));

        //declaring the Panels to start with the layout
        JPanel header = new JPanel();
        JPanel home = new JPanel();
        JPanel text1 = new JPanel();
        JPanel text2 = new JPanel();

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
        home.setBounds(0, 5, 100, 100);
        home.setBackground(new Color(45,45,45));
        home.setLayout(null);
        home.add(Home);

        //Declaring above panels' properties
        text1.setBounds(10, 380, 500, 40);
        text1.setBackground(new Color(45,45,45));

        text2.setBounds(50,430, 500, 370 );
        text2.setBackground(new Color(45,45,45));

        header.setBounds(250, 10, 500, 90);
        header.setBackground(new Color(45,45,45));

        //Declaring the labels to be used in above panels
        Text1 = new JLabel();
        Text2a = new JLabel();
        Text2b = new JLabel();
        Text2c = new JLabel(); //declare outside this method
        JLabel Header = new JLabel();

        //setting up the properties of these labels
        Text1.setForeground(new Color(255,160,11));
        Text1.setFont(new Font("Agency FB", Font.BOLD, 25));
        Text1.setHorizontalAlignment(JLabel.LEFT);
        Text1.setVerticalAlignment(JLabel.CENTER);

        Text2a.setForeground(new Color(255,113,11));
        Text2a.setFont(new Font("Agency FB", Font.BOLD, 30));
        Text2a.setBounds(5,10,500,40);

        Text2b.setForeground(new Color(255,113,11));
        Text2b.setFont(new Font("Agency FB", Font.BOLD, 30));
        Text2b.setBounds(5,70,500,40);

        Text2c.setForeground(new Color(255,113,11));
        Text2c.setFont(new Font("Agency FB", Font.BOLD, 30));
        Text2c.setBounds(5,130,500,40);

        Header.setText("Strength Checker");
        Header.setForeground(new Color(255,160,11));
        Header.setFont(new Font("Agency FB", Font.BOLD,40));
        Header.setHorizontalAlignment(JLabel.CENTER);

        //JLabel for a simple instruction
        JLabel warn = new JLabel("Please enter your password:");
        warn.setForeground(new Color(255,160,11));
        warn.setBackground(Color.GREEN);
        warn.setFont(new Font("Agency FB",Font.ITALIC,25));
        warn.setBounds(350,140,500,80);

        this.add(warn);

        //adding above labels to their respective panels

        text1.setLayout(new BorderLayout());
        text1.add(Text1);

        text2.setLayout(null);
        text2.add(Text2a);
        text2.add(Text2b);
        text2.add(Text2c);

        header.setLayout(new BorderLayout());
        header.add(Header);

        //coding the text Field for the input
        Input = new JTextField();
        Input.setPreferredSize(new Dimension(400,80));
        Input.setBounds(300, 200, 400, 80);
        Input.setForeground(new Color(255,160,11));
        Input.setBackground(new Color(45,45,45));
        Input.setFont(new Font("Agency FB", Font.BOLD,25));
        Input.setBorder(BorderFactory.createLineBorder(new Color(255,160,11), 8));

        //coding the button for taking input
        click = new JButton("Submit");
        click.setFocusable(false);
        click.setBackground(new Color(45,45,45));
        click.setForeground(new Color(255,160,11));
        click.setFont(new Font("Agency FB", Font.BOLD, 30));
        click.setBorder(BorderFactory.createLineBorder(new Color(255,160,11), 8));
        click.setBounds(400, 300, 200, 70);
        click.addActionListener(this);

        //adding the panels to the frame
        this.add(header);
        this.add(home);
        this.add(Input);
        this.add(text1);
        this.add(text2);
        this.add(click);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Home){
            this.dispose();
            SwingUtilities.invokeLater(() -> {
                // Create and show the frame on the EDT
                new Home();
            });
        }

        if(e.getSource()==click) { //executing the command if the "click" button is clicked
            pass = Input.getText();
            Text1.setText("");
            Text2a.setText("");
            Text2a.setForeground(new Color(255,113,11));
            Text2b.setText("");
            Text2b.setForeground(new Color(255,113,11));
            Text2c.setText("");
            Text2c.setForeground(new Color(255,113,11)); //setting default parameters for when the code loops


            if (pass.isEmpty()) {
                Text1.setText("Please Enter a Password");
            } else {

                if (pass.length() > 25 || pass.length() < 5) {
                    Text1.setText("The password must be between 5 and 15 characters");
                } else {
                    //Using pattern to create a pattern to check for and matcher to match that pattern with a given String ( "pass" in this case )
                    Pattern upperCase = Pattern.compile("[A-Z]");
                    Pattern numbers = Pattern.compile("[0-9]");
                    Pattern special = Pattern.compile("[^A-Za-z0-9]");

                    Matcher upper = upperCase.matcher(pass);
                    Matcher number = numbers.matcher(pass);
                    Matcher spec = special.matcher(pass);

                    //Creating a boolean out of the matcher.find() function to manage the code more efficiently and easily

                    boolean a = upper.find();
                    boolean b = number.find();
                    boolean c = spec.find();

                    if (a && b && c && pass.length()>=16) {
                        Text1.setText("The password looks strong");

                        Text2a.setForeground(new Color(85,107,47));
                        Text2a.setText("*uppercase letters");

                        Text2b.setForeground(new Color(85,107,47));
                        Text2b.setText("*numbers");

                        Text2c.setForeground(new Color(85,107,47));
                        Text2c.setText("*special characters");

                    } else {
                        if ((a && b) || (b && c) || (c && a)) { //Looks for the absent parameter and suggest adding em to the user
                            Text1.setText("The password strength is average");
                            if (!a) {
                                Text2a.setText("*Try adding some uppercase letters");
                            }
                            else{
                                Text2a.setForeground(new Color(85,107,47));
                                Text2a.setText("*uppercase letters");
                            }
                            if (!b) {
                                Text2b.setText("*Try adding some numbers");
                            }
                            else{
                                Text2b.setForeground(new Color(85,107,47));
                                Text2b.setText("*numbers");
                            }
                            if (!c) {
                                Text2c.setText("*Try adding some special characters");
                            }
                            else{
                                Text2c.setForeground(new Color(85,107,47));
                                Text2c.setText("*special characters");
                            }
                        } else {
                            Text1.setText("The password seems pretty weak");
                            if (!a) {
                                Text2a.setText("*Try adding some uppercase letters");
                            }
                            else{
                                Text2a.setForeground(new Color(85,107,47));
                                Text2a.setText("*uppercase letters");
                            }
                            if (!b) {
                                Text2b.setText("*Try adding some numbers");
                            }
                            else{
                                Text2b.setForeground(new Color(85,107,47));
                                Text2b.setText("*numbers");
                            }
                            if (!c) {
                                Text2c.setText("*Try adding some special characters");
                            }
                            else{
                                Text2c.setForeground(new Color(85,107,47));
                                Text2c.setText("*special characters");
                            }
                        }
                    }


                }
            }

        }
    }
}
