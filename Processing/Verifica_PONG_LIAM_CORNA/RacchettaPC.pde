
class RacchettaPC {
  float x=60;
  float y=height/2;
  float vel=5;
  int dir=0;
  void show() {
    strokeWeight(5);
    stroke(255);
    fill(255);
    imageMode(CENTER);
    image(pc, x, y, 20, 60);
  }
  //per buggare il pc tenere premuto il mouse
  void muovi(float y2) { 

    // 0=giù  1=su

    if (mousePressed) {
      if (dir==0) {
        y+=vel;
        if (y>height-50) {
          y=height-50;
          vel+=5;
          dir=1;
        }
      } else {
         y-=vel;
        if (y<50) {
          y=50;
          vel+=5;
          dir=0;
        }

       
      }
    } else {
      if(dir==0){
        vel=5;
      }else{
        vel=-5;
      }
      vel=5;
      y=y2;
      if (y<50) {
        y=50;
        dir=0;
      }
      if (y>height-50) {
        y=height-50;
        dir=1;
      }
    }
  }
}
