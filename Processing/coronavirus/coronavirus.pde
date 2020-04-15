Persona gente[];
int giorno = 200;


void setup(){
  size(800,600);
  gente = new Persona[500];
  for(int i = 0; i < gente.length; i++){
    gente[i] = new Persona();
  }
  for (Persona p1 : gente) {
    for (Persona p2 : gente) {
      if (p1 != p2 && dist(p1.x, p1.y, p2.x, p2.y) <= p1.diam) {
        p1.x += p1.diam - dist(p1.x, p1.y, p2.x, p2.y);
        p1.y += p1.diam - dist(p1.x, p1.y, p2.x, p2.y);
        p2.x += p1.diam - dist(p1.x, p1.y, p2.x, p2.y);
        p2.y += p1.diam - dist(p1.x, p1.y, p2.x, p2.y);
      }
    }
  }
  gente[0].stato=1;
  gente[0].tFineIncubazione=int(random(3,20))*giorno;
}


void draw() {
  background(0);
  for (int i = 0; i < 6; i++) {
    for (Persona p : gente) {
      p.update();
      for (Persona p2 : gente) {
        if (p != p2) {
          p.collisione(p2);
        }
      }
    }
  }
  for (Persona p : gente) {
    p.show();
  }
  stampaTimer();
}

void stampaTimer(){
  fill(255);
  textSize(25);
  textAlign(RIGHT);
  text(millis()/1000,width-20, height-50);
  text("giorno "+millis()/giorno,width-20, height-20);
  noFill();
}
