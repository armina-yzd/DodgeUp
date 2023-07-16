import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Main extends PApplet {

    static ArrayList<Player> players = Db.GetPlayer();

    static int x = 0;
    static int heart = 25;
    static int num = players.size() + 1;
    float[] yPos = { -80, -100, -30, -200, -10, -150 };
    int count = 0;
    int count2 = 0;
    static int speedy = 2;
    static int j = 8;
    static int check = 3;
    int in = 710;
    static boolean check2 = true;
    static boolean game = false;
    static boolean player = false;

    boolean mode = true;

    static ArrayList<Block> blocks = new ArrayList<>();
    static Bigoli bigoli1;
    static Bigoli bigoli2;
    static int k = 0;
    PImage img;


    public static PApplet processing;

    public static void main(String[] args) {
        PApplet.main("Main", args);

    }

    public void setup() {

        processing = this;
        int y = 0;
        for (int i = 0; i < 6; i++) {
            float x1 = random(y, y + 60);
            float yDir = random(speedy, speedy + 2);
            int c1, c2, c3;
            c1 = (int) random(1, 224);
            c2 = (int) random(1, 224);
            c3 = (int) random(1, 224);
            Block block = new Block(x1, yPos[i], yDir, c1, c2, c3) {
            };
            blocks.add(block);
            y += 66;

        }
        bigoli1 = new Bigoli(50, 0) {
        };
        bigoli2 = new Bigoli(100, 0) {
        };
        img = createImage(230, 230, ARGB);
        for (int i = 0; i < img.pixels.length; i++) {
            float a = map(i, 0, img.pixels.length, 255, 0);
            img.pixels[i] = color(0, 153, 204, a);
        }
    }

    public void settings() {
        size(400, 700);
    }

    public void draw() {

        if (mode) {
            PImage background = loadImage("background2.jpg");
            background(background);

            noStroke();
            fill(191,140,140);

            textSize(33);
            text("Dark Mode", 110, 430);

            text("Light Mode", 110, 505);

            fill(150,78,78);

            textSize(50);
            text("Dodge Up", 85, 270);

            if (mouseX >= 110 && mouseX <= 260 && mouseY >= 410 && mouseY <= 430) {
                if (mousePressed) {
                    k = 1;
                    game = true;
                    mode = false;
                }
            }

            if (mouseX >= 110 && mouseX <= 260 && mouseY >= 480 && mouseY <= 505) {
                if (mousePressed) {
                    k = 2;
                    game = true;
                    mode = false;
                }
            }

        }

        if (game) {

            if (k == 1) {
                background(0);
            } else {
                background(225);
            }

            image(img, 70, 150);
            image(img, 140, 90);
            stroke(150);
            line(0, 620, 400, 620);
            stroke(0);

            fill(215, 200, 153);
            textSize(23);
            text("player " + num, 300, 30);
            smooth();
            noStroke();

            fill(255, 0, 0);
            textSize(23);
            int h = heart * 4;
            if (heart > 25) {
                heart = 25;
            }
            if (heart == 25) {
                text(h, 65, 40);
                text('%', 100, 40);
            } else if (heart > 2) {
                text(h, 65, 40);
                text('%', 87, 40);
            } else {
                text(h, 65, 40);
                text('%', 77, 40);
            }

            beginShape();
            vertex(50, 15);
            bezierVertex(50, -5, 90, 5, 50, 40);
            vertex(50, 15);
            bezierVertex(50, -5, 10, 5, 50, 40);
            endShape();

            Human human = new Human() {
            };
            human.ShowObject();

            blocks.get(x).ShowObject();
            yPos[x] = yPos[x] + blocks.get(x).yDir;
            blocks.get(x).setyPos(yPos[x]);
            if (yPos[x] > 570) {
                float yDir = random(speedy, speedy + 3);
                yPos[x] = -10;
                blocks.get(x).setx(random(0, 60));
                blocks.get(x).setyDir(yDir);
                blocks.get(x).setcolor((int) random(225), (int) random(225), (int) random(225));
                if (blocks.get(x).isState()) {
                    count++;
                    count2++;
                } else {
                    blocks.get(x).setState(true);
                }
            }

            blocks.get(x + 1).ShowObject();
            yPos[x + 1] = yPos[x + 1] + blocks.get(x + 1).yDir;
            blocks.get(x + 1).setyPos(yPos[x + 1]);
            if (yPos[x + 1] > 570) {
                float yDir = random(speedy, speedy + 2);
                yPos[x + 1] = -10;
                blocks.get(x + 1).setx(random(66, 126));
                blocks.get(x + 1).setyDir(yDir);
                blocks.get(x + 1).setcolor((int) random(225), (int) random(225), (int) random(225));
                if (blocks.get(x + 1).isState()) {
                    count++;
                    count2++;
                } else {
                    blocks.get(x + 1).setState(true);
                }
            }

            blocks.get(x + 2).ShowObject();
            yPos[x + 2] = yPos[x + 2] + blocks.get(x + 2).yDir;
            blocks.get(x + 2).setyPos(yPos[x + 2]);
            if (yPos[x + 2] > 570) {
                float yDir = random(speedy, speedy + 2);
                yPos[x + 2] = -10;
                blocks.get(x + 2).setx(random(132, 192));
                blocks.get(x + 2).setyDir(yDir);
                blocks.get(x + 2).setcolor((int) random(225), (int) random(225), (int) random(225));
                if (blocks.get(x + 2).isState()) {
                    count++;
                    count2++;
                } else {
                    blocks.get(x + 2).setState(true);
                }
            }

            blocks.get(x + 3).ShowObject();
            yPos[x + 3] = yPos[x + 3] + blocks.get(x + 1).yDir;
            blocks.get(x + 3).setyPos(yPos[x + 3]);
            if (yPos[x + 3] > 570) {
                float yDir = random(speedy, speedy + 2);
                yPos[x + 3] = -10;
                blocks.get(x + 3).setx(random(198, 258));
                blocks.get(x + 3).setyDir(yDir);
                blocks.get(x + 3).setcolor((int) random(225), (int) random(225), (int) random(225));
                if (blocks.get(x + 3).isState()) {
                    count++;
                    count2++;
                } else {
                    blocks.get(x + 3).setState(true);
                }
            }

            blocks.get(x + 4).ShowObject();
            yPos[x + 4] = yPos[x + 4] + blocks.get(x + 4).yDir;
            blocks.get(x + 4).setyPos(yPos[x + 4]);
            if (yPos[x + 4] > 570) {
                float yDir = random(speedy, speedy + 2);
                yPos[x + 4] = -10;
                blocks.get(x + 4).setx(random(264, 324));
                blocks.get(x + 4).setyDir(yDir);
                blocks.get(x + 4).setcolor((int) random(225), (int) random(225), (int) random(225));
                if (blocks.get(x + 4).isState()) {
                    count++;
                    count2++;
                } else {
                    blocks.get(x + 4).setState(true);
                }
            }

            blocks.get(x + 5).ShowObject();
            yPos[x + 5] = yPos[x + 5] + blocks.get(x + 5).yDir;
            blocks.get(x + 5).setyPos(yPos[x + 5]);
            if (yPos[x + 5] > 570) {
                float yDir = random(speedy, speedy + 2);
                yPos[x + 5] = -10;
                blocks.get(x + 5).setx(random(330, 390));
                blocks.get(x + 5).setyDir(yDir);
                blocks.get(x + 5).setcolor((int) random(225), (int) random(225), (int) random(225));
                if (blocks.get(x + 5).isState()) {
                    count++;
                    count2++;
                } else {
                    blocks.get(x + 5).setState(true);
                }
            }

            if (count2 > 50) {
                bigoli1.ShowObject();
                bigoli1.setyPos(bigoli1.getyPos() + 7);
            }
            if (count2 > 150) {
                bigoli2.ShowObject();
                bigoli2.setyPos(bigoli2.getyPos() + 9);

            }

            if (bigoli2.getyPos() > 600) {
                bigoli2.setyPos(in);
                in += 6;
            }
            if (bigoli2.getyPos() > 950) {
                bigoli2.setyPos(0);
                bigoli2.setState(true);
                float b2 = random(200, 380);
                bigoli2.setx(b2);
                in = 710;

            }

            if (bigoli1.getyPos() > 600) {
                bigoli1.setyPos(in);
                in += 6;

            }

            if (bigoli1.getyPos() > 950) {
                bigoli1.setyPos(0);
                bigoli1.setState(true);
                float b1 = random(0, 190);
                bigoli1.setx(b1);
                in = 710;

            }

            if (count >= j) {
                speedy += 1;
                j += 8;
            }
            if (speedy >= 15) {
                speedy = 7;
            }
            if (bigoli1.check(human.getX())) {
                noStroke();
                fill(108, 0, 0);
                circle(human.getX(), 552, 14);
                if (heart < 25 && bigoli1.isState()) {
                    heart += 2;
                }
                bigoli1.setState(false);

            }

            if (bigoli2.check(human.getX())) {
                noStroke();
                fill(108, 0, 0);
                circle(human.getX(), 552, 14);
                if (heart < 25 && bigoli2.isState()) {
                    heart += 2;
                }
                bigoli2.setState(false);

            }

            if (count >= 150 && count < 200) {
                check = 1;
                game = false;

            } else {
                for (int i = 0; i < 5; i++) {
                    if (blocks.get(x + i).check(human.getX())) {
                        blocks.get(x + i).setState(false);
                        heart--;
                        background(140, 0, 0);

                        fill(0);
                        textSize(40);
                        text(h + "%", 15, 70);
                        textSize(60);
                        text("Score :" + count2, 100, 350);
                        if (heart == 0) {
                            check = 2;
                            game = false;
                        }
                    }
                }
            }

        } else {
            if (check == 1) {
                if (k == 1) {
                    background(0, 0, 90);
                } else {
                    background(0, 100, 170);
                }

                fill(0);
                textSize(23);
                text("player " + num, 300, 30);
                textSize(33);
                text("Player List", 120, 440);
                textSize(28);
                text("Continue Playing", 95, 515);

                fill(0);
                textSize(100);
                text("You Won", 29, 340);

                if (check2) {

                    Db.AddPlayer(num, 1, 150);
                    players = Db.GetPlayer();
                    check2 = false;
                }

                if (mouseX >= 110 && mouseX <= 275 && mouseY >= 410 && mouseY <= 457) {
                    if (mousePressed) {
                        player = true;
                        check = 3;
                    }
                }

                if (mouseX >= 85 && mouseX <= 300 && mouseY >= 480 && mouseY <= 530) {
                    if (mousePressed) {
                        count = 200;
                        game = true;
                        check = 3;
                        check2 = true;
                    }
                }

            } else if (check == 2) {

                if (k == 1) {
                    background(102, 0, 0);
                } else {
                    background(150, 0, 0);
                }
                fill(102, 0, 0);
                stroke(0);
                rect(110, 415, 165, 50);
                fill(0);
                textSize(23);
                text("player " + num, 300, 30);

                textSize(33);
                text("Player List", 120, 450);

                textSize(60);
                text("Score : " + count2, 30, 280);
                textSize(100);
                text("You Lost", 29, 370);

                if (check2) {
                    int index = 0;
                    for (int i = 0; i < players.size(); i++) {
                        if (players.get(i).getPlayerid() == num) {
                            Db.UpdatePlayer(count2, num);
                            players = Db.GetPlayer();
                            check2 = false;
                            index++;

                        }
                    }
                    if (index == 0) {
                        Db.AddPlayer(num, 2, count);
                        players = Db.GetPlayer();
                        check2 = false;
                    }

                }

                if (mouseX >= 110 && mouseX <= 275 && mouseY >= 420 && mouseY <= 467) {
                    if (mousePressed) {
                        player = true;
                        check = 3;

                    }
                }

            }
        }
        if (player) {
            if (k == 1) {
                background(0);
            } else {
                background(225);
            }

            fill(180, 0, 0);
            textSize(20);
            text("ID", 10, 20);
            text("State", 120, 20);
            text("Record", 200, 20);
            int y = 50;
            fill(225);
            for (int i = 0; i < players.size(); i++) {
                if (k == 1) {
                    fill(225);
                } else {
                    fill(0);
                }

                if (!(players.get(i).isState())) {
                    fill(180, 0, 0);
                }

                text("player " + players.get(i).getPlayerid(), 10, y);
                if (players.get(i).isState()) {
                    text("won", 120, y);
                } else {
                    text("lost", 120, y);
                }
                text(players.get(i).getCount(), 200, y);

                y += 35;
            }
            text("play again", 15, 670);

            if (mouseX >= 10 && mouseX <= 105 && mouseY >= 650 && mouseY <= 675) {
                if (mousePressed) {
                    check2 = true;
                    num++;
                    game = true;
                    heart = 50;
                    count = 0;
                    count2 = 0;
                    speedy = 2;
                    j = 5;
                    player = false;
                }
            }
        }

    }

}