# 15) QA 2023-01-21 #
## План ## 
1) Реализация связей в Hibernate 
   1) one-to-many - один ко многим 
   2) many-to-one - многие к одному 
   3) many-to-many - многие ко многим 
   4) one-to-one - один к одному 
2) Рассмотрим способы решения проблемы N + 1 (ну и саму проблему) на примере связи one-to-many
   1) fetch-запрос
   2) Entity-граф 
3) Рассмотрим исключение LazyInitializationException 
