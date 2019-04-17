
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javafx.scene.control.TextField;
/**
 * TrainBook
 */
public class TrainBook  extends JFrame{
    private int width = 500;
    private int height = 600;
    private int x=30;
    private int y=30;

    ImageIcon img ;
    private JLabel trainNo,trainName;
    private JTextField trainNoTF,trainNameTF;
    private JButton submit;
    

    TrainBook(){
        setBounds(160,50,width,height);
        setVisible(true);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setTitle("Railway Reservation ");
        setLayout(null);

        x=30;y=30;width =90;height=25;

        trainNo =new JLabel("Train No    :");
        trainNo.setBounds(x,y,width+40,height);
        trainNo.setFont(new Font("Calisto MT",Font.BOLD,18));

        trainNoTF =new JTextField("");
        trainNoTF.setBounds(x+width+20,y,width,height);
        trainNoTF.setFont(new Font("Calisto MT",Font.BOLD,18));

        trainName =new JLabel("Train Name :");
        trainName.setBounds(x,y+height+20,width+40,height);
        trainName.setFont(new Font("Calisto MT",Font.BOLD,18));

        trainNameTF =new JTextField("");
        trainNameTF.setBounds(x+width+20,y+height+20,width,height);
        trainNameTF.setFont(new Font("Calisto MT",Font.BOLD,18));


        img = new ImageIcon("next1.gif");
        submit = new JButton(img);
        submit.setBounds(300,450,100,60);
        submit.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                String text1= trainNoTF.getText();
                String text2= trainNameTF.getText();
                if(text1.length()>0 && text2.length()>0){
                    System.out.println("go to next ------>");
                    dispose();
                    new DetailsPage();
                    
                }
            }
        });

        add(trainNo);
        add(trainNoTF);
        add(trainName);
        add(trainNameTF);
        add(submit);
    }
}