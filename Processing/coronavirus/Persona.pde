class Persona {
  float x, y, vX, vY, diam;
  int stato;
  int incubazione;
  int tFineIncubazione; 
  boolean isIncubato = true;
  float immunita;
  float anticorpi;
  int eta;
  int tPrimaOspedale; 
  int tPrimaTIntensiva;
  boolean isInOspedale = false;
  boolean isInTIntensiva = false;
  int tGuarigione;
  int tFineTerInt;
  boolean haFinitoTIint = false;
  boolean isGuarito=false;

  Persona() {
    diam=10;
    incubazione = int(random(3, 20));
    immunita = random(0.75, 1);
    eta = int(random(5, 100));
    anticorpi=random(0.75, 1); //cercare valori più verosimili
    tGuarigione = int(random(20, 30)) * giorno;
    stato=0;
    x=random(width);
    y=random(height);

    float r = random(1);

    if (r<=1) {

      do {
        vX=random(-0.5, 0.5);
      } while (vX==0);

      do {
        vY=random(-0.5, 0.5);
      } while (vY==0);
    } else {
      vX=0;
      vY=0;
    }
  }

  void update() {
    x=x+vX;
    y=y+vY;

    if (y<=diam/2 || y>=height-diam/2) {
      vY=vY*-1;
    }

    if (x<=diam/2 || x>=width-diam/2) {
      vX=vX*-1;
    }
    y = constrain(y, diam/2, height-diam/2);
    x = constrain(x, diam/2, width-diam/2);

    if (millis() >= tFineIncubazione && stato==1 && isIncubato==true) {
      isIncubato=false;
      float r = random(1);
      if (r<immunita) {
        stato=2;
        tPrimaOspedale = int(random(1, 14)) * giorno + millis();
        
      }
    }

    if (stato==2 && millis()>=tPrimaOspedale && isInOspedale==false) {
      if (random(100)<eta) {
        stato=3;
        tPrimaTIntensiva = int(random(1, 10)) * giorno + millis();
        
        vX=0;
        vY=0;
      }
      isInOspedale=true;
    }

    if (stato==3 && millis()>=tPrimaTIntensiva && isInTIntensiva==false) {
      if (random(1)<anticorpi) {
        stato=4;
        tFineTerInt = int(random(3, 30)) * giorno + millis();
        
      }
      isInTIntensiva=true;
    }

    if (stato==4 && millis()>=tFineTerInt && haFinitoTIint==false) {
      if (random(1)<0.5) {
        stato=5;
        isGuarito=true;
        do {
          vX=random(-0.5, 0.5);
        } while (vX==0);

        do {
          vY=random(-0.5, 0.5);
        } while (vY==0);
      } else {
        stato=6;
      }
      haFinitoTIint=true;
    }
    
    if( (stato==1 || stato==2 || stato==3) && millis()>=tGuarigione && isGuarito==false){
      
    }
    
  }

  void show() {
    switch(stato) {
    case 0: 
      fill(255); 
      break; // sano
    case 1: 
      fill(255, 255, 0); 
      break; // asintomatico
    case 2: 
      fill(255, 100, 0); 
      break; // infetto
    case 3: 
      fill(255, 0, 0); 
      break; // ospedale
    case 4: 
      fill(255, 100, 255); 
      break; // terapia intensiva
    case 5: 
      fill(0, 0, 255); 
      break; // guarito
    case 6: 
      fill(160); 
      break; // morto
    default: 
      fill(109, 80, 0); 
      break; // errore
    }
    circle(x, y, diam);
    noFill();
  }

  int sign(float a) {
    if (a == 0) {
      return 0;
    } else if (a > 0) {
      return 1;
    } else {
      return -1;
    }
  }

  int quad() {
    if (vX > 0 && vY < 0) return 1;
    if (vX < 0 && vY < 0) return 2;
    if (vX < 0 && vY > 0) return 3;
    if (vX > 0 && vY > 0) return 4;
    return 15;
  }

  void tp(Persona p, float n) {
    switch (quad()) {
    case 1:
      {
        x += diam - dist(p.x, p.y, this.x, this.y)+n;
        y -= diam - dist(p.x, p.y, this.x, this.y)+n;
      }
    case 2:
      {
        x -= diam - dist(p.x, p.y, this.x, this.y)+n;
        y -= diam - dist(p.x, p.y, this.x, this.y)+n;
      }
    case 3:
      {
        x -= diam - dist(p.x, p.y, this.x, this.y)+n;
        y += diam - dist(p.x, p.y, this.x, this.y)+n;
      }
    case 4:
      {
        x += diam - dist(p.x, p.y, this.x, this.y)+n;
        y += diam - dist(p.x, p.y, this.x, this.y)+n;
      }
    default:
      {
      }
    }
  }

  void collisione (Persona p) {
    if (dist(p.x, p.y, this.x, this.y) <= this.diam) {
      //if ((this.stato==0 || this.stato==5) && (p.stato!=0 && p.stato!=5 && p.stato!=6)) {
      if ((this.stato==0) && (p.stato!=0 && p.stato!=5 && p.stato!=6)) {
        this.stato=1;
        this.tFineIncubazione = incubazione * giorno + millis();
        // } else if ((p.stato==0 || p.stato==5) && (this.stato!=0 && this.stato!=5 && this.stato!=6)) {
      } else if ((p.stato==0) && (this.stato!=0 && this.stato!=5 && this.stato!=6)) {
        p.stato=1;
        p.tFineIncubazione = incubazione * giorno + millis();
      }
      if (p.vX!=0 && p.vY!=0 && this.vX!=0 && this.vY!=0) {
        float tmp1 = p.vX, tmp2 = p.vY;
        p.vX = vX;
        p.vY = vY;
        vX = tmp1;
        vY = tmp2;
        this.tp(p, 0);
        p.tp(this, 0);
      } else {
        if (abs(this.y-p.y)<abs(this.x-p.x)) {
          this.vX *=-1;
          this.tp(p, diam/100);
          p.tp(this, diam/100);
        } else {
          this.vY *=-1;
          this.tp(p, diam/100);
          p.tp(this, diam/100);
        }
      }
    }
  }
}
