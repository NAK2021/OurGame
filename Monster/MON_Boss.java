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

public class MON_Boss extends Entity {

    GamePanel gp;
    public static final String monName = "The Dragon of the Dungeon";

    public MON_Boss(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_monster;
        boss = true;
        name = monName;
        defaultSpeed = 1;
        speed = defaultSpeed;
        maxLife = 150;
        life = maxLife;
        attack = 13;
        defence = 2;
        exp = 200;
        knockBackPower = 5;
        sleep = false; //sleep = dont operate
        int size = gp.tileSize * 8;
        solidArea.x = 100;
        solidArea.y = 130;
        solidArea.width = size - 160 - 50;
        solidArea.height = size - 160 - 50;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        attackArea.x = 200;
        attackArea.y = 260;
        attackArea.width = 200;
        attackArea.height = 200;
        motionDuration = 20; // + 5
        motion2Duration = 40;// + 10 0 -> 60

        getImage();
        getAttackImage();

    }

    public void getImage(){
        int i = 8;

        if (!inRage){
            up1 = setup("/Resources/Monsters/boss_move(U-L)_1", gp.tileSize * i, gp.tileSize * i);
            up2 = setup("/Resources/Monsters/boss_move(U-L)_2", gp.tileSize * i, gp.tileSize * i);
            up3 = setup("/Resources/Monsters/boss_move(U-L)_3", gp.tileSize * i, gp.tileSize * i);
            up4 = setup("/Resources/Monsters/boss_move(U-L)_4", gp.tileSize * i, gp.tileSize * i);

            down1 = setup("/Resources/Monsters/boss_move(D-R)_1", gp.tileSize * i, gp.tileSize * i);
            down2 = setup("/Resources/Monsters/boss_move(D-R)_2", gp.tileSize * i, gp.tileSize * i);
            down3 = setup("/Resources/Monsters/boss_move(D-R)_3", gp.tileSize * i, gp.tileSize * i);
            down4 = setup("/Resources/Monsters/boss_move(D-R)_4", gp.tileSize * i, gp.tileSize * i);

            left1 = setup("/Resources/Monsters/boss_move(U-L)_1", gp.tileSize * i, gp.tileSize * i);
            left2 = setup("/Resources/Monsters/boss_move(U-L)_2", gp.tileSize * i, gp.tileSize * i);
            left3 = setup("/Resources/Monsters/boss_move(U-L)_3", gp.tileSize * i, gp.tileSize * i);
            left4 = setup("/Resources/Monsters/boss_move(U-L)_4", gp.tileSize * i, gp.tileSize * i);

            right1 = setup("/Resources/Monsters/boss_move(D-R)_1", gp.tileSize * i, gp.tileSize * i);
            right2 = setup("/Resources/Monsters/boss_move(D-R)_2", gp.tileSize * i, gp.tileSize * i);
            right3 = setup("/Resources/Monsters/boss_move(D-R)_3", gp.tileSize * i, gp.tileSize * i);
            right4 = setup("/Resources/Monsters/boss_move(D-R)_4", gp.tileSize * i, gp.tileSize * i);
        }

        if (inRage){
            up1 = setup("/Resources/Monsters/boss2_move(U-L)_1", gp.tileSize * i, gp.tileSize * i);
            up2 = setup("/Resources/Monsters/boss2_move(U-L)_2", gp.tileSize * i, gp.tileSize * i);
            up3 = setup("/Resources/Monsters/boss2_move(U-L)_3", gp.tileSize * i, gp.tileSize * i);
            up4 = setup("/Resources/Monsters/boss2_move(U-L)_4", gp.tileSize * i, gp.tileSize * i);

            down1 = setup("/Resources/Monsters/boss2_move(D-R)_1", gp.tileSize * i, gp.tileSize * i);
            down2 = setup("/Resources/Monsters/boss2_move(D-R)_2", gp.tileSize * i, gp.tileSize * i);
            down3 = setup("/Resources/Monsters/boss2_move(D-R)_3", gp.tileSize * i, gp.tileSize * i);
            down4 = setup("/Resources/Monsters/boss2_move(D-R)_4", gp.tileSize * i, gp.tileSize * i);

            left1 = setup("/Resources/Monsters/boss2_move(U-L)_1", gp.tileSize * i, gp.tileSize * i);
            left2 = setup("/Resources/Monsters/boss2_move(U-L)_2", gp.tileSize * i, gp.tileSize * i);
            left3 = setup("/Resources/Monsters/boss2_move(U-L)_3", gp.tileSize * i, gp.tileSize * i);
            left4 = setup("/Resources/Monsters/boss2_move(U-L)_4", gp.tileSize * i, gp.tileSize * i);

            right1 = setup("/Resources/Monsters/boss2_move(D-R)_1", gp.tileSize * i, gp.tileSize * i);
            right2 = setup("/Resources/Monsters/boss2_move(D-R)_2", gp.tileSize * i, gp.tileSize * i);
            right3 = setup("/Resources/Monsters/boss2_move(D-R)_3", gp.tileSize * i, gp.tileSize * i);
            right4 = setup("/Resources/Monsters/boss2_move(D-R)_4", gp.tileSize * i, gp.tileSize * i);
        }
    }

    public void getAttackImage(){
        int i = 8;

        if (!inRage){
//            attackUp1 = setup("/Resources/Monsters/boss_attack_up_1", gp.tileSize * i, gp.tileSize * i * 2);
//            attackUp2 = setup("/Resources/Monsters/boss_attack_up_2", gp.tileSize * i, gp.tileSize * i * 2);
//            attackDown1 = setup("/Resources/Monsters/boss_attack_down_1", gp.tileSize * i, gp.tileSize * i * 2);
//            attackDown2 = setup("/Resources/Monsters/boss_attack_down_2", gp.tileSize * i, gp.tileSize * i * 2);
            attackLeft1 = setup("/Resources/Monsters/boss_atk(U-L)_1", gp.tileSize * i * 2, gp.tileSize * i);
            attackLeft2 = setup("/Resources/Monsters/boss_atk(U-L)_2", gp.tileSize * i * 2, gp.tileSize * i);
            attackLeft3 = setup("/Resources/Monsters/boss_atk(U-L)_3", gp.tileSize * i * 2, gp.tileSize * i);
            attackLeft4 = setup("/Resources/Monsters/boss_atk(U-L)_4", gp.tileSize * i * 2, gp.tileSize * i);
            attackRight1 = setup("/Resources/Monsters/boss_atk(D-R)_1", gp.tileSize * i * 2, gp.tileSize * i);
            attackRight2 = setup("/Resources/Monsters/boss_atk(D-R)_2", gp.tileSize * i *  2, gp.tileSize * i);
            attackRight3 = setup("/Resources/Monsters/boss_atk(D-R)_3", gp.tileSize * i * 2, gp.tileSize * i);
            attackRight4 = setup("/Resources/Monsters/boss_atk(D-R)_4", gp.tileSize * i *  2, gp.tileSize * i);
        }
        else {
//            attackUp1 = setup("/Resources/Monsters/ogre_phase2_attack_up_1", gp.tileSize * i, gp.tileSize * i * 2);
//            attackUp2 = setup("/Resources/Monsters/ogre_phase2_attack_up_2", gp.tileSize * i, gp.tileSize * i * 2);
//            attackDown1 = setup("/Resources/Monsters/ogre_phase2_attack_down_1", gp.tileSize * i, gp.tileSize * i * 2);
//            attackDown2 = setup("/Resources/Monsters/ogre_phase2_attack_down_2", gp.tileSize * i, gp.tileSize * i * 2);
        attackLeft1 = setup("/Resources/Monsters/boss2_atk(U-L)_1", gp.tileSize * i * 2, gp.tileSize * i);
        attackLeft2 = setup("/Resources/Monsters/boss2_atk(U-L)_2", gp.tileSize * i * 2, gp.tileSize * i);
        attackLeft3 = setup("/Resources/Monsters/boss2_atk(U-L)_3", gp.tileSize * i * 2, gp.tileSize * i);
        attackLeft4 = setup("/Resources/Monsters/boss2_atk(U-L)_4", gp.tileSize * i * 2, gp.tileSize * i);
        attackRight1 = setup("/Resources/Monsters/boss2_atk(D-R)_1", gp.tileSize * i * 2, gp.tileSize * i);
        attackRight2 = setup("/Resources/Monsters/boss2_atk(D-R)_2", gp.tileSize * i *  2, gp.tileSize * i);
        attackRight3 = setup("/Resources/Monsters/boss2_atk(D-R)_3", gp.tileSize * i * 2, gp.tileSize * i);
        attackRight4 = setup("/Resources/Monsters/boss2_atk(D-R)_4", gp.tileSize * i *  2, gp.tileSize * i);
        }

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
        }

        if (getTileDistance(gp.player) < 10 ){ // 10 tiles distance between player and skeleton
            moveTowardPlayer(60); // Every 60 frames the Skeleton checks the player position and maybe change the direction
        } else {
            getRandomDirection(120);
        }

        if (!attacking){
            checkAttackOrNot(10, gp.tileSize * 7, gp.tileSize * 4);
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
        if(i == 100){dropItem(new OBJ_Key(gp));}
//        if (i < 50){dropItem(new OBJ_Coin(gp));}
//        if (i >= 50 && i < 75){dropItem(new OBJ_Heart(gp));}
//        if (i >= 75 && i < 100){dropItem(new OBJ_Mana_Crystal(gp));}
    }
}
