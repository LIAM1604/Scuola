PImage foto;

void setup() {
  size(1579,888); 
  foto = loadImage("moto3.jpg");

}

void draw() {
  for (int i=0; i<10000; i++) {

    float x= random (0, width);
    float y= random (0, height);
    strokeWeight(5);
    stroke(foto.get((int)x,(int)y));
    point(x, y);
  }
  if(mousePressed){
   noLoop(); 
  }
}
