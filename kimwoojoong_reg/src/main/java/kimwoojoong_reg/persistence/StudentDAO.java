package kimwoojoong_reg.persistence;

import java.util.HashMap;
import java.util.Map;

import kimwoojoong_reg.domain.StudentVO;


public class StudentDAO {
	
	private static Map<String, StudentVO> storage = new HashMap<>();
	
	public boolean join (StudentVO student) {
		try {
			storage.put(student.getId(), student);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
}
