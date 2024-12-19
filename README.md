# Отчет по лабораторной работе №3

**№ группы:** ПМ-2401

**Выполнила:** Важова Дарья Юрьевна

**Вариант:** 3

**1.Постановка задачи:**

* Разработать функционал для управления списком дел с возможностью добавления, удаления и изменения статуса задач. Предусмотреть вывод полного списка, выполненных
или невыполненных задач, а также отображение статистики: общее количество дел, выполненные, невыполненные и процент выполнения. Реализовать операции для работы
с задачами по их названию или порядковому номеру.
Описание функционала
> 1. Создание пустого списка дел
Создание списка дел с возможным указанием его названия. Список по умолчанию
пустой.
> 2. Вывод списка дел
Вывод списка дел в формате:
(a) [ ] «НевыполненноеДело»
(b) [ x ] «ВыполненноеДело».
Нумерация дел делает список удобным для восприятия.
> 3. Вывод списка не сделанных дел
Формирует и выводит список только невыполненных задач.
> 4. Вывод списка выполненных дел
Формирует и выводит список только выполненных задач.
> 5. Добавление нового дела
Добавляет новое дело в список, проверяя, что оно еще не существует.
> 6. Изменение статуса дела по номеру
Устанавливает статус задачи как выполненной, используя её порядковый номер.
> 7. Изменение статуса дела по названию
Устанавливает статус задачи как выполненной, используя её название.
> 8. Получение номера дела по названию
Возвращает порядковый номер задачи в списке по её названию.
> 9. Удаление дела по номеру
Удаляет дело из списка, используя его порядковый номер.
> 10. Удаление дела по названию
Удаляет дело из списка, используя его название.
> 11. Получение общего количества дел
Возвращает общее количество задач в списке.
> 12. Получение количества выполненных дел
Возвращает количество задач со статусом “выполнено”.
> 13. Получение количества невыполненных дел
Возвращает количество задач со статусом “не выполнено”.
> 14. Вычисление процента выполненных дел
Рассчитывает процент выполненных задач от общего количества. Может быть
выведен в удобном формате.
> 15. Вывод статистики по делам
Отображает количество всех дел, выполненных и невыполненных задач, а также
процент выполнения.


* Моё понимание
1. Создать класс списков дел с полем name, значение которого можно задать самостоятельно.
2. Создать класс дел с полями name и  status, значение которых можно задать самостоятельно.
3. Переписать метод toString для того, чтобы выводить список дел в необходимом формате.
4. Создать массив в классе списков дел, куда будут записываться дела.
5. Создать метод для получения из массива всех дела со статусом false и вывода их на экран.
6. Создать метод для получения из массива всех дела со статусом true и вывода их на экран.
7. Создать метод для добавления в массив новой задачи, проверяя, что такой задачи пока нет в списке. При наличии такой же задачи не менять массив.
8. Создать метод для изменения статуса дела по его номеру на противоположный.
9. Создать метод для изменения статуса дела по его названию на противоположный.
10. Создать метод для получения номера дела по его названию.
11. Создать метод для удаление дела из списка, используя номер дела.
12. Создать метод для удаление дела из списка, используя название дела.
13. Создать метод для получения колличества непустых элементов в массив.
14. Создать метод для получения коллучества элементов со статусом true в массиве.
15. Создать метод для получения коллучества элементов со статусом false в массиве.
16. Создать метод для вычисления отношения выполненных задач к их общему колличеству.
17. Создать метод для вычисления и вывода статистики выполнения задач списка.

**2.5 Математическая модель**

Процентное соотношение между колличеством выполненных задач и их общему количеством = (кол-во выполненных задач / общее кол-во задач) *100%

**3.Выбор структуры данных**

* Для хранения названий (name) списка и задач используется тип String. Для хранения статусов дел используется тип данных boolean. Для хранения всех задач используется одномерный массив типа данных Task длинной 10000. 

**4.Описание классов**

Для решения задачи были созданы классы ToDoList и Task.
* Task
  * Имеет поля name и status, которые задаются при создании нового обьекта. Содержит методы getName, getStatus, setStatus для получения имени задачи, получения статуса задачи, задания нового статуса задачи.
* ToDoList
  * Имеете поле name для задания названия для списка. Вмещает в себя все методы необходимые для решения задачи. 

**5.Программа**

 ```java
class Task {

    private String name;
    private boolean status;


    public Task(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {//геттер названия
        return name;
    }

    public boolean getStatus() {//геттер статуса
        return status;
    }

    public void setStatus(boolean c){//сеттер статуса выполнения задачи
        this.status = c;
    }

    @Override
    public String toString() {
        String st;
        if (status)
            st = "[x] ";
        else
            st = "[ ] ";
        return st + name;
    }
}
 ```

 ```java
class ToDoList{

    private String name;

    public void setName(String listname) {
        this.name = listname;
    }

    Task[] list = new Task[10000]; //создание массива задач

    public void addTask(Task task){ //добавление дела в массив
        int flag = 0; //флаг показывает совпадает ли добавляемая задача с существующей
        for (int i = 0; i < count(); i++){
            if (Objects.equals(task.getName(), list[i].getName())){
                flag = 1;
                i = count();
            }
        }
        if (flag == 0)
            list[count()] = task;
    }

    public int count(){ // возвращает общее количество задач
        int ans = 0;
        for (int i = 0; i < list.length; i++){
            if (list[i] == null){
                ans = i;
                i = list.length;
            }
        }
        return ans;
    }

    public void list(){// вывод всего списка задач
        System.out.println(name);
        System.out.println();
        for (int i = 0; i<= count(); i++){
            if (list[i] != null){
                System.out.printf(i + 1 + ". ");
                System.out.println(list[i]);
            }
        }
    }

    public void activeTasks(){ // вывод списка незавершенных задач
        int k = 1;
        for (int i = 0; i<= count(); i++){
            if (list[i] != null && !list[i].getStatus()){
                System.out.printf(k + ". ");
                System.out.println(list[i]);
                k++;
            }
        }
        System.out.println();
    }

    public void completedTasks(){ //вывод списка завершенных задач
        int k = 1;
        for (int i = 0; i<= count(); i++){
            if (list[i] != null && list[i].getStatus()){
                System.out.printf(k + ". ");
                System.out.println(list[i]);
                k++;
            }
        }
        System.out.println();
    }

    public void changeStatus(int n){ // изменение статуса по номеру
        list[n-1].setStatus(!list[n-1].getStatus());
    }

    public void changeStatus(String s){ // изменение статуса по названию
        int n = -1;
        for (int i = 0; i < count(); i++){
            if (Objects.equals(list[i].getName(), s)){
                n = i;
            }
        }
        if (n>=0)
            list[n].setStatus(!list[n].getStatus());
    }

    public int numberOf(String s){ // получение номера дела по названию
        int ans = -1;
        for (int i = 0; i < count(); i++){
            if (Objects.equals(list[i].getName(), s)){
                ans = i;
                i = count();
            }
        }
        return ans + 1;
    }

    public void deleteTask(int n){ // удаление задачи по номеру
        for (int i = n - 1; i<=count(); i++) {
            list[i] = list[i + 1];
        }
        list[count()] = null;
    }

    public void deleteTask(String s){ //удаление задачи по названию
        int n = numberOf(s);
        deleteTask(n);
    }

    public int numberOfCompletedTasks(){ //количество выполненных задач
        int ans = 0;
        for (int i = 0; i < count(); i++){
            if (list[i].getStatus())
                ans++;
        }
        return ans;
    }

    public int numberOfActiveTasks(){ // количество невыполненных задач
        int ans = 0;
        for (int i = 0; i < count(); i++){
            if (!list[i].getStatus())
                ans++;
        }
        return ans;
    }

    public String percentage(){
        return "Процент выполнения задач: " + Math.round((double)numberOfCompletedTasks()/count()) + "%";

    }

    public void statistics(){ //вывод статистики по делам
        System.out.printf("Количество выполненных задач: " + numberOfCompletedTasks());
        System.out.println();
        System.out.printf("Количество невыполненных задач: " + numberOfActiveTasks());
        System.out.println();
        System.out.print(percentage());
    }

}
 ```

**6.Анализ правильности решения**
1. Проверка создания пустого списка дел
* Input
```
ToDoList taskList = new ToDoList();
taskList.setName("План на выходные");
        
taskList.list();
```
* Output
```
План на выходные
```
2. Проверка правильности дабавления задач и их вывода
* Input
```
ToDoList taskList = new ToDoList();
        taskList.setName("План на выходные");

        Task t1 = new Task("Сделать зарядку", false);
        Task t2 = new Task("Сходить за продуктами", false);
        Task t3 = new Task("Сделать домашнее задание", true);
        Task t4 = new Task("Сходить за продуктами", false);
        Task t5 = new Task("Посмотреть фильм", false);

        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);
        taskList.addTask(t4);
        taskList.addTask(t5);

        taskList.list();
```
* Output
```
План на выходные

1. [ ] Сделать зарядку
2. [ ] Сходить за продуктами
3. [x] Сделать домашнее задание
4. [ ] Посмотреть фильм
```

3. Проверка на правильность вывода списков выполеннных и невыполненных дел
* Input
``` ToDoList taskList = new ToDoList();
        taskList.setName("План на выходные");

        Task t1 = new Task("Сделать зарядку", false);
        Task t2 = new Task("Сходить за продуктами", false);
        Task t3 = new Task("Сделать домашнее задание", true);
        Task t4 = new Task("Сходить за продуктами", false);
        Task t5 = new Task("Посмотреть фильм", false);

        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);
        taskList.addTask(t4);
        taskList.addTask(t5);

        taskList.completedTasks();
        taskList.activeTasks();
    }
```
* Output
```
1. [x] Сделать домашнее задание

1. [ ] Сделать зарядку
2. [ ] Сходить за продуктами
3. [ ] Посмотреть фильм
```

4. Проверка на правильность изменения стаутса дела по номеру и названию
*Input
```
 ToDoList taskList = new ToDoList();
        taskList.setName("План на выходные");

        Task t1 = new Task("Сделать зарядку", false);
        Task t2 = new Task("Сходить за продуктами", false);
        Task t3 = new Task("Сделать домашнее задание", true);
        Task t4 = new Task("Сходить за продуктами", false);
        Task t5 = new Task("Посмотреть фильм", false);

        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);
        taskList.addTask(t4);
        taskList.addTask(t5);

        taskList.changeStatus(1);
        taskList.changeStatus("Посмотреть фильм");

        taskList.list();
```
*Output
```
План на выходные

1. [x] Сделать зарядку
2. [ ] Сходить за продуктами
3. [x] Сделать домашнее задание
4. [x] Посмотреть фильм
```
5. Проверка на получение номера дела по названию
* Input
```
ToDoList taskList = new ToDoList();
        taskList.setName("План на выходные");

        Task t1 = new Task("Сделать зарядку", false);
        Task t2 = new Task("Сходить за продуктами", false);
        Task t3 = new Task("Сделать домашнее задание", true);
        Task t4 = new Task("Сходить за продуктами", false);
        Task t5 = new Task("Посмотреть фильм", false);

        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);
        taskList.addTask(t4);
        taskList.addTask(t5);

        System.out.println(taskList.numberOf("Посмотреть фильм"));
```
* Output
```
4
```

6. Проверка удаления дела по номеру и по названию
* Input
```
ToDoList taskList = new ToDoList();
        taskList.setName("План на выходные");

        Task t1 = new Task("Сделать зарядку", false);
        Task t2 = new Task("Сходить за продуктами", false);
        Task t3 = new Task("Сделать домашнее задание", true);
        Task t4 = new Task("Сходить за продуктами", false);
        Task t5 = new Task("Посмотреть фильм", false);

        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);
        taskList.addTask(t4);
        taskList.addTask(t5);

        taskList.deleteTask(1);
        taskList.deleteTask("Посмотреть фильм");

        taskList.list();
```
* Output
```
План на выходные

1. [ ] Сходить за продуктами
2. [x] Сделать домашнее задание
```
7. Проверка на получение общего количества дел, количества выполненных дел, количества невыполненных дел
* Input
```
ToDoList taskList = new ToDoList();
        taskList.setName("План на выходные");

        Task t1 = new Task("Сделать зарядку", false);
        Task t2 = new Task("Сходить за продуктами", false);
        Task t3 = new Task("Сделать домашнее задание", true);
        Task t4 = new Task("Сходить за продуктами", false);
        Task t5 = new Task("Посмотреть фильм", false);

        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);
        taskList.addTask(t4);
        taskList.addTask(t5);

        System.out.println(taskList.count());
        System.out.println(taskList.numberOfCompletedTasks());
        System.out.println(taskList.numberOfActiveTasks());
```
* Output
```
4
1
3
```

8. Проверка на вычисление процента выполненных задачи и общей статистики выполнения
* Input
```
ToDoList taskList = new ToDoList();
        taskList.setName("План на выходные");

        Task t1 = new Task("Сделать зарядку", false);
        Task t2 = new Task("Сходить за продуктами", false);
        Task t3 = new Task("Сделать домашнее задание", true);
        Task t4 = new Task("Сходить за продуктами", false);
        Task t5 = new Task("Посмотреть фильм", false);

        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);
        taskList.addTask(t4);
        taskList.addTask(t5);

        System.out.println(taskList.percentage());
        taskList.statistics();
```
* Output
```
Процент выполнения задач: 25%
Количество выполненных задач: 1
Количество невыполненных задач: 3
Процент выполнения задач: 25%
Process finished with exit code 0
```
