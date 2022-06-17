<h1>Лабораторная #1</h1>
Написать программу на языке Java, выполняющую соответствующие варианту действия. Программа должна соответствовать следующим требованиям:<br>
<br>
<ol>
<li>Она должна быть упакована в исполняемый jar-архив.</li>
<li>Выражение должно вычисляться в соответствии с правилами вычисления математических выражений (должен соблюдаться порядок выполнения действий и т.д.).</li>
<li>Программа должна использовать математические функции из стандартной библиотеки Java.</li>
<li>Результат вычисления выражения должен быть выведен в стандартный поток вывода в заданном формате.</li>
<li>Выполнение программы необходимо продемонстрировать на сервере helios.</li>
</ol>

![image](https://user-images.githubusercontent.com/103372056/174412948-d07118e7-f177-467d-88b4-03a827aa5190.png)


<h1>Лабораторная #2</h1>
На основе базового класса Pokemon написать свои классы для заданных видов покемонов. Каждый вид покемона должен иметь один или два типа и стандартные базовые характеристики:<br>
<br>
<ul>
<li>очки здоровья (HP)</li>
<li>атака (attack)</li>
<li>защита (defense)</li>
<li>специальная атака (special attack)</li>
<li>специальная защита (special defense)</li>
<li>скорость (speed)</li>
</ul>
Классы покемонов должны наследоваться в соответствии с цепочкой эволюции покемонов. На основе базовых классов PhysicalMove, SpecialMove и StatusMove реализовать свои классы для заданных видов атак.<br><br>
Атака должна иметь стандартные тип, силу (power) и точность (accuracy). Должны быть реализованы стандартные эффекты атаки. Назначить каждому виду покемонов атаки в соответствии с вариантом. Уровень покемона выбирается минимально необходимым для всех реализованных атак.<br><br>
Используя класс симуляции боя Battle, создать 2 команды покемонов (каждый покемон должен иметь имя) и запустить бой.<br><br>
Базовые классы и симулятор сражения находятся в jar-архиве. Документация в формате javadoc - здесь.<br><br>
Информацию о покемонах, цепочках эволюции и атаках можно найти на сайтах http://poke-universe.ru, http://pokemondb.net, http://veekun.com/dex/pokemon<br><br>

<h4>Комментарии</h4>
Цель работы: на простом примере разобраться с основными концепциями ООП и научиться использовать их в программах.<br><br>

Что надо сделать (краткое описание):<br>
<ol>
<li>Ознакомиться с документацией, обращая особое внимание на классы Pokemon и Move. При дальнейшем выполнении лабораторной работы читать документацию еще несколько раз.</li>
<li>Скачать файл Pokemon.jar. Его необходимо будет использовать как для компиляции, так и для запуска программы. Распаковывать его не надо! Нужно научиться подключать внешние jar-файлы к своей программе.</li>
<li>Написать минимально работающую программу и посмотреть как она работает.<br>
Battle b = new Battle();<br>
Pokemon p1 = new Pokemon("Чужой", 1);<br>
Pokemon p2 = new Pokemon("Хищник", 1);<br>
b.addAlly(p1);<br>
b.addFoe(p2);<br>
b.go();<br>
</li>
<li>Создать один из классов покемонов для своего варианта. Класс должен наследоваться от базового класса Pokemon. В конструкторе нужно будет задать типы покемона и его базовые характеристики. После этого попробуйте добавить покемона в сражение.</li>
<li>Создать один из классов атак для своего варианта (лучше всего начать с физической или специальной атаки). Класс должен наследоваться от класса PhysicalMove или SpecialMove. В конструкторе нужно будет задать тип атаки, ее силу и точность. После этого добавить атаку покемону и проверить ее действие в сражении. Не забудьте переопределить метод describe, чтобы выводилось нужное сообщение.</li>
<li>Если действие атаки отличается от стандартного, например, покемон не промахивается, либо атакующий покемон также получает повреждение, то в классе атаки нужно дополнительно переопределить соответствующие методы (см. документацию). При реализации атак, которые меняют статус покемона (наследники StatusMove), скорее всего придется разобраться с классом Effect. Он позволяет на один или несколько ходов изменить состояние покемона или модификатор его базовых характеристик.</li>
<li>Доделать все необходимые атаки и всех покемонов, распределить покемонов по командам, запустить сражение.
pokemons</li>
</ol>


<h1>Лабораторная #3</h1>
Описание предметной области, по которой должна быть построена объектная модель:<br><br>
И вот Знайка стал думать. Думал он три дня и три ночи и придумал сделать шар из резины. Коротышки умели добывать резину. В городе у них росли цветы, похожие на фикусы. Если на стебле такого цветка сделать надрез, то из него начинает вытекать белый сок. Этот сок постепенно густеет и превращается в резину, из которой можно делать мячи и калоши.
<style type="text/css">
   .line { 
    border-left: 2px solid #ccc; /* Параметры линии */ 
    margin-left: 20px; /* Отступ слева */
    padding-left: 10px; /* Расстояние от линии до текста */ 
   }
  </style> 
<p class="line">Когда Знайка это придумал, он велел малышам собирать резиновый сок. Все стали приносить сок, для которого Знайка приготовил большую бочку. Незнайка тоже пошёл собирать сок и встретил на улице своего друга Гуньку, который играл с двумя малышками в прыгалки.</p>
<h4>Программа должна удовлетворять следующим требованиям:</h4>
<ol>
<li>Доработанная модель должна соответствовать принципам SOLID.</li>
<li>Программа должна содержать как минимум два интерфейса и один абстрактный класс (номенклатура должна быть согласована с преподавателем).</li>
<li>В разработанных классах должны быть переопределены методы equals(), toString() и hashCode().</li>
<li>Программа должна содержать как минимум один перечисляемый тип (enum).</li>
</ol>
<h4>Порядок выполнения работы:</h4>
<ol>
<li>Доработать объектную модель приложения.</li>
<li>Перерисовать диаграмму классов в соответствии с внесёнными в модель изменениями.</li>
<li>Согласовать с преподавателем изменения, внесённые в модель.</li>
<li>Модифицировать программу в соответствии с внесёнными в модель изменениями.</li>
</ol>
