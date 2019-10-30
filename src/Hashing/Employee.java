package Hashing;

public class Employee {
    private int id;
    private long salary;
    private String name;
    public static int M = 10007; //Table length

    public Employee(int id, long salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public boolean equals(Object obj) {
        Employee emp = (Employee) obj;
        return this.id == emp.id && this.salary == emp.salary && this.name == emp.name;
    }

    public int hashCode() {
        int hash = 17;
        int R = 31;
        hash = R*hash + ((Integer) id).hashCode();
        hash = R*hash + ((Long) salary).hashCode();
        hash = R*hash + name.hashCode();
        return hash;

    }

//  Simplistic modular hashing
//  The bug is that it can return negative index
    public int hash1(Employee key) {
        return key.hashCode() % M;
    }

//  Better modular hashing function
//  One in billion bug exists though
    public int hash2(Employee key) {
        return Math.abs(key.hashCode()) % M;
    }

//  Correct modular hashing function
//  It masks/ignores the sign bit
    public int hash3(Employee key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
}
