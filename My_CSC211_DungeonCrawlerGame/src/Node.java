public class Node {
    private Enemies local;
    private boolean isEnd;
//    private boolean isAlive;

    /* Allows us to set which enemy we'll be fighting at the coordinates that we'll arrive at and allows us
       to set whether or nor the enemy is the final boss*/
    public Node(Enemies local, boolean isEnd){
        this.local = local;
        this.isEnd = isEnd;
    }

    public Enemies getLocalEnemy(){
        return local;
    }
}
