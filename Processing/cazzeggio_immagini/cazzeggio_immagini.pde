PImage foto;

void setup() {
  size(800, 800);
  foto = loadImage("ultimate muscle.jpg");
}

void draw() {
  loadPixels();
  for (int i=0; i<width; i++) {
    for (int j=0; j<height; j++) {
      int pos = i+j*width;
      float r = red(foto.pixels[pos]);
      float g = green(foto.pixels[pos]);
      float b = blue(foto.pixels[pos]);
      float l = brightness(foto.pixels[pos]);
float d = dist(i, j, mouseX, mouseY);
      float fact = map(d, 0, width/4, 2, 0);
      if(l>170){
         pixels[pos] = color(255);
      }else{
         pixels[pos] = color(0);
      }
      
    }
  }
  updatePixels();
}
