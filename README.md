![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Debian](https://img.shields.io/badge/Debian-D70A53?style=for-the-badge&logo=debian&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

Приложение открывается на адресе: http://localhost:8080/swagger-ui/index.html, взаимодействие пользователя с приложением
осуществляется через Swagger. Версия приложения «подтягивается» из конфигурационного
файла.
При первом запуске приложения с помощью утилиты Liquibase создается база данных MySQL,
которая заполняется тестовыми данными – героями Алана Милна, у которых есть телефоны и
адреса электронной почты.
Согласованность данных обеспечивается на уровне базы путем проверки вносимых сведений с
использованием регулярных выражений.
Поскольку приложение предусматривает только CRUD-операции без какого-либо
преобразования данных, сервисный слой в приложении отсутствует.
Исключения перехватываются в контроллере с помощью ExceptionHandler.
Логирование осуществляется как в файл, так и путем вывода сообщений на консоль.
Тестируется только метод контроллера на предмет выброса исключения, поскольку
приложение фактически состоит только из методов контроллера, которые вызывают методы
репозитория.
