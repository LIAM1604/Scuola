class Goccia {

  float g = random(1, 5);
  float x = random(width);
  float y = 0;
  int dim = 25;
  float colore;
  float vento=random(-3,3);

  void cadi() {
    y += g;
    if (y>height) {
      y = random(-100, -dim);
    }
    x+=vento;
    if (x>width) {
      x = 0;
    }
        if (x<0) {
      x = width;
    }
  }

  void show() {
    strokeWeight(g);
    stroke(255, colore, 0);
    colore = map(y, 0, height, 0, 255);
    line(x, y, x+vento, y+dim);
  }
}
