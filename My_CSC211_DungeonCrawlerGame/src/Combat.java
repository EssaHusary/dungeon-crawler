import java.util.Scanner;

public class Combat {
    Player player;
    Enemies enemies;
    Node node;

    Combat(Player player, Enemies enemies, Node node){
        this.player = player;
        this.enemies = enemies;
        this.node = node;
    }

    public void runCombat(Enemies localEnemy){
        Scanner input = new Scanner(System.in);

        while (player.stillAlive() && localEnemy.stillAlive()){

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


            System.out.print("You have " + player.getCurrentHp() + " hp, " + player.getCurrNumberOfPotions()
                    + " power points, and " + player.getCurrNumberOfPotions() + " potions. Choose an action" +
                    " - Attack, Special Ability, or Heal: ");

            String playerAction = input.nextLine();

            System.out.println();


            if (playerAction.equalsIgnoreCase("Attack")){
                System.out.print("Choose weapon - The Bringer of Hikma, The Ring of Farraj, " +
                        " The Sword of Haqeeqah, or The Bow of Adalit: ");
                String weaponChoice = input.nextLine();
                System.out.println();

                if (weaponChoice.equalsIgnoreCase("The Bringer of Hikma")){

                    /* In the following "if" statement, if the random number generated earlier is less than
                       or equal to 6, then the enemy dodges the attack */
                    if (localEnemy.missesAtk(player.getPlayerBolaAttack()) || enemyDodge <= 5){
                        System.out.println(localEnemy.name + "dodged the attack!");
                    } else {
                        System.out.println("Attack successful!");
//                        int damageOfHikma = enemies.damageTaken(player.getPlayerBolaAttack());
//                        System.out.println("Enemy health reduced by " + damageOfHikma + " hp");
                        localEnemy.damageTaken(player.getPlayerBolaAttack());
                        System.out.println("Enemy health reduced by " +
                                player.getPlayerBolaAttack() + " hp");
                        System.out.println("Enemy health is now " + localEnemy.getCurrentHp() + " hp...");
                        System.out.println();
                    }

                } else if (weaponChoice.equalsIgnoreCase("The Ring of Farraj")){

                    // The following dodge hinges on randomly generated number
                    if (localEnemy.missesAtk(player.getPlayerRingAttack()) || enemyDodge <= 5){
                        System.out.println(localEnemy.name + "dodged the attack!");
                    } else {
                        System.out.println("Attack successful!");
//                        int damageOfFarraj = enemies.damageTaken(player.getPlayerRingAttack());
//                        System.out.println("Enemy health reduced by " + damageOfFarraj + " hp");
                        localEnemy.damageTaken(player.getPlayerRingAttack());
                        System.out.println("Enemy health reduced by " +
                                player.getPlayerRingAttack() + " hp");
                        System.out.println("Enemy health is now " + localEnemy.getCurrentHp() + " hp...");
                        System.out.println();
                    }

                } else if (weaponChoice.equalsIgnoreCase("The Sword of Haqeeqah")) {

                    // The following dodge hinges on randomly generated number
                    if (localEnemy.missesAtk(player.getPlayerSwordAttack()) || enemyDodge <= 5) {
                        System.out.println(localEnemy.name + "dodged the attack!");
                    } else {
                        System.out.println("Attack successful!");
//                        int damageOfHaqeeqah = enemies.damageTaken(player.getPlayerSwordAttack());
//                        System.out.println("Enemy health reduced by " + damageOfHaqeeqah + " hp");
                        localEnemy.damageTaken(player.getPlayerSwordAttack());
                        System.out.println("Enemy health reduced by " +
                                player.getPlayerSwordAttack() + " hp");
                        System.out.println("Enemy health is now " + localEnemy.getCurrentHp() + " hp...");
                        System.out.println();
                    }
                } else if (weaponChoice.equalsIgnoreCase("The Bow of Adalit")) {

                    // The following dodge hinges on randomly generated number
                    if (localEnemy.missesAtk(player.getPlayerBowAttack()) || enemyDodge <= 5) {
                        System.out.println(localEnemy.name + "dodged the attack!");
                    } else {
                        System.out.println("Attack successful!");
//                        int damageOfAdalit = enemies.damageTaken(player.getPlayerBowAttack());
//                        System.out.println("Enemy health reduced by " + damageOfAdalit + " hp");
                        localEnemy.damageTaken(player.getPlayerBowAttack());
                        System.out.println("Enemy health reduced by " +
                                player.getPlayerBowAttack() + " hp");
                        System.out.println("Enemy health is now " + localEnemy.getCurrentHp() + " hp...");
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
                if (player.getCurrNumberOfPowerPoints() <= 50 && player.getCurrNumberOfPowerPoints() > 0){
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
                            System.out.println(localEnemy.name + "is shocked by its power!");
                            System.out.println("Enemy health reduced by 150 hp");
//                            enemyHealth = enemyHealth - 40;
//                            powerPoints = powerPoints - 10;
                            System.out.println("Enemy health is now " +
                                    localEnemy.damageTaken(player.getPlayerSpecialAttack()) + " hp...");
                            System.out.println("Player has " + player.getCurrNumberOfPowerPoints() + " power points remaining...");
                            System.out.println();
                        } else {
                            System.out.println("The special attack wasn't very effective!");
                            System.out.println(localEnemy.name +  "wasn't very affected by it's power.");
                            System.out.println("Enemy health reduced by 40 hp");
//                            enemyHealth = enemyHealth - 40;
//                            powerPoints = powerPoints - 10;
                            int enemyHealth = localEnemy.getCurrentHp() - 40;
                            int powerPoints = player.getCurrNumberOfPowerPoints() - 10;
                            System.out.println("Enemy health is now " + enemyHealth + " hp...");
                            System.out.println("Player has " + powerPoints + " power points remaining...");
                            System.out.println();
                        }
                    } else if (specialAbilityChoice.equalsIgnoreCase("Weapon Booster")){

                        // Player needs at least 30 points to use "weapon booster"
                        if (player.getCurrNumberOfPowerPoints() >= 30){
                            System.out.println("Player used Weapon Booster!");
                            System.out.println("All weapons are now double their previous strength!");
//                            powerPoints = powerPoints - 30;
//                            damageOfHikma = damageOfHikma * 2;
//                            damageOfFarraj = damageOfFarraj * 2;
//                            damageOfHaqeeqah = damageOfHaqeeqah * 2;
//                            damageOfAdalit = damageOfAdalit * 2;
                            System.out.println("Player has " + player.weaponBoost() + " power points left...");
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
                if (player.getCurrNumberOfPotions() <= 3 && player.getCurrNumberOfPotions() > 0 ){
                    System.out.println("Player healed themself!");
                    System.out.println("Player health increased by " + 90 + " hp!");
                    System.out.println("Player's health is now " +
                            player.healthAbsorbed(player.getCurrNumberOfPotions()) + " hp.");
                    System.out.println(player.getCurrNumberOfPotions() + " potion(s) remaining...");
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
            if (localEnemy.getCurrentHp() <= 0){

                if (localEnemy.name.equalsIgnoreCase("Al-Thi’b Al-Shabah")){

                    System.out.println("AL-THI'B AL-SHABAH IS DEAD! YOU HAVE BEATEN THE GAME! CONGRATS! " +
                            "HONOR AND GLORY AWAIT YOU BACK HOME, BRAVE WARRIOR!");
                    break; // Ends loop and program

                } else {

                    System.out.println(localEnemy.name + "IS DEAD! CONGRATS! CONTINUE FORWARD!");
                    break; // Ends loop

                }
            }





            /* Upon every iteration, the following print statement prints the stats and resources that
            need to be managed by enemy */
            System.out.println(localEnemy.name + "has " + localEnemy.getCurrentHp() + " hp and " +
                    localEnemy.getCurrentNumberOfHealingPowerUses() +
                    " healing power. He is choosing his action...");

            /* If enemy health is greater than 75 hp and if the random value is greater than 10 (probability
               that the enemy chooses to attack), the following "if" statement is
               executed */
            if (localEnemy.getCurrentHp() > 75 && enemyAttack > 10){
                // Whether or not the player dodges hinges on the randomly generated value
                if (playerDodge > 10){
                    System.out.println(localEnemy.name + "chose to attack!");
//                    playerHealth = playerHealth - damageOfEnemyAttack;
//                    System.out.println("Player health decreased by " + damageOfEnemyAttack + " hp!");
                    player.damageTaken(localEnemy.getEnemyAttack());
                    System.out.println("Player health decreased by " + localEnemy.getEnemyAttack() + " hp!");
                    System.out.println("Player's health is now " + player.getCurrentHp() + " hp.");
                    System.out.println();
                } else {
                    System.out.println("Player dodged the attack!");
                    System.out.println();
                }

               /* If enemy health is less than 75 hp and if the random value is greater than 10 (probability
                  that the enemy chooses to attack), the following "if" statement is executed. Pre-death attack
                  is used by enemy as a last resort  */
            } else if (localEnemy.getCurrentHp() < 75 && enemyAttack > 10){
                // Whether or not the player dodges hinges on the randomly generated value
                if (playerDodge > 10){
                    System.out.println(localEnemy.name + "chose to do his pre-death attack!");
//                    playerHealth = playerHealth - damageOfEnemyPreDeathAttack;
//                    System.out.println("Player health decreased by " + damageOfEnemyPreDeathAttack + " hp!");
                    player.damageTaken(localEnemy.getEnemySpecialAttack());
                    System.out.println("Player health decreased by " + localEnemy.getEnemySpecialAttack() + " hp!");
                    System.out.println("Player's health is now " + player.getCurrentHp() + " hp.");
                    System.out.println();
                } else {
                    System.out.println("Player dodged the attack!");
                    System.out.println();
                }

               /* If enemy health is less than 75 hp and if the random value is less than 10 (probability
                  that the enemy chooses to heal), the following "if" statement is executed. Enemy chooses
                  to heal, if he still has healing power */
            } else if ((localEnemy.getCurrentHp() < 75 && enemyAttack < 10)){

                // Whether he heals depends on how much healing power he has
                if (localEnemy.getCurrentNumberOfHealingPowerUses() > 0){
                    System.out.println(localEnemy.name + "chose to heal himself!");
//                    enemyHealth = enemyHealth + 50;
//                    enemyHealingPower = enemyHealingPower - 1;
                    System.out.println("Enemy health increased by " +
                            localEnemy.enemyHealthRestored(localEnemy.
                                    getCurrentNumberOfHealingPowerUses()) + " hp!");
                    System.out.println("Enemy's health is now " + localEnemy.getCurrentHp() + " hp.");
                    System.out.println("Enemy can no longer heal himself! He's a goner now!");
                    System.out.println();

                    // Not enough healing power, so he resorts to pre-death attack
                } else {
                    System.out.println(localEnemy.name + "chose to heal himself! BUT...");
                    System.out.println("He has no more healing power left!");
                    System.out.println("As a result," +  localEnemy.name + "has chosen to do his pre-death " +
                            "attack!");
//                    playerHealth = playerHealth - damageOfEnemyPreDeathAttack;
//                    System.out.println("Player health decreased by " + damageOfEnemyPreDeathAttack + " hp!");
                    player.damageTaken(localEnemy.getEnemySpecialAttack());
                    System.out.println("Player health decreased by " + localEnemy.getEnemySpecialAttack() +
                            " hp!");
                    System.out.println("Player's health is now " + player.getCurrentHp() + " hp.");
                    System.out.println();
                }
            }

            /* If player health is less than or equal to 0, the following print statement and break statement
               are executed. Enemy wins. */
            if (player.getCurrentHp() <= 0){
                System.out.println("YOU ARE DEAD! RETRY? CLICK 'RUN' IF SO...");
                break;   // Ends loop and program
            }
        }
    }
}


