import java.util.Scanner;

public class Map {

    Node node;
    Combat combat;
    Node[][] enemyMap = new Node[10][7];

    // The array/map is initialized
    private static char[][] map = {
            {' ', ' ', ' ', 'h', 'h', ' ', ' '},
            {' ', ' ', 'E', '1', '7', 'h', ' '},
            {' ', ' ', ' ', '1', ' ', '5', ' '},
            {' ', ' ', ' ', 'h', ' ', ' ', ' '},
            {'h', 'e', ' ', 'X', 'h', '4', 'h'},
            {'h', '2', ' ', '8', '9', 'h', 'h'},
            {' ', 'h', ' ', 'h', 'h', 'h', ' '},
            {' ', 'h', 'h', '3', ' ', ' ', ' '},
            {' ', ' ', 'h', 'h', ' ', ' ', ' '},
            {' ', ' ', 'h', '6', ' ', ' ', ' '},
    };

    public static int playerRow = 1; // Player's starting row
    public static int playerColumn = 2; // Player's starting column

    public Map(){
        Enemies rajulAlRamal = new Enemies("Rajul Al-Ramal", 2,
                70, 500, 10, 5, 75,
                95, 7);
        Enemies quzamAlMawt = new Enemies("Quzam Al-Mawt", 0,
                0, 800, 20, 200, 90,
                105, 2);
        Enemies kabshAlJaheem = new Enemies("Kabsh Al-Jaheem", 1,
                50, 500, 10, 5, 80,
                90, 9);
        Enemies kharabAlRooh = new Enemies("Kharab Al-Rooh", 0,
                0, 700, 10, 1000, 80,
                85, 10);
        Enemies thibAlShabah = new Enemies("Thi’b Al-Shabah", 3,
                100, 1000, 10, 5, 95,
                125, 15);

        // Sets enemies at these coordinates

        enemyMap[2][3] = new Node(rajulAlRamal, false);
        enemyMap[2][5] = new Node(kharabAlRooh, false);
        enemyMap[4][5] = new Node(kabshAlJaheem, false);
        enemyMap[7][3] = new Node(quzamAlMawt, false);
        enemyMap[4][1] = new Node(thibAlShabah, true);

//        enemyMap[2][3] = new Node(rajulAlRamal, false, true);
//        enemyMap[2][5] = new Node(kharabAlRooh, false, true);
//        enemyMap[4][5] = new Node(kabshAlJaheem, false, true);
//        enemyMap[7][3] = new Node(quzamAlMawt, false, true);
//        enemyMap[4][1] = new Node(thibAlShabah, true, true);
    }




    public static void displayMap(){

        System.out.println();

        // Prints the map. The spot where the player is located will be assigned a value of 'P' (for player)
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++){

                map[playerRow][playerColumn] = 'P';
                System.out.print(map[i][j] + " ");

            }
            System.out.println(); /* Upon every iteration of the outside loop (the rows), a new row is separated
                                     from the previous row */
        }

        // Initializes a new map that will be used to reset current map to former state
        char[][] resetMap = {
                {' ', ' ', ' ', 'h', 'h', ' ', ' '},
                {' ', ' ', 'E', '1', '7', 'h', ' '},
                {' ', ' ', ' ', '1', ' ', '5', ' '},
                {' ', ' ', ' ', 'h', ' ', ' ', ' '},
                {'h', 'e', ' ', 'X', 'h', '4', 'h'},
                {'h', '2', ' ', '8', '9', 'h', 'h'},
                {' ', 'h', ' ', 'h', 'h', 'h', ' '},
                {' ', 'h', 'h', '3', ' ', ' ', ' '},
                {' ', ' ', 'h', 'h', ' ', ' ', ' '},
                {' ', ' ', 'h', '6', ' ', ' ', ' '},
        };

        map = resetMap; // Resets map to former state

        // Below is the legend for the map
        System.out.println("Numbers 1-9 = respective room #");
        System.out.println("X = Room 10");
        System.out.println("E = entrance");
        System.out.println("e = exit");
        System.out.println("h = hallway");
        System.out.println("P = player location on the map");
        System.out.println();
    }

    public void mapTraversal(){
        Scanner input = new Scanner(System.in); // Creates new object of Scanner class

        int j = 0; /* The while loop below hinges on whether j = 0. The variable j will be assigned a value
                      of 1 to end the program (when the player reaches the exit) */

        while (j == 0){

            System.out.println();
            System.out.print("Please enter a cardinal direction to move. Type 'n' for north, 's' for south, " +
                    " 'e' for east, and 'w' for west. Otherwise, type 'map' to see the map: ");

            String playerChoiceMove = input.nextLine();


            if (playerChoiceMove.equalsIgnoreCase("n")){

                /* If the player tries moving from room 8 to room 10, room 2 to the exit, or tries to move out
                   of bounds on the north end of the map (where the two 'h' symbols are), they will be informed
                   that the move they attempted to make was illegal */
                if ((playerRow == 5 && playerColumn == 3) || (playerRow == 5 && playerColumn == 1) ||
                        (playerRow == 0 && playerColumn == 3) || (playerRow == 0 && playerColumn == 4)){

                    System.out.println();
                    System.out.println("You've made an illegal move. Please select another move.");
                    continue; // Player must retry move

                } else {
                    playerRow--; // Temporarily changes row of player. See below line

                    /* If they attempt to go out of bounds, playerRow will be incremented, returning the player
                       to the previous row that they were on */
                    if (map[playerRow][playerColumn] == ' '){

                        playerRow++; // Goes back to previous row (increments "playerRow")
                        System.out.println();
                        System.out.println("You've made an illegal move. You can't move " +
                                " outside of the map. Please select another move.");
                        continue; // Player must retry move

                    } else {
                        if (map[playerRow][playerColumn] == 'h'){
                            System.out.println();
                            System.out.println("You are in the hallway.");
                        } else {
                            System.out.println();
                            System.out.println("You are in room " + map[playerRow][playerColumn] + ".");
                        }
                    }
                }


            } else if (playerChoiceMove.equalsIgnoreCase("s")){

                /* If the player tries moving from the exit to room 2, room 10 (X) to room 8, or tries to move
                   out of bounds on the south end of the map (where the 'h' and '6' symbols are), they will be
                   informed that the move they attempted to make was illegal */
                if ((playerRow == 4 && playerColumn == 1) || (playerRow == 4 && playerColumn == 3) ||
                        (playerRow == 9 && playerColumn == 2) || (playerRow == 9 && playerColumn == 3)){

                    System.out.println();
                    System.out.println("You've made an illegal move. Please select another move.");
                    continue;

                } else {
                    playerRow++; // Temporarily changes row of player. See below line

                    // If they attempt to go out of bounds, the following will be executed
                    if (map[playerRow][playerColumn] == ' '){

                        playerRow--;
                        System.out.println();
                        System.out.println("You've made an illegal move. You can't move " +
                                " outside of the map. Please select another move.");
                        continue;

                    } else {
                        if (map[playerRow][playerColumn] == 'h'){
                            System.out.println();
                            System.out.println("You are in the hallway.");
                        } else {
                            System.out.println();
                            System.out.println("You are in room " + map[playerRow][playerColumn] + ".");
                        }
                    }
                }

            } else if (playerChoiceMove.equalsIgnoreCase("e")){

                /* If the player tries moving from room 1 to room 7, room 8 to room 9, or tries to move out
                   of bounds on the east end of the map (where the two 'h' symbols are), they will be informed
                   that the move they attempted to make was illegal */
                if ((playerRow == 1 && playerColumn == 3) || (playerRow == 5 && playerColumn == 3) ||
                        (playerRow == 4 && playerColumn == 6) || (playerRow == 5 && playerColumn == 6)){

                    System.out.println();
                    System.out.println("You've made an illegal move. Please select another move.");
                    continue;

                } else {
                    playerColumn++; // Temporarily changes column of player. See below line

                    // If they attempt to go out of bounds, the following will be executed
                    if (map[playerRow][playerColumn] == ' '){

                        playerColumn--;
                        System.out.println();
                        System.out.println("You've made an illegal move. You can't move " +
                                " outside of the map. Please select another move.");
                        continue;

                    } else {
                        if (map[playerRow][playerColumn] == 'h'){
                            System.out.println();
                            System.out.println("You are in the hallway.");
                        } else {
                            System.out.println();
                            System.out.println("You are in room " + map[playerRow][playerColumn] + ".");
                        }
                    }
                }

            } else if (playerChoiceMove.equalsIgnoreCase("w")){

                /* If the player tries moving from room 7 to room 1, room 9 to room 8, or tries to move out
                   of bounds on the west end of the map (where the two 'h' symbols are), they will be informed
                   that the move they attempted to make was illegal */
                if ((playerRow == 1 && playerColumn == 4) || (playerRow == 5 && playerColumn == 4) ||
                        (playerRow == 4 && playerColumn == 0) || (playerRow == 5 && playerColumn == 0)){

                    System.out.println();
                    System.out.println("You've made an illegal move. Please select another move.");
                    continue;

                } else {
                    playerColumn--; // Temporarily changes column of player. See below line

                    // If they attempt to go out of bounds, the following will be executed
                    if (map[playerRow][playerColumn] == ' '){

                        playerColumn++;
                        System.out.println();
                        System.out.println("You've made an illegal move. You can't move " +
                                " outside of the map. Please select another move.");
                        continue;

                    } else {
                        if (map[playerRow][playerColumn] == 'h'){
                            System.out.println();
                            System.out.println("You are in the hallway.");
                        } else {
                            System.out.println();
                            System.out.println("You are in room " + map[playerRow][playerColumn] + ".");
                        }
                    }
                }

            } else if (playerChoiceMove.equalsIgnoreCase("map")){
                displayMap(); // Calls the displayMap method
            }



//            if (map[playerRow][playerColumn] == '1'){
//                System.out.println();
//                System.out.println("This is a 90’ x 90’ room. " +
//                        "Has writing (in blood) on the south wall (bird's eye view) which " +
//                        "reads, 'Help me'. The western wall and eastern walls have blood " +
//                        "stains on them. The doors to the north and south of the room open " +
//                        "up to hallways. The northern wall reads, 'You made a mistake entering " +
//                        "here.'");
//            }


            if (map[playerRow][playerColumn] == map[1][3]){
                System.out.println();
                System.out.println("This is a 90’ x 90’ room. " +
                        "Has writing (in blood) on the south wall (bird's eye view) which " +
                        "reads, 'Help me'. The western wall and eastern walls have blood " +
                        "stains on them. The doors to the north and south of the room open " +
                        "up to hallways. The northern wall reads, 'You made a mistake entering " +
                        "here.'");
            }


            if (map[playerRow][playerColumn] == map[2][3]){


                if(node.getLocalEnemy().stillAlive()){

                    System.out.println();
                    System.out.println("There's a sword here stuck in a random pool of sand. Pick it up?");
                    String wantToPickUp = input.nextLine();
                    if (wantToPickUp.equalsIgnoreCase("yes")){
                        System.out.println("Player: Woah, the sand's moving!");
                        System.out.println("* Player gets launched up in the air and falls some feet back as sand " +
                                "creature called \"Rajul Al-Ramal\" rises from this small pool of sand *");
                        System.out.println("Player: Hey, I've heard of this beast. This is Rajul Al-Ramal!");
                        System.out.println("Rajul Al-Ramal: grrrowwwaaahhahhhha!!!!");
                        combat.runCombat(enemyMap[2][3].getLocalEnemy());
                        enemyMap[2][3] = null;
                        System.out.println("Player: This sword is very handy. I'll keep it just in case.");
                    } else {
                        System.out.println("Player: Hmmm, I'll pick it up later.");
                    }

                }

                else if (!node.getLocalEnemy().stillAlive()){

                    System.out.println();
                    System.out.println("This is a 90’ x 90’ room. " +
                            "Has writing (in blood) on the south wall (bird's eye view) which " +
                            "reads, 'Help me'. The western wall and eastern walls have blood " +
                            "stains on them. The doors to the north and south of the room open " +
                            "up to hallways. The northern wall reads, 'You made a mistake entering " +
                            "here.'");
                }
            }


            if(map[playerRow][playerColumn] == 'X'){
                System.out.println();
                System.out.println("This is a 30’ x 50’ room. There are two doors opening up to hallways " +
                        "to the north and east of the room. Vacant looking. No visible signs " +
                        "of danger. However, there is a glowing gem on the southernmost wall.");
            }

            if(map[playerRow][playerColumn] == '4'){
                System.out.println();
                System.out.println("This is a 110’ x 70’ room. There are doors opening up to hallways to " +
                        "the south, east, and west of this room leading to rooms 8, 9, and 10 (X). " +
                        "Does not have a door on the western side, so the player can see all " +
                        "around the room before entering. It seems safe because there are no " +
                        "blood on the walls and no signs of any danger. There are hoove marks " +
                        "on the floor, however.");
            }

            if(map[playerRow][playerColumn] == '9'){
                System.out.println();
                System.out.println("This is a 90' x 30' room. There are doors opening up to hallways to the" +
                        "north, south, and east of the room. There's nothing peculiar about this " +
                        "room. It's quite rusty, yet plain.");
            }

            if(map[playerRow][playerColumn] == '8'){
                System.out.println();
                System.out.println("This is a 50’ x 70’ room. There's a door opening up to a hallway to the " +
                        "south of the room. The player sees nothing in this room except for " +
                        "a set of bolas in the middle of the room. Right next to the bolas " +
                        "is an inscription on the floor which reads, 'Take The Bringer of " +
                        "Hikma. It brings wisdom to those who wield it and folly to those who " +
                        "are dealt it.'");
            }

            if(map[playerRow][playerColumn] == '3'){
                System.out.println();
                System.out.println("This is a 110’ x 70’ room. There are doors opening up to hallways to the " +
                        "north, south, and west of this room. Every wall in the room has gore and " +
                        "blood splattered everywhere. Why? I don’t know, maybe because there’s a " +
                        "giant sand troll waiting to pummel all who enter the room!");
            }

            if(map[playerRow][playerColumn] == '6'){
                System.out.println();
                System.out.println("This is a 30’ x 70’ room. There are doors to the north and west of this " +
                        "room opening up to hallways leading to rooms 2 and 3. Empty, completely " +
                        "empty. Not a scratch or sign of danger in sight. Empty…..or so it " +
                        "appears. There is actually a hidden staircase underneath a semi-open " +
                        "floor panel located right where the number six is on the map.");
            }

            if(map[playerRow][playerColumn] == '2'){
                System.out.println();
                System.out.println("This is a 110’ x 50’ room. There is a door opening up to the hallway on " +
                        "the south side and there's a door opening up to the hallway on the west " +
                        "side. The eastern wall has spears attached to the walls " +
                        "with people’s heads and other limbs in these spears. The western wall " +
                        "has holes in it - these holes are where the spears come from. It’s a " +
                        "trap room.");
            }

            if(map[playerRow][playerColumn] == '5'){
                System.out.println();
                System.out.println("This is a 90’ x 50’ room. There's only one door opening up to the hallway " +
                        "on the north side of the room, so it’s  a dead end room (though it has an " +
                        "item of value). There are weird, gooey sand pods on the roof of the " +
                        "room and slime on all of the walls of the room.");
            }

            if(map[playerRow][playerColumn] == '7'){
                System.out.println();
                System.out.println("This is a 30’ x 110’ room. Has doors to the north and east of the " +
                        "room which open up to hallways. Appears small and empty, but there’s " +
                        "something fishy going on because there's no signs of immediate danger... ");
            }

            if(map[playerRow][playerColumn] == 'e'){
                System.out.println();
                System.out.println("You have beaten the final boss! You have passed the trials!" +
                        " Glory, honor, and high esteem await you, brave warrior!");

                j = 1; /* The variable j is assigned a value of 1 to end the program (since the while loop
                          above hinges on j being equal to 0 in order to run) */
            }
        }
    }
}

