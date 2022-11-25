# 12) QA 2022-11-19 #
## План ## 
1) Архитектура проекта на ваше ТЗ с использованием Spring и jdbc
   1) application.properties, data.sql, schema.sql. Как это все работает при старте приложения?
   2) Контроллер, dto, валидация, обработчик ошибок
   3) AbstractService и сервис-слой приложения
   4) Storage, dao и использование jdbc
2) Jdbc и его фишки
   1) DataSource. Что это такое?
   2) ResultSetExtractor и RowMapper (как это юзать в приложении?)
   3) ResultSet
      1) Зачем он нужен?
      2) Типы ResultSet
      3) Можно ли с помощью него изменять данные?
   4) Основные интерфейсы в jdbc (какой, когда и зачем?)
      1) Statement
      2) PreparedStatement
      3) CallableStatement
   5) Работа с транзакцией в Spring
   6) FecthSize и BatchSize

Еще вот пример удаления таблицы и обнуления инкремента:

>DELETE FROM USERS;

>ALTER TABLE USERS ALTER COLUMN ID RESTART WITH 1; 