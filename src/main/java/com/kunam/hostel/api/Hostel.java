package com.kunam.hostel.api;

public class Hostel {
    private Long id;
    private String name;
    private String city;
    
    // Add other fields as necessary

    // Default constructor
    public Hostel() {}

    // Parameterized constructor
    public Hostel(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    // Getter and setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// Override toString() method for debugging
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", city=" +city + "]";
    }
}
