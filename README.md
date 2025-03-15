This is a dungeon crawler video game that I created in the first semester of my computer science degree. The player must escape, fighting monsters along the way, ultimately engaging in a final boss fight that ends the game. To run it, simply run the program the way your IDE would have you run programs (which is probably a start button).
    
This game uses basic OOP design principles and concepts. The "Player" is a class of its own and so is the "Enemy" class, storing stats for each instance of the Enemy class. The "Node" class is for the express purpose of specifying enemies at certain coordinates on the map. The "Map" class is designed to create the game map using a 2D array and track where the player, enemies, and interactables are on the map. The “Interactables” class has yet to be completed, however, the intent is to have the player pick up weapons and power-ups as they traverse the map. The “Chance” class is designed to lend successful attacks to random chance. Finally, the “Combat” class stores the combat loop, where I utilized multiple if-else statements and a while loop (to check the life status of the player and enemy). Very simple concept and very simple OOP design principles. It is a work in progress.

From the perspective of the user, here is how it works: They are prompted to choose a cardinal direction: n for North, s for South, w for West, and e for East. As they navigate the dungeon, they may encounter and pick up new weapons, or they might encounter and fight enemies as they try to escape. It looks like this:
![image](https://github.com/user-attachments/assets/b385d240-2936-484e-884e-05fc87556f29)

They may also request to see the map by simply typing "map":
![image](https://github.com/user-attachments/assets/374ead58-133c-4f4f-a7da-e0c489759ec1)

If they engage in a battle with an enemy, then they activate the combat loop. It would look like this:
![image](https://github.com/user-attachments/assets/821b3ace-c6c7-4536-ab5b-9e6a40b77a7c)
