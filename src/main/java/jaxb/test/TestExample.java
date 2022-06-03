package jaxb.test;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: User
 * Date: 17.01.2022
 * Time: 19:43
 */

import jaxb.model.Department;
import jaxb.model.Employee;
import jaxb.model.Organisation;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestExample {

    private static final String XML_FILE = "dept-info.xml";

    public static void main(String[] args) {

        Employee emp1 = new Employee("E01", "Tom", null);
        Employee emp2 = new Employee("E02", "Mary", "E01");
        Employee emp3 = new Employee("E03", "John", null);

        List<Employee> list = new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        /////////EMP 2
        Employee emp1dep2 = new Employee("E010", "Elisabet", null);
        Employee emp2dep2 = new Employee("E020", "Joanna", null);

        List<Employee> listemp2 = new ArrayList<Employee>();
        listemp2.add(emp1dep2);
        listemp2.add(emp2dep2);
        //////////////////////ADD DEPARTMENT TASK//////////////////////
        Department dept = new Department("D01", "ACCOUNTING", "NEW YORK");
        Department dept2 = new Department("D02", "RULES", "LOS ANGELES");
        Department dept3 = new Department("D03", "ADMINISTRATION", "MIAMI");
        List<Department> list1 = new ArrayList<Department>();
        list1.add(dept);
        list1.add(dept2);
        ////////////////////ADD DEPARTMENT WITH EMPLOYEES TO ORGANISATION////////////////////
        Organisation organisation = new Organisation("101", "SAMSUNG");
        List<Organisation> organisationList = new ArrayList<Organisation>();
        organisationList.add(organisation);

        dept.setEmployees(list);
        dept2.setEmployees(listemp2);
        organisation.setDepartments(list1);
        organisation.setDepartments(list1);
        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Department.class);

            //Marshaller для записи в документ
            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(dept, System.out);

            // Write to File
            File outFile = new File(XML_FILE);
            m.marshal(dept, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());

            //Unmarshaller для извлечения данных
// (2) Unmarshaller : Read XML content to Java Object.
            Unmarshaller um = context.createUnmarshaller();
            // XML file create before.

            Department deptFromFile1 = (Department) um.unmarshal(new FileReader(XML_FILE));
            List<Employee> emps = deptFromFile1.getEmployees();
            for (Employee emp : emps) {
                System.out.println("Employee: " + emp.getEmpName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        ///////////////ORGANISATION////////////////////////
        System.out.println("\nADD ORGANISATION\n");
        try {
            JAXBContext context2 = JAXBContext.newInstance(Organisation.class);
            //MARSHALLER ДЛЯ ЗАПИСИ В ФАЙЛ
            Marshaller m2 = context2.createMarshaller();
            m2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m2.marshal(organisation, System.out);
            File outFile2 = new File(XML_FILE);
            m2.marshal(organisation, outFile2);
            System.err.println("Write to file: " + outFile2.getAbsolutePath());
            //UNMARSHALLER ДЛЯ ЧТЕНИЯ ИЗ ФАЙЛА
            Unmarshaller um2 = context2.createUnmarshaller();
            Organisation orgFromFile2 = (Organisation) um2.unmarshal(new FileReader(XML_FILE));
            List<Department> departments = orgFromFile2.getDepartments();
            System.out.println("Organisation: " + organisation.getOrgName());
            for (Department dep : departments) {
                System.out.println("Department: " + dep.getDeptName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nSHOW FULL VERSION\n");
        ///////////////ORGANISATION 2////////////////////////
        try {
            JAXBContext context3 = JAXBContext.newInstance(Organisation.class);
            //MARSHALLER ДЛЯ ЗАПИСИ В ФАЙЛ
            Marshaller m3 = context3.createMarshaller();
            m3.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m3.marshal(organisation, System.out);
            File outFile3 = new File(XML_FILE);
            m3.marshal(organisation, outFile3);
            System.err.println("Write to file: " + outFile3.getAbsolutePath());
            //UNMARSHALLER ДЛЯ ЧТЕНИЯ ИЗ ФАЙЛА
            Unmarshaller um3 = context3.createUnmarshaller();
            Organisation orgFromFile3 = (Organisation) um3.unmarshal(new FileReader(XML_FILE));
            List<Department> departments = orgFromFile3.getDepartments();
            System.out.println("Organisation: " + organisation.getOrgName());
            for (Department dep2 : departments) {
                System.out.println("Department: " + dep2.getDeptName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

