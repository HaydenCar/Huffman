import java.io.File;
import java.util.Scanner;

public class HuffmanTree {
    private TreeNode root;
    private ListArrayBased freqTable;
    private String[][] storage = new String[26][2]; // Store characters and binary codes using 2D aray

    private void readFrequencyTable(String fileName) {
        // reads the file into a frequency table
        freqTable = new ListArrayBased();
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            int index = 1;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] tokens = line.split("\t");
                char symbol = tokens[0].charAt(0);
                int freq = Integer.parseInt(tokens[1]);
                freqTable.add(index, new TreeNode(freq, symbol));
                index++;
            }
        } catch (Exception e) {
            System.out.println("SCANNER EXCEPTION");
        }
    }

    public void generateHuffmanTree() {
        readFrequencyTable("LetterCountAscending.txt");
        // Using the frequency table we generate the huffman tree by visiting all the nodes and
        // use a greedy algorithm to assign them in order

        while (freqTable.size() > 1) {
            TreeNode leftChild = (TreeNode) freqTable.get(1);
            TreeNode rightChild = (TreeNode) freqTable.get(2);
            freqTable.remove(1);
            freqTable.remove(1);

            TreeNode parent = new TreeNode(leftChild.getFreq() + rightChild.getFreq(), '*');
            parent.setLeft(leftChild);
            parent.setRight(rightChild);

            int i = 1;
            //if i isnt bigger than the size of the table and adds when it is in order
            while (i <= freqTable.size() && ((TreeNode) freqTable.get(i)).getFreq() < parent.getFreq()) {
                i++;
            }
            freqTable.add(i, parent);
        }
        root = (TreeNode) freqTable.get(1);

        traverseTree(root, "");
    }

    private void traverseTree(TreeNode root, String code) {
        if (root != null) {
            if (root.getLeft() == null && root.getRight() == null) {
                int index = root.getSymbol() - 'A';
                storage[index][0] = "" + root.getSymbol(); // Store letter
                storage[index][1] = code; // Store code
            } else {
                traverseTree(root.getLeft(), code + "0");
                traverseTree(root.getRight(), code + "1");
            }
        }
    }

    public String encode(String message) throws Exception {
        String encodedMessage = "";  // Start with an empty string
        for (int i = 0; i < message.length(); i++) {
            int index = message.charAt(i) - 'A';
            String code = storage[index][1];  // Retrieve the code for the character
            if (code != null) {
                encodedMessage += code;  // Concatenate code to the string
            } else {
                throw new Exception(message.charAt(i) + ": is not a valid char");
            }
        }
        return encodedMessage; // return the encoded message
    }

    public String decode(String bin) throws Exception {
        String message = "";  // Start with an empty string
        TreeNode curr = root;

        // check bin and continue down tree
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '0') {
                curr = curr.getLeft();
            } else if (bin.charAt(i) == '1') {
                curr = curr.getRight();
            } else {
                throw new Exception(bin.charAt(i) + ": is an invalid bit");
            }

            // If leaf append char
            if (curr.getLeft() == null && curr.getRight() == null) {
                message += curr.getSymbol();  // Concatenate symbol to the string
                curr = root;  // Reset to root for the next character
            }
        }
        return message;
    }
}