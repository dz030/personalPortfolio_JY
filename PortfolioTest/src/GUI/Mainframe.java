package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.accessibility.AccessibleContext;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

import DTO.portfolioDTO;
import INF.INF_imp;
import Manager.PostManager;

public class Mainframe extends Frame implements ActionListener{
	PostManager m = PostManager.getInstance();
	INF_imp imp = new INF_imp();
	int dupCheck = 0;
	int[]dupChck = new int[10];
	String p3PortID = null;
	
	Label title = new Label("MINNEY PORTFOLIO");
	
	Button topR1 = new Button("+");
	Button topR2 = new Button("Email");
	
	Panel northPanel= new Panel();
	Panel centerPanel = new Panel();
//----------------------------------------------- ^ TOP FIX
	Panel southPanel = new Panel();
	Button bottomBtn = new Button("<");
//----------------------------------------------- ^ BOTTOM FIX
	Button p1center1 = new Button("Graphic Design");
	Button p1center2 = new Button("Product Design");
	Button p1center3 = new Button("Video Graphy");
//----------------------------------------------- ^ MAIN PAGE	
	Panel p2MainPanel = new Panel();
	
	Button Mlikes = new Button("♥");
	Button MtitleBtn = new Button("TitleBtn");
	Label McountLikes = new Label("0");
//----------------------------------------------- ^ PAGE 2
	Panel p3MainPanel = new Panel();
	Panel p3NorthPanel = new Panel();
	Panel p3Panel_sub = new Panel();
	Label p3N_title = new Label("MINNEY PORTFOLIO");
	
	Button p3_topR1 = new Button("+");
	Button p3_topR2 = new Button("Edit");
	Button p3_topR3 = new Button("Delete");
	
	Panel p3CenterPanel = new Panel();
	Label p3_title = new Label("TITLE");
	Button p3_likes = new Button("♥");
	Label p3_photo = new Label("PHOTO");
	Label p3_content = new Label("CONTENTTTTTTTTTTTTTT");
	Label p3_countLikes = new Label("0");
//----------------------------------------------- ^ PAGE 3	
	Panel p4AMainPanel = new Panel();
	Panel p4APanel_sub1 = new Panel();
	Panel p4APanel_sub2 = new Panel();
	Panel p4APanel_sub3 = new Panel();
	Label p4A_title = new Label("Title");
	Label p4A_photo = new Label("Image");
	Label p4A_content = new Label("Content");
	JTextField p4A_titleTF = new JTextField(10);
	Button p4A_photoBtn = new Button("Attach file");
	TextArea p4A_contentTA = new TextArea(10,20);
	Button p4A_editBtn = new Button("Post");
	
//----------------------------------------------- ^ PAGE 4_ADD
	Panel p4EMainPanel = new Panel();
	Panel p4EPanel_sub1 = new Panel();
	Panel p4EPanel_sub2 = new Panel();
	Panel p4EPanel_sub3 = new Panel();
	Label p4E_title = new Label("Title");
	Label p4E_photo = new Label("Image");
	Label p4E_content = new Label("Content");
	JTextField p4E_titleTF = new JTextField(10);
	Button p4E_photoBtn = new Button("Attach file");
	TextArea p4E_contentTA = new TextArea(10,20);
	Button p4E_editBtn = new Button("Complete");
	
//----------------------------------------------- ^ PAGE 4_EDIT
	Panel emailPanel = new Panel();
	Panel emailPanel_sub1 = new Panel();
	Panel emailPanel_sub2 = new Panel();
	Label urEmail = new Label("Type your @Email");
	JTextField urEmailText = new JTextField(10);
	TextArea emailContent = new TextArea();
	Button sendEmail = new Button("Send");
	
	
	Mainframe(){
		northPanel.setBackground(Color.darkGray);
		title.setForeground(Color.white);
		northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.X_AXIS));
		northPanel.remove(p3_topR1);
		northPanel.remove(p3_topR2);
		northPanel.remove(p3_topR3);
		northPanel.add(title);
		northPanel.add(topR1);
		northPanel.add(topR2);
		topR1.addActionListener(this);
		topR2.addActionListener(this);
		
//----------------------------------------------- ^ TOP FIX		
		southPanel.setLayout(new BorderLayout());
		bottomBtn.setPreferredSize(new Dimension(40,30));
		southPanel.add(bottomBtn,"West");
		
		bottomBtn.addActionListener(this);
//----------------------------------------------- ^ BOTTOM FIX
		centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.X_AXIS));
		centerPanel.add(p1center1);
		centerPanel.add(p1center2);
		centerPanel.add(p1center3);
		
		p1center1.addActionListener(this);
//----------------------------------------------- ^ MAIN PAGE			
		p2MainPanel.setLayout(new FlowLayout());
		p2MainPanel.setBackground(Color.WHITE);
		
		//refresh();
		
//----------------------------------------------- ^ PAGE 2
		p3MainPanel.setLayout(new BorderLayout());
		p3MainPanel.add(p3NorthPanel,"South");
		p3MainPanel.add(p3CenterPanel,"Center");
		
		p3NorthPanel.setBackground(Color.darkGray);
		p3NorthPanel.setLayout(new BoxLayout(p3NorthPanel,BoxLayout.X_AXIS));
		p3N_title.setForeground(Color.darkGray);
		p3NorthPanel.add(p3N_title);
		p3NorthPanel.add(p3_topR2);
		p3NorthPanel.add(p3_topR3);
		p3_topR1.addActionListener(this);
		p3_topR2.addActionListener(this);
		p3_topR3.addActionListener(this);
		
		
		p3CenterPanel.setLayout(new BorderLayout());
		p3CenterPanel.setBackground(Color.LIGHT_GRAY);
		p3Panel_sub.setLayout(new BoxLayout(p3Panel_sub,BoxLayout.Y_AXIS));
		p3Panel_sub.add(p3_likes);
		p3Panel_sub.add(p3_countLikes);
		p3_likes.addActionListener(this);
		
		p3CenterPanel.add(p3_title,"North");
		p3CenterPanel.add(p3_photo,"Center");
		p3CenterPanel.add(p3Panel_sub,"East");
		p3CenterPanel.add(p3_content,"South");
		
//----------------------------------------------- ^ PAGE 3
		p4AMainPanel.setLayout(new BoxLayout(p4AMainPanel,BoxLayout.Y_AXIS));
		p4AMainPanel.add(p4APanel_sub1);
		p4AMainPanel.add(p4APanel_sub2);
		p4AMainPanel.add(p4APanel_sub3);
		p4AMainPanel.add(p4A_editBtn);
		p4A_editBtn.addActionListener(this);
		
		p4APanel_sub1.setLayout(new BorderLayout());
		p4APanel_sub1.add(p4A_title,"West");
		p4APanel_sub1.add(p4A_titleTF,"Center");
		
		p4APanel_sub2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p4APanel_sub2.add(p4A_photo);
		p4APanel_sub2.add(p4A_photoBtn);
		
		p4APanel_sub3.setLayout(new BorderLayout());
		p4APanel_sub3.add(p4A_content,"West");
		p4APanel_sub3.add(p4A_contentTA,"Center");
		
//----------------------------------------------- ^ PAGE 4_ADD
		p4EMainPanel.setLayout(new BoxLayout(p4EMainPanel,BoxLayout.Y_AXIS));
		p4EMainPanel.add(p4EPanel_sub1);
		p4EMainPanel.add(p4EPanel_sub2);
		p4EMainPanel.add(p4EPanel_sub3);
		p4EMainPanel.add(p4E_editBtn);
		
		p4EPanel_sub1.setLayout(new BorderLayout());
		p4EPanel_sub1.add(p4E_title,"West");
		p4EPanel_sub1.add(p4E_titleTF,"Center");
		
		p4EPanel_sub2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p4EPanel_sub2.add(p4E_photo);
		p4EPanel_sub2.add(p4E_photoBtn);
		
		p4EPanel_sub3.setLayout(new BorderLayout());
		p4EPanel_sub3.add(p4E_content,"West");
		p4EPanel_sub3.add(p4E_contentTA,"Center");
		
//----------------------------------------------- ^ PAGE 4_EDIT		
		emailPanel.setLayout(new BoxLayout(emailPanel,BoxLayout.Y_AXIS));
		emailPanel.setBackground(Color.LIGHT_GRAY);
		emailPanel.add(emailPanel_sub1);
		emailPanel.add(emailPanel_sub2);
		
		emailPanel_sub1.setLayout(new FlowLayout(FlowLayout.LEFT));
		emailPanel_sub1.add(urEmail);
		emailPanel_sub1.add(urEmailText);
		
		emailPanel_sub2.setLayout(new BorderLayout());
		emailPanel_sub2.add(emailContent,"Center");
		emailPanel_sub2.add(sendEmail,"South");
		
		
		
		
		//입력판넬 기본셋팅 
				this.setLayout(new BorderLayout());
				this.add(northPanel,"North");
				this.add(centerPanel,"Center");
				//this.add(centerPanel,"East");
				this.add(southPanel,"South");  
				
				
				this.setBounds(1500,500,500,350);
				this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						System.exit(0); 
					}
				});
				this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(p1center1)) {
			p2_Screen();
		}else if(e.getSource().equals(topR1)) {
			p4_AddScreen();
		}else if(e.getSource().equals(p3_likes)) {
			likeBtn_action(p3PortID);
		}else if(e.getSource().equals(p4A_editBtn)) {
			postAddBtn_action();
			System.out.println("Post Success");
		}else if(e.getSource().equals(topR2)) {
			emailScreen();
		}else if(e.getSource().equals(p3_topR2)) {
			p4_EditScreen();
		}else if(e.getSource().equals(p3_topR3)) {
			p2_Screen();
		}else if(e.getSource().equals(bottomBtn)) {
			mainScreen();
		}
		
	}
	
	public void clearMain() {
		//this.add(northPanel);
		this.remove(centerPanel);
		this.remove(p2MainPanel);
		this.remove(p3MainPanel);
		this.remove(p4AMainPanel);
		this.remove(p4EMainPanel);
		this.remove(emailPanel);
	}
	
	public int mainScreen() {
		clearMain();
		this.add(centerPanel);
		this.setVisible(true);
		return 0;
	}
	
	public void emailScreen() {
		clearMain();
		this.add(emailPanel);
		this.setVisible(true);
	}
	
	public void p2_Screen() {
		clearMain();
		refresh();
		this.add(p2MainPanel);
		this.setVisible(true);
	}
	
	public void p3_Screen(String portID, String title, String content, String countLikes) {
		clearMain();
		this.add(p3MainPanel);
		this.setVisible(true);
		p3_title.setText(title);
	//	p3_photo.setText(pDTO.getPhoto());
		p3_content.setText(content);
		p3_countLikes.setText(countLikes);
		p3PortID = portID;
		
	}
	
	public void p4_AddScreen() {
		clearMain();
		this.add(p4AMainPanel);
		this.setVisible(true);
	}
	
	public void postAddBtn_action() {
		int IportID = (imp.listPost().size())+2;
		portfolioDTO pDTO = new portfolioDTO();
		String portID = String.valueOf(IportID);
		pDTO.setPortID(portID);
		String title=p4A_titleTF.getText();
		pDTO.setTitle(title);
		String photo="This is photo"+portID;
		pDTO.setPhoto(photo);
		String content = p4A_contentTA.getText();
		pDTO.setContent(content);
		
		String countLikes = "0";
		imp.AddPost(pDTO);
		imp.AddLikes(portID);
		
		p3_Screen(portID, title, content, countLikes);
	}

	public void refresh() {
		for(int i =0; i<imp.listPost().size(); i++) {
			if(dupChck[i]== 0) {
				String title = imp.listPost().get(i).getTitle();
				String content = imp.listPost().get(i).getContent();
				String countLikes = imp.getHashList().get(String.valueOf(i+1));
				String portID = String.valueOf(i+1);
				
				Panel p2Panel_each = new Panel();
				Label photo = new Label(imp.listPost().get(i).getPhoto());
				Button likes = new Button("♥ "+countLikes);
				Button titleBtn = new Button(title);
				
				p2Panel_each.setLayout(new BoxLayout(p2Panel_each,BoxLayout.PAGE_AXIS));
				p2Panel_each.setBackground(Color.WHITE);
				p2Panel_each.setPreferredSize(new Dimension(200,300));
				photo.setPreferredSize(new Dimension(180,220));
				photo.setBackground(Color.DARK_GRAY);
				likes.setPreferredSize(new Dimension(30,30));
				p2Panel_each.add(photo);
				p2Panel_each.add(titleBtn);
				p2Panel_each.add(likes);
				
				p2MainPanel.add(p2Panel_each);
				
				dupChck[i] = i+1;
				
				likes.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(likes)) {
							likeBtn_action(portID);
							
						}
					}
					
				});
				
				titleBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(titleBtn)) {
							p3_Screen(portID, title, content, countLikes);
						}
					}
					
				});
			}
		}
	}
	
	public void p4_EditScreen() {
		clearMain();
		this.add(p4EMainPanel);
		this.setVisible(true);
	}
	
	public void likeBtn_action(String portID) {
		dupCheck = m.likesControl(dupCheck);
		String totalLikes = imp.listLikes(portID);
		if(dupCheck == 1) {
			p3_countLikes.setText(String.valueOf(totalLikes));
			p3_likes.setForeground(Color.red);
		}else if(dupCheck == 0) {
			p3_countLikes.setText(String.valueOf(totalLikes));
			p3_likes.setForeground(Color.black);
		}
	}
	
	
	
	
	
	
	
	
}
