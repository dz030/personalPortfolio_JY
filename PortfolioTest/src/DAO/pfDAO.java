package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import DTO.engagementDTO;
import DTO.portfolioDTO;

public class pfDAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id ="system";
	private String pwd = "oracle";
	
	private ResultSet rs = null;
	
	public Connection conn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pwd);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//-------------------------------------------------------------------connected
	
	public void AddPost(portfolioDTO pDTO) {
			String sql = "insert into portfolio values (?,?,?,?)";
			PreparedStatement ppst = null;
			if(conn()!=null) {
				try {
					ppst = conn.prepareStatement(sql);
					ppst.setString(1, pDTO.getPortID());
					ppst.setString(2, pDTO.getPhoto());
					ppst.setString(3, pDTO.getTitle());
					ppst.setString(4, pDTO.getContent());
					ppst.executeQuery();
					
				} catch (Exception e) {
				} finally {
					try {
						if(ppst != null) {
							ppst.close(); 
						}
						if(conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
			}
			
	}
	
	public void editPost(String photo, String title, String content, String portID) {
		String sql = "update portfolio set photo = ?, title = ?, content = ? where portID = ?";
		PreparedStatement ppst = null;  
		if(conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, photo);
				ppst.setString(2, title);
				ppst.setString(3, content);
				ppst.setString(4, portID);
				ppst.executeUpdate();
			} catch (Exception e) {
			}finally {
				try {
					if(ppst != null) ppst.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<portfolioDTO> ListPost() {
		String sql = "select * from portfolio";  
		Statement st = null;    
		ArrayList<portfolioDTO> tempList = new ArrayList<>();
		                                
		if(conn()!=null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()) {
					portfolioDTO tempDTO = new portfolioDTO();
					tempDTO.setPortID(rs.getString("portID"));
					tempDTO.setPhoto(rs.getString("photo"));
					tempDTO.setTitle(rs.getString("title"));
					tempDTO.setContent(rs.getString("content"));
					
					tempList.add(tempDTO);
					
				}
			} catch (Exception e) {

			} finally {
				try {
					if(st != null) st.close();
					if(conn != null) conn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return tempList;
	}
//------------------------------------------------------------------	
	public ArrayList<engagementDTO> ListLikes() {
		String sql = "select * from engagement";  
		Statement st = null;    
		ArrayList<engagementDTO> tempList = new ArrayList<>();
		                                
		if(conn()!=null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()) {
					engagementDTO tempDTO = new engagementDTO();
					tempDTO.setPortID(rs.getString("portID"));
					tempDTO.setLikes(String.valueOf(rs.getInt("likes")));
					
					tempList.add(tempDTO);
					
				}
			} catch (Exception e) {

			} finally {
				try {
					if(st != null) st.close();
					if(conn != null) conn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return tempList;
	}
	
	public engagementDTO selectOneLikes(String portID) {
		String sql = "select * from engagement where portID = ?";  
		PreparedStatement ppst = null;
		engagementDTO tempDTO = new engagementDTO();
		if(conn()!=null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, portID);
				rs= ppst.executeQuery();
				if(rs.next()) {
					tempDTO.setPortID(rs.getString("portID"));
					tempDTO.setLikes(String.valueOf(rs.getInt("likes")));
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if(ppst != null) {
						ppst.close(); 
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		return tempDTO;
	}
	
	public void likesControlUpp(String portID) {
		String sql = "update engagement set likes = likes+1 where portID = ?";
		PreparedStatement ppst = null;  
		if(conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, portID);
				ppst.executeUpdate();
			} catch (Exception e) {
			}finally {
				try {
					if(ppst != null) ppst.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void likesControlDown(String portID) {
		String sql = "update engagement set likes = likes-1 where portID = ?";
		PreparedStatement ppst = null;  
		if(conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, portID);
				ppst.executeUpdate();
			} catch (Exception e) {
			}finally {
				try {
					if(ppst != null) ppst.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void addLikes(String portID) {
		String sql = "insert into engagement values(?,0)";
		PreparedStatement ppst = null;
		if(conn()!=null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, portID);
				ppst.executeQuery();
				
			} catch (Exception e) {
			} finally {
				try {
					if(ppst != null) {
						ppst.close(); 
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			}
		}
		
	public void addComment(String portID, String comment) {
		String sql = "insert into comments values(?,?)";
		PreparedStatement ppst = null;
		if(conn()!=null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, portID);
				ppst.setString(2, comment);
				ppst.executeQuery();
				
			} catch (Exception e) {
			} finally {
				try {
					if(ppst != null) {
						ppst.close(); 
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

	public void removeOne(String portID) {
		String sql = "delete from portfolio where portID = ?";
		PreparedStatement ppst = null;
		if(conn()!=null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, portID);
				ppst.executeQuery();
				
			} catch (Exception e) {
			} finally {
				try {
					if(ppst != null) {
						ppst.close(); 
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
	}


}
