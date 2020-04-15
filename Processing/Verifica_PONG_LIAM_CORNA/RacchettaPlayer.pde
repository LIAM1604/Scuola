
class RacchettaPlayer {
  float x=width-60;
  float y=height/2;

  void show() {
   // strokeWeight(5);
   // stroke(255);
    //fill(255);
    imageMode(CENTER);
    image(giocatore,x, y, 20, 60);
  }
  void muovi() {
    y=mouseY;
    if (y<50) {
      y=50;
    }
    if (y>height-50) {
      y=height-50;
    }
  }
}
