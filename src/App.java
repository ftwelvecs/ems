import model.dto.EmployeeDTO;
import utils.Mapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final int CREATE = 1;
    private static final int GET_BY_NAME = 2;
    private static final int GET_ALL = 3;
    private static final int DELETE_BY_NAME = 4;
    private static final int SAVE = 5;
    private static final int EXIT = 6;

    private static final List<Integer> ALL_COMMANDS = Arrays.asList(CREATE, GET_BY_NAME, GET_ALL, DELETE_BY_NAME, SAVE, EXIT);

    private static int ID = 0;
    private static List<EmployeeDTO> employeeDTOList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("D:\\Study\\EMS\\employee_list.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<EmployeeDTO> oldEmployees = new ArrayList<>();

        // читаем файл по строчно
        for (String line = ""; line != null; line = bufferedReader.readLine()) {
            // разбиваем строку на массив
            String[] stringArray = line.split(","); // бьем по запятой
            try {
                // преобразуем массив в объект EmployeeDTO
                EmployeeDTO employeeDTO = Mapper.toEmployeeDTO(stringArray);
                // берем людей пенсионного возраста
                if (employeeDTO.getAge() > 62) {
                    oldEmployees.add(employeeDTO);
                }
            } catch (Exception e) { }
        }

        StringBuilder stringBuilder = new StringBuilder();
        // готовим общий текст добавляя данные по сотрудникам в формате CSV (comma-separated values)
        for (EmployeeDTO employeeDTO : oldEmployees) {
            stringBuilder.append(employeeDTO.getId())
                    .append(",")
                    .append(employeeDTO.getName())
                    .append(",")
                    .append(employeeDTO.getDepartmentName())
                    .append(",")
                    .append(employeeDTO.getAge())
                    .append("\n");
        }

        // записываем в файл
        FileWriter fileWriter = new FileWriter("C:\\Users\\tomi\\Desktop\\employees.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static void run() {
        greetings();
        Scanner scanner = new Scanner(System.in);

        MAIN_LOOP: while (true) {
            printCommands();
            int command = Integer.parseInt(scanner.nextLine());
            if (isCorrectCommand(command)) {
                switch (command) {
                    case CREATE: create(scanner);
                        if (canExit(scanner)) break MAIN_LOOP;
                        break;
                    case GET_BY_NAME: getByName(scanner);
                        if (canExit(scanner)) break MAIN_LOOP;
                        break;
                    case GET_ALL: getAll();
                        if (canExit(scanner)) break MAIN_LOOP;
                        break;
                    case DELETE_BY_NAME: deleteByName(scanner);
                        if (canExit(scanner)) break MAIN_LOOP;
                        break;
                    case SAVE: save();
                        break;
                    case EXIT:
                        break MAIN_LOOP;
                }
            } else {
                System.out.println("Неправильная команда: " + command);
            }
        }

        scanner.close();
    }

    private static void create(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите департамент: ");
        String department = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());

        EmployeeDTO employeeDTO = new EmployeeDTO(++ID, name, department, age);
        employeeDTOList.add(employeeDTO);
        System.out.println("Сотрудник " + employeeDTO.getName() + " создан");
    }

    private static void getAll() {
        if (employeeDTOList.isEmpty()) {
            System.out.println("Пусто");
        } else {
            for (EmployeeDTO employeeDTO : employeeDTOList) {
                System.out.println(employeeDTO.getId() + ". " + employeeDTO.getName() + " [" + employeeDTO.getDepartmentName() + "]");
            }
        }
    }

    private static void getByName(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        for (EmployeeDTO employeeDTO : employeeDTOList) {
            if (employeeDTO.getName().equalsIgnoreCase(name)) {
                System.out.println(employeeDTO.getId() + ". " + employeeDTO.getName() + " [" + employeeDTO.getDepartmentName() + "]");
                return;
            }
        }
        System.out.println("Сотрудник с именем: " + name + " не найден");
    }

    private static void deleteByName(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        EmployeeDTO employeeDTO = null;
        for (EmployeeDTO element : employeeDTOList) {
            if (element.getName().equalsIgnoreCase(name)) {
                employeeDTO = element;
                break;
            }
        }

        if (employeeDTO != null) {
            employeeDTOList.remove(employeeDTO);
            System.out.println("Сотрудник " + employeeDTO.getName() + " успешно удален");
        } else {
            System.out.println("Сотрудник с именем: " + name + " не найден");
        }
    }

    private static void save() {
        /* завершим когда дойдем до Exceptions */
    }

    private static boolean canExit(Scanner scanner) {
        System.out.println("Хотите ли вы продолжить? Y/N");
        String answer = scanner.nextLine();
        return !"Y".equalsIgnoreCase(answer);
    }

    private static boolean isCorrectCommand(int command) {
        return ALL_COMMANDS.contains(command);
    }

    private static void printCommands() {
        System.out.println("Выберите команду:");
        System.out.println("\t1 - для создания нового сотрудника");
        System.out.println("\t2 - чтобы найти сотрудника по имени");
        System.out.println("\t3 - чтобы вывести весь список сотрудников");
        System.out.println("\t4 - для удаления сотрудника по имени");
        System.out.println("\t5 - сохранить");
        System.out.println("\t6 - завершить программу");
        System.out.print("Ввод: ");
    }

    private static void greetings() {
        System.out.println("Добро пожаловать в EMS - Employee Management System");
    }

}
