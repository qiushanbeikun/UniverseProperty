import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main {

    private JFrame frame;
    private JPanel card1;
    private JPanel card2;
    private CardLayout cl;
    private JPanel cards;
    private JTextField textField1;
    private JTextField textField2;
    private JButton generateIDU;
    private JButton generateICU;
    private JPanel graphicIDU = null;
    private JPanel graphicICU = null;
    int treeHeight;


    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main(){
        frame = new JFrame("SRE's Magic Universe");
        frame.setSize(1900,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        addComponent(frame);
        frame.setVisible(true);
    }


    public void addComponent(Container pane){
        final String IDU = "InfiniteDiverseUniverse";
        final String ICU = "InfiniteConverseUniverse";

        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[] = {IDU, ICU};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        ListenForItem iL = new ListenForItem();
        cb.addItemListener(iL);
        comboBoxPane.add(cb);


        //Create the panel that contains the "cards".
        card1 = new JPanel();
        JLabel label1 = new JLabel("Set tree height");
        card1.add(label1, BorderLayout.NORTH);
        textField1 = new JTextField("");
        textField1.setColumns(7);
        card1.add(textField1, BorderLayout.PAGE_START);
        generateIDU = new JButton("Generate IDU");
        card1.add(generateIDU);

        //-----------------------------------------------

        card2 = new JPanel();
        JLabel label2 = new JLabel("Set tree height");
        card2.add(label2, BorderLayout.NORTH);
        textField2 = new JTextField("");
        textField2.setColumns(7);
        card2.add(textField2, BorderLayout.PAGE_START);
        generateICU = new JButton("Generate ICU");
        card2.add(generateICU);

        //-----------------------------------------------

        ListenForButton lForButton = new ListenForButton();
        generateIDU.addActionListener(lForButton);
        generateICU.addActionListener(lForButton);

        cards = new JPanel(new CardLayout());
        cards.add(card1, IDU);
        cards.add(card2, ICU);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);

    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == generateIDU) {
                // this should generate the graph of a IDU
                InfiniteDivergentUniverse iDU = new InfiniteDivergentUniverse(Integer.valueOf(textField1.getText()), 0, 3, 1, 0,0, 1);
                /*graphicIDU = iDU.Illustration();
                card1.add(graphicIDU);
                frame.setVisible(true);*/

                iDU.simulateDrawingPicture();

            }
            else if (e.getSource() == generateICU) {
                // this should generate the graph of a ICU
            }
        }
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    private class ListenForItem implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent evt) {
            cl = (CardLayout)(cards.getLayout());
            cl.show(cards, (String)evt.getItem());
        }
    }





}
