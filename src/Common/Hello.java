import java.util.*;
class Node{
    int i,j,distance;
    Node(int i,int j,int distance){
        this.i=i;
        this.j=j;
        this.distance=distance;
    }
}


class Hello {
    public static void main(String[] args) {

        int result[][] = allCellsDistOrder(2,2,0,1);
        for(int num[] : result)
        {
            System.out.print(Arrays.toString(num));
        }
    }

    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        ArrayList<Node> list=new ArrayList<>();
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                list.add(new Node(i,j,Math.abs(rCenter-i)+Math.abs(cCenter-j)));


        for(int i=0;i<list.size();i++)
        {
            System.out.print(list.get(i).i);
            System.out.print(list.get(i).j);
            System.out.print(list.get(i).distance);
             System.out.println();
        }

        Collections.sort(list,(a,b)->a.distance-b.distance);



        int result[][]=new int[list.size()][2];
        for(int i=0;i<list.size();i++)
        {
            result[i][0]=list.get(i).i;
            result[i][1]=list.get(i).j;
        }


        return result;
    }
}