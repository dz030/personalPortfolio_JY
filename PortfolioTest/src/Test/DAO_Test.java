package Test;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.pfDAO;
import DTO.portfolioDTO;
import INF.INF_imp;

public class DAO_Test {
	pfDAO pfdao = null;
	INF_imp imp = null;
	
	@Before
	public void loading() {
		pfdao = new pfDAO();
	}
	
	@Test  
	public void AddPostTest() {
		portfolioDTO pDTO = new portfolioDTO();
		pDTO.setPortID("3");
		pDTO.setPhoto("This is photo3");
		pDTO.setTitle("Minney test");
		pDTO.setContent("why minney is so pretty?");
		pfdao.AddPost(pDTO); 
		
	}
	@Test
	public void editPost() {
		pfdao.editPost("hehehe", "hehe", "hehe", "3");
	}
	@Test
	public void ListPost() {
		ArrayList<portfolioDTO> list = pfdao.ListPost();
		for(int i=0; i < list.size();i++) {
	         System.out.println("-------------------");
	         System.out.println(list.get(i).getPortID());
	         System.out.println(list.get(i).getPhoto());
	         System.out.println(list.get(i).getTitle());
	         System.out.println(list.get(i).getContent());
	      }
	}
	@Test
	public void likesControlUpp() {
		pfdao.likesControlUpp("1");
	}
	@Test
	public void likesControlDown() {
		pfdao.likesControlDown("1");
	}
	@Test
	public void addLikes() {
		pfdao.addLikes("3");
	}
	@Test
	public void addComment() {
		pfdao.addComment("3","wholesome!!");
	}
	@Test
	public void removeOne() {
		pfdao.removeOne("3");
	}
	
}
