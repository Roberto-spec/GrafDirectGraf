import java.util.ArrayDeque;
import java.util.Queue;

public class DirectedGraf {
    private int[][] matrix;
    private Vertex[] VertexList;

    public DirectedGraf() {
        VertexList =new Vertex[1];
        matrix=new int[1][1];
        matrix[0][0]=0;
    }


    public void addVertex(int key){
        int len= VertexList.length;
        if(VertexList[0]==null) {
            VertexList[0] = new Vertex(key);
        }
        else{
            VertexList[len-1]=new Vertex(key);
        }
        Vertex[] v= new Vertex[len+1];
        for(int i=0;i<len;i++){
            v[i]=VertexList[i];
        }
        len= matrix.length;
        int[][] m=new int[len+1][len+1];
        for(int i=0;i<len+1;i++) {
            m[i][len-1]=0;
            m[len-1][i]=0;
        }
        matrix=m;
        VertexList=v;
    }
    private int findVertex(int key){
        int len= VertexList.length;
        for(int i=0;i<len;i++){
            if(key==VertexList[i].getKey()) return i;
        }
        return -1;
    }

    public void addMatch(int keyFrom,int keyTo){
        int indexFrom=findVertex(keyFrom);
        int indexTo=findVertex(keyTo);
        if(indexFrom!=1&&indexTo!=-1)matrix[keyFrom][keyTo]=1;
    }
    public void ObhodGlubina(int start){
        for(int i=0;i<matrix.length;){
            VertexList[i].setVisited(false);
        }
        startGlubina(start);
    }
    private void startGlubina(int index){
        if(index>=matrix.length||index<0){
            return;
        }
        VertexList[index].setVisited(true);
        Queue<Integer> queue=new ArrayDeque<>();
        int indexVisibleVertex;
        while ((indexVisibleVertex=getIndexVisible(index))!=-1){
            queue.add(indexVisibleVertex);
            VertexList[indexVisibleVertex].setVisited(true);
        }
        while(!queue.isEmpty()){
            startGlubina(queue.poll());
        }

    }
    private int getIndexVisible(int index){
        if(index>-1&&index< matrix.length){
            for(int i=0;i< matrix.length;i++){
                if(matrix[index][i]==1&&!VertexList[i].isVisited()){
                    return i;
                }
            }
        }
        return -1;
    }


}
