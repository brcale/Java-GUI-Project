import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.*;
import java.lang.*;
import java.util.*;

class MyFrame 
    extends JFrame 
    implements ActionListener { 
    // objects of the form 
    private Container fr; 
    private JLabel formTitle; 
    private JLabel name; 
    private JTextField textBoxName; 
    private JLabel email; 
    private JTextField textBoxEmail; 
    private JLabel gender; 
    private JRadioButton male; 
    private JRadioButton female; 
    private ButtonGroup gengp; 
    private JLabel birthday; 
    private JTextField textBoxBirthday;
    private JLabel address; 
    private JTextArea textBoxAdd; 
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JTextArea resadd; 

    public MyFrame() 
    { 
        setTitle("Registration Form"); 
        setBounds(300, 90, 900, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
        fr = getContentPane(); 
        fr.setLayout(null); 
        
        formTitle = new JLabel("Registration Form"); 
        formTitle.setFont(new Font("Arial", Font.PLAIN, 30)); 
        formTitle.setSize(300, 30); 
        formTitle.setLocation(300, 30); 
        fr.add(formTitle); 
  
        name = new JLabel("Name"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(100, 20); 
        name.setLocation(100, 100); 
        fr.add(name); 
  
        textBoxName = new JTextField(); 
        textBoxName.setFont(new Font("Arial", Font.PLAIN, 15)); 
        textBoxName.setSize(190, 20); 
        textBoxName.setLocation(200, 100); 
        fr.add(textBoxName); 
  
        email = new JLabel("Email"); 
        email.setFont(new Font("Arial", Font.PLAIN, 20)); 
        email.setSize(100, 20); 
        email.setLocation(100, 150); 
        fr.add(email); 
  
        textBoxEmail = new JTextField(); 
        textBoxEmail.setFont(new Font("Arial", Font.PLAIN, 15)); 
        textBoxEmail.setSize(190, 20); 
        textBoxEmail.setLocation(200, 150); 
        fr.add(textBoxEmail); 
  
        gender = new JLabel("Gender"); 
        gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
        gender.setSize(100, 20); 
        gender.setLocation(100, 200); 
        fr.add(gender); 
  
        male = new JRadioButton("Male"); 
        male.setFont(new Font("Arial", Font.PLAIN, 15)); 
        male.setSelected(true); 
        male.setSize(75, 20); 
        male.setLocation(200, 200); 
        fr.add(male); 
  
        female = new JRadioButton("Female"); 
        female.setFont(new Font("Arial", Font.PLAIN, 15)); 
        female.setSelected(false); 
        female.setSize(80, 20); 
        female.setLocation(275, 200); 
        fr.add(female); 
  
        gengp = new ButtonGroup(); 
        gengp.add(male); 
        gengp.add(female); 
        
        birthday = new JLabel("Birthday: "); 
        birthday.setFont(new Font("Arial", Font.PLAIN, 20)); 
        birthday.setSize(100, 20); 
        birthday.setLocation(100, 250); 
        fr.add(birthday); 
  
        textBoxBirthday = new JTextField(); 
        textBoxBirthday.setFont(new Font("Arial", Font.PLAIN, 15)); 
        textBoxBirthday.setSize(190, 20); 
        textBoxBirthday.setLocation(200, 250); 
        fr.add(textBoxBirthday); 
        
        address = new JLabel("Address"); 
        address.setFont(new Font("Arial", Font.PLAIN, 20)); 
        address.setSize(100, 20); 
        address.setLocation(100, 300); 
        fr.add(address); 
  
        textBoxAdd = new JTextArea(); 
        textBoxAdd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        textBoxAdd.setSize(200, 50); 
        textBoxAdd.setLocation(200, 300); 
        textBoxAdd.setLineWrap(true); 
        fr.add(textBoxAdd); 
  
        term = new JCheckBox("Accept Terms And Conditions."); 
        term.setFont(new Font("Arial", Font.PLAIN, 15)); 
        term.setSize(250, 20); 
        term.setLocation(150, 400); 
        fr.add(term); 
  
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(150, 450); 
        sub.addActionListener(this); 
        fr.add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(270, 450); 
        reset.addActionListener(this); 
        fr.add(reset); 
  
        tout = new JTextArea(); 
        tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tout.setSize(300, 400); 
        tout.setLocation(500, 100); 
        tout.setLineWrap(true); 
        tout.setEditable(false); 
        fr.add(tout);
  
        res = new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setSize(500, 25); 
        res.setLocation(100, 500); 
        fr.add(res); 
  
        resadd = new JTextArea(); 
        resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        resadd.setSize(200, 75); 
        resadd.setLocation(580, 175); 
        resadd.setLineWrap(true); 
        fr.add(resadd);
  
        setVisible(true); 
    } 
    //function that opens, writes, and closes a file
    public void workWithFile(String data, String data1,String data2, String data3) throws IOException {
    	FileWriter pw = new FileWriter("password",true);
    	pw.write(data);
        pw.write(data1);
        pw.write(data2);
        pw.write(data3);
        pw.write(System.getProperty( "line.separator" ));
    	pw.write(System.getProperty( "line.separator" ));
        pw.close();
    }
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) { 
   //if everything is done right, this code will execute and information will be stored in a database
            if (term.isSelected()) { 
                String data1; 
                String data = "Name : "
                      + textBoxName.getText() + "\n"
                      + "Email : "
                      + textBoxEmail.getText() + "\n"; 
                if (male.isSelected()) 
                    data1 = "Gender : Male"
                            + "\n"; 
                else
                    data1 = "Gender : Female"
                            + "\n"; 
                
                String data2 = "Birthday : " + textBoxBirthday.getText()
                      + "\n"; 
  
                String data3 = "Address : " + textBoxAdd.getText(); 
                tout.setText(data + data1 + data2 + data3); 
                try {
					workWithFile(data,data1,data2,data3);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                tout.setEditable(false); 
                res.setText("Registration Success"); 
            } 
   //if submit is clicked but user didn't accept terms of conditions, this code will execute
            else { 
                tout.setText(""); 
                resadd.setText(""); 
                res.setText("Please accept the"
                            + " terms & conditions.."); 
            } 
        } 
   //if reset is pressed, this code will execute and it's going to remove all the strings from textboxes
        else if (e.getSource() == reset) { 
            textBoxName.setText(""); 
            textBoxAdd.setText(""); 
            textBoxEmail.setText(""); 
            textBoxBirthday.setText("");
            res.setText(""); 
            tout.setText(""); 
            term.setSelected(false); 
            resadd.setText(""); 
        } 
    } 
} 
class Registration { 
  
    public static void main(String[] args) throws Exception 
    { 
        MyFrame f = new MyFrame(); 
    } 
} 