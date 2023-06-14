package Ai;

public class Node {

    Node parent;
    public int col; //toa do
    public int row;
    int gCost; //from cr point to start point
    int hCost; //from cr point to goal point
    int fCost; //total
    boolean solid;//is it an obstacle
    boolean open;//can open the path??
    boolean checked; //used???

    public Node(int col, int row){
        this.col = col;
        this.row = row;
    }
}
