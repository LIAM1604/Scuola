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

void update() {
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


  void scendi() {

    y += diam + 5;
    dir = dir * -1;
  }


  boolean isOnWall() {
    if ( this.x > width-diam/2 || this.x < diam/2 ) return true; 
    else return false;
  }

  void show() {
    imageMode(CENTER);
    image(nemico, x, y, diam*2, diam);
  }
}
