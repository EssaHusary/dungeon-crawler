import java.util.Scanner;

public class CombatBeta {
    Player player;
    Enemies enemies;

    Combat(Player player, Enemies enemies){
        this.player = player;
        this.enemies = enemies;
    }

    public void runCombat(){
        Scanner input = new Scanner(System.in); // Creates new object of Scanner class


        // A series of variables are declared and assigned values
        int numberOfPotions = 3;
        int potionHealthPoints = 50;
        int powerPoints = 50;
        int damageOfHikma = 15;
        int damageOfFarraj = 15;
        int damageOfHaqeeqah = 15;
        int damageOfAdalit = 25;

        int damageOfEnemyAttack = 40;
        int damageOfEnemyPreDeathAttack = 60;
        int enemyHealingPower = 1;

        int playerHealth = 1000;
        int enemyHealth = 1000;

        /* The following "while" loop hinges on whether the player's health or the monster's health is
           above a value of 0. The player and the monster take turns choosing actions. Once either value
           is less than or equal to 0, the loop ends and a message displaying the results of the combat
           loop (ie you have died, you have won) is printed */
        while (playerHealth > 0 && enemyHealth > 0){

            /* In the following 4 lines, a random number between 0 and 100 is generated. The first
               variable's value determines whether or not the player's special attack is effective, the
               second variable's value determines whether or not the player dodges the enemy's attack,
               the third determines what action the enemy chooses to take, and the fourth determines
               whether or not the enemy dodges the player's basic attack. The probabilities can be seen
               in later lines (such as if the variable "specialAttackEffectiveness" has a value greater than 70,
               then the player's special attack will be effective) */
            int specialAttackEffectiveness = (int) (Math.random() * 101);
            int playerDodge = (int) (Math.random() * 101);
            int enemyAttack = (int) (Math.random() * 101);
            int enemyDodge = (int) (Math.random() * 101);

            /* Upon every iteration, the following print statement prints the stats and resources that
            need to be managed */
            System.out.print("You have " + playerHealth + " hp, " + powerPoints + " power points, and "
                    + numberOfPotions + " potions. Choose an action - Attack, Special " +
                    "Ability, or Heal: ");

            String playerAction = input.nextLine(); /* Takes user input. Assigns to variable the action that the
                                                       player wants to take */

            System.out.println(); // Creates a new, empty line that serves as a space between lines

            /* In the following "if" statement, if the player enters (any variation in the capitalization of)
               the word "Attack", the following statements nested within the "if" statement will be executed.*/
            if (playerAction.equalsIgnoreCase("Attack")){
                System.out.print("Choose weapon - The Bringer of Hikma, The Ring of Farraj, " +
                        " The Sword of Haqeeqah, or The Bow of Adalit: ");
                String weaponChoice = input.nextLine();
                System.out.println();

                if (weaponChoice.equalsIgnoreCase("The Bringer of Hikma")){

                    /* In the following "if" statement, if the random number generated earlier is less than
                       or equal to 6, then the enemy dodges the attack */
                    if (enemyDodge <= 5 ){
                        System.out.println("Al-Thi'b Al-Shabah dodged the attack!");
                    } else {
                        System.out.println("Attack successful!");
                        enemyHealth = enemyHealth - damageOfHikma; // Enemy health reset
                        System.out.println("Enemy health reduced by " + damageOfHikma + " hp");
                        System.out.println("Enemy health is now " + enemyHealth + " hp...");
                        System.out.println();
                    }

                } else if (weaponChoice.equalsIgnoreCase("The Ring of Farraj")){

                    // The following dodge hinges on randomly generated number
                    if (enemyDodge <= 5){
                        System.out.println("Al-Thi'b Al-Shabah dodged the attack!");
                    } else {
                        System.out.println("Attack successful!");
                        enemyHealth = enemyHealth - damageOfFarraj;
                        System.out.println("Enemy health reduced by " + damageOfFarraj + " hp");
                        System.out.println("Enemy health is now " + enemyHealth + " hp...");
                        System.out.println();
                    }

                } else if (weaponChoice.equalsIgnoreCase("The Sword of Haqeeqah")) {

                    // The following dodge hinges on randomly generated number
                    if (enemyDodge <= 10) {
                        System.out.println("Al-Thi'b Al-Shabah dodged the attack!");
                    } else {
                        System.out.println("Attack successful!");
                        enemyHealth = enemyHealth - damageOfHaqeeqah;
                        System.out.println("Enemy health reduced by " + damageOfHaqeeqah + " hp");
                        System.out.println("Enemy health is now " + enemyHealth + " hp...");
                        System.out.println();
                    }
                } else if (weaponChoice.equalsIgnoreCase("The Bow of Adalit")) {

                    // The following dodge hinges on randomly generated number
                    if (enemyDodge <= 5) {
                        System.out.println("Al-Thi'b Al-Shabah dodged the attack!");
                    } else {
                        System.out.println("Attack successful!");
                        enemyHealth = enemyHealth - damageOfAdalit;
                        System.out.println("Enemy health reduced by " + damageOfAdalit + " hp");
                        System.out.println("Enemy health is now " + enemyHealth + " hp...");
                        System.out.println();
                    }
                } else {

                    // Following is executed if there's a misspelling, or syntax error such as a lack of a space
                    System.out.println("Invalid choice! Either misspelled or something else went wrong!" +
                            " Redo your turn please!");
                    System.out.println();
                    continue; /* Player must restart their turn or change action if they didn't input a
                                 weapon name correctly */
                }
            } else if (playerAction.equalsIgnoreCase("Special Ability")){

                // Whether or not the player can perform a special ability hinges on the resource "power points"
                if (powerPoints <= 50 && powerPoints > 0){
                    System.out.print("Choose your special ability - The Horn of Abu-Khattaib or " +
                            "Weapon Booster (boosts the damage of your weapons by 2 times): ");
                    String specialAbilityChoice = input.nextLine();
                    System.out.println();
                    if (specialAbilityChoice.equalsIgnoreCase("The Horn of Abu-Khattaib")){
                        System.out.println("Player used The Horn of Abu-Khattaib!");

                        /* In the following line, whether or not the special attack is effective hinges on
                           the randomly generated number */
                        if (specialAttackEffectiveness > 70){
                            System.out.println("The special attack was super effective!");
                            System.out.println("Al-Thi'b Al-Shabah is shocked by its power!");
                            System.out.println("Enemy health reduced by 40 hp");
                            enemyHealth = enemyHealth - 40;
                            powerPoints = powerPoints - 10;
                            System.out.println("Enemy health is now " + enemyHealth + " hp...");
                            System.out.println("Player has " + powerPoints + " power points remaining...");
                            System.out.println();
                        } else {
                            System.out.println("The special attack wasn't very effective!");
                            System.out.println("Al-Thi'b Al-Shabah wasn't very affected by it's power.");
                            System.out.println("Enemy health reduced by 10 hp");
                            enemyHealth = enemyHealth - 10;
                            powerPoints = powerPoints - 10;
                            System.out.println("Enemy health is now " + enemyHealth + " hp...");
                            System.out.println("Player has " + powerPoints + " power points remaining...");
                            System.out.println();
                        }
                    } else if (specialAbilityChoice.equalsIgnoreCase("Weapon Booster")){

                        // Player needs at least 30 points to use "weapon booster"
                        if (powerPoints >= 30){
                            System.out.println("Player used Weapon Booster!");
                            System.out.println("All weapons are now double their previous strength!");
                            powerPoints = powerPoints - 30;
                            damageOfHikma = damageOfHikma * 2;
                            damageOfFarraj = damageOfFarraj * 2;
                            damageOfHaqeeqah = damageOfHaqeeqah * 2;
                            damageOfAdalit = damageOfAdalit * 2;
                            System.out.println("Player has " + powerPoints + " power points left...");
                            System.out.println();

                            // Not enough points means that they can't use the booster
                        } else {
                            System.out.println("Not enough Power Points! Can't use special ability! " +
                                    "At least 30 points are required to use this ability!");
                            System.out.println("Please choose another action...");
                            System.out.println();
                            continue; // Must restart turn if there aren't enough points
                        }

                    } else {

                        // Following is executed if there's a misspelling, or syntax error
                        System.out.println("Invalid choice! Either misspelled or something else went wrong!" +
                                " Redo your turn please!");
                        System.out.println();
                        continue; // Player must restart their turn if they didn't input an ability name correctly
                    }


                } else {   // Not enough points means that they can't use either ability
                    System.out.println("Not enough Power Points! Can't use either special ability! " +
                            "At least 10 points are required to use a special ability");
                    System.out.println("Please choose another action...");
                    System.out.println();
                    continue; /* Must restart turn and perform other action if there aren't enough points
                                 to perform either ability */
                }

            } else if (playerAction.equalsIgnoreCase("Heal")){

                // Player has max of 3 potions
                if (numberOfPotions <= 3 && numberOfPotions > 0 ){
                    System.out.println("Player healed themself!");
                    playerHealth = playerHealth + potionHealthPoints;
                    System.out.println("Player health increased by " + potionHealthPoints + " hp!");
                    System.out.println("Player's health is now " + playerHealth + " hp.");
                    numberOfPotions = numberOfPotions - 1;
                    System.out.println(numberOfPotions + " potion(s) remaining...");
                    System.out.println();

                } else { // Not enough potions means that they can't heal
                    System.out.println("No more potions remaining! Can't heal!");
                    System.out.println("Please choose another action...");
                    System.out.println();
                    continue; /* Must restart turn and perform other action if there aren't enough potions
                                 to heal */
                }
            } else {

                // Following is executed if there's a misspelling, or syntax error when typing "heal"
                System.out.println("Invalid choice! Either misspelled or something else went wrong!" +
                        " Redo your turn please!");
                System.out.println();
                continue; // Player must restart their turn if they didn't input the action name correctly
            }


            /* If enemy health is less than or equal to 0, the following print statement and break statement
               are executed. Player wins. */
            if (enemyHealth <= 0){
                System.out.println("AL-THI'B AL-SHABAH IS DEAD! YOU HAVE BEATEN THE GAME! CONGRATS! " +
                        "HONOR AND GLORY AWAIT YOU BACK HOME, BRAVE WARRIOR!");
                break; // Ends loop and program
            }



            /* Upon every iteration, the following print statement prints the stats and resources that
            need to be managed by enemy */
            System.out.println("Al-Thi'b Al-Shabah has " + enemyHealth + " hp and " + enemyHealingPower +
                    " healing power. He is choosing his action...");

            /* If enemy health is greater than 75 hp and if the random value is greater than 10 (probability
               that the enemy chooses to attack), the following "if" statement is
               executed */
            if (enemyHealth > 75 && enemyAttack > 10){
                // Whether or not the player dodges hinges on the randomly generated value
                if (playerDodge > 10){
                    System.out.println("Al-Thi'b Al-Shabah chose to attack!");
                    playerHealth = playerHealth - damageOfEnemyAttack;
                    System.out.println("Player health decreased by " + damageOfEnemyAttack + " hp!");
                    System.out.println("Player's health is now " + playerHealth + " hp.");
                    System.out.println();
                } else {
                    System.out.println("Player dodged the attack!");
                    System.out.println();
                }

               /* If enemy health is less than 75 hp and if the random value is greater than 10 (probability
                  that the enemy chooses to attack), the following "if" statement is executed. Pre-death attack
                  is used by enemy as a last resort  */
            } else if (enemyHealth < 75 && enemyAttack > 10){
                // Whether or not the player dodges hinges on the randomly generated value
                if (playerDodge > 10){
                    System.out.println("Al-Thi'b Al-Shabah chose to do his pre-death attack!");
                    playerHealth = playerHealth - damageOfEnemyPreDeathAttack;
                    System.out.println("Player health decreased by " + damageOfEnemyPreDeathAttack + " hp!");
                    System.out.println("Player's health is now " + playerHealth + " hp.");
                    System.out.println();
                } else {
                    System.out.println("Player dodged the attack!");
                    System.out.println();
                }

               /* If enemy health is less than 75 hp and if the random value is less than 10 (probability
                  that the enemy chooses to heal), the following "if" statement is executed. Enemy chooses
                  to heal, if he still has healing power */
            } else if ((enemyHealth < 75 && enemyAttack < 10)){

                // Whether he heal depends on how much healing power he has
                if (enemyHealingPower > 0){
                    System.out.println("Al-Thi'b Al-Shabah chose to heal himself!");
                    enemyHealth = enemyHealth + 50;
                    enemyHealingPower = enemyHealingPower - 1;
                    System.out.println("Enemy health increased by " + 50 + " hp!");
                    System.out.println("Enemy's health is now " + enemyHealth + " hp.");
                    System.out.println("Enemy can no longer heal himself! He's a goner now!");
                    System.out.println();

                    // Not enough healing power, so he resorts to pre-death attack
                } else {
                    System.out.println("Al-Thi'b Al-Shabah chose to heal himself! BUT...");
                    System.out.println("He has no more healing power left!");
                    System.out.println("As a result, Al-Thi'b Al-Shabah has chosen to do his pre-death attack!");
                    playerHealth = playerHealth - damageOfEnemyPreDeathAttack;
                    System.out.println("Player health decreased by " + damageOfEnemyPreDeathAttack + " hp!");
                    System.out.println("Player's health is now " + playerHealth + " hp.");
                    System.out.println();
                }
            }

            /* If player health is less than or equal to 0, the following print statement and break statement
               are executed. Enemy wins. */
            if (playerHealth <= 0){
                System.out.println("YOU ARE DEAD! RETRY? CLICK 'RUN' IF SO...");
                break;   // Ends loop and program
            }
        }
    }
}
