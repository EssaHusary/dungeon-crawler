import java.util.Random;

public class Chance {
    public int x;

    public Chance(int x){
        this.x = x;
    }

    // Random number is generated for a certain range of values
    public int chanceOfSuccessfulHit(){
        return new Random().nextInt(x);
    }
}
