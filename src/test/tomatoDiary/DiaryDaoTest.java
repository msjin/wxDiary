package tomatoDiary;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.bean.Diary;
import com.dao.DiaryDao;

public class DiaryDaoTest {

	ApplicationContext ctx = null;
	DiaryDao dao = null;
	@Before
	public void init(){
		ctx = new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");
	}
	
	public void getDiaryDao(){
		dao = (DiaryDao) ctx.getBean("diaryDao");
	}
	
	
	public void saveDiary(){
		Diary diary = new Diary();
		
		dao.save(diary);
	}
	@Test
	public void getDiary(){
		getDiaryDao();
		List<Diary> list = dao.findAll();
		for(Diary d:list){
			System.out.println(d.getId().length());
		}
	}
}
