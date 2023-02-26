import java.io.File;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Map;

public class Program {
    private File file = new File("db_tasks_list.txt");

        public boolean completeTask(int index){
            Schedule sc = getSchedule();
            if(index >= 0 && index < sc.getSize()) {
                sc.getTask(index).setDone(true);
                Model.saveScheduleToFile(sc, file);
            } else {
                return false;
            }
            return true;
        }
        public boolean deleteTask(int index){
            Schedule sc = getSchedule();
            if(index > 0 && index < sc.getSize()) {
                sc.removeTask(sc.getTask(index));
                Model.saveScheduleToFile(sc, file);
            } else {
                return false;
            }
            return true;
        }
    public boolean addNewTask(Map<String, String> strings){
        String[] ft = strings.get("finishTime").split("-");
        LocalDate finishTime = LocalDate.of(Integer.parseInt(ft[0]),
                                    Integer.parseInt(ft[1]),
                                    Integer.parseInt(ft[2]));
        Task task = new Task(strings.get("user"),
                            strings.get("description"),
                            finishTime,
                            Boolean.parseBoolean(strings.get("important")),
                            false,
                            LocalDate.now());
        Schedule sc = getSchedule();
        sc.addNewTask(task);
        Model.saveScheduleToFile(sc, file);
        return true;
    }

    public String printSchedule(){
        Schedule schedule = (Schedule) getSchedule();
        if(schedule.getSize() == 0){
            return "Задач нет!";
        }
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb);
        String s = String.format("%-2s | %-16s | %-32s | %-12s | %-6s | %6s | %-12s%n",
                "№",
                "Ответственный",
                "Описание задачи",
                "Дедлайн",
                "Важное",
                "Сделал",
                "Дата создания");
        sb.append(s);
        sb.append("---|------------------|----------------------------------|--------------|--------|--------|--------------\n");

        for (int i = 0; i < schedule.getSize(); i++) {
            sb.append(String.format("%-2s |", Integer.toString(i + 1)) + schedule.getTask(i).toFormatString());
        }
        return sb.toString();
    }
    public static LocalDate strToLD(String str){
        String[] arrStr = str.split("-");
        int[] arrInt = new int[3];
        for (int i = 0; i < arrStr.length; i++) {
            arrInt[i] = Integer.parseInt(arrStr[i]);
        }
        return LocalDate.of(arrInt[0], arrInt[1], arrInt[2]);
    }
    public static boolean strToB(String str){
        return Boolean.parseBoolean(str);
    }

    private Schedule getSchedule(){
        Schedule answer = new Schedule();
        try {
            answer = (Schedule) Model.getScheduleFromFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }
}
