
  float xc;
  float yc;
  float velx=random(-10, 10);
  float vely=random(-10, 10);
  float r=50;
  int d;
  float dist;
  color c=color(0);
  PImage foto;
  int n=1;
  import processing.sound.*;
 SoundFile suono;

void setup(){
   suono = new SoundFile(this, "villagger.mp3");
 size (600,600); 

    xc=random(r, width-r);
    yc=random(r, height-r);

}

void draw(){
  background(255);
  if(n%2==0){
    foto=loadImage("ciro.png");
  }else{
    foto=loadImage("ciro-smile.png");
  }
    imageMode(CENTER);
    image(foto,xc-5,yc+15,r*4.5,r*4);
 
    if (xc<r) {
      velx=random(1, 10);
      c=color(random(0,255),random(0,255),random(0,255));
      n++;
      suono.play();
    }

    if (xc>=width-r) {
      velx=random(-10, -1);
      c=color(random(0,255),random(0,255),random(0,255));
      n++;
      suono.play();
    }
    if (yc<r) {
      vely=random(1, 10);
      c=color(random(0,255),random(0,255),random(0,255));
      n++;
      suono.play();
    }
    if (yc>=width-r) {
      vely=random(-10, -1);
      c=color(random(0,255),random(0,255),random(0,255));
      n++;
      suono.play();
    }
    xc+=velx;
    yc+=vely;
  

}
  
