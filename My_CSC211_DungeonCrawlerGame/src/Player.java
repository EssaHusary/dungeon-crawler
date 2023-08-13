public class Player {
    public String name;
    private int maxNumberOfPotions, currNumberOfPotions, maxNumberOfPowerPoints, currNumberOfPowerPoints, hpFromPotions,
            maxHp, currentHp, swordOfHaqeeqahAttack, ringOfFarrajAttack, bowOfAdalitAttack, bringerOfHikmaAttack,
            hornOfAbuKhattaibSpecialAtk, accuracy;

    // Stats for the player are initialized in this constructor
    public Player(){
        name = "Mijad";
        maxNumberOfPotions = 3;
        currNumberOfPotions = this.maxNumberOfPotions;
        maxNumberOfPowerPoints = 50;
        currNumberOfPowerPoints = this.maxNumberOfPowerPoints;
        hpFromPotions = 90;
        maxHp = 1000;
        currentHp = this.maxHp;
        swordOfHaqeeqahAttack = 85;
        ringOfFarrajAttack = 75;
        bowOfAdalitAttack = 100;
        bringerOfHikmaAttack = 90;
        hornOfAbuKhattaibSpecialAtk = 150;
        accuracy = 20;
    }

    public int getCurrentHp() {return currentHp; }

   // public int getCurrentNumberOfPotions() {return currNumberOfPotions; }

    public int getPlayerSwordAttack() {
        return swordOfHaqeeqahAttack;
    }

    public int getPlayerRingAttack() {
        return ringOfFarrajAttack;
    }

    public int getPlayerBowAttack() {
        return bowOfAdalitAttack;
    }

    public int getPlayerBolaAttack() {
        return bringerOfHikmaAttack;
    }

    public int getPlayerSpecialAttack() {

        currNumberOfPowerPoints = currNumberOfPowerPoints - 10;

        return hornOfAbuKhattaibSpecialAtk;
    }

    public int getCurrNumberOfPotions() { return currNumberOfPotions; }

    public int getCurrNumberOfPowerPoints() { return currNumberOfPowerPoints; }

    public int chanceAtkHits(){
        return new Chance(30).chanceOfSuccessfulHit() + accuracy;
    }

    public boolean stillAlive(){
        return currentHp > 0;
    }

    public int damageTaken(int enemyAttack){
        currentHp -= enemyAttack;

        return currentHp;
    }


    // Tracks the remaining number of healing potions that the player can use
    public int healthAbsorbed(int currNumberOfPotions){
        currNumberOfPotions--;
        currentHp = currentHp + hpFromPotions;

        return currentHp;
    }


    public int weaponBoost(){

        currNumberOfPowerPoints = currNumberOfPowerPoints - 30;

        bringerOfHikmaAttack = bringerOfHikmaAttack * 2;
        ringOfFarrajAttack = ringOfFarrajAttack * 2;
        swordOfHaqeeqahAttack = swordOfHaqeeqahAttack * 2;
        bowOfAdalitAttack = bowOfAdalitAttack * 2;

        return currNumberOfPowerPoints;
    }
}


