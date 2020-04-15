import processing.sound.*;
import processing.sound.*;
SoundFile racchetta;
SoundFile muro;
SoundFile finale;
Palla p1;
RacchettaPC rpc;
RacchettaPlayer rp;
float yp;
PImage campo;
PImage giocatore;
PImage pc;
PImage i;
int finito=0;
boolean inizio=false;
void setup() {
  size(1000, 600);
  rpc= new RacchettaPC();
  rp= new RacchettaPlayer();
  p1 = new Palla();
  yp=height/2;
  campo=loadImage("campo.jpg");
  giocatore=loadImage("italia.png");
  pc=loadImage("francia.png");
  racchetta = new SoundFile(this, "racchetta.wav");
  muro = new SoundFile(this, "muro.wav");
  finale = new SoundFile(this, "finale.wav");

}

void draw() {

  background(campo);
  stroke(255);
  strokeWeight(5);
  line(35, 20, width-35, 20);
  line(35, 20, 35, height-20);
  line(35, height-20, width-35, height-20);
  line(width-35, 20, width-35, height-20);

  p1.show();
  p1.muovi();

  rpc.show();
  rpc.muovi(p1.yc); 
  rp.show();
  rp.muovi();
  p1.isColliso(rpc.x, rpc.y);
  p1.isColliso2(rp.x, rp.y);
  p1.esito();
  p1.offset();
}
