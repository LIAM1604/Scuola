import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class space_invaders extends PApplet {

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
public void setup() {
  
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

public void draw() {
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



public void keyPressed() {
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
public void keyReleased() {
  if (key != ' ') {
    A1.dirX=0;
  }
}
class Astronave {

  float x;
  float y;
  float offset;
  float dirX;
  ArrayList<Proiettile> caricatore = new ArrayList<Proiettile>();

  Astronave() {
    offset=50;
    x = width/2;
    y = height - offset;
    dirX=0;
  }

  public void update() {
    x += dirX;
    x = constrain(x, 10, width-10);
  }

  public void show() {
    imageMode(CENTER);
    image(nave,x,y,50*1.5f,offset*3/2);
    for (int i = caricatore.size()-1; i>=0; i--) {
      caricatore.get(i).update();
      caricatore.get(i).show();
      if (caricatore.get(i).y<0) {
        caricatore.remove(i);
      }
    }
  }

  public void spara() {
    caricatore.add(new Proiettile(this.x));
  }
}
class Nemico {

  float x;
  float y;
  float dir;
  float diam;

  Nemico(float posX, float posY) {
    x = posX;
    y = posY;
    dir = 4;
    diam = 40;
  }

public void update() {
    if(y + diam>height - 80){
      textAlign(CENTER);
      textSize(50);
      fill(255,0,0);
      background(0);
      text("GAME OVER", width/2, height/2);
      noLoop();
    }
    else {
    x += dir;
    }
  }


  public void scendi() {

    y += diam + 5;
    dir = dir * -1;
  }


  public boolean isOnWall() {
    if ( this.x > width-diam/2 || this.x < diam/2 ) return true; 
    else return false;
  }

  public void show() {
    imageMode(CENTER);
    image(nemico, x, y, diam*2, diam);
  }
}
class Proiettile {

  float x;
  float y;
  float v;
  float dim;
  float d;
  Proiettile(float posX) {
    x = posX;
    y = height-80;
    v = -5;
    dim = 7;
  }

  public void update() {
    y += v;
    
  }

  public void show() {

   strokeWeight(4);
    stroke(255);
    line(x, y, x, y-dim);
  }
  
public boolean isColliso(Nemico n1){
    float d = dist(n1.x, n1.y, this.x, this.y);
    float r2 = n1.diam/2;
  if(d <= r2) return true;
    else return false;
  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "space_invaders" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
