class Palla {
  float vx=5;
  float vy=2.5;
  float yc=height/2;
  float xc=width/2;
  float r=10;
  long punti=0;
  int aumP=0;
  int R=255;
  int G=255;
  int B=255;
  int offset=20;
  void show() {
    textSize(15);
    text("PUNTI:"+punti, width/2-40, 15);
    text("+ "+aumP, width/2+offset, 15);
    fill(R, G, B);
    stroke(255-R, 255-G, 255-B);
    strokeWeight(3);
    circle(xc, yc, r*2);
  }
  void muovi() {
    xc+=vx;
    yc+=vy;
    if (yc<r+20) {
      vy*=-1;
      R=(int)random(0, 255);
      G=(int)random(0, 255);
      B=(int)random(0, 255);
      muro.play();
    }
    if (yc>=height-r-20) {
      vy*=-1;
      R=(int)random(0, 255);
      G=(int)random(0, 255);
      B=(int)random(0, 255);
      muro.play();
    }
    punti+=aumP;
  }

  void isColliso(float xd, float yd) {
    float d;
    for (int i=0; i<25; i++) {
      d = dist(xd, yd+i, this.xc, this.yc);
      if (d <= r+10) {
        vx*=-1;
        racchetta.play();
        break;
      }
      d = dist(xd, yd-i, this.xc, this.yc);
      if (d <= r+10) {
        vx*=-1;
        racchetta.play();
        break;
      }
    }
  }

  void isColliso2(float xd, float yd) {
    float d;
    for (int i=0; i<25; i++) {
      d = dist(xd, yd+i, this.xc, this.yc);
      if (d <= r+10) {
        vx*=-1;
        aumP+=2;
        racchetta.play();
        break;
      }
      d = dist(xd, yd-i, this.xc, this.yc);
      if (d <= r+10) {
        vx*=-1;
        aumP+=2;
        racchetta.play();
        break;
      }
    }
  }

  void esito() {
    if (xc>width-50) {
      background(0);
      textSize(80);
      text("GAME OVER", width/2-200, height/2);
      textSize(30);
      text("PUNTI:"+punti, width/2-200, height/2+50);
      finale.loop();
      text("Directed by LIAM", width/2-100, height/2+100);
      text("thanks for playing", width/2-100, height/2+150);
      textSize(20);
      text("ESC per uscire", 10, 20);
      noLoop();
    }
    if (xc<0) {
      background(0);
      textSize(80);
      text("HAI VINTO", width/2-200, height/2);
      textSize(30);
      text("PUNTI:"+punti, width/2-200, height/2+50);
      text("Directed by LIAM", width/2-100, height/2+100);
      text("thanks for playing", width/2-100, height/2+150);
      textSize(20);
      text("ESC per uscire", 10, 20);
      
      finale.loop();
      noLoop();
    }
  }

  void offset() {
    if (punti>9) offset=30;
    if (punti>99) offset=40;
    if (punti>999) offset=50;
    if (punti>9999) offset=60;
    if (punti>99999) offset=70;
    if (punti>999999) offset=80;
    if (punti>9999999) offset=90;
    if (punti>99999999) offset=100;
    if (punti>999999999) offset=110;
  }
}
