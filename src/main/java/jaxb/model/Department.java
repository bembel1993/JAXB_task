package jaxb.model;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: User
 * Date: 17.01.2022
 * Time: 19:42
 */
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//XmlRootElement - будет указывать на наш корневой узел структуры
@XmlRootElement(name = "department")
//XmlAccessorType - используется для указания метода доступа к
// атрибутам объектов Java при создании файлов XML из объектов Java
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {

    private String deptNo;
    private String deptName;
    private String location;
//XmlElementWrapper - указывает на оболочку, которая будет оборачивать данное содержимое.
    @XmlElementWrapper(name = "employees")
//сотрудников может быть множество, поэтому указываем
// тег для определения конкретного из них за это отвечает XmlElement
    @XmlElement(name = "employee")
    private List<Employee> employees;

    /**
     * This default constructor is required if there are other constructors.
     */
    public Department() {

    }

    public Department(String deptNo, String deptName, String location) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.location = location;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}

