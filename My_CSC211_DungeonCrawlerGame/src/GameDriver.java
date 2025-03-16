public class GameDriver {
    public static void main(String[] args){
        Map map = new Map();
        map.mapTraversal();  // To explore the map. This is a beta. Errors may occur as
                             // things like pickups have yet to be integrated into the map.

        CombatBeta beta = new CombatBeta();
        beta.runCombat();  // To begin the combat loop on the final boss. This is also a beta.

        /* The map traversal is slightly buggy as it hasn't been fully completed. The combat loop
         runs decently well, so comment out line 4, the mapTraversal line to run the
         combat loop. */
    }
}
