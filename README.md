<h2>ПОДКЛЮЧИТЬ СЕРВЕРНУЮ ЧАСТЬ БЕЗ БАЗЫ ДАННЫХ (далее БД) – простой вариант:</h2>

<i>Бэк будет работать на списках, созданных разработчиком.</i>
1.	Перейти по следующему пути<br/>
    siteForInteriorDesigner\src\main\java\com\malina\siteForInteriorDesigner\controller<br/><br/>
2.	В файле ServiceController.java в методе findAllService()
```
    return service.findAllService(); //закомментировать
    return Arrays.asList(ser1, ser2, ser3, ser4, ser5); //раскомментировать
```

4.	В файле PortfolioController.java в методе getPortfolio()
```
    return service.findAllImage(); //закомментировать
    return Arrays.asList(img1, img2); //раскомментировать
```
<h2>ПОДКЛЮЧИТЬ СЕРВЕРНУЮ ЧАСТЬ С БД – менее простой вариант:</h2>
1.	https://www.enterprisedb.com/downloads/postgres-postgresql-downloads - установить PostgreSQL.<br/>
    ***При установки указать порт 5432, пароль !234Qwer<br/><br/>
2.	В приложении pgAdmin 4 создать БД web_app_db, в качестве владельца указать postgres.<br/><br/>
3.	Чтобы писать запросы, используется инструмент Query tool (Alt + Shift + Q).<br/><br/>
4.	В окне Query выполняем (F5) следующие запросы:

```
// Создание таблицы service
create table if not exists service (
		 id serial primary key,
     name varchar(255),
     short_description text,
     long_description text,
     price bigint,
     value_measure varchar(50)
);

// Заполнение таблицы service
insert into service(name, short_description, long_description, price, value_measure) values ('Консультация', 'Это может быть онлайн или живая встреча', 'Это может быть онлайн или живая встреча. Стоимость – от 1000 рублей в зависимости от задачи и времени ее решения.', 1500, 'руб');
insert into service(name, short_description, long_description, price, value_measure) values ('Полный дизайн-проект', 'Предоставление полного дизайн-проекта для интерьера, включая все необходимые планы, спецификации и таблицы для реализации проекта.', null, 1800, 'руб/м');
insert into service(name, short_description, long_description, price, value_measure) values ('Планировочное решение', 'Создание полного плана интерьера', 'Услуга создания планировочного решения включает: - Обмерный чертеж с отображением и привязками всех существующих конструкций и коммуникаций; - План демонтажа существующих перегородок; - План монтажа новых перегородок; - План помещения после перепланировки с экспликацией; - План расстановки мебели;', 300, 'руб/м');
insert into service(name, short_description, long_description, price, value_measure) values ('Эскизный проект', 'Это мини-проект, адаптированный под Вашу задачу', 'Это мини-проект, адаптированный под Вашу задачу. Смотреть пример.', 5000, 'руб/пом');
insert into service(name, short_description, long_description, price, value_measure) values ('Авторский надзор', 'Помощь и контроль в процессе реализации дизайн-проекта', 'Данная услуга предполагает: - регулярный выезд на объект с целью обсуждения с подрядчиком вопросов, возникающих в процессе реализации дизайн-проекта; - консультирование онлайн и по телефону; - помощь в подборе отделочных и декоративных материалов, поиск аналогов; - контроль графика поставок и приемка материалов.', 7000, 'руб/мес');

// Вывод таблицы service
select * from service;

// Создание таблицы portfolio
create table if not exists portfolio (
    id serial primary key,
    path varchar(255),
    index int2
);

// Заполнение таблицы portfolio
insert into portfolio(path, index) values ('../src/assets/images/complectation.png', 0);
insert into portfolio(path, index) values ('../src/assets/images/project_frame.png', 1);

// Вывод таблицы portfolio
select * from portfolio;
```
***В таблице portfolio поле index указывает на индекс фотографии, который будет передаваться в метод openModal (клиентская часть) при нажатии на фото.

5.	Для подключения PostgreSQL к Visual Studio Code можно воспользоваться инструкцией - https://www.commandprompt.com/education/how-to-connect-to-postgresql-from-visual-studio-code/ <br/><br/>
6.	Для подключения PostgreSQL к IntelliJ IDEA в IDEA Database -> + -> Data Source -> PostgreSQL. Заполнить появившееся окно:
   ```
    Name: web_app_db@localhost
    Host: localhost
    Port: 5432
    User: postgres
    Database: web_app_db
  	URL: jdbc:postgresql://localhost:5432/web_app_db
    Test Connection - для проверки подключения.
```
***Для запуска проекта в VSC потребуется установить Extension Pack for Java, JDK, Spring Boot Extension Pack, проект запускается с помощью F5. <br/>
   Подробнее см. https://youtu.be/dq1z9t03mXI?si=wgp0nJZSoeDh7DQP

<h2>СВЯЗЫВАЕМ КЛИЕНТСКУЮ И СЕРВЕРНУЮ ЧАСТИ</h2>
В серверной части в ServiceController.java и PortfolioController.java прописываем аннотацию 

```
@CrossOrigin(origins = "http://localhost:5173")
```

В клиентской части в файле .vue прописываем

```
methods: {
        getServices() {
            fetch('http://localhost:8080/service')
            .then(res => res.json())
            .then(data => {
                this.servic = data
                console.log(data)
            })
        },
        getPortfolio() {
            fetch('http://localhost:8080/portfolio')
            .then(res => res.json())
            .then(data => {
                this.portfolio = data
                console.log(data)
            })
        }
}
```
Пример представлен в site-for-interior-designer/part_of_code/src/views/ModalButton.vue
