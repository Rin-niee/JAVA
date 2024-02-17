/*Создайте класс MyTime для представления времени. Класс MyTime должен содержать:
 Поля данных hour, minute и second, которые представляют время.
 Безаргументный конструктор, который создает объект типа MyTime для текущего
времени. (Значения полей данных этого объекта представляют текущее время.)
 Конструктор, который создает объект типа MyTime с указанным временем в
миллисекундах, прошедших с 00:00, 1 января 1970 г. (Значения полей данных этого
объекта будут представлять это время.)
 Конструктор, который создает объект типа MyTime с указанными часами,
минутами и секундами.
 Три getter-метода для полей данных hour, minute и second соответственно.
 Метод с именем setTime(long elapseTime), который присваивает объекту новое
время с помощью прошедшего времени. Например, если прошедшее время
равно 555550000 миллисекундам, то hour равно 10, minute равно 19,
а second равно 10.
Напишите клиент этого класса — программу, которая создает три объекта
типа MyTime (с помощью new MyTime(), new MyTime(555550000) и new MyTime(5, 23,
55)) и отображает значениях их полей данных hour, minute и second в
формате часы:минуты:секунды.
(Подсказка: первые два конструктора извлекут значения hour, minute и second из
прошедшего времени. Для безаргументного конструктора текущее время может быть
получено с помощью метода System.currentTimeMillis())*/

import java.util.Date;

public class MyTime{
  
  public int hour;
  public int minute;
  public int second;
  
  public MyTime()
  {
    long currentTimeMillis = System.currentTimeMillis();
    setTime(currentTimeMillis);
  }
  public MyTime(long elapsedTime)
  {
    setTime(elapsedTime);
  }
  public MyTime(int hour, int minute, int second)
  {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }
  
  public int GetHour()
  {
    return hour;
  }
  public int GetMinute()
  {
    return minute;
  }
  public int GetSecond()
  {
    return second;
  }
  
  public void setTime(long elapsedTime){
    long totalseconds = elapsedTime/1000;
    second = (int)(totalseconds % 60);
    long totalminute = totalseconds/60;
    minute = (int)(totalminute % 60);
    hour = (int)(totalminute / 60);
  }
  
  public String toString()
  {
    return String.format("%02d:%02d:%02d", hour, minute, second);
  }
  
}
