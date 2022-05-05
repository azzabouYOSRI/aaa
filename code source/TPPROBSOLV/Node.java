package TPPROBSOLV;

import java.util.ArrayList;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JC
 */
public class Node implements Comparable<Node> {
     private int cityNumber;
   // @EqualsAndHashCode.Include
    private int cost;
    private int[][] reducedMatrix;
    private List<Integer> CurrentWay=new ArrayList<>();
    private boolean ReadyNode =false;

    public Node(int cityNumber, int cost, int[][] reducedMatrix) {
        this.cityNumber = cityNumber;
        this.cost = cost;
        this.reducedMatrix = reducedMatrix;
    }

    public Node() {
    }

    public int getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(int cityNumber) {
        this.cityNumber = cityNumber;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int[][] getReducedMatrix() {
        return reducedMatrix;
    }

    public void setReducedMatrix(int[][] reducedMatrix) {
        this.reducedMatrix = reducedMatrix;
    }

    public List<Integer> getCurrentWay() {
        return CurrentWay;
    }

    public void setCurrentWay(List<Integer> CurrentWay) {
        this.CurrentWay = CurrentWay;
    }

    public boolean isReadyNode() {
        return ReadyNode;
    }

    public void setReadyNode(boolean ReadyNode) {
        this.ReadyNode = ReadyNode;
    }

  

    @Override
    public int compareTo(Node o) {
        if(o ==null)
            return 1;
        return this.cost-o.cost;

    }
    
}
