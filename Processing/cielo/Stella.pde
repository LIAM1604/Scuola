class Stella {
  float x;
  float y;
  float z;
  float xx;
  float yy;
  Stella() {
    x=random(-width/2, width/2);
    y=random(-height/2, height/2);
    z=random(-width/2,width/2);
    xx=x/z;
    
    yy=y/z;
    
  }

  void show() {
    stroke(255);
    strokeWeight(map(z, 0, width, 10, 1));
    xx = map ( x/z, 0, 1, 0, width);
    yy = map ( y/z, 0, 1, 0, height);
    point(xx, yy);
  }
  void update(){
    z-=vel;
    if(z<1){
      z=random(width);
  }
}
}
