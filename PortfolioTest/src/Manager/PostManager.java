package Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import DAO.pfDAO;
import DTO.commentDTO;
import DTO.engagementDTO;
import DTO.portfolioDTO;

public class PostManager {
	private Scanner in = new Scanner(System.in);
	private portfolioDTO pDTO = new portfolioDTO();
	private pfDAO dao = new pfDAO();
	//private INF_imp imp = new INF_imp();
	private commentDTO cDTO = new commentDTO();
	private ArrayList<portfolioDTO> pList = new ArrayList<>();
	private ArrayList<engagementDTO> eList=new ArrayList<>();
	private ArrayList<commentDTO> cList = new ArrayList<>();
	private int dupCheck = 0;
	
	private static PostManager m = null;
	public static PostManager getInstance() {
		if(m==null) {
			m = new PostManager();
		}
		return m;
	}
	
	public PostManager() {
		//tempScreen();
	}
	
	public void tempScreen() {
		while(true) {
			System.out.println("1.ADDnEdit Post");
			System.out.println("2.ListPost");
			System.out.println("3.Likes");
			System.out.println("4.AddComment");
			System.out.println("5.removeAll");
			
			int key = in.nextInt();
			in.nextLine();
		//	switch(key) {
		//	case 1 : INFimp.AddnEditPost(); break;
		//	case 2 : INFimp.listPost(); break;
		//	case 3 : INFimp.likesControl(); break;
		//	case 4 : INFimp.addComment(); break;
		//	case 5 : INFimp.removeOne(); break;
		//	default :
		//	}
		}
		
	}
	
	public portfolioDTO AddnEditPost(String portID, String photo, String title, String content) {
		pDTO.setPortID(portID);
		pDTO.setPhoto(photo);
		pDTO.setTitle(title);
		pDTO.setContent(content);
		
		pList.add(pDTO);
		
		System.out.println("==List up SUCCESS==");
		
		return pDTO;
	}
	
	public void listPost() {
		System.out.println("+++Post List++++");
		for(int i=0; i<pList.size(); i++) {
			System.out.println("portID: "+ pList.get(i).getPortID());
			System.out.println("Title: "+ pList.get(i).getTitle());
			System.out.println("Photo: "+ pList.get(i).getPhoto());
			System.out.println("Content: "+ pList.get(i).getContent());
		}
	}
	
	
	public int likesControl(int dupCheck) {  //NEED MULTI THREAD
			
			if(dupCheck == 0) {
				System.out.println("+1 Like");
				dupCheck = dupCheck + 1;
				dao.likesControlUpp("1");
			}else if(dupCheck > 0) {
				System.out.println("-1 Like");
				dupCheck = dupCheck -1 ;
				dao.likesControlDown("1");
			}
			return dupCheck;
	}
	
	public void addComment(String portID, String comment) { //NEED MULTI THREAD
		for(int i=0; i<pList.size(); i++) {
			if(portID == pList.get(i).getPortID()) {
				cDTO.setPortID(portID);
				cDTO.setComments(comment);
				
				cList.add(cDTO);
				
				System.out.println("SUBMIT SUCCESS");
			}
		}
		
		
		
	}
	
	public void removeOne(String portID) {
		for(int i=0; i<pList.size(); i++) {
		if(portID == pList.get(i).getPortID()) {
			pList.remove(i);
		}
		}
	}


}
