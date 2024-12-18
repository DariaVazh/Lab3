public class ToDoList {
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

    public void list(){ // вывод всего списка задач
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

    public void statistics(){ //вывод статистики по делам
        System.out.printf("Количество выполненных задач: " + numberOfCompletedTasks());
        System.out.println();
        System.out.printf("Количество невыполненных задач: " + numberOfActiveTasks());
        System.out.println();
        System.out.printf("Процент выполнения поставленных задач: "+"%.2f",((double)numberOfCompletedTasks()/count()));
    }
}
