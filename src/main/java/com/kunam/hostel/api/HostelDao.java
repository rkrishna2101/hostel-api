package com.kunam.hostel.api;

import com.kunam.hostel.api.Hostel;
import java.util.List;

public interface HostelDao {
	 List<Hostel> findAll();
	 	Hostel findById(int id);
	    void save(Hostel hostel);
	    void update(Hostel hostel);
	    void deleteById(int id);
}


