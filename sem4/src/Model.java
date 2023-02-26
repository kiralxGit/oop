import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class Model {

    public static Schedule getScheduleFromFile(File file) throws Exception{
        Schedule schedule = new Schedule<>();
        Scanner sc = new Scanner(file);
        sc.useDelimiter(System.getProperty("line.separator"));
        while(sc.hasNext()){
            schedule.addNewTask(parseToTask(sc.next()));
        }
        sc.close();
        return schedule;
    }

    public static boolean saveScheduleToFile(Schedule schedule, File file){
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            fileWriter.write(scheduleToStr(schedule));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String scheduleToStr(Schedule cal){
        StringBuilder sb = new StringBuilder();
        Iterator<Task> it = cal;
        while(it.hasNext()){
            sb.append(it.next());
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    private static Task parseToTask(String str){
        Task task;
        String[] arrStr = str.split(";");
        task = new Task(arrStr[0],
                    arrStr[1],
                Program.strToLD(arrStr[2]),
                Program.strToB(arrStr[3]),
                Program.strToB(arrStr[4]),
                Program.strToLD(arrStr[5]));
        return task;
    }
}