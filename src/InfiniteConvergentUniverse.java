import javax.swing.plaf.metal.MetalTheme;
import java.util.ArrayList;

public class InfiniteConvergentUniverse {

    boolean convergence;
    private int total;
    private int nodePosition;
    //private int numberOfNormalSubtrees;
    private int numberOfConvergentBrothers;
    private int numberOfBrothers;
    private int numberOfSubtrees;
    private double parentNodePositionX;
    private double parentNodePositionY;

    private double order;
    private double branchLength;
    private double nodePositionX;
    private double nodePositionY;
    private double branchDegree;

    //private InfiniteDivergentUniverse.GraphicsTool IDUGraph = new InfiniteDivergentUniverse.GraphicsTool();
    private ArrayList<InfiniteConvergentUniverse> normalSubtree = new ArrayList<>();
    private ArrayList<InfiniteConvergentUniverse> convergentSubtree = new ArrayList<>();


    // the impplement of the InfiniteConvergentniverse is almost the witn IDU
    // the different is for the fist branch of each node, "the convergent branch"
    // by the definition, the number of random branches and the number of convergent branches are not fixed,
    //       that is we need additional functions for these.
    // info about a infinite diverse universe
    // total: tree height
    // node position: determine if the node is a leaf
    // convergence: a boolean to determine whether this node/branch should converge to the base world line
    // number of brothers: shows how many subtrees does the parent node has , this number is used to generate the reqiured info to draw the graph
    //                     note: info about subtrees are generated when the tree was first instantiated, the tree node cannot change how many brothers it has.
    // number of subtrees: a random number between 1 and 5
    //          indicates the number of subtrees of a node
    //          a node must have at least one subtree except for
    // number of convergent brothers, a number to determine number of convergent subtrees in this node,
    //                  this number should be smaller than the number of subtrees, with a upper bound of 2
    // info about the parent node position to draw the graph
    // order: is the order of this node among all its brothers

    //

    public InfiniteConvergentUniverse(int total, int nodePosition, boolean convergence, int numberOfSubtrees, int numberOfBrothers, int numberOfConvergentBrothers, double parentNodePositionX, double parentNodePositionY, int order){
        this.total = total;
        this.nodePosition = nodePosition;
        this.convergence = convergence;
        this.numberOfSubtrees = numberOfSubtrees;
        this.numberOfConvergentBrothers = numberOfConvergentBrothers;
        this.numberOfBrothers = numberOfBrothers;
        this.parentNodePositionX = parentNodePositionX;
        this.parentNodePositionY = parentNodePositionY;
        this.order = order;

        if (nodePosition != total){
            generateSubtree();
        }
        // else this tree is complete in length and no need of further generates
    }



    // there are two types of subtrees to generate, first for the normal trees and then for the convergent trees
    // the order of each subtree should be continuous
    public void generateSubtree(){
        for (int i = 1; i <= numberOfConvergentBrothers; i++) {
            convergentSubtree.add(generateAConvergentSubtree(i));
        }
        for (int i = 1; i <= numberOfBrothers - numberOfConvergentBrothers; i++) {
            normalSubtree.add(generateANormalSubtree(i));
        }
    }

    public InfiniteConvergentUniverse generateANormalSubtree(int order){
        int numberOfSubs = 1+ (int) Math.floor(Math.random() * 4);
        int numberOfConvergentSubs = (int) Math.floor(Math.random()*2);
        return new InfiniteConvergentUniverse(total, nodePosition+1, false, numberOfSubs, this.numberOfSubtrees, numberOfConvergentSubs, this.nodePositionX, nodePositionY, order);
    }

    public InfiniteConvergentUniverse generateAConvergentSubtree(int order){
        int numberOfSubs = 1+ (int) Math.floor(Math.random() * 4);
        int numberOfConvergentSubs = (int) Math.floor(Math.random()*2);
        return new InfiniteConvergentUniverse(total, nodePosition+1, true, numberOfSubs, this.numberOfSubtrees, numberOfConvergentSubs, this.nodePositionX, this.nodePositionY, order);
    }

    public void generateGraphInfo(){
        // total degree is half of that in IDU, asume that the bumber of normak subtrees is approx
        //          half  of the total subtrees
        //          all the convergent branches re converging to the x-axies, that is
        //          if they are Y is below zero, the degree is positive, Y above zeron, then degree is negative
        //       assume that all the normal branches diverges to the x-axies, they follow similar rules.
        double totalD = Math.PI/6/(nodePosition+1);
        if (this.numberOfBrothers != 1){
            if (this.convergence){
                if (parentNodePositionY>0){

                }else{ // parent node position < 0

                }
            }
            else{// this is not a convergent branch

            }
        }else{
            this.branchDegree = 0;
        }


        // branch length stays the same with IDU

        double DNP = nodePosition;
        double DT = total;
        if (nodePosition != 0) {
            this.branchLength = (-DNP/3 + 1800/DT + DT/6);
        }else{
            this.branchLength = 0;
        }

    }
}
