class Astronave {
  float x;
  float y;
  float offset;
  float dirX;
  ArrayList<Proiettile> caricatore = new ArrayList<Proiettile>();
  Astronave() {
    offset=20;
    x=width/2;
    y=height-offset;
    dirX=0;
  }

  void show() {
    noStroke();
    fill(255);
    rectMode(CENTER);
    rect(x, y, 20, offset*3/2);
    for (int i = caricatore.size()-1; i >= 0; i--) {
      caricatore.get(i).update();
      caricatore.get(i).show();
      if (caricatore.get(i).y<0) {
        caricatore.remove(i);
      }
    }
  }

  void update() {
    x+=dirX;
    x = constrain(x, 10, width-10);
  }

  void spara() {
    caricatore.add(new Proiettile(this.x));
  }
}
