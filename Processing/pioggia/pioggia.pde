Goccia[] pioggia =new Goccia[200];
void setup() {
  size(800, 600);
  for (int i=0; i<pioggia.length; i++) {
    pioggia[i] = new Goccia();
  }
}

void draw() {
  background(0);
  for (int i =0; i<pioggia.length; i++) {
    pioggia[i].cadi();
    pioggia[i].show();
  }
}
