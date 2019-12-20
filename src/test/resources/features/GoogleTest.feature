#language: ru

Функциональность: Тестирование страницы Гугл Путешествия

  Структура сценария: поиск путешествия
    Дано страница Гугл с поиском направления путешествия
    Если набрать на клавиатуре "<Направление путешествия>"
    Тогда откроется страница с описанием путешествия
    Если нажать на кнопку [Планирование поездок]
    Тогда можно выбрать отправную точку: "<Откуда>"
    Также установить даты путешествия: <От> и <До>
    И другие критерии: <Кол-во туристов> и <Звезды отеля>

    Примеры:
      | Направление путешествия | Откуда | От         | До         | Кол-во туристов | Звезды отеля |
      | Мюнхен                  | Казань | 2020-01-04 | 2020-01-08 | 2               | 4            |
      | Москва                  | Казань | 2020-01-03 | 2020-01-11 | 1               | 4            |
      | Лондон                  | Москва | 2020-01-12 | 2020-01-19 | 2               | 3            |