package Monster;

import Data.Progress;
import Entity.Entity;
import Main.GamePanel;
import Obj.Consumables.OBJ_Coin;
import Obj.Consumables.OBJ_Key;
import Obj.OBJ_Chest;
import Obj.OBJ_Door_Iron;
import Obj.Consumables.OBJ_Heart;
import Obj.Consumables.OBJ_Mana_Crystal;
import Obj.Weapons.OBJ_Sword_Steel;

import java.util.Random;

public class MON_Golem extends Entity {

    GamePanel gp;
    public static final String monName = "Golem";

    public MON_Golem(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_monster;
        boss = true;
        name = monName;
        defaultSpeed = 1;
        speed = defaultSpeed;
        maxLife = 300;
        life = maxLife;
        attack = 13;
        defence = 2;
        exp = 200;
        knockBackPower = 5;
        sleep = false; //sleep = dont operate
        int size = gp.tileSize * 8;
        solidArea.x = 100;
        solidArea.y = 160;
        solidArea.width = size - 160 - 50;
        solidArea.height = size - 160 - 50;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        attackArea.x = 200;
        attackArea.y = 260;
        attackArea.width = 200;
        attackArea.height = 200;

        motionDuration = 30; // + 5
        motion2Duration = 60;// + 10

        getImage();
        getAttackImage();
        setDialogue();
    }

    public void getImage(){
        int i = 8;

        if (!inRage){
            up1 = setup("/Resources/Monsters/golem_left_1", gp.tileSize * i, gp.tileSize * i);
            up2 = setup("/Resources/Monsters/golem_left_2", gp.tileSize * i, gp.tileSize * i);
            up3 = setup("/Resources/Monsters/golem_left_3", gp.tileSize * i, gp.tileSize * i);
            up4 = setup("/Resources/Monsters/golem_left_4", gp.tileSize * i, gp.tileSize * i);

            down1 = setup("/Resources/Monsters/golem_right_1", gp.tileSize * i, gp.tileSize * i);
            down2 = setup("/Resources/Monsters/golem_right_2", gp.tileSize * i, gp.tileSize * i);
            down3 = setup("/Resources/Monsters/golem_right_3", gp.tileSize * i, gp.tileSize * i);
            down4 = setup("/Resources/Monsters/golem_right_4", gp.tileSize * i, gp.tileSize * i);

            left1 = setup("/Resources/Monsters/golem_left_1", gp.tileSize * i, gp.tileSize * i);
            left2 = setup("/Resources/Monsters/golem_left_2", gp.tileSize * i, gp.tileSize * i);
            left3 = setup("/Resources/Monsters/golem_left_3", gp.tileSize * i, gp.tileSize * i);
            left4 = setup("/Resources/Monsters/golem_left_4", gp.tileSize * i, gp.tileSize * i);

            right1 = setup("/Resources/Monsters/golem_right_1", gp.tileSize * i, gp.tileSize * i);
            right2 = setup("/Resources/Monsters/golem_right_2", gp.tileSize * i, gp.tileSize * i);
            right3 = setup("/Resources/Monsters/golem_right_3", gp.tileSize * i, gp.tileSize * i);
            right4 = setup("/Resources/Monsters/golem_right_4", gp.tileSize * i, gp.tileSize * i);
        }

        if (inRage){

            up1 = setup("/Resources/Monsters/golem2_left_1", gp.tileSize * i, gp.tileSize * i);
            up2 = setup("/Resources/Monsters/golem2_left_2", gp.tileSize * i, gp.tileSize * i);
            up3 = setup("/Resources/Monsters/golem2_left_3", gp.tileSize * i, gp.tileSize * i);
            up4 = setup("/Resources/Monsters/golem2_left_4", gp.tileSize * i, gp.tileSize * i);

            down1 = setup("/Resources/Monsters/golem2_right_1", gp.tileSize * i, gp.tileSize * i);
            down2 = setup("/Resources/Monsters/golem2_right_2", gp.tileSize * i, gp.tileSize * i);
            down3 = setup("/Resources/Monsters/golem2_right_3", gp.tileSize * i, gp.tileSize * i);
            down4 = setup("/Resources/Monsters/golem2_right_4", gp.tileSize * i, gp.tileSize * i);

            left1 = setup("/Resources/Monsters/golem2_left_1", gp.tileSize * i, gp.tileSize * i);
            left2 = setup("/Resources/Monsters/golem2_left_2", gp.tileSize * i, gp.tileSize * i);
            left3 = setup("/Resources/Monsters/golem2_left_3", gp.tileSize * i, gp.tileSize * i);
            left4 = setup("/Resources/Monsters/golem2_left_4", gp.tileSize * i, gp.tileSize * i);

            right1 = setup("/Resources/Monsters/golem2_right_1", gp.tileSize * i, gp.tileSize * i);
            right2 = setup("/Resources/Monsters/golem2_right_2", gp.tileSize * i, gp.tileSize * i);
            right3 = setup("/Resources/Monsters/golem2_right_3", gp.tileSize * i, gp.tileSize * i);
            right4 = setup("/Resources/Monsters/golem2_right_4", gp.tileSize * i, gp.tileSize * i);
        }
    }

    public void getAttackImage(){
        int i = 8;

        if (!inRage){
//            attackUp1 = setup("/Resources/Monsters/boss_attack_up_1", gp.tileSize * i, gp.tileSize * i * 2);
//            attackUp2 = setup("/Resources/Monsters/boss_attack_up_2", gp.tileSize * i, gp.tileSize * i * 2);
//            attackDown1 = setup("/Resources/Monsters/boss_attack_down_1", gp.tileSize * i, gp.tileSize * i * 2);
//            attackDown2 = setup("/Resources/Monsters/boss_attack_down_2", gp.tileSize * i, gp.tileSize * i * 2);
            attackLeft1 = setup("/Resources/Monsters/golem_attack_left_1", gp.tileSize * i * 2, gp.tileSize * i);
            attackLeft2 = setup("/Resources/Monsters/golem_attack_left_2", gp.tileSize * i * 2, gp.tileSize * i);
            attackLeft3 = setup("/Resources/Monsters/golem_attack_left_3", gp.tileSize * i * 2, gp.tileSize * i);
            attackLeft4 = setup("/Resources/Monsters/golem_attack_left_4", gp.tileSize * i * 2, gp.tileSize * i);

            attackRight1 = setup("/Resources/Monsters/golem_attack_right_1", gp.tileSize * i * 2, gp.tileSize * i);
            attackRight2 = setup("/Resources/Monsters/golem_attack_right_2", gp.tileSize * i *  2, gp.tileSize * i);
            attackRight3 = setup("/Resources/Monsters/golem_attack_right_3", gp.tileSize * i * 2, gp.tileSize * i);
            attackRight4 = setup("/Resources/Monsters/golem_attack_right_4", gp.tileSize * i *  2, gp.tileSize * i);
        }
        else {

//            attackUp1 = setup("/Resources/Monsters/ogre_phase2_attack_up_1", gp.tileSize * i, gp.tileSize * i * 2);
//            attackUp2 = setup("/Resources/Monsters/ogre_phase2_attack_up_2", gp.tileSize * i, gp.tileSize * i * 2);
//            attackDown1 = setup("/Resources/Monsters/ogre_phase2_attack_down_1", gp.tileSize * i, gp.tileSize * i * 2);
//            attackDown2 = setup("/Resources/Monsters/ogre_phase2_attack_down_2", gp.tileSize * i, gp.tileSize * i * 2);
            attackLeft1 = setup("/Resources/Monsters/golem2_attack_left_1", gp.tileSize * i * 2, gp.tileSize * i);
            attackLeft2 = setup("/Resources/Monsters/golem2_attack_left_2", gp.tileSize * i * 2, gp.tileSize * i);
            attackLeft3 = setup("/Resources/Monsters/golem2_attack_left_3", gp.tileSize * i * 2, gp.tileSize * i);
            attackLeft4 = setup("/Resources/Monsters/golem2_attack_left_4", gp.tileSize * i * 2, gp.tileSize * i);

            attackRight1 = setup("/Resources/Monsters/golem2_attack_right_1", gp.tileSize * i * 2, gp.tileSize * i);
            attackRight2 = setup("/Resources/Monsters/golem2_attack_right_2", gp.tileSize * i *  2, gp.tileSize * i);
            attackRight3 = setup("/Resources/Monsters/golem2_attack_right_3", gp.tileSize * i * 2, gp.tileSize * i);
            attackRight4 = setup("/Resources/Monsters/golem2_attack_right_4", gp.tileSize * i *  2, gp.tileSize * i);
        }

    }

    public void setDialogue(){
        dialogues[0][0] = "Fool! You dare to challenge me, The Golem?";
        dialogues[0][1] = "I am the ruler of these depths, the master of this dungeon!";
        dialogues[0][2] = "Tremble before my might and feel the WEIGHT OF MY SWORD!";
    }

    public void setAction(){
        if (!inRage && life < maxLife/2){
            inRage = true;
            getImage();
            getAttackImage();
            defaultSpeed++;
            speed = defaultSpeed;
            attack *= 2;
            motionDuration -= 5;
            motion2Duration -= 10;

            attackArea.x = 360;
            attackArea.y = 260;
            attackArea.width = 300;
            attackArea.height = 300;
        }

        if (getTileDistance(gp.player) < 10 ){ // 10 tiles distance between player and skeleton
            moveTowardPlayer(60); // Every 60 frames the Skeleton checks the player position and maybe change the direction
        } else {
            getRandomDirection(120);
        }

        if (!attacking){
            checkAttackOrNot(40, gp.tileSize * 7, gp.tileSize * 4);
        }
    }

    public void damageReaction(){
        actionLockCounter = 0;
    }

    public void checkDrop(){

        gp.bossBattleOn = false;
        Progress.skeletonLordDefeated = true;

        // Restore the previous music
        gp.stopMusic();
        gp.playMusic(0);

        // Remove the iron door
        for (int i = 0; i < gp.obj[1].length; i++) {
            if (gp.obj[gp.currentMap][i] != null && gp.obj[gp.currentMap][i].name.equals(OBJ_Door_Iron.objName)){
                gp.playSE(19);
                gp.obj[gp.currentMap][i] = null;
            }
        }

//        int i = new Random().nextInt(100)+1;
        int i = 100;
        if(i == 100){dropItem(new OBJ_Sword_Steel(gp));}
//        if (i < 50){dropItem(new OBJ_Coin(gp));}
//        if (i >= 50 && i < 75){dropItem(new OBJ_Heart(gp));}
//        if (i >= 75 && i < 100){dropItem(new OBJ_Mana_Crystal(gp));}
    }
}
