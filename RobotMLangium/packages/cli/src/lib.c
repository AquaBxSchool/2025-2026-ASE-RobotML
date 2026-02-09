#include <EEPROM.h>
#include <PinChangeInt.h>
#include <PinChangeIntConfig.h>
#define _NAMIKI_MOTOR // for Namiki 22CL-103501PG80:1
#include <MotorWheel.h>
#include <Omni4WD.h>
#include <PID_Beta6.h>
#include <fuzzy_table.h>

irqISR(irq1, isr1);
MotorWheel wheel1(3, 2, 4, 5, &irq1);
irqISR(irq2, isr2);
MotorWheel wheel2(11, 12, 14, 15, &irq2);
irqISR(irq3, isr3);
MotorWheel wheel3(9, 8, 16, 17, &irq3);
irqISR(irq4, isr4);
MotorWheel wheel4(10, 7, 18, 19, &irq4);
Omni4WD Omni(&wheel1, &wheel2, &wheel3, &wheel4);
float speed = 0.0;

float distanceRadial(float angle) { return angle * 141.17; }
float delaying(float distance) {
  return (167 * (distance / speed - 2.9940119760479043));
}
void forward(Omni4WD &Omni, int distance) {
  float delay_time = delaying(distance);
  Omni.setCarAdvance(speed);
  Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
  delay(delay_time);                // 35.1mm
  Omni.setCarSpeedMMPS(0, 500);     // 7.8mm
  delay(500);
  // 50.1mm
}
void leftward(Omni4WD &Omni, int distance) {
  float delay_time = delaying(distance);
  Omni.setCarLeft(speed);
  Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
  delay(delay_time);                // 35.1mm
  Omni.setCarSpeedMMPS(0, 500);     // 7.8mm
  delay(500);
  // 50.1mm
}
void rightward(Omni4WD &Omni, int distance) {
  float delay_time = delaying(distance);
  Omni.setCarRight(speed);
  Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
  delay(delay_time);                // 35.1mm
  Omni.setCarSpeedMMPS(0, 500);     // 7.8mm
  delay(500);
  // 50.1mm
}
void backward(Omni4WD &Omni, int distance) {
  float delay_time = delaying(distance);
  Omni.setCarBackoff(speed);
  Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
  delay(delay_time);                // 35.1mm
  Omni.setCarSpeedMMPS(0, 500);     // 7.8mm
  delay(500);
  // 50.1mm
}
void lowerleft(Omni4WD &Omni, int distance) {
  float delay_time = delaying(distance);
  Omni.setCarLowerLeft(speed);
  Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
  delay(delay_time);                // 35.1mm
  Omni.setCarSpeedMMPS(0, 500);     // 7.8mm
  delay(500);
  // 50.1mm
}
void upperleft(Omni4WD &Omni, int distance) {
  float delay_time = delaying(distance);
  Omni.setCarUpperLeft(speed);
  Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
  delay(delay_time);                // 35.1mm
  Omni.setCarSpeedMMPS(0, 500);     // 7.8mm
  delay(500);
  // 50.1mm
}
void upperright(Omni4WD &Omni, int distance) {
  float delay_time = delaying(distance);
  Omni.setCarUpperRight(speed);
  Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
  delay(delay_time);                // 35.1mm
  Omni.setCarSpeedMMPS(0, 500);     // 7.8mm
  delay(500);
  // 50.1mm
}
void lowerright(Omni4WD &Omni, int distance) {
  float delay_time = delaying(distance);
  Omni.setCarLowerRight(speed);
  Omni.setCarSpeedMMPS(speed, 500); // 7.8mm
  delay(delay_time);                // 35.1mm
  Omni.setCarSpeedMMPS(0, 500);     // 7.8mm
  delay(500);
  // 50.1mm
}
void rotateLeft(Omni4WD &Omni, int angle) {
  float delay_time = delaying(distanceRadial(angle));
  Omni.setCarRotateLeft(speed);
  Omni.setCarSpeedMMPS(speed, 500);
  delay(delay_time);
  Omni.setCarSpeedMMPS(0, 500);
  delay(500);
}
void rotateRight(Omni4WD &Omni, int angle) {
  float delay_time = delaying(distanceRadial(angle));
  Omni.setCarRotateRight(speed);
  Omni.setCarSpeedMMPS(speed, 500);
  delay(delay_time);
  Omni.setCarSpeedMMPS(0, 500);
  delay(500);
}
void rotate(Omni4WD &Omni, int angle) {
  if (angle < 0) {
    rotateLeft(Omni, -angle);
  } else {
    rotateRight(Omni, angle);
  }
}
long getDistance() {
  pinMode(6, OUTPUT);
  digitalWrite(6, LOW);
  delayMicroseconds(2);
  digitalWrite(6, HIGH);
  delayMicroseconds(5);
  digitalWrite(6, LOW);
  pinMode(6, INPUT);

  long duration = pulseIn(6, HIGH);
  delay(100);

  return duration / 29 / 2 * 10;
}

void setup() {
  TCCR1B = TCCR1B & 0xf8 | 0x01; // Pin9,Pin10 PWM 31250Hz
  TCCR2B = TCCR2B & 0xf8 | 0x01; // Pin3,Pin11 PWM 31250Hz

  Omni.PIDEnable(0.31, 0.01, 0, 10);
}
void loop() {
  main_();
  return;
}