<h1>Лабораторная #1</h1>
<p>Написать программу на языке Java, выполняющую соответствующие варианту действия. Программа должна соответствовать следующим требованиям:</p>
<ol>
  <li>Она должна быть упакована в исполняемый jar-архив.</li>
  <li>Выражение должно вычисляться в соответствии с правилами вычисления математических выражений (должен соблюдаться порядок выполнения действий и т.д.).</li>
  <li>Программа должна использовать математические функции из стандартной библиотеки Java.</li>
  <li>Результат вычисления выражения должен быть выведен в стандартный поток вывода в заданном формате.</li>
  <li>Выполнение программы необходимо продемонстрировать на сервере helios.</li>
</ol>
<h3>Вариант:</h3>

![image](https://user-images.githubusercontent.com/103372056/174412948-d07118e7-f177-467d-88b4-03a827aa5190.png)


<h1>Лабораторная #2</h1>
<p>На основе базового класса Pokemon написать свои классы для заданных видов покемонов. Каждый вид покемона должен иметь один или два типа и стандартные базовые характеристики:</p>
<ul>
  <li>очки здоровья (HP)</li>
  <li>атака (attack)</li>
  <li>защита (defense)</li>
  <li>специальная атака (special attack)</li>
  <li>специальная защита (special defense)</li>
  <li>скорость (speed)</li>
</ul>
<p>Классы покемонов должны наследоваться в соответствии с цепочкой эволюции покемонов. На основе базовых классов PhysicalMove, SpecialMove и StatusMove реализовать свои классы для заданных видов атак.</p>
<p>Атака должна иметь стандартные тип, силу (power) и точность (accuracy). Должны быть реализованы стандартные эффекты атаки. Назначить каждому виду покемонов атаки в соответствии с вариантом. Уровень покемона выбирается минимально необходимым для всех реализованных атак.</p>
<p>Используя класс симуляции боя Battle, создать 2 команды покемонов (каждый покемон должен иметь имя) и запустить бой.</p>
<p>Базовые классы и симулятор сражения находятся в <a href="https://se.ifmo.ru/documents/10180/660917/Pokemon.jar/a7ce60af-6ee6-47d0-a95e-e5ed9a697bd2">jar-архиве</a>. Документация в формате javadoc - <a href="https://se.ifmo.ru/~tony/doc/">здесь</a>.</p>
<p>Информацию о покемонах, цепочках эволюции и атаках можно найти на сайтах http://poke-universe.ru, http://pokemondb.net, http://veekun.com/dex/pokemon</p>

<h3>Комментарии</h3>
<p>Цель работы: на простом примере разобраться с основными концепциями ООП и научиться использовать их в программах.</p>
<p>Что надо сделать (краткое описание):</p>
<ol>
  <li>Ознакомиться с <a href="https://se.ifmo.ru/~tony/doc/">документацией</a>, обращая особое внимание на классы Pokemon и Move. При дальнейшем выполнении лабораторной работы читать документацию еще несколько раз.</li>
  <li>Скачать файл Pokemon.jar. Его необходимо будет использовать как для компиляции, так и для запуска программы. Распаковывать его не надо! Нужно научиться подключать внешние jar-файлы к своей программе.</li>
  <li>Написать минимально работающую программу и посмотреть как она работает.<br>
    <pre>
      Battle b = new Battle();
      Pokemon p1 = new Pokemon("Чужой", 1);
      Pokemon p2 = new Pokemon("Хищник", 1);
      b.addAlly(p1);
      b.addFoe(p2);
      b.go();
    </pre>
  </li>
  <li>Создать один из классов покемонов для своего варианта. Класс должен наследоваться от базового класса Pokemon. В конструкторе нужно будет задать типы покемона и его базовые характеристики. После этого попробуйте добавить покемона в сражение.</li>
  <li>Создать один из классов атак для своего варианта (лучше всего начать с физической или специальной атаки). Класс должен наследоваться от класса PhysicalMove или SpecialMove. В конструкторе нужно будет задать тип атаки, ее силу и точность. После этого добавить атаку покемону и проверить ее действие в сражении. Не забудьте переопределить метод describe, чтобы выводилось нужное сообщение.</li>
  <li>Если действие атаки отличается от стандартного, например, покемон не промахивается, либо атакующий покемон также получает повреждение, то в классе атаки нужно дополнительно переопределить соответствующие методы (см. документацию). При реализации атак, которые меняют статус покемона (наследники StatusMove), скорее всего придется разобраться с классом Effect. Он позволяет на один или несколько ходов изменить состояние покемона или модификатор его базовых характеристик.</li>
  <li>Доделать все необходимые атаки и всех покемонов, распределить покемонов по командам, запустить сражение.
pokemons</li>
</ol>

<h1>Лабораторная #3</h1>
<p>Описание предметной области, по которой должна быть построена объектная модель:</p>
<p>
И вот Знайка стал думать. Думал он три дня и три ночи и придумал сделать шар из резины. Коротышки умели добывать резину. В городе у них росли цветы, похожие на фикусы. Если на стебле такого цветка сделать надрез, то из него начинает вытекать белый сок. Этот сок постепенно густеет и превращается в резину, из которой можно делать мячи и калоши.<br>
Когда Знайка это придумал, он велел малышам собирать резиновый сок. Все стали приносить сок, для которого Знайка приготовил большую бочку. Незнайка тоже пошёл собирать сок и встретил на улице своего друга Гуньку, который играл с двумя малышками в прыгалки.
</p>
<h3>Программа должна удовлетворять следующим требованиям:</h3>
<ol>
  <li>Доработанная модель должна соответствовать принципам SOLID.</li>
  <li>Программа должна содержать как минимум два интерфейса и один абстрактный класс (номенклатура должна быть согласована с преподавателем).</li>
  <li>В разработанных классах должны быть переопределены методы equals(), toString() и hashCode().</li>
  <li>Программа должна содержать как минимум один перечисляемый тип (enum).</li>
</ol>
<h3>Порядок выполнения работы:</h3>
<ol>
  <li>Доработать объектную модель приложения.</li>
  <li>Перерисовать диаграмму классов в соответствии с внесёнными в модель изменениями.</li>
  <li>Согласовать с преподавателем изменения, внесённые в модель.</li>
  <li>Модифицировать программу в соответствии с внесёнными в модель изменениями.</li>
</ol>

<h1>Лабораторная #4</h1>
<p>Доработать программу из лабораторной работы #3, обновив реализацию объектной модели в соответствии с новой версией описания предметной области.</p>
<p>Описание предметной области, по которой должна быть построена объектная модель:</p>
<p>
Эта затея всем очень понравилась. Коротышки ещё никогда не летали на воздушном шаре, и всем малышам это было очень интересно. Никто, конечно, не знал, как делать воздушные шары, но Знайка сказал, что он всё обдумает и тогда объяснит.<br>
И вот Знайка стал думать. Думал он три дня и три ночи и придумал сделать шар из резины. Коротышки умели добывать резину. В городе у них росли цветы, похожие на фикусы. Если на стебле такого цветка сделать надрез, то из него начинает вытекать белый сок. Этот сок постепенно густеет и превращается в резину, из которой можно делать мячи и калоши.<br>
Когда Знайка это придумал, он велел малышам собирать резиновый сок. Все стали приносить сок, для которого Знайка приготовил большую бочку. Незнайка тоже пошёл собирать сок и встретил на улице своего друга Гуньку, который играл с двумя малышками в прыгалки.
</p>
<h3>Программа должна удовлетворять следующим требованиям:</h3>
<ol>
  <li>В программе должны быть реализованы 2 собственных класса исключений (checked и unchecked), а также обработка исключений этих классов.</li>
  <li>В программу необходимо добавить использование локальных, анонимных и вложенных классов (static и non-static).</li>
</ol>
<h3>Порядок выполнения работы:</h3>
<ol>
  <li>Доработать объектную модель приложения.</li>
  <li>Перерисовать диаграмму классов в соответствии с внесёнными в модель изменениями.</li>
  <li>Согласовать с преподавателем изменения, внесённые в модель.</li>
  <li>Модифицировать программу в соответствии с внесёнными в модель изменениями.</li>
</ol>

<h1>Лабораторная #5</h1>
<p>Реализовать консольное приложение, которое реализует управление коллекцией объектов в интерактивном режиме. В коллекции необходимо хранить объекты класса Dragon, описание которого приведено ниже.</p>
<h3>Разработанная программа должна удовлетворять следующим требованиям:</h3>
<ol>
  <li>Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.</li>
  <li>Все требования к полям класса (указанные в виде комментариев) должны быть выполнены.</li>
  <li>Для хранения необходимо использовать коллекцию типа java.util.ArrayList</li>
  <li>При запуске приложения коллекция должна автоматически заполняться значениями из файла.</li>
  <li>Имя файла должно передаваться программе с помощью: аргумент командной строки.</li>
  <li>Данные должны храниться в файле в формате xml</li>
  <li>Чтение данных из файла необходимо реализовать с помощью класса java.io.FileReader</li>
  <li>Запись данных в файл необходимо реализовать с помощью класса java.io.FileWriter</li>
  <li>Все классы в программе должны быть задокументированы в формате javadoc.</li>
  <li>Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).</li>
</ol>
<h3>В интерактивном режиме программа должна поддерживать выполнение следующих команд:</h3>
<ul>
  <li>help : вывести справку по доступным командам</li>
  <li>info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)</li>
  <li>show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении</li>
  <li>add {element} : добавить новый элемент в коллекцию</li>
  <li>update id {element} : обновить значение элемента коллекции, id которого равен заданному</li>
  <li>remove_by_id id : удалить элемент из коллекции по его id</li>
  <li>clear : очистить коллекцию</li>
  <li>save : сохранить коллекцию в файл</li>
  <li>execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.</li>
  <li>exit : завершить программу (без сохранения в файл)</li>
  <li>remove_first : удалить первый элемент из коллекции</li>
  <li>shuffle : перемешать элементы коллекции в случайном порядке</li>
  <li>reorder : отсортировать коллекцию в порядке, обратном нынешнему</li>
  <li>count_by_head head : вывести количество элементов, значение поля head которых равно заданному</li>
  <li>filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку</li>
  <li>print_ascending : вывести элементы коллекции в порядке возрастания</li>
</ul>
<h3>Формат ввода команд:</h3>
<ul>
  <li>Все аргументы команды, являющиеся стандартными типами данных (примитивные типы, классы-оболочки, String, классы для хранения дат), должны вводиться в той же строке, что и имя команды.</li>
  <li>Все составные типы данных (объекты классов, хранящиеся в коллекции) должны вводиться по одному полю в строку.</li>
  <li>При вводе составных типов данных пользователю должно показываться приглашение к вводу, содержащее имя поля (например, "Введите дату рождения:")</li>
  <li>Если поле является enum'ом, то вводится имя одной из его констант (при этом список констант должен быть предварительно выведен).</li>
  <li>При некорректном пользовательском вводе (введена строка, не являющаяся именем константы в enum'е; введена строка вместо числа; введённое число не входит в указанные границы и т.п.) должно быть показано сообщение об ошибке и предложено повторить ввод поля.</li>
  <li>Для ввода значений null использовать пустую строку.</li>
  <li>Поля с комментарием "Значение этого поля должно генерироваться автоматически" не должны вводиться пользователем вручную при добавлении.</li>
</ul>
<h3>Описание хранимых в коллекции классов:</h3>
<pre>
  public class Dragon {
      private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
      private String name; //Поле не может быть null, Строка не может быть пустой
      private Coordinates coordinates; //Поле не может быть null
      private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
      private Long age; //Значение поля должно быть больше 0, Поле может быть null
      private Color color; //Поле не может быть null
      private DragonType type; //Поле не может быть null
      private DragonCharacter character; //Поле не может быть null
      private DragonHead head;
  }  
  public class Coordinates {
      private Long x; //Поле не может быть null
      private long y; //Максимальное значение поля: 508
  }  
  public class DragonHead {
      private Long size; //Поле может быть null
      private float eyesCount;
      private float toothCount;
  }  
  public enum Color {
      GREEN,
      RED,
      BLUE,
      WHITE,
      BROWN;
  }  
  public enum DragonType {
      WATER,
      UNDERGROUND,
      AIR;
  }
  public enum DragonCharacter {
      CUNNING,
      WISE,
      EVIL,
      FICKLE;
  }
</pre>

<h1>Лабораторная #6</h1>
<p>Разделить программу из лабораторной работы №5 на клиентский и серверный модули. Серверный модуль должен осуществлять выполнение команд по управлению коллекцией. Клиентский модуль должен в интерактивном режиме считывать команды, передавать их для выполнения на сервер и выводить результаты выполнения.</p>
<h3>Необходимо выполнить следующие требования:</h3>
<ul>
  <li>Операции обработки объектов коллекции должны быть реализованы с помощью Stream API с использованием лямбда-выражений.</li>
  <li>Объекты между клиентом и сервером должны передаваться в сериализованном виде.</li>
  <li>Объекты в коллекции, передаваемой клиенту, должны быть отсортированы по умолчанию</li>
  <li>Клиент должен корректно обрабатывать временную недоступность сервера.</li>
  <li>Обмен данными между клиентом и сервером должен осуществляться по протоколу TCP</li>
  <li>Для обмена данными на сервере необходимо использовать потоки ввода-вывода</li>
  <li>Для обмена данными на клиенте необходимо использовать сетевой канал</li>
  <li>Сетевые каналы должны использоваться в неблокирующем режиме.</li>
</ul>
<h3>Обязанности серверного приложения:</h3>
<ul>
  <li>Работа с файлом, хранящим коллекцию.</li>
  <li>Управление коллекцией объектов.</li>
  <li>Назначение автоматически генерируемых полей объектов в коллекции.</li>
  <li>Ожидание подключений и запросов от клиента.</li>
  <li>Обработка полученных запросов (команд).</li>
  <li>Сохранение коллекции в файл при завершении работы приложения.</li>
  <li>Сохранение коллекции в файл при исполнении специальной команды, доступной только серверу (клиент такую команду отправить не может).</li>
</ul>
<h3>Серверное приложение должно состоять из следующих модулей (реализованных в виде одного или нескольких классов):</h3>
<ul>
  <li>Модуль приёма подключений.</li>
  <li>Модуль чтения запроса.</li>
  <li>Модуль обработки полученных команд.</li>
  <li>Модуль отправки ответов клиенту.</li>
</ul>
<h3>Обязанности клиентского приложения:</h3>
<ul>
  <li>Чтение команд из консоли.</li>
  <li>Валидация вводимых данных.</li>
  <li>Сериализация введённой команды и её аргументов.</li>
  <li>Отправка полученной команды и её аргументов на сервер.</li>
  <li>Обработка ответа от сервера (вывод результата исполнения команды в консоль).</li>
  <li>Команду save из клиентского приложения необходимо убрать.</li>
  <li>Команда exit завершает работу клиентского приложения.</li>
</ul>

<h1>Лабораторная #7</h1>
<p>Доработать программу из лабораторной работы №6 следующим образом:</p>
<ol>
  <li>Организовать хранение коллекции в реляционной СУБД (PostgresQL). Убрать хранение коллекции в файле.</li>
  <li>Для генерации поля id использовать средства базы данных (sequence).</li>
  <li>Обновлять состояние коллекции в памяти только при успешном добавлении объекта в БД</li>
  <li>Все команды получения данных должны работать с коллекцией в памяти, а не в БД</li>
  <li>Организовать возможность регистрации и авторизации пользователей. У пользователя есть возможность указать пароль.</li>
  <li>Пароли при хранении хэшировать алгоритмом SHA-1</li>
  <li>Запретить выполнение команд не авторизованным пользователям.</li>
  <li>При хранении объектов сохранять информацию о пользователе, который создал этот объект.</li>
  <li>Пользователи должны иметь возможность просмотра всех объектов коллекции, но модифицировать могут только принадлежащие им.</li>
  <li>Для идентификации пользователя отправлять логин и пароль с каждым запросом.</li>
</ol>
<p>Необходимо реализовать многопоточную обработку запросов.</p>
<ol>
  <li>Для многопоточного чтения запросов использовать создание нового потока (java.lang.Thread)</li>
  <li>Для многопотчной обработки полученного запроса использовать создание нового потока (java.lang.Thread)</li>
  <li>Для многопоточной отправки ответа использовать Fixed thread pool</li>
  <li>Для синхронизации доступа к коллекции использовать потокобезопасные аналоги коллекции из java.util.concurrent</li>
</ol>
<h3>Порядок выполнения работы:</h3>
<ol>
  <li>В качестве базы данных использовать PostgreSQL.</li>
  <li>Для подключения к БД на кафедральном сервере использовать хост pg, имя базы данных - studs, имя пользователя/пароль совпадают с таковыми для подключения к серверу.</li>
</ol>
