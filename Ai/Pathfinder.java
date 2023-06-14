package Ai;

import Main.GamePanel;

import java.util.ArrayList;

public class Pathfinder { // A* Algorithm
    GamePanel gp;
    Node[][] node;
    ArrayList<Node> openList = new ArrayList<>(); //contains the parent node
    public ArrayList<Node> pathList = new ArrayList<>();// this most suitable path
    Node startNode, goalNode, currentNode;
    boolean goalReached = false;
    int step = 0; //limit, in case cannot find the path, the game won't be frozen
    //set vào gp
    public Pathfinder(GamePanel gp){
        this.gp = gp;
        instantiateNode();
    }

    public void instantiateNode(){ //adding every node on the map
        node = new Node[gp.maxWorldCol][gp.maxWorldRow];
        
        int col = 0;
        int row = 0;

        while (col < gp.maxWorldCol && row < gp.maxWorldRow){

            node[col][row] = new Node(col, row);
            col++;

            if (col == gp.maxWorldCol){
                col = 0;
                row++;
            }
        }
    }

    public void resetNode(){
        int col = 0;
        int row = 0;

        while (col < gp.maxWorldCol && row < gp.maxWorldRow){

            // Reset open, checked and solid state
            node[col][row].open = false;
            node[col][row].checked = false;
            node[col][row].solid = false;

            col++;
            if (col == gp.maxWorldCol){
                col = 0;
                row++;
            }
        }

        // Reset other settings
        openList.clear();
        pathList.clear();
        goalReached = false;
        step = 0;
    }

    public void setNode(int startCol, int startRow, int goalCol, int goalRow){ //set others position on the map
        resetNode();

        // Set Start and Goal node
        startNode = node[startCol][startRow]; //start node on map
        currentNode = startNode; //node bat dau
        goalNode = node[goalCol][goalRow]; //goal node on map
        openList.add(currentNode);// dua node bat dau vao list

        int col = 0;
        int row = 0;

        while (col < gp.maxWorldCol && row < gp.maxWorldRow){// check solid (obstacles)

            // SET SOLID NODE
            // CHECK TILES
            int tileNum = gp.tileM.mapTileNumber[gp.currentMap][col][row];//value in the map (illustrating obstacle)
//            System.out.println("tileNum: " + tileNum);
            if (gp.tileM.tile[tileNum].collision){ // .collision: check va cham
                node[col][row].solid = true; //this node is an obstacle
            }

            // CHECK INTERACTIVE TILES ???? (assume map 1 has the greatest number of destructible objects)
            // why it needs to be repeated
//            for (int i = 0; i < gp.iTile[1].length; i++) {//can it be destroyed
//                if (gp.iTile[gp.currentMap][i] != null && gp.iTile[gp.currentMap][i].destructible){
//                    int itCol = gp.iTile[gp.currentMap][i].worldX / gp.tileSize;
//                    int itRow = gp.iTile[gp.currentMap][i].worldY / gp.tileSize;
//                    node[itCol][itRow].solid = true;
//                }
//            }

            // SET COST
            getCost(node[col][row]);//tinh trong so cho node

            col++;
            if (col == gp.maxWorldCol){
                col = 0;
                row++;
            }
        }
    }

    public void getCost(Node node){//tinh trong so

        // G cost: khoang cach tu 1 diem den diem bat dau
        int xDistance = Math.abs(node.col - startNode.col);
        int yDistance = Math.abs(node.row - startNode.row);
        node.gCost = xDistance + yDistance;

        // H cost: khoang cach tu 1 diem den diem ket thuc
        xDistance = Math.abs(node.col - goalNode.col);
        yDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xDistance + yDistance;

        // F cost
        node.fCost = node.gCost + node.hCost;
    }

    public boolean search(){//tim duong
        while(!goalReached && step < 500){//toi da 500 buoc, ko tim thay se ko chase nua
            int col = currentNode.col; //diem bat dau
            int row = currentNode.row;

            // Check the current node
            currentNode.checked = true; //danh dau da di
            openList.remove(currentNode);

            // Open the Up node
            if (row - 1 >= 0){
                openNode(node[col][row - 1]);
            }

            // Open the Left node
            if (col - 1 >= 0){
                openNode(node[col - 1][row]);
            }

            // Open the Down node
            if (row + 1 < gp.maxWorldRow){
                openNode(node[col][row + 1]);
            }

            // Open the Right node
            if (col + 1 < gp.maxWorldCol){
                openNode(node[col + 1][row]);
            }

            // Find the best node
            int bestNodeIndex = 0;
            int bestNodeFCost = 999;

            for (int i = 0; i < openList.size(); i++) {

                // Check if this node's F cost is better
                if (openList.get(i).fCost < bestNodeFCost){
                    bestNodeIndex = i;
                    bestNodeFCost = openList.get(i).fCost;
                }

                // If F cost is equal, check the G Cost
                else if (openList.get(i).fCost == bestNodeFCost){
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost){
                        bestNodeIndex = i;
                    }
                }
            }

            // If there is no node in the openList, end the loop
            if (openList.size() == 0){
                break;
            }

            // After the loop, openList[bestNodeIndex] is the next step (=currentNode)
            currentNode = openList.get(bestNodeIndex);

            if (currentNode == goalNode){
                goalReached = true;
                trackThePath();
            }

            step++;
        }
        return goalReached;
    }

    public void openNode(Node node){//mo duong
        if (!node.open && !node.checked && !node.solid){
            node.open = true;
            node.parent = currentNode;
            openList.add(node);
        }
    }

    public void trackThePath(){//backtrack t
        Node current = goalNode;

        while (current != startNode){
            // Always adding to the first slot so the last added node is in the [0]
            // With this list any NPCs or Monsters can track the path
            pathList.add(0, current);

            current = current.parent;
        }
    }
}
