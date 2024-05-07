import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener, MouseListener {

    //declaring JButtons outside the constructor method to use them in the instance
    JButton pass;
    JButton strength;

    //JLabel hover declared outside the method to be used for the "about animation"
    JPanel hover;

    JPanel image;
    Home(){
        //using the "this" keyboard keyword to set up the basic properties of the frame
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(1000,800);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(45,45,45));

        //coding the basic layout of the page using panels
        JPanel heading = new JPanel();
        JPanel about = new JPanel();
        hover = new JPanel();
        JPanel buttonPass = new JPanel();
        JPanel buttonStrength = new JPanel();
        image = new JPanel();

        //defining the properties of said panels
        heading.setBounds(250,10,500,90);
        heading.setBackground(new Color(45,45,45));

        about.setBounds(900,10,100,60);
        about.setBackground(new Color(45,45,45));
        about.setBorder(BorderFactory.createLineBorder(new Color(45,45,45),4));

        buttonPass.setBounds(60,310,350,80);
        buttonPass.setBackground(new Color(45,45,45));
        buttonPass.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

        buttonStrength.setBounds(60,490,350,80);
        buttonStrength.setBackground(new Color(45,45,45));
        buttonStrength.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));


        //adding the labels i.e. the text in said Panels
        JLabel Heading = new JLabel();
        JLabel About = new JLabel();
        JLabel Image = new JLabel();

        //Resizing and adding an Image Icon
        ImageIcon raw = new ImageIcon("lock.png");
        Image por = raw.getImage().getScaledInstance(300,300, java.awt.Image.SCALE_DEFAULT);
        ImageIcon lock = new ImageIcon(por);

        //adding the image to the label
        Image.setIcon(lock);

        //adding the image label to a panel
        image.setBounds(680, 210, 300, 300);
        image.setBackground(new Color(45,45,45));

        //no need for a label in either of the buttonx frame since we're gonna be using Jbuttons
        // ( declared outside the method so that the interface can access them )

        //setting properties for the labels
        Heading.setText("A Cool Project");
        Heading.setFont(new Font("Agency FB", Font.BOLD, 80));
        Heading.setForeground(new Color(255,160,11));
        Heading.setHorizontalAlignment(JLabel.CENTER);

        About.setText("About");
        About.setFont(new Font("Agency FB",Font.BOLD, 25));
        About.setForeground(new Color(255,160,11));
        About.setHorizontalAlignment(JLabel.CENTER);

        //setting the layouts and adding the labels to respective panels
        heading.setLayout(new BorderLayout());
        heading.add(Heading);

            about.setLayout(new BorderLayout());
            about.add(About);

        image.add(Image);

        //setting the buttons' properties
        pass = new JButton();
        pass.setText("Generate Password");
        pass.setFocusable(false);
        pass.setFont(new Font("Agency FB", Font.BOLD, 45));
        pass.setForeground(new Color(255,160,11));
        pass.setBackground(new Color(45,45,45));
        pass.addActionListener(this);
        pass.setBorder(BorderFactory.createLineBorder(new Color(45,45,45), 0));

        strength = new JButton();
        strength.setText("Strength Checker");
        strength.setFocusable(false);
        strength.setFont(new Font("Agency FB", Font.BOLD, 45));
        strength.setForeground(new Color(255,160,11));
        strength.setBackground(new Color(45,45,45));
        strength.addActionListener(this);
        strength.setBorder(BorderFactory.createLineBorder(new Color(45,45,45), 0));

        //adding the buttons to the panels
        buttonPass.add(pass);
        buttonStrength.add(strength);
        //adding the panels to the frame
        this.add(heading);
        this.add(about);
        this.add(buttonPass);
        this.add(buttonStrength);
        this.add(image);

        //Coding the animated hover screen
        hover.setPreferredSize(new Dimension(400,600));
        hover.setBounds(1000,150,400,600);
        hover.setBackground(new Color(255,160,11));
        About.addMouseListener(this);

        //Label for the text in hover
        JLabel ani = new JLabel();
        String text = "<html>This bare bones Java Program aims to simply<br>" +
                "either generate a random password based on user input<br>" +
                "(The Stronger the better)<br>" +
                "or check the strength/vulnerability of any<br>" +
                "password entered by the user using parameters<br>" +
                "such as the presence of special or numerical characters<br>" +
                "or the character length of the password.<br>" +
                "The Program has been made more user-friendly and appealing<br>" +
                "with the help of Java GUI and many sweats and tears.<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "A Joint Effort by : Yathansh ( 23CSU352 )<br>" +
                "                    Yuva ( 23CSU357 )<br>" +
                "                    Dev ( 23CSU407 )</html>";
        ani.setText(text);
        ani.setFont(new Font("Agency FB", Font.BOLD, 20));
        ani.setForeground(new Color(45,45,45));
        ani.setHorizontalAlignment(JLabel.LEFT);
        ani.setVerticalAlignment(JLabel.TOP);

        //adding the text to hover
        hover.setLayout(new BorderLayout());
        hover.add(ani);

        //adding the hover thingy to the frame
        this.add(hover);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pass){
            this.dispose();
            new passGen();
        }
        if(e.getSource()==strength){
            this.dispose();
            new Strength();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //left empty
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //left empty
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //left empty
    }

    @Override //the panel moves towards the screen as long as the user's cursor hovers over the "about" label
    public void mouseEntered(MouseEvent e) {
        if (hover.getX() >= 1000) {
            // Only move the panel if it's not already on the screen
            Timer timer = new Timer(10, new ActionListener() { // Decreased delay for faster animation
                int end = 600; // Target x-coordinate to stop the animation
                int img_end = 1000;

                @Override
                public void actionPerformed(ActionEvent evt) {
                    int currentX = hover.getX();
                    int currentI = image.getX();
                    if (currentX > end || currentI <img_end) {
                        hover.setLocation(currentX - 10, hover.getY());
                        image.setLocation(image.getX()+10, image.getY());
                    } else {
                        hover.setLocation(600, hover.getY());
                        image.setLocation(1000,image.getY());
                        ((Timer) evt.getSource()).stop(); // getting the object from getSource and converting it to a Timer before stopping the code
                    }
                }
            });
            timer.start(); // Start the timer
        }

    }

    @Override //the panel moves to its initial position outside the screen soon as the user removes their cursor from the "about" label
    public void mouseExited(MouseEvent e) {
        if(hover.getX()<1000){
            Timer timer = new Timer(10, new ActionListener() {
                int end = 1000;
                int img_end = 680;
                @Override
                public void actionPerformed(ActionEvent e) {
                    int current = hover.getX();
                    int currentI = image.getX();

                    if(current<end || currentI>img_end){
                        hover.setLocation(hover.getX()+10,hover.getY());
                        image.setLocation(image.getX()-10,image.getY());
                    }
                    else{
                        ((Timer) e.getSource()).stop();
                    }

                }
            });

            timer.start();
        }
    }
}
