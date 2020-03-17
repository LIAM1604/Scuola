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

  void update() {
    y += v;
    
  }

  void show() {

   strokeWeight(4);
    stroke(255);
    line(x, y, x, y-dim);
  }
  
boolean isColliso(Nemico n1){
    float d = dist(n1.x, n1.y, this.x, this.y);
    float r2 = n1.diam/2;
  if(d <= r2) return true;
    else return false;
  }
}
