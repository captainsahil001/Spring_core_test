package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConnections.class);
        
//        DataBaseConnections conn = context.getBean(DataBaseConnections.class);
//        
//        System.out.println(conn);
        
        EmployeeDataBaseOperations op = context.getBean(EmployeeDataBaseOperations.class);
//        op.insertEmployeeDetails();
//        op.getEmployeeUsingId(1);
//        op.UpdateSalaryUsingDeptNo(30000, 11);
        op.DeleteDetailsOfEmployeeUsingId(2);
    }
}
