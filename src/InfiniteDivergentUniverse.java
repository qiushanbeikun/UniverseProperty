import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class InfiniteDivergentUniverse {
    private int total;
    private int nodePosition;
    private int numberOfSubtrees;
    private int numberOfBrothers;
    private double parentNodePositionX;
    private double parentNodePositionY;


    private double order;
    private double branchLength;
    private double nodePositionX;
    private double nodePositionY;
    private double branchDegree;



    private GraphicsTool IDUGraph = new GraphicsTool();
    private ArrayList<InfiniteDivergentUniverse> subtree = new ArrayList<>();

    // info about a infinite diverse universe
    // total: tree height
    // node position: determine if the node is a leaf
    // number of subtrees: a random number between 1 and 5
    //          indicates the number of subtrees of a node
    //          a node must have at least one subtree except for
    // number of brothers: retrieved from its parents, exactally the number of subtrees of its parent
    // order: is the order of this node among all its brothers

    public InfiniteDivergentUniverse(int total, int nodePosition, int numberOfSubtrees, int numberOfBrothers, double parentNodePositionX, double parentNodePositionY, double order){
        this.total = total;
        this.nodePosition = nodePosition;
        this.numberOfSubtrees = numberOfSubtrees;
        this.numberOfBrothers = numberOfBrothers;
        this.parentNodePositionX = parentNodePositionX;
        this.parentNodePositionY = parentNodePositionY;
        this.order = order;
        //System.out.println(numberOfBrothers);
        // System.out.println(nodePosition);
        generateGraphInfo();

        if (nodePosition != total){
            generateSubtree();
        }
            //else stop generating subtrees
        /*System.out.println("the tree is completely generated");
        System.out.println("the tree has been completely drawn");*/

    }

    public void generateSubtree(){
        for (int i = 1; i <= numberOfSubtrees; i++) {
            subtree.add(generateRandomSubtree(i));
        }
    }

    // note node position starts from 0
    public InfiniteDivergentUniverse generateRandomSubtree(int order){
        int numberOfSubSub = 1 + (int) Math.floor((Math.random() * 4));
        return new InfiniteDivergentUniverse(total, nodePosition+1, numberOfSubSub, this.numberOfSubtrees, nodePositionX, nodePositionY, order);

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
    private void generateGraphInfo(){
        double totalD = Math.PI/3/(nodePosition+1);
        if (numberOfBrothers !=1){
            this.branchDegree = -totalD/2 + (order-1)*totalD/(numberOfBrothers-1);
        }else{
            this.branchDegree = 0;
        }
        double DNP = nodePosition;
        double DT = total;
        if (nodePosition != 0) {
            this.branchLength = (-DNP/3 + 1800/DT + DT/6);
        }else{
            this.branchLength = 0;
        }
        this.nodePositionX = parentNodePositionX + branchLength;
        this.nodePositionY = parentNodePositionY + Math.sin(branchDegree)*branchLength;
    }

    public void simulateDrawingPicture(){
        System.out.println("Printing the Node at Position: " + nodePosition);
        System.out.println("this node has number of brothers of: " + numberOfBrothers);
        int temp = (nodePosition + 1);
        System.out.println("Total degree is " + "pi/3/"+temp);
        System.out.println("At coordinate: (" + nodePositionX + "," + nodePositionY + ")" );
        System.out.println("The branch is drawn from (" + parentNodePositionX + "," + parentNodePositionY + ") to ("  + nodePositionX + "," + nodePositionY + ")" );
        System.out.println("branch degree is: " + branchDegree);
        System.out.println("-----------------------------------------------");
        for (InfiniteDivergentUniverse g: subtree){
            g.simulateDrawingPicture();
        }
    }



}
