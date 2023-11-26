package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import monthly_mess_system.Customer;

public interface IO_operaions {
	
	public static void storeDetails(String fname,Map<String,Customer> cmap) {
		try(ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(fname))){
			oot.writeObject(cmap);
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static Map<String,Customer> retriveDetails(String fname){
		Map<String,Customer> cmap = new HashMap<>();
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname))){
			cmap = (Map<String, Customer>) in.readObject();
			return cmap;
		}
		catch(Exception e) {
			e.printStackTrace();
			new HashMap<>();
		}
		return cmap;
	}

}
