/*
@AUTHOR: S.ABILASH
Comment: Got Bored so i made this
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.awt.event.*;
public class main{

    public static void main(String[] args) {
        System.out.println("MORSE CODE TRAINSLATOR - S.ABILASH");
        System.out.println("Morse History: ");
        System.out.println("");
        
        HashMap<Character, String> mem = new HashMap<Character, String>();
        mem.put('a',".-");
        mem.put('b',"-...");
        mem.put('c',"-.-.");
        mem.put('d',"-..");
        mem.put('e',".");
        mem.put('f',"..-.");
        mem.put('g',"--.");
        mem.put('h',"....");
        mem.put('i',"'..");
        mem.put('j',".---");
        mem.put('k',"-.-");
        mem.put('l',".-..");
        mem.put('m',"--");
        mem.put('n',"-.");
        mem.put('o',"---");
        mem.put('p',".--.");
        mem.put('q',"--.-");
        mem.put('r',".-.");
        mem.put('s',"...");
        mem.put('t',"-");
        mem.put('u',"..-");
        mem.put('v',"...-");
        mem.put('w',".--");
        mem.put('x',"-..-");
        mem.put('y',"-.--");
        mem.put('z',"--..");
        //numbers
        mem.put('0',"-----");
        mem.put('1',".----");
        mem.put('2',"..---");
        mem.put('3',"...--");
        mem.put('4',"....-");
        mem.put('5',".....");
        mem.put('6',"-....");
        mem.put('7',"--...");
        mem.put('8',"---..");
        mem.put('9',"----.");
        //puncutation
        mem.put('.',".-.-.-");
        mem.put(',',"--..--");
        mem.put('?',"..--..");
        mem.put('\"',".----.");
        mem.put('!',"-.-.--");
        mem.put('/',"-..-.");
        mem.put('(',"-.--.");
        mem.put(')',"-.--.-");
        mem.put('&',".-...");
        mem.put(':',"---...");
        mem.put(';',"-.-.-.");
        mem.put('=',"-...-");
        mem.put('+',".-.-.");
        mem.put('-',"-....-");
        mem.put('_',"..--.-");
        mem.put('\'',".-..-.");
        mem.put('$',"...-..-");
        mem.put('@',".--.-.");
        mem.put(' ',"/");
        //init MorseCode
        //MorseCode morse = new MorseCode();
        //setting window
        JFrame window = new JFrame("Morse Translator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 150);

        //set the window icon
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\morse_icon.jpg");
        window.setIconImage(icon);

        //get the dimension of the computer screen and set the window to center of the computer screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - window.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - window.getHeight()) / 2);
        window.setLocation(x, y);

        //create a panel
        JPanel panel = new JPanel();

        //create a label
        JLabel label = new JLabel("Morse Translator");
        JLabel author = new JLabel("(By S.ABILASH)");

        //create a text field which accept (100 characters
        JTextField field = new JTextField("Enter Something",40);

        //create a button for Encoding And Decoding
        JButton encode = new JButton("Encode");
        JButton decode = new JButton("Decode");
        JButton clear = new JButton("Clear");
        //add all the componment to the panel
        panel.add(label);
        panel.add(author);
        panel.add(field);
        panel.add(encode);
        panel.add(decode);
        panel.add(clear);
        //set the panel to center
        window.getContentPane().add(BorderLayout.CENTER, panel);

        //set the window to visible
        window.setVisible(true);

        //event listener for encoding button
        encode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==encode)
                {
                    String input = field.getText();
                    System.out.println("Given Input: "+input);
                    String output="";
                    for(int i=0;i<input.length();i++)
                    {
                        char value=Character.toLowerCase(input.charAt(i));
                        if(mem.get(value)!=null)
                        {
                            output+=mem.get(value);
                            output+=" ";
                        }else{
                            System.out.println("Invalid Character");
                        }

                    }
                    System.out.println("Output: "+output);
                    System.out.println("");
                    field.setText(output);
                }
            }
        });

        //event listener for decoding button
        decode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==decode)
                {
                    String input = field.getText();
                    System.out.println("Given Input: "+input);
                    String output="",value="";

                    for(int i=0;i<input.length();i++)
                    {
                        if(Character.isSpaceChar(input.charAt(i)))
                        {
                            for(Entry<Character,String> entry : mem.entrySet())
                            {
                                if(value.equals(entry.getValue()))
                                {
                                    output+=entry.getKey();
                                    value="";
                                }
                            }
                        }else {
                            value += input.charAt(i);
                        }
                    }
                    System.out.println("Output: "+output);
                    System.out.println("");
                    field.setText(output);
                }
            }
        });
        //event listener for clear button
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==clear)
                {
                    field.setText("");
                }
            }
        });
    }

}
