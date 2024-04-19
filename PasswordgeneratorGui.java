import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordgeneratorGui extends JFrame {
    private  PasswordGeneratorL passwordGeneratorL;
        public PasswordgeneratorGui() {
            super("Password Generator");
            setSize(540, 570);
            setResizable(false);
            setLayout(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            passwordGeneratorL = new PasswordGeneratorL();
            addGuiComponents();

        }
    private void addGuiComponents(){
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("Dialog",Font.BOLD,32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0,10,540,39);
        add(titleLabel);

        JTextArea passwordOutput = new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog",Font.BOLD,32));

        JScrollPane passwordOutputpane = new JScrollPane(passwordOutput);
        passwordOutputpane.setBounds(25,97,479,70);
        passwordOutputpane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputpane);


        JLabel passwordLengthLabel = new JLabel("Password Length: ");
        passwordLengthLabel.setFont(new Font("Dialog",Font.PLAIN,32));
        passwordLengthLabel.setBounds(25,215,272,39);
        add(passwordLengthLabel);

        JTextArea passwordLengthInput = new JTextArea();
        passwordLengthInput.setFont(new Font("Dialog",Font.PLAIN,32));
        passwordLengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInput.setBounds(310,215,192,39);
        add(passwordLengthInput);

        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog",Font.PLAIN,32));
        uppercaseToggle.setBounds(25,302,225,56);
        add(uppercaseToggle);

        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog",Font.PLAIN,32));
        lowercaseToggle.setBounds(282,302,225,56);
        add(lowercaseToggle);

        JToggleButton numberToggle = new JToggleButton("Numbers");
        numberToggle.setFont(new Font("Dialog",Font.PLAIN,32));
        numberToggle.setBounds(25,373,225,56);
        add(numberToggle);

        JToggleButton symbolToggle = new JToggleButton("Symbols");
        symbolToggle.setFont(new Font("Dialog",Font.PLAIN,32));
        symbolToggle.setBounds(282,373,225,56);
        add(symbolToggle);


        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog",Font.PLAIN,32));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passwordLengthInput.getText().length() <= 0){ System.out.println("Please enter number!!"); return;}
                boolean anyToggleselected  = lowercaseToggle.isSelected() ||
                        uppercaseToggle.isSelected() ||
                        numberToggle.isSelected() ||
                        symbolToggle.isSelected();

                int passwordLength = Integer.parseInt(passwordLengthInput.getText());
                if (anyToggleselected){
                    String generatePassword = passwordGeneratorL.generatePassword(passwordLength,uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),numberToggle.isSelected(),
                            symbolToggle.isSelected());
                    passwordOutput.setText(generatePassword);
                }
                else {
                    System.out.println("Please select any button to generate password!!");
                }
            }
        });
        add(generateButton);



    }
}

