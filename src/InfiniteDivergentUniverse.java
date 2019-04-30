import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class InfiniteDivergentUniverse {
    int total;
    int nodePosition;
    int numberOfSubtrees;

    private GraphicsTool IDUGraph = new GraphicsTool();
    ArrayList<InfiniteDivergentUniverse> subtree = new ArrayList<>();

    // info about a infinite diverse universe
    // total: tree height
    // node position: determine if the node is a leaf
    // number of subtrees: a random number between 1 and 5
    //          indicates the number of subtrees of a node
    //          a node must have at least one subtree except for
    public InfiniteDivergentUniverse(int total, int nodePosition, int numberOfSubtrees, int order){
        this.total = total;
        this.nodePosition = nodePosition;
        this.numberOfSubtrees = numberOfSubtrees;
        System.out.println(nodePosition);

        if (nodePosition != total){
            generateSubtree();
        }
            //else stop generating subtrees

    }

    public void generateSubtree(){
        for (int i = 1; i < numberOfSubtrees; i++) {
            subtree.add(generateRandomSubtree(i));
        }
    }

    public InfiniteDivergentUniverse generateRandomSubtree(int order){
        int numberOfSubSub = 1 + (int) Math.floor((Math.random() * 4));
        return new InfiniteDivergentUniverse(total, nodePosition+1,numberOfSubSub, order);

    }

    protected GraphicsTool Illustration(){
        IDUGraph.setPreferredSize(new Dimension(1800, 666));
        return IDUGraph;
    }

    private class GraphicsTool extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            this.setBackground(Color.WHITE);
            //draw the compunent for this node
            //draw the component for subtrees

        }
    }

}
