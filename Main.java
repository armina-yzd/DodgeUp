import processing.core.PApplet;

import java.util.ArrayList;


public class Main extends PApplet {

    static ArrayList<Player> players=Db.GetPlayer();

    static int x=0;
    static int heart=50;
    static int num=players.size()+1;
    float[] yPos={0,0,0,0,0};
    int count=0;
    int count2=0;
    static int speedy=2;
    static int j=5;
    static int check=3;
    static  boolean check2=true;
    static boolean game=true;
    static boolean player=false;
    static ArrayList<Block> blocks= new ArrayList<>();
    public static PApplet processing;
    public static void main(String[] args) {
        PApplet.main("Main",args);

    }


    public void setup(){

      processing=this;
      int y=0;
        for(int i=0; i<5; i++){
            float x1=random(y,y+60);
            float yDir = random(speedy,speedy+2);
            int c1,c2,c3;
            c1=(int)random(225);
            c2=(int)random(225);
            c3=(int)random(225);
            Block block = new Block(x1,yPos[i],yDir,c1,c2,c3) {
            };
            blocks.add(block);
            y+=80;

        }

    }

    public void settings(){
        size(400,700);
    }

    public void draw () {
        if(game){
            background(0);
            stroke(150);
            line(0, 620, 400, 620);
            stroke(0);

            fill(225,204,153);
            textSize(23);
            text("player "+num,300,30);
            smooth();
            noStroke();

            fill(255, 0, 0);
            textSize(23);
            int h=heart*2;
            if(heart==50){
                text(h, 65, 40);
                text('%',100,40);
            }else {
                text(h, 65, 40);
                text('%',87,40);
            }

            beginShape();
            vertex(50, 15);
            bezierVertex(50, -5, 90, 5, 50, 40);
            vertex(50, 15);
            bezierVertex(50, -5, 10, 5, 50, 40);
            endShape();

            fill(0, 76, 153);
            Human human = new Human() {
            };
            human.ShowObject();


            blocks.get(x).ShowObject();
            yPos[x] = yPos[x] + blocks.get(x).yDir;
            blocks.get(x).setyPos(yPos[x]);
            if (yPos[x] > 570) {
                float yDir = random(speedy,speedy+3);
                yPos[x] = 0;
                blocks.get(x).setx(random(0, 60));
                blocks.get(x).setyDir(yDir);
                blocks.get(x).setcolor((int) random(225), (int) random(225), (int) random(225));
                if(blocks.get(x).isState()){
                    count++;
                    count2++;
                }else{
                    blocks.get(x).setState(true);
                }
            }

            blocks.get(x + 1).ShowObject();
            yPos[x + 1] = yPos[x + 1] + blocks.get(x + 1).yDir;
            blocks.get(x + 1).setyPos(yPos[x + 1]);
            if (yPos[x + 1] > 570) {
                float yDir = random(speedy,speedy+2);
                yPos[x + 1] = 0;
                blocks.get(x + 1).setx(random(80, 140));
                blocks.get(x+1).setyDir(yDir);
                blocks.get(x + 1).setcolor((int) random(225), (int) random(225), (int) random(225));
                if(blocks.get(x+1).isState()){
                    count++;
                    count2++;
                }else{
                    blocks.get(x+1).setState(true);
                }
            }

            blocks.get(x + 2).ShowObject();
            yPos[x + 2] = yPos[x + 2] + blocks.get(x + 2).yDir;
            blocks.get(x + 2).setyPos(yPos[x + 2]);
            if (yPos[x + 2] > 570) {
                float yDir = random(speedy,speedy+2);
                yPos[x + 2] = 0;
                blocks.get(x + 2).setx(random(160, 220));
                blocks.get(x+2).setyDir(yDir);
                blocks.get(x + 2).setcolor((int) random(225), (int) random(225), (int) random(225));
                if(blocks.get(x+2).isState()){
                    count++;
                    count2++;
                }else{
                    blocks.get(x+2).setState(true);
                }
            }

            blocks.get(x + 3).ShowObject();
            yPos[x + 3] = yPos[x + 3] + blocks.get(x + 1).yDir;
            blocks.get(x + 3).setyPos(yPos[x + 3]);
            if (yPos[x + 3] > 570) {
                float yDir = random(speedy,speedy+2);
                yPos[x+3] = 0;
                blocks.get(x+3).setx(random(240, 300));
                blocks.get(x+3).setyDir(yDir);
                blocks.get(x+3).setcolor((int) random(225), (int) random(225), (int) random(225));
                if(blocks.get(x+3).isState()){
                    count++;
                    count2++;
                }else{
                    blocks.get(x+3).setState(true);
                }
            }

            blocks.get(x+4).ShowObject();
            yPos[x+4] = yPos[x+4] + blocks.get(x+4).yDir;
            blocks.get(x+4).setyPos(yPos[x+4]);
            if (yPos[x+4] > 570) {
                float yDir = random(speedy,speedy+2);
                yPos[x+4] = 0;
                blocks.get(x+4).setx(random(320, 380));
                blocks.get(x+4).setyDir(yDir);
                blocks.get(x+4).setcolor((int) random(225), (int) random(225), (int) random(225));
                if(blocks.get(x+4).isState()){
                    count++;
                    count2++;
                }else{
                    blocks.get(x+4).setState(true);
                }
            }

            if(count>=j){
                speedy+=1;
                j+=5;
            }
            if(speedy>=16){
                speedy=8;
            }



            if (count >= 150 && count<200) {
                check=1;
                game=false;

            } else {
                for (int i = 0; i < 5; i++) {
                    if (blocks.get(x + i).check(human.getX())) {
                        blocks.get(x+i).setState(false);
                        heart--;
                        if (heart == 0) {
                            check=2;
                            game=false;
                        }
                    }
                }
            }

        } else {
            if(check==1){
                background(0,0,80);
                fill(0,0,80);
                stroke(0);
                rect(110,405,165,50);
                rect(85,480,220,50);
                fill(0);
                textSize(23);
                text("player "+num,300,30);
                textSize(33);
                text("Player List",120,440);
                textSize(28);
                text("Continue Playing",95,515);

                fill(0);
                textSize(100);
                text("You Won",29,340);

                if(check2){

                    Db.AddPlayer(num,1,count);
                    players=Db.GetPlayer();
                    check2=false;
                }

                if(mouseX>=110 && mouseX<=275 && mouseY>=410 && mouseY<=457){
                    if(mousePressed){
                        player=true;
                        check=3;
                    }
                }

                if(mouseX>=85 && mouseX<=300 && mouseY>=480 && mouseY<=530){
                    if(mousePressed){
                        count=200;
                        game=true;
                        check=3;
                        check2=true;
                    }
                }




            }else if(check==2){
                background(102,0,0);
                fill(102,0,0);
                stroke(0);
                rect(110,415,165,50);
                fill(0);
                textSize(23);
                text("player "+num,300,30);

                textSize(33);
                text("Player List",120,450);

                textSize(60);
                text("Score : "+count2,30,280);
                textSize(100);
                text("You Lost",29,370);

                if(check2){
                    int index=0;
                    for (int i=0; i<players.size(); i++){
                        if(players.get(i).getPlayerid()==num){
                            Db.UpdatePlayer(count2,num);
                            players=Db.GetPlayer();
                            check2=false;
                            index++;

                        }
                    }
                    if(index==0){
                        Db.AddPlayer(num,2,count);
                        players=Db.GetPlayer();
                        check2=false;
                    }





                }


                if(mouseX>=110 && mouseX<=275 && mouseY>=420 && mouseY<=467){
                    if(mousePressed){
                        player=true;
                        check=3;

                    }
                }



            }
        }
        if(player){
            background(0);
            fill(180,0,0);
            textSize(20);
            text("ID",10,20);
            text("State",120,20);
            text("Record",200,20);
            int y=50;
            fill(225);
            for(int i=0; i<players.size(); i++){
                fill(225);
                if(players.get(i).getCount()>150){
                    fill(180,0,0);
                }

                text("player "+players.get(i).getPlayerid(),10,y);
                if(players.get(i).isState()){
                    text("won",120,y);
                }else {
                    text("lost",120,y);
                }
                text(players.get(i).getCount(),200,y);

                y+=35;
            }
            text("play again",15,670);
            if(mouseX>=15 && mouseX<=100 && mouseY>=660 && mouseY<=670){
                if(mousePressed){
                   check2=true;
                   num++;
                   game=true;
                   heart=50;
                   count=0;
                    speedy=2;
                    j=5;
                   player=false;
                }
            }
        }

    }


}