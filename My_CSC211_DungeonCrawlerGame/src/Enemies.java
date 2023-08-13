public class Enemies {
    public String name;
    private int maxNumberOfHealingPowerUses, currNumberOfHealingUses, hpFromHealingPower, maxHp, currentHp,
            attack, specialAtk, accuracy, defAgainstRangedWeapons, defAgainstCloseWeapons;

    // Allows us to create custom enemy objects
    public Enemies(String name, int maxNumberOfHealingPowerUses, int hpFromHealingPower, int maxHp,
                   int defAgainstRangedWeapons, int defAgainstCloseWeapons, int attack, int specialAtk,
                   int accuracy){
        this.name = name;
        this.maxNumberOfHealingPowerUses = maxNumberOfHealingPowerUses;
        currNumberOfHealingUses = this.maxNumberOfHealingPowerUses;
        this.hpFromHealingPower = hpFromHealingPower;
        this.maxHp = maxHp;
        currentHp = this.maxHp;
        this.defAgainstRangedWeapons = defAgainstRangedWeapons;
        this.defAgainstCloseWeapons = defAgainstCloseWeapons;
        this.attack = attack;
        this.specialAtk = specialAtk;
        this.accuracy = accuracy;
    }

    public int getEnemyAttack() {
        return attack;
    }

    public int getEnemySpecialAttack() {
        return specialAtk;
    }

    public int getCurrentNumberOfHealingPowerUses() { return currNumberOfHealingUses; }

    public int getCurrentHp() {return currentHp; }

    public int chanceAtkHits(){
        return new Chance(30).chanceOfSuccessfulHit() + accuracy;
    }

    // Certain enemies are impervious to close range attacks
    public boolean missesAtk(int playerAttack){
        System.out.println("Player missed attack!");
        return playerAttack < defAgainstCloseWeapons || playerAttack < defAgainstRangedWeapons;
    }

    public boolean stillAlive(){
        return currentHp > 0;
    }

//    public void damageTaken(int playerAttack){
//        currentHp -= playerAttack;
//    }

    public int damageTaken(int playerAttack){
        currentHp -= playerAttack;
        return currentHp;
    }

    // Tracks the number of times an enemy can use their healing power
    public int enemyHealthRestored(int currNumberOfHealingUses){
        currNumberOfHealingUses--;
        currentHp = currentHp + hpFromHealingPower;
        return hpFromHealingPower;
    }

}

