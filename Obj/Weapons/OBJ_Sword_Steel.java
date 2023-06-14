package Obj.Weapons;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Sword_Steel extends Entity {

    public static final String objName = "Steel Sword";

    public OBJ_Sword_Steel(GamePanel gp) {
        super(gp);

        type = type_sword;
        name = objName;
        down1 = setup("/Resources/Objects/steel_sword", gp.tileSize, gp.tileSize);
        attackValue = 40;
        attackArea.width = 46;
        attackArea.height = 38;
        description = "[" + name + "]\nSharp and strong";
        price = 235;
        knockBackPower = 2;
        motionDuration = 7;
        motion2Duration = 27;
    }
}
