package exojdbc;

import java.util.Calendar;

import com.afcepf.paques.dao.OeufDAO;
import com.afcepf.paques.entities.Oeuf;

public class App2 {

	public static void main(String[] args) {

		OeufDAO dao = new OeufDAO(); 
		for(Oeuf o : dao.getAll()){
			System.out.println(o);
		}
		
		System.out.println("ok");
		
		Oeuf o2 = dao.getById(1);
		System.out.println(o2);
		
		//insertion :
		Oeuf nvOeuf = new Oeuf("Oeuf au plat","vla vla",3.54,Calendar.getInstance().getTime()); 
		dao.insert(nvOeuf);
		
		System.out.println(nvOeuf.getId());
		
		nvOeuf.setLibelle("Oeuf mardi");
		dao.update(nvOeuf);
		//Oeuf nv = new Oeuf(1, "Oeuf tout simple","test test",5.54,Calendar.getInstance().getTime()); 
		//dao.update(nv);
		
//		Oeuf nv = new Oeuf(14); 
//		dao.delete(nv);

	}

}
