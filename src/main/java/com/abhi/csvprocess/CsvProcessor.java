package com.abhi.csvprocess;

import java.io.*;
import java.net.URL;
import java.util.*;

public class CsvProcessor {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        Employee emp  = null;
        String fileName = "employee.csv";
        File file = new CsvProcessor().getResourceFile(fileName);
        int recordCount = 0;

        try{
            Reader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            //String line = br.readLine();
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                emp = new Employee(Integer.parseInt(columns[0]), columns[1], columns[2], columns[3], columns[4]);
                employees.add(emp);
                recordCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Employees : " + employees);
        //System.out.println("recordCount : " + recordCount);
        uniqueUserIdList(employees);

        noOfDuplicateUserId(employees);

        noOfDuplicateRecord(employees);

    }

    private File getResourceFile(final String fileName)
    {
        URL url = this.getClass()
                .getClassLoader()
                .getResource(fileName);

        if(url == null) {
            throw new IllegalArgumentException(fileName + " is not found.");
        }

        File file = new File(url.getFile());

        return file;
    }

    //  The number of unique userId for each emailId.
    public static void  uniqueUserIdList(List<Employee> employees){

        Map<String, Set<Integer>> empMap = new HashMap<>();

        Set<Integer> userIDs = null;
        for(Employee e : employees) {
            userIDs = new HashSet<>();

            if (empMap.containsKey(e.getEmail())) {
                userIDs = empMap.get(e.getEmail());
                userIDs.add(e.getUserId());
                empMap.put(e.getEmail(), userIDs);
            }else{
                userIDs.add(e.getUserId());
                empMap.put(e.getEmail(), userIDs);
            }
        }
        System.out.println("");
        System.out.println("The number of unique userId for each emailId :");
        System.out.println(empMap);
    }

    //  The number of duplicated userid for each emailId.
    public static void  noOfDuplicateUserId(List<Employee> employees){
        Map<String, Integer> empMap = new HashMap<>();

        for(Employee e : employees) {
            if (empMap.containsKey(e.getEmail())) {
                empMap.put(e.getEmail(), empMap.get(e.getEmail()) + 1);
            }else{
                empMap.put(e.getEmail(), 1);
            }
        }
        System.out.println("");
        System.out.println("The number of duplicated userid for each emailId :");
        System.out.println(empMap);
    }

    //  The number of duplicated entries
    public static void noOfDuplicateRecord(List<Employee> employees) {

        int duplicateRecordCount = 0;
        Set<Employee> uniqueRecord = new HashSet<>();
        for(Employee e : employees){
            if(!uniqueRecord.add(e)){
                duplicateRecordCount++;
            }
        }
        System.out.println("");
        System.out.println("The number of duplicated entries : ");
        System.out.println(duplicateRecordCount);
    }

}
