class Proiettile {
  float x;
  float y;
  float vel;
  float dim;
  Proiettile(float posX) {
    x=posX;
    y=height;
    vel=-1;
    dim=4;
  }
  void update() {
    y+=vel;
  }
  void show() {
    fill(255, 0, 0);
    stroke(255, 0, 0);
    strokeWeight(dim);
    line(x, y, x, y-dim);
  }
}
