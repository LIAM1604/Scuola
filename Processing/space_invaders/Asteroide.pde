class Nemico {

  float x;
  float y;
  float dir;
  float diam;
  boolean isAlBordo;

  Nemico(float posX, float posY) {
    x = posX;
    y = posY;
    dir = 4;
    diam = 40;
    isAlBordo= false;
  }

  void update() {
    x += dir;
    if (x>width-diam/2 || x<diam/2) { 
      isAlBordo=true; 
      scendi();
    }
  }

  void scendi() {
    if (isAlBordo) {
      y += diam + 5;
      dir = dir * -1;
      isAlBordo=false;
    }
  }

  void show() {
    fill(0, 255, 0);
    noStroke();
    circle(x, y, diam);
  }
}
