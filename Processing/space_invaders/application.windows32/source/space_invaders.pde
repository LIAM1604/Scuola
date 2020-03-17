int nnemici=60;
Astronave A1;
ArrayList<Nemico> flotta = new ArrayList<Nemico>();
int offsetNemico = 50;
PImage nave;
PImage nemico;
PImage proiettile;
int punti;
int maxNemiciRiga=20;
float yIni = 50;
int c = 0;
void setup() {
  fullScreen();
 // size(600, 600);
  float yIni = 50;
  int c = 0;
  nave = loadImage("amuchina.png");
  nemico = loadImage("corona.png");
  A1 = new Astronave();
  for (int i = 0; i<nnemici; i++) {
    flotta.add(new Nemico(offsetNemico*(c+1), yIni));
    c++;
    if ((i+1)%maxNemiciRiga == 0) {
      yIni += 50;
      c = 0;
    }

  }
}

void draw() {
  background(0);
  textAlign(CENTER);
  fill(255);
  textSize(20);
  text("PUNTI: "+punti, width/2, 40);
  A1.update();
  A1.show();
  for (int i=A1.caricatore.size() -1; i>=0; i--) {
    for (int j = flotta.size() -1; j>=0; j--) {
      if (A1.caricatore.size()>0 && A1.caricatore.get(i).isColliso(flotta.get(j))) {
        println("COLPITO!");
        punti += (height - A1.caricatore.get(i).y);
        flotta.remove(j);
        A1.caricatore.remove(i);
        if (flotta.size()<=0) {
          textAlign(CENTER);
          textSize(50);
          fill(255);
          background(0);
          text("HAI VINTO", width/2, height/2);
          textAlign(CENTER);
          fill(255);
          textSize(20);
          text("PUNTI: "+punti, width/2, 40);
          noLoop();
        }
      }
    }
  }
for (Nemico i : flotta) {
      if (i.isOnWall()) { 
        for (Nemico j : flotta) j.scendi();
        break;
      }
    } 
  for (int i = flotta.size()-1; i >=0; i--) {
    flotta.get(i).update();
    flotta.get(i).show();
  }
}



void keyPressed() {
  if (key == CODED) {
    if (keyCode == RIGHT) {
      A1.dirX = 5;
    } else if (keyCode == LEFT) {
      A1.dirX = -5;
    }
  } else if (key == ' ') {
    A1.spara();
  }
}
void keyReleased() {
  if (key != ' ') {
    A1.dirX=0;
  }
}
