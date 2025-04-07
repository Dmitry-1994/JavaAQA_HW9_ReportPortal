# Интеграция с Report Portal
## Для интеграции проекста на базе _Gradle_ с _Report Portal_ необходимо:
1. Добавить в проект файл [docker-compose.yml](https://github.com/reportportal/reportportal/blob/master/docker-compose.yml)
2. В проекте в _src/test/resources/_
    - создать директорию META-INF.services, в нее добавить файл [org.junit.jupiter.api.extension.Extension](https://github.com/Dmitry-1994/JavaAQA_HW9_ReportPortal/blob/main/src/test/resources/META-INF/services/org.junit.jupiter.api.extension.Extension)
    - добавить файл [log4j2.xml](https://github.com/Dmitry-1994/JavaAQA_HW9_ReportPortal/blob/main/src/test/resources/log4j2.xml)
    - добавить файл [reportportal.properties](https://github.com/Dmitry-1994/JavaAQA_HW9_ReportPortal/blob/main/src/test/resources/reportportal.properties)
3. В файле _build.gradle_
    - добавить [репозитории](https://github.com/Dmitry-1994/JavaAQA_HW9_ReportPortal/blob/9dbf1b1d02871809671b51287fd1e15b068ea1d2/build.gradle#L14-L16)
    - добавить [зависимости](https://github.com/Dmitry-1994/JavaAQA_HW9_ReportPortal/blob/9dbf1b1d02871809671b51287fd1e15b068ea1d2/build.gradle#L25-L31)
    - в разделе _test_ указать [настройки](https://github.com/Dmitry-1994/JavaAQA_HW9_ReportPortal/blob/9dbf1b1d02871809671b51287fd1e15b068ea1d2/build.gradle#L37-L38)
4. Для подключения логирования
    - в проекте в _src/test/_ создать [утилитный класс](https://github.com/Dmitry-1994/JavaAQA_HW9_ReportPortal/blob/main/src/test/java/ru/netology/util/Util.java)
    - для тестового класса добавить [аннотацияю](https://github.com/Dmitry-1994/JavaAQA_HW9_ReportPortal/blob/9dbf1b1d02871809671b51287fd1e15b068ea1d2/src/test/java/ru/netology/test/DeliveryTest.java#L13)
    - для отправки сообщения в лог используйте метод logInfo(), передавая необходимое сообщение в качестве параметра ([пример](https://github.com/Dmitry-1994/JavaAQA_HW9_ReportPortal/blob/9dbf1b1d02871809671b51287fd1e15b068ea1d2/src/test/java/ru/netology/test/DeliveryTest.java#L27))
5. В _терминале_ IDEA выполнить команду _docker-compose -p reportportal up -d --force-recreate_ для запуска _Report Portal_
6. Открыть [страницу](http://localhost:8080/) с _Report Portal_ в браузере
7. Для связи _Report Portal_ с проектом
    - выполнить вход систему _Report Portal_ при помощи
        * Логин: _superadmin_
        * Пароль: _erebus_
    - Кликнуть по иконке пользователя в нижнем левом углу и перейти в раздел _ADMINISTRATE_
    - Добавить проект
        * Кликнуть на кнопку _Add New Project_ в правом верхнем углу
        * Ввести имя проекта
        * нажать кнопку _ADD_
    - Перейти в созданный проект
    - Кликнуть по иконке пользователя в нижнем левом углу и перейти в раздел _PROFILE_
    - Сгенерировать _API-ключ_
        * Перейти в _API KEYS_
        * Нажать на кнопку _Generate API key_
        * Ввести любое значение
        * Нажать кнопку _Generate_
    - Скопироать сгенерируемый API-ключь, нажав кнопку _Copy to Clipboard_, и вставить его как значение параметра _rp.api.key_ в файле [reportportal.properties](https://github.com/Dmitry-1994/JavaAQA_HW9_ReportPortal/blob/main/src/test/resources/reportportal.properties)
    - В _Report Portal_ нажать кнопку _Close_
    - Перейти в _CONFIG EXAMPLES_
    - Скопировать значение параметра _rp.project_ и вставить его как значение соответствующего параметра в файле [reportportal.properties](https://github.com/Dmitry-1994/JavaAQA_HW9_ReportPortal/blob/main/src/test/resources/reportportal.properties)

После выполнения тестов в разделе _launches_ *Report Portal* наблюдайте их результаты
       

# Cкриншоты полученных с помощью Report Portal отчетов

### При падающем тесте
![image](https://github.com/user-attachments/assets/80cdaf36-1285-4ffa-929e-3f7a89336a8d)

### При успешном выполнении теста
![image](https://github.com/user-attachments/assets/5ac8b744-4642-4ccc-84e8-87961f4f2c89)
