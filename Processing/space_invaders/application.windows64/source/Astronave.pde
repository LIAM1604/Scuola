class Astronave {

  float x;
  float y;
  float offset;
  float dirX;
  ArrayList<Proiettile> caricatore = new ArrayList<Proiettile>();

  Astronave() {
    offset=50;
    x = width/2;
    y = height - offset;
    dirX=0;
  }

  void update() {
    x += dirX;
    x = constrain(x, 10, width-10);
  }

  void show() {
    imageMode(CENTER);
    image(nave,x,y,50*1.5,offset*3/2);
    for (int i = caricatore.size()-1; i>=0; i--) {
      caricatore.get(i).update();
      caricatore.get(i).show();
      if (caricatore.get(i).y<0) {
        caricatore.remove(i);
      }
    }
  }

  void spara() {
    caricatore.add(new Proiettile(this.x));
  }
}
