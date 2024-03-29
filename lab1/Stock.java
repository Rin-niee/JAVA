/*По примеру класса Circle (из примера программы к разделу 1 и 2) создайте класс Stock для
представления акций компании. Класс Stock должен содержать:
Строковое поле данных с именем symbol для обозначения акций.
Строковое поле данных с именем name для наименования акций.
Поле данных previousClosingPrice типа double, в котором хранится стоимость акций
на момент закрытия предыдущего дня.
Поле данных currentPrice типа double, в котором хранится стоимость акций в
настоящий момент.
Конструктор, создающий акции с указанными обозначением и наименованием.
Метод с именем getChangePercent(), который возвращает процент изменения
стоимости акций с previousClosingPrice на currentPrice.
Напишите клиент этого класса — программу, которая создает объект типа Stock с
обозначением SBER, именем ПАО Сбербанк, стоимостью акций на момент закрытия
предыдущего дня, равной 281.50. Задайте новую стоимость акций в настоящий момент,
равную 282.87, и отобразите процент изменения стоимости акций.*/


class Stock{
  
  String symbol;
  String name;
  double prevoiusClosingPrice;
  double currentPrice;
  
  Stock(){
    symbol = "NULL SYMBOL";
    name= "NULL NAME";
    prevoiusClosingPrice = 0;
    currentPrice = 0;
  }
  Stock(String newSymbol, String newName, double newPrevoiusClosingPrice, double newCurrentPrice)
  {
    symbol = newSymbol;
    name= newName;
    prevoiusClosingPrice = newPrevoiusClosingPrice ;
    currentPrice = newCurrentPrice;
  }
  
  double getChangePercent(){
    return (((currentPrice-prevoiusClosingPrice)/((currentPrice+prevoiusClosingPrice)/2))*100);
  }
}
