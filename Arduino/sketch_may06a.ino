int IN3 = 6;
int IN4 = 7;
int message_for_motor = 0;
int condition_rotate = 0;
int FAN = 13;

void setup()
{
  Serial.begin(9600);
  pinMode (IN4, OUTPUT);
  pinMode (IN3, OUTPUT);
  pinMode (FAN, OUTPUT);
}


class Project
{
public:
 void Fan_High()
  {
    digitalWrite(FAN, HIGH);
  }
    void Fan_Low()
  {
    digitalWrite(FAN, LOW);
  }
 };

void loop()
{
  Project obj;
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
     obj.Fan_High();
  }
    if (message_for_motor == 'z')
  {
     obj.Fan_Low();
  }
}
