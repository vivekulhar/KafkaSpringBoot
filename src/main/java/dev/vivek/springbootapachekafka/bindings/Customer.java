package dev.vivek.springbootapachekafka.bindings;



public class Customer {
    private String name;
    private String email;
    private Integer id;

    public Customer() {
    }
    public Customer(String name, String email, Integer id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public Integer getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Consumer [name=" + name + ", email=" + email + ", id=" + id + "]";
    }

}
