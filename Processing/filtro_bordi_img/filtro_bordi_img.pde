PImage foto;
color rgb;
void setup() {
  size(1579,888);
  foto = loadImage("moto3.jpg");
}

void draw() {
  color rgb= color(random(255),random(255),random(255));
  loadPixels();

  for (int i = 0; i < width-1; i++) {
    for (int j = 0; j < height; j++) {
      int pos = i + j*width;
      int pos2 = (i+1) + j*width;
      float c1=brightness(foto.pixels[pos]);
      float c2=brightness(foto.pixels[pos2]);
      float diff = abs(c1-c2);
      
      pixels[pos] = color(diff);
      
      if(diff>map(mouseX,0,width,0,100)){
        pixels[pos] = color(rgb);
      }else{
        pixels[pos] = color(0);
      }
      
    }
  }
  updatePixels();
}
