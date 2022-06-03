package jaxb.model;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//XmlRootElement - будет указывать на наш корневой узел структуры
@XmlRootElement(name = "organisation")
//XmlAccessorType - используется для указания метода доступа к
// атрибутам объектов Java при создании файлов XML из объектов Java
@XmlAccessorType(XmlAccessType.FIELD)
public class Organisation {
    private String orgNo;
    private String orgName;

    //XmlElementWrapper - указывает на оболочку, которая будет оборачивать данное содержимое.
    @XmlElementWrapper(name = "department")
//департаментов может быть множество, поэтому указываем
// тег для определения конкретного из них за это отвечает XmlElement
    @XmlElement(name = "department")
    private List<Department> departments;
    @XmlElement(name = "department 2")
    private List<Department> departments2;

    public Organisation(){}

    public Organisation(String orgNo, String orgName) {
        this.orgNo = orgNo;
        this.orgName = orgName;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public List<Department> getDepartments() {
        return departments;
    }


    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void setDepartments(List<Department> departments, List<Department> departments2) {
        this.departments = departments;
        this.departments2 = departments2;
    }
}
