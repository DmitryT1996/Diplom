#include <OneWire.h>
#include <DallasTemperature.h>
#define LED 13
#define IN3 6
#define IN4 7
#define FAN 13
#define InN 2
#define OutN 2
#define sig 0.5
int message_for_motor = 0;
int condition_rotate = 0;
int outer;
float patt[InN];
float enters[InN];
float hidden[OutN];
float hidd_ent_w[OutN] = {0.35, 1.01};
float ent_hidd_w[2][2] = {{2.819, 6.2947}, {-2.4866, -6.6707}};

OneWire oneWire(15);
DallasTemperature ds(&oneWire);
byte qty;

void setup()
{
  Serial.begin(9600);
  ds.begin(); 
  qty = ds.getDeviceCount(); 
  pinMode (IN4, OUTPUT);
  pinMode (IN3, OUTPUT);
  pinMode (FAN, OUTPUT);
  pinMode (LED, OUTPUT);
}

float sigma(float value){
    return value * (1 - value);
}

void Count(){

    for(int i = 0; i < InN; i ++){
        hidden[i] = 0;
            for(int j = 0; j < OutN; j++){
                hidden[i] += patt[j]*ent_hidd_w[j][i];
            }
            if(hidden[i]>sig)
                hidden[i] = 1;
            else
            hidden[i] = 0;
    }
    outer = 0;
    for(int i = 0; i < InN; i ++){
        outer+=hidden[i]*hidd_ent_w[i];
    }
    sigma(outer);
}

void Command(int value)
{
  if(value == 1)  
    digitalWrite(LED, HIGH);
  else if(value == 0) 
    digitalWrite(LED, LOW);

}

void CreateVector()
{
  for (int i = 0; i < qty; i++){
    patt[i] = ds.getTempCByIndex(i);
  } 
  
//    for (int i = 0; i < qty; i++){
//    Serial.println(patt[i]);
//  } 
  delay(1000);
}



 void Fan_High()
  {
    digitalWrite(FAN, HIGH);
  }
    void Fan_Low()
  {
    digitalWrite(FAN, LOW);
  }

void loop()
{
    ds.requestTemperatures();
    CreateVector();
    Count();
    Command(outer);
  if (Serial.available() > 0) 
  {
 
    message_for_motor = Serial.read();
    Serial.println(message_for_motor);

      if(message_for_motor == 'l')
      {
        condition_rotate = 1;
      }
      else if(message_for_motor == 'r')
      {
        condition_rotate = 2;
      }
      else if(message_for_motor == 's')
      {
         condition_rotate = 0;
      }
            else if(message_for_motor == '3')
      {
        condition_rotate = 3;
      }
            else if(message_for_motor == '4')
      {
        condition_rotate = 4;
      }
  }
if(condition_rotate == 0)
  {
  digitalWrite (IN3, LOW);
  digitalWrite (IN4, LOW);
  }

 else if(condition_rotate == 1)
  {
  digitalWrite (IN4, HIGH);
  digitalWrite (IN3, LOW); 
  }
  else if(condition_rotate == 2)
  {
  digitalWrite (IN3, HIGH);
    digitalWrite (IN4, LOW);
  }
   else if(condition_rotate == 3)
  {
  digitalWrite (IN3, HIGH);
    digitalWrite (IN4, LOW);
    digitalWrite (IN4, LOW);
  digitalWrite (IN3, LOW);
  }
     else if(condition_rotate == 4)
  {
  digitalWrite (IN4, HIGH);
    digitalWrite (IN3, LOW);
    digitalWrite (IN3, LOW);
  digitalWrite (IN4, LOW);
  }

  if (message_for_motor == 'f')
  {
     Fan_High();
  }
    if (message_for_motor == 'z')
  {
     Fan_Low();
  }
}
