Stella[]cielo = new Stella[1000];
float vel=10;
void setup() {
  fullScreen();
 // size(600, 600);
  for (int i=0; i<cielo.length; i++) {
    cielo[i]=new Stella();
  }
}

void draw() {
  background(0);
  text("vel: "+vel,width/2, 50);
  textSize(32);
  translate(width/2,height/2);
  vel=map(mouseX,0,width,0,20);
  for(int i=0; i<cielo.length; i++){
    cielo[i].show();
    cielo[i].update();
  }
}
