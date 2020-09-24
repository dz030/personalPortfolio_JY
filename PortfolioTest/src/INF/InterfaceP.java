package INF;

import java.util.ArrayList;
import java.util.HashMap;

import DTO.engagementDTO;
import DTO.portfolioDTO;

public interface InterfaceP {
	public ArrayList<portfolioDTO> listPost();
	public String listLikes(String portID);
	//public void likesControl();
	public void AddPost(portfolioDTO pDTO);
	public void AddLikes(String portID);
	public void addComment();
	public void removeOne();
	public HashMap<String,String> getHashList();
}
