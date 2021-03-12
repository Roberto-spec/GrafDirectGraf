public class Vertex {
    private int key;
    private boolean isVisited;

    public Vertex(int key) {
        this.key = key;
        isVisited=false;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
