int r=200;
float x;
float y;
float d;
double contC=0;
double contQ=0;
double p=0;
double diff;
double record=100;
void setup() {
  //dichiari finestra 400*400 pixel
  size(400, 400);
  strokeWeight(2);
  fill(0);
  stroke(0);
  //disegno quidrato circoscritto a cerchio
  square(0, 0, width);
  circle(width/2, height/2, width);
}

void draw() {
  translate(width/2, height/2);
  //for serve per fare 10k ounti ogni frame
  for (int i=0; i<10000; i++) {
    x=random(-r, r);
    y=random(-r, r);
    d=sqrt(x * x + y * y);
    //controllo se punto dentro o fuori dal cerchio, se in cerchio verde se fuori rosso
    if (d<r) {
      stroke(#00FC1F); 
      contC++;
    } else {
      stroke(255, 0, 0);
    }
    contQ++;
    point(x, y);
    p = ((float) contC / (float) contQ) * 4;
    //calcolo diff minima del nostro PI con quello vero
    diff= Math.abs( Math.PI - p);
    if(diff<record){
     record=diff; 
     println(record);
    }
    
  }
  
}
