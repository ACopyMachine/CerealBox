import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JScrollPane;

public class TheCerealBox
{
    public static ArrayList<Cereal> cerealList = new ArrayList<Cereal>();
    
    public TheCerealBox()
    {
        setList();
        
        
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        mb.add(m1);
        JMenuItem m11 = new JMenuItem("Save Output To File");
        m1.add(m11);
        
        
        
        final JFrame frame = new JFrame("The Cereal Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
        JButton a = new JButton("50+ Sugar \n& 100+ Cals");
        JButton b = new JButton("0 Fat");
        JButton c = new JButton("Sugar>Carbohydrates");
        JButton d = new JButton("Hot or Cold \nhave more fiber");
        JButton e = new JButton("Macronutrient Ratios");
        buttonPanel.add(a);
        buttonPanel.add(b);
        buttonPanel.add(c);
        buttonPanel.add(d);
        buttonPanel.add(e);
        
        JTextArea tf =  new JTextArea(" ");
        JPanel textPanel = new JPanel(new GridLayout(1,1));
        JScrollPane scrollTextPanel = new JScrollPane(textPanel);
        tf.setLineWrap(true);
        tf.setEditable(false);
        
        GridBagConstraints wgbc = new GridBagConstraints();
        wgbc.weighty = 1;
        wgbc.weightx = 1;
        wgbc.fill = GridBagConstraints.BOTH;
        textPanel.add(tf,wgbc);
        
        
        JPanel east = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weighty = 1;
        east.add(buttonPanel, gbc);
        
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        
        buttonPanel.setSize(50,1500);
        
        JPanel center = new JPanel()
        {
            public Dimension getPreferredSize() 
            {
                return new Dimension(700, 700);
            }
        };
        center.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        frame.add(east, BorderLayout.EAST);
        frame.add(center);
        frame.add(scrollTextPanel);

        
        frame.pack();
        frame.setVisible(true);
              
        a.addActionListener(new ActionListener()
                            {  
                                public void actionPerformed(ActionEvent e)
                                {  
                                    int count = 0;
                                    ArrayList<Cereal> ratCalList = new ArrayList<Cereal>();
                                    for(Cereal currCereal : cerealList)
                                    {
                                        if (currCereal.getRating()>50 && currCereal.getCalories()>100)
                                        {
                                            count++;
                                            ratCalList.add(currCereal);
                                        }
                                    }
                                    tf.setText("There are " + count +" cereals with 50+ grams of sugar and 100+ calories: \n" + ratCalList);  
                                    tf.setCaretPosition(0);
                                }
                            });  
        
        b.addActionListener(new ActionListener()
                            {  
                                public void actionPerformed(ActionEvent e)
                                {  
                                    ArrayList<Cereal> noFatList = new ArrayList<Cereal>();
                                    for(Cereal currCereal : cerealList)
                                    {
                                        if (currCereal.getFat()==0)
                                            noFatList.add(currCereal);
                                    }
                                    tf.setText("There are " + noFatList.size() + " cereals with no fat: \n" + noFatList);  
                                    tf.setCaretPosition(0);
                                }
                            });  
                            
        c.addActionListener(new ActionListener()
                            {  
                                public void actionPerformed(ActionEvent e)
                                {  
                                    int count = 0;
                                    ArrayList<Cereal> moreSugarList = new ArrayList<Cereal>();
                                    for(Cereal currCereal : cerealList)
                                    {
                                        if (currCereal.getSugar()>currCereal.getCarbohydrates())
                                        {
                                            count++;
                                            moreSugarList.add(currCereal);
                                        }
                                    }
                                    tf.setText("There are " + count +" cereals with more sugar then carbohydrates: \n" + moreSugarList); 
                                    tf.setCaretPosition(0);
                                }
                            });   
        d.addActionListener(new ActionListener()
                            {  
                                public void actionPerformed(ActionEvent e)
                                {                                      
                                    int hotCount = 0, coldCount = 0, hotFiberCount = 0, coldFiberCount = 0;
                                    for(Cereal currCereal : cerealList)
                                    {
                                        if (currCereal.getTemp().equals("C"))
                                        {
                                            coldCount++;
                                            coldFiberCount+=currCereal.getFiber();
                                        }
                                        else if (currCereal.getTemp().equals("H"))
                                        {    
                                            hotCount++;
                                            hotFiberCount+=currCereal.getFiber();
                                        }
                                    }
                                    tf.setText("The average fiber count in hot foods is " + (double)hotFiberCount/hotCount + "\nThe average fiber count in cold foods is " + ((double)coldFiberCount/coldCount));  
                                    tf.setCaretPosition(0);
                                }
                            });  
                            
        e.addActionListener(new ActionListener()
                            {  
                                public void actionPerformed(ActionEvent e)
                                {  
                                    ArrayList<Double> macroRatioList = new ArrayList<Double>();
                                    ArrayList<Cereal> cerealMacroRatioList = new ArrayList<Cereal>();
                                    
                                    double macroPreSum = 0;
                                    double macroRatio = 0;
                                    
                                    
                                    for(Cereal currCereal : cerealList)
                                    {
                                        macroPreSum = currCereal.getFat()+currCereal.getProtein()+currCereal.getCarbohydrates();
                                        macroRatio = Math.abs((macroPreSum*0.40-currCereal.getCarbohydrates()))+Math.abs((macroPreSum*0.30-currCereal.getFat()))+Math.abs((macroPreSum*0.30-currCereal.getProtein()));
                                        macroRatioList.add(macroRatio);
                                        cerealMacroRatioList.add(currCereal);
                                    }
                                    
                                        
                                    for (int i = 0; i < macroRatioList.size(); i++) 
                                    {
                                        for (int j = i + 1; j < macroRatioList.size(); j++) 
                                        {
                                            double temp = 0;
                                            Cereal cerealTemp = null;
                                            if (macroRatioList.get(j) < macroRatioList.get(i)) 
                                            {
                                                temp = macroRatioList.get(i);
                                                macroRatioList.set(i, macroRatioList.get(j));
                                                macroRatioList.set(j, temp);
                                                
                                                cerealTemp = cerealMacroRatioList.get(i);
                                                cerealMacroRatioList.set(i, cerealMacroRatioList.get(j));
                                                cerealMacroRatioList.set(j, cerealTemp);
                                            }
                                        }
                                    }
                                    
                                    tf.setText("Cereals Macro Nutrient Ratios: ");
                                    for(int i = 0; i<macroRatioList.size(); i++)
                                    {
                                        tf.setText(tf.getText() + "\n" + cerealMacroRatioList.get(i) + "\n\tMacronutrient value: " + macroRatioList.get(i));
                                    }
                                    tf.setCaretPosition(0);
                                }
                            }); 
                            
                            
        m11.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {  
                                    try
                                    {
                                        BufferedWriter out = new BufferedWriter(new FileWriter("out. txt"));
                                        //"Name\tType\tCalories\tProtein\tFat\tSodium\tFiber\tCarbohydrates\tSugar\tPotassium\tVitamins\tShelf\tWeight\tCups\tRating\n"
                                        out.write(tf.getText());
                                        tf.setText("Saved To File  >>>   out.text \n" + tf.getText());
                                        out.close();
                                        tf.setCaretPosition(0);
                                        
                                    }
                                   
                                    catch (IOException ex)
                                    {
                                        System.out.println("File Write Error");
                                    }
            
                                }
                            }); 
                                        
            }
            
            
    public static void setList()
    {
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("Alexander Pushkar - Cereal.txt"));
           
            String str;
    
            while ((str = in.readLine())!= null)
            {
         
                String[] cerealData = str.split(",");
      
                Cereal cerealRec = new Cereal(cerealData[0],
                cerealData[1],
                Integer.parseInt(cerealData[2]),
                Integer.parseInt(cerealData[3]),
                Integer.parseInt(cerealData[4]),
                Integer.parseInt(cerealData[5]),
                Double.parseDouble(cerealData[6]),
                Double.parseDouble(cerealData[7]),
                Integer.parseInt(cerealData[8]),
                Integer.parseInt(cerealData[9]),
                Integer.parseInt(cerealData[10]),
                Integer.parseInt(cerealData[11]),
                Double.parseDouble(cerealData[12]),
                Double.parseDouble(cerealData[13]),
                Double.parseDouble(cerealData[14]));
                                         
                cerealList.add(cerealRec);         
            }
            
            
            in.close();
        }
            
        catch (IOException e)
        {
        System.out.println("File Read Error");
        }
        
    }
    
    public static void main(String args[])
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TheCerealBox();
            }
        });
    }
    
}