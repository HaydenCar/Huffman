import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public static void main(String[] args) {
        new Main();
    }

    // Do I even need to comment this?
    // Simple GUI that has a try catch on the input to make sure no bad message gets read
    // Wasn't sure how to make it prettier but its functional
    public Main() {
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.generateHuffmanTree();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel leftButtonPanel = new JPanel();
        JPanel rightButtonPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        JTextArea inputTextArea = new JTextArea("Text Area for input message for\n" +
                                                "encoding or bitcode for decoding", 2, 30);
        JTextArea outputTextArea = new JTextArea("Text Area for output message after\n" +
                                                "decoding or bitcode after encoding", 2, 30);

        JButton encodeButton = new JButton("ENCODE");
        encodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String in = inputTextArea.getText();
                    String message = huffmanTree.encode(in);
                    if (message == ""){
                        outputTextArea.setText("Invalid input");
                    } else outputTextArea.setText(message);
                } catch (Exception exc){
                    outputTextArea.setText("Invalid input");
                }

            }
        });

        JButton decodeButton = new JButton("DECODE");
        decodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String in = inputTextArea.getText();
                    String message = huffmanTree.decode(in);
                    if (message == ""){
                        outputTextArea.setText("Invalid input");
                    } else outputTextArea.setText(message);
                } catch (Exception exc){
                    outputTextArea.setText("Invalid input");
                }

            }
        });

        topPanel.add(inputTextArea);
        bottomPanel.add(outputTextArea);
        leftButtonPanel.add(encodeButton);
        rightButtonPanel.add(decodeButton);
        centerPanel.add(leftButtonPanel, BorderLayout.EAST);
        centerPanel.add(rightButtonPanel, BorderLayout.WEST);

        topPanel.setBackground(Color.GRAY);
        centerPanel.setBackground(Color.GRAY);
        leftButtonPanel.setBackground(Color.GRAY);
        rightButtonPanel.setBackground(Color.GRAY);
        bottomPanel.setBackground(Color.GRAY);

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,200);
        setVisible(true);
        setTitle("HUFFMAN");
    }
}
