package Entity;

import Main.GamePanel;

public class PlayerDummy extends Entity{

    public static final String npcName = "Dummy";

    public PlayerDummy(GamePanel gp) {
        super(gp);

        name = npcName;
        getImage();
    }

    public void getImage() {
        int i = 2;
        up1 = setup("/Resources/Player/ava_left_1", gp.tileSize * i, gp.tileSize * i);
        up2 = setup("/Resources/Player/ava_left_2", gp.tileSize * i, gp.tileSize * i);
        up3 = setup("/Resources/Player/ava_left_2", gp.tileSize * i, gp.tileSize * i);
        up4 = setup("/Resources/Player/ava_left_1", gp.tileSize * i, gp.tileSize * i);

        down1 = setup("/Resources/Player/ava_right_1", gp.tileSize * i, gp.tileSize * i);
        down2 = setup("/Resources/Player/ava_right_2", gp.tileSize * i, gp.tileSize * i);
        down3 = setup("/Resources/Player/ava_right_2", gp.tileSize * i, gp.tileSize * i);
        down4 = setup("/Resources/Player/ava_right_1", gp.tileSize * i, gp.tileSize * i);

        left1 = setup("/Resources/Player/ava_left_1", gp.tileSize * i, gp.tileSize * i);
        left2 = setup("/Resources/Player/ava_left_2", gp.tileSize * i, gp.tileSize * i);
        left3 = setup("/Resources/Player/ava_left_2", gp.tileSize * i, gp.tileSize * i);
        left4 = setup("/Resources/Player/ava_left_1", gp.tileSize * i, gp.tileSize * i);

        right1 = setup("/Resources/Player/ava_right_1", gp.tileSize * i, gp.tileSize * i);
        right2 = setup("/Resources/Player/ava_right_2", gp.tileSize * i, gp.tileSize * i);
        right3 = setup("/Resources/Player/ava_right_2", gp.tileSize * i, gp.tileSize * i);
        right4 = setup("/Resources/Player/ava_right_1", gp.tileSize * i, gp.tileSize * i);
    }
}
