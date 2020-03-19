PImage foto;
int x;
int y;
int dx;
int sx;
int alto;
int basso;
int dir=0;
void setup() {
  size(1579, 888); 
  foto = loadImage("moto3.jpg");
  background(0);
    dx=1;
  sx=1;
  alto=1;
  basso=1;
  dir=0;
  x=0;
  y=0;
}

void draw() {
  for (int i=0; i<1000; i++) {
    if (dir==0) { // destra dir 0
      if (x<width-dx) {
        x++;
      } else {
        dir=1;
        dx++;
      }
    } else if (dir==1) { // basso dir 1
      if (y<height-basso) {
        y++;
      } else {
        dir=2;
        basso++;
      }
    } else if (dir==2) { // sinistra dir 2
      if (x>sx) {
        x--;
      } else {
        dir=3;
        sx++;
      }
    } else { //alto dir 3
      if (y>alto) {
        y--;
      } else {
        dir=0;
        alto++;
      }
    }
    stroke(foto.get(x, y));
    point(x, y);
  }
}
