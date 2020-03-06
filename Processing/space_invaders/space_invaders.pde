//Proiettile[]proiettili= new Proiettile[200];
Astronave a1;
void setup() {
  size(600, 600);
  a1=new Astronave();
}

void draw() {
  background(0);
  a1.update();
  a1.show();
}

void keyPressed() {
  if (key == CODED) {
    if (keyCode == RIGHT) {
      a1.dirX = +5;
    } else if (keyCode == LEFT) {
      a1.dirX = -5;
    }
  } else if (key == ' ') {
    a1.spara();
  }
}
void keyReleased() {
  if (key!=' ') {
    a1.dirX=0;
  }
}
