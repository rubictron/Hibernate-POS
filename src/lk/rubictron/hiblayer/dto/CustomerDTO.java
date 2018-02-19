/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.dto;

/**
 *
 * @author rubictron
 */
public class CustomerDTO {
    
    private int id;
    private String name;
    private String contact;
    private double salary;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String name, String contact, double salary) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.salary = salary;
    }
    public CustomerDTO( String name, String contact, double salary) {
        this.name = name;
        this.contact = contact;
        this.salary = salary;
    }

     

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double sallary) {
        this.salary = sallary;
    }
    
}
