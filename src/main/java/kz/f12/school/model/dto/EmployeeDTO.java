package kz.f12.school.model.dto;

public class EmployeeDTO {
    private int id;
    private String name;
    private String departmentName;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", age=" + age +
                '}';
    }

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id) {
        this(id, "Mister");
    }

    public EmployeeDTO(int id, String name) {
        this(id, name, "Unknown");
    }

    public EmployeeDTO(int id, String name, String departmentName) {
        this(id, name, departmentName, 0);
    }

    public EmployeeDTO(int id, String name, String departmentName, int age) {
        this.id = id;
        this.name = name;
        this.departmentName = departmentName;
        this.age = age;
    }
}
