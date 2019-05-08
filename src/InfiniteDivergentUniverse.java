import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class InfiniteDivergentUniverse {
    int total;
    int nodePosition;
    int numberOfSubtrees;
    int numberOfBrothers;
    int parentNodePositionX;
    int parentNodePositionY;


    double order;
    double branchLength;
    int nodePositionX;
    int nodePositionY;



    private GraphicsTool IDUGraph = new GraphicsTool();
    ArrayList<InfiniteDivergentUniverse> subtree = new ArrayList<>();

    // info about a infinite diverse universe
    // total: tree height
    // node position: determine if the node is a leaf
    // number of subtrees: a random number between 1 and 5
    //          indicates the number of subtrees of a node
    //          a node must have at least one subtree except for
    // number of brothers: retrieved from its parents, exactally the number of subtrees of its parent
    // order: ======================== i kind of forget what is the function of this order
    //                                 maybe is to determine the order of this branch in the graph
    public InfiniteDivergentUniverse(int total, int nodePosition, int numberOfSubtrees, int numberOfBrothers, int parentNodePositionX, int parentNodePositionY, int order){
        this.total = total;
        this.nodePosition = nodePosition;
        this.numberOfSubtrees = numberOfSubtrees;
        this.numberOfBrothers = numberOfBrothers;
        this.parentNodePositionX = parentNodePositionX;
        this.parentNodePositionY = parentNodePositionY;
        System.out.println(nodePosition);
        generateGraphInfo();

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
        return new InfiniteDivergentUniverse(total, nodePosition+1,numberOfSubSub, this.numberOfBrothers, nodePositionX, nodePositionY, order);

    }

    protected GraphicsTool Illustration(){
        // this defines the size of the graph to be drawed
        IDUGraph.setPreferredSize(new Dimension(1800, 666));
        return IDUGraph;
    }

    private class GraphicsTool extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            this.setBackground(Color.WHITE);
            //draw the compunent for this node
            //draw the component for subtrees
            // this is a question about how to do natural recursion in the graph tool component

        }
    }
    // to generate the required info to draw the graph
    // equaitons: branch length determind by the depth of the tree and node position
    // to make sure that the gragh can occupy thewhole canvas, branch length and node info should be determined wisely.
    //
    public void generateGraphInfo(){
        this. order = Math.PI/6/total;
        this.branchLength = (-nodePosition/3 + total/6);
        this.nodePositionX = parentNodePositionX + ;
    }


}
