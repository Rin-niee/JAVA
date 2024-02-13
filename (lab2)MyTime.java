/*Создайте класс MyTime для представления времени. Класс MyTime должен содержать:
 Поля данных hour, minute и second, которые представляют время.
 Безаргументный конструктор, который создает объект типа MyTime для текущего
времени. (Значения полей данных этого объекта представляют текущее время.)
 Конструктор, который создает объект типа MyTime с указанным временем в
миллисекундах, прошедших с 00:00, 1 января 1970 г. (Значения полей данных этого
объекта будут представлять это время.)
 Конструктор, который создает объект типа MyTime с указанными часами,
минутами и секундами.
 Три getter-метода для полей данных hour, minute и second соответственно.
 Метод с именем setTime(long elapseTime), который присваивает объекту новое
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

class MyTime{
  
  int hour;
  int minute;
  int second;
  long elapseTime;
  
  MyTime()
  {
    System.currentTimeMillis();
  }
  
  MyTime(int newHour, int newMinute, int newSecond)
  {
    hour = newHour;
    minute=newMinute;
    second= newSecond;
  }
  MyTime(long newElapseTime)
  {
    elapseTime=newElapseTime;
  }
  
  /*MyTime(int newHour)
  {
    hour = newHour;
  }
  MyTime(int newMinute)
  {
    minute=newMinute;
  }
  MyTime(int newSecond)
  {
    second= newSecond;
  }*/
  
  Date setTime(long elapseTime){
    hour = elapseTime/(3600000);
    minute = ((elapseTime%(3600000))/60);
    second = (((elapseTime%(3600000))%60)/60);
  }
}
