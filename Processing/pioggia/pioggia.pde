Goccia[] pioggia =new Goccia[500];
void setup() {
  size(1920, 1080);
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
