package INF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import DAO.pfDAO;
import DTO.engagementDTO;
import DTO.portfolioDTO;
import Manager.PostManager;

public class INF_imp implements InterfaceP{
	private Scanner in = new Scanner(System.in);
	PostManager pManager = PostManager.getInstance();
	private pfDAO dao = new pfDAO();


	@Override
	public ArrayList<portfolioDTO> listPost() {
		ArrayList<portfolioDTO> pList = dao.ListPost();
		return pList;
	}
	@Override
	public String listLikes(String portID) {
		engagementDTO eDTO = dao.selectOneLikes(portID);
		String totalLikes = eDTO.getLikes();
		return totalLikes;
	}
	@Override
	public void AddPost(portfolioDTO pDTO) {
		dao.AddPost(pDTO);
	}
	@Override
	public void AddLikes(String portID) {
		dao.addLikes(portID);
	}
/*
	@Override
	public void likesControl() {
		System.out.println("-----U like this post?------");
		while(true) {
			//int key = in.nextInt();
			//in.nextLine();
			
			//pManager.likesControl();
		}
	}
*/
	@Override
	public void addComment() {
		System.out.println("----Select PortID----");
		String portID = in.nextLine();
		
		System.out.println("----Type ur Comment----");
		String comment = in.nextLine();
		
		pManager.addComment(portID,comment);
	}

	@Override
	public void removeOne() {
		System.out.println("Choose the post to delete");
		String portID = in.nextLine();
		
		pManager.removeOne(portID);
	}

	@Override
	public HashMap<String, String> getHashList() {
		ArrayList<engagementDTO>eList = dao.ListLikes();
		HashMap<String,String> hList = new HashMap<String, String>();
		for(int i=0; i < eList.size(); i++) {
			hList.put(eList.get(i).getPortID(), eList.get(i).getLikes());
		}
		return hList;
	}

	

}
