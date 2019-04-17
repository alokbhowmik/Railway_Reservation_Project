import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DJPanel extends JPanel {
    private int width = 200;
    private int height = 30;
    private int x=150;
    private int y=20;
    private JLabel details ,show;
    private JLabel name,surname,age,mobileNo,email;
    private JTextField nameTf,surnameTf,ageTf,mobileNoTf,emailTf;
    private JButton submit,next,previous;
    boolean isThere(char c,String s){
       char ch[]=s.toCharArray();
       for(int i=0;i<s.length();i++){
           if(ch[i]==c) return true;
       }
        
        return false;
    }
    DJPanel(){
        setBackground(new Color(102,205,170));
        setLayout(null);
        
        details = new JLabel("Fill The Details");
        details.setForeground(new Color(0,0,0));
        details.setFont(new Font("Algerian",Font.CENTER_BASELINE,20));
        details.setBounds(x,y,200,30);


        name = new JLabel("Name");
        name.setForeground(new Color(0,0,0));
        name.setFont(new Font("",Font.HANGING_BASELINE,20));
        name.setBounds(20,y+40,width,height);

        nameTf = new JTextField();
        nameTf.setForeground(new Color(0,0,0));
        nameTf.setFont(new Font("",Font.HANGING_BASELINE,20));
        nameTf.setBounds(20+width,y+40,width,height);

        surname = new JLabel("Surname");
        surname.setForeground(new Color(0,0,0));
        surname.setFont(new Font("",Font.HANGING_BASELINE,20));
        surname.setBounds(20,y+50+height,width,height);

        surnameTf = new JTextField();
        surnameTf.setForeground(new Color(0,0,0));
        surnameTf.setFont(new Font("",Font.HANGING_BASELINE,20));
        surnameTf.setBounds(20+width,y+50+height,width,height);

        age = new JLabel("age");
        age.setForeground(new Color(0,0,0));
        age.setFont(new Font("",Font.HANGING_BASELINE,20));
        age.setBounds(20,y+60+height*2,width,height);

        ageTf = new JTextField();
        ageTf.setForeground(new Color(0,0,0));
        ageTf.setFont(new Font("",Font.HANGING_BASELINE,20));
        ageTf.setBounds(20+width,y+60+height*2,width,height);


        email = new JLabel("email");
        email.setForeground(new Color(0,0,0));
        email.setFont(new Font("",Font.HANGING_BASELINE,20));
        email.setBounds(20,y+70+height*3,width,height);

        emailTf = new JTextField();
        emailTf.setForeground(new Color(0,0,0));
        emailTf.setFont(new Font("",Font.HANGING_BASELINE,20));
        emailTf.setBounds(20+width,y+70+height*3,width,height);

        mobileNo = new JLabel("Mobile No");
        mobileNo.setForeground(new Color(0,0,0));
        mobileNo.setFont(new Font("",Font.HANGING_BASELINE,20));
        mobileNo.setBounds(20,y+80+height*4,width,height);

        mobileNoTf = new JTextField(10);
        mobileNoTf.setForeground(new Color(0,0,0));
        mobileNoTf.setFont(new Font("",Font.HANGING_BASELINE,20));
        mobileNoTf.setBounds(20+width,y+80+height*4,width,height);


        submit = new JButton("submit");
        submit.setForeground(new Color(0,0,0));
        submit.setFont(new Font("",Font.HANGING_BASELINE,20));
        submit.setBounds(200,y+90+height*6,100,50);
        submit.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        String Pname=nameTf.getText();
                        String Psername =surnameTf.getText();
                        int page = Integer.parseInt(ageTf.getText());
                        String pemail = emailTf.getText();
                        long pmobileno = Long.parseLong(mobileNoTf.getText());
                        show.setText("");
                        if(mobileNoTf.getText().length()!=10){
                            
                            show.setText("Length of your mobile no should be equalto 10");
                        }
                        if(!isThere('.',pemail) && !isThere('@',pemail)){
                            show.setText("");
                            show.setText(" . or @ is not there");
                        }
                        else{
                            nameTf.setText("");
                            surnameTf.setText("");
                            ageTf.setText("");
                            emailTf.setText("");
                            mobileNoTf.setText("");
                        }
                    } catch (Exception exc) {
                        //TODO: handle exception
                        System.out.println("ero"+exc);
                        show.setText("");
                        show.setText("Please check all the details ");
                    }
                
                }
            }
        );

        next = new JButton("Next");
        next.setForeground(new Color(0,0,0));
        next.setFont(new Font("",Font.HANGING_BASELINE,20));
        next.setBounds(340,y+90+height*6,100,50);
        next.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        previous = new JButton("Previous");
        previous.setForeground(new Color(0,0,0));
        previous.setFont(new Font("",Font.HANGING_BASELINE,20));
        previous.setBounds(40,y+90+height*6,150,50);
        previous.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // removeAll();
                new TrainBook();
            }
        });
        show = new JLabel("");
        show.setForeground(new Color(255,0,0));
        show.setFont(new Font("",Font.LAYOUT_LEFT_TO_RIGHT,20));
        show.setBounds(20,y+90+height*8,500,50);

        




        add(details);
        add(name);
        add(nameTf);
        add(surname);
        add(surnameTf);
        add(age);
        add(ageTf);
        add(email);
        add(emailTf);
        add(mobileNo);
        add(mobileNoTf);
        add(submit);
        add(show);
        add(next);
        add(previous);
    }
    
}
public class DetailsPage extends JFrame{
    private int width = 500;
    private int height = 600;
    private int x=30;
    private int y=30;
    DJPanel panel ;

    DetailsPage(){
        panel= new DJPanel();
        // panel.setBounds(x,y,width,height);
        getContentPane().add(panel);

        setBounds(160,50,width,height);
        setVisible(true);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setTitle("Details ");
        setLayout(null);

        

    }
    public static void main(String[] args) {
        new DetailsPage();
    }
    
}

