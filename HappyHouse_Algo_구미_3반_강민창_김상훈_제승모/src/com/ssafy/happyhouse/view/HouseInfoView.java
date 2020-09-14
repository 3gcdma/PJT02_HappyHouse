package com.ssafy.happyhouse.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HousePageBean;
import com.ssafy.happyhouse.model.service.HouseService;
import com.ssafy.happyhouse.model.service.HouseServiceImpl;
import com.ssafy.happyhouse.test.environment.Environment;
import com.ssafy.happyhouse.test.environment.environmentDao;
import com.ssafy.happyhouse.test.environment.environmentDaoImpl;
import com.ssafy.happyhouse.test.shopAnalysisTest.Shop;
import com.ssafy.happyhouse.test.shopAnalysisTest.analysisDAO;
import com.ssafy.happyhouse.test.shopAnalysisTest.analysisDAOImpl;


public class HouseInfoView{
	
	/**model들 */
	private HouseService 		houseService;
	private int select =0;
	/** main 화면 */
	private JFrame frame;
	
	/** 주택 목록 화면*/
	// JFrame owner;
	

	/**창 닫기 버튼*/
	//private JButton  closeBt;
	private JLabel dongLabel = new JLabel();
	
	/**주택 이미지 표시 Panel*/
	private JLabel	 			imgL;
	private JLabel[] 			houseInfoL;
	
	/**조회 조건*/
	private JCheckBox[]		  	chooseC;
	private JComboBox<String> 	findC; 
	private JTextField		  	wordTf;
	private JButton			  	searchBt;
	
	/**조회 내용 표시할 table*/
	private DefaultTableModel 	houseModel;
	private JTable			  	houseTable;
	private JScrollPane		  	housePan;
	private String[]		  	title = { "번호", "동", "아파트이름", "거래금액", "거래종류" };
	
	/**검색  조건*/
	private String	key;
	
	/**검색할 단어*/
	private String  word;
	private boolean[] searchType = { true, true, true, true };
	private String[] choice = { "all", "dong", "name" };
	
	/**화면에 표시하고 있는 주택*/
	private HouseDeal curHouse;

	
	private void showHouseInfo(int code) {
		
		curHouse = houseService.search(code);
		
		//System.out.println(curHouse);
		
		
		//foodInfoL[0].setText(""+curfood.getCode());
		houseInfoL[0].setText("");
		houseInfoL[1].setText("");
		houseInfoL[2].setText(curHouse.getAptName());
		houseInfoL[3].setText(""+curHouse.getDealAmount());
		String rent = curHouse.getRentMoney();
		if(rent == null) {
			houseInfoL[4].setText("없음");
		}else {
			houseInfoL[4].setText(curHouse.getRentMoney());
		}
		houseInfoL[5].setText(""+curHouse.getBuildYear());
		houseInfoL[6].setText(curHouse.getArea()+"");
		houseInfoL[7].setText(String.format("%d년 %d월 %d일"
											,curHouse.getDealYear()
											,curHouse.getDealMonth()
											,curHouse.getDealDay()
											));
		houseInfoL[8].setText(curHouse.getDong());
		houseInfoL[9].setText(curHouse.getJibun());
		
		//System.out.println("###############" + curHouse.getImg());
		
		ImageIcon icon = null;
		if( curHouse.getImg() != null && curHouse.getImg().trim().length() != 0) {
			icon = new ImageIcon("img/" + curHouse.getImg());
			System.out.println("#####" + icon.toString() + "####");
		}else {
			icon = new ImageIcon("img/다세대주택.jpg");
		}

		imgL.setIcon(icon);
		  
		  

//		Image img = null;
//		try {
//			img = ImageIO.read(new File("img/"+curHouse.getImg()));
//         } catch (IOException ex) {
//        	 try {
//        		 img = ImageIO.read(new File("img/다세대주택.jpg"));
//			} catch (Exception e) {
//			}
//         }
//		img = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		imgL.setIcon(new ImageIcon(img));
	}
	
	public HouseInfoView(){
		/*Service들 생성 */
		houseService = new HouseServiceImpl();
		
		/*메인 화면 설정 */
		frame = new JFrame("HappyHouse -- 아파트 거래 정보");
//		frame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e){
//				frame.dispose();
//			}
//		});
		
		setMain();
		
		frame.setSize(1200, 800);
		frame.setResizable(true);
		frame.setVisible(true);
		showHouseInfo(1);
		//showHouses();
	}

	/**메인 화면인 주택 목록을 위한 화면 셋팅하는 메서드  */
	public void setMain(){
		/*왼쪽 화면을 위한 설정 */
		JPanel left = new JPanel(new BorderLayout());
		JPanel leftCenter = new JPanel(new GridLayout(1, 2));
		JPanel leftR = new JPanel(new GridLayout(10, 2));
		leftR.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 10 , 10));
		
		
		String[] info= {"","","주택명","거래금액","월세금액","건축연도","전용면적","거래일","법정동","지번"};
		int size = info.length;
		JLabel infoL[] = new JLabel[size];
		houseInfoL = new JLabel[size];
		for (int i = 0; i <size; i++) {
			infoL[i] = new JLabel(info[i]);
			houseInfoL[i]=new JLabel("");
			leftR.add(infoL[i]);
			leftR.add(houseInfoL[i]);
			if( i == 8 ) dongLabel = houseInfoL[i];
		}
		imgL = new JLabel();
		leftCenter.add(imgL);
		leftCenter.add(leftR);
		
		left.add(new JLabel("아파트 거래 정보", JLabel.CENTER),"North");
		left.add(leftCenter,"Center");
		
		
		/*오른쪽 화면을 위한 설정 */
		JPanel right = new JPanel(new BorderLayout());
		JPanel rightTop = new JPanel(new GridLayout(4, 2));
		JPanel rightTop1 = new JPanel(new GridLayout(2, 6));
		String[] chooseMeg= { "아파트 매매", "아파트 전월세", "주택 매매", "주택 전월세"};
		chooseC = new JCheckBox[chooseMeg.length];
		for (int i = 0, len= chooseMeg.length; i < len; i++) {
			chooseC[i] = new JCheckBox(chooseMeg[i], true);
			rightTop1.add(chooseC[i]);
		}
		JButton[] analysis = new JButton[2];
		analysis[0] = new JButton("상권분석");
		analysis[1] = new JButton("환경분석");
		ButtonGroup g = new ButtonGroup();
		JRadioButton dong =new JRadioButton("동");
		JRadioButton price = new JRadioButton("가격");
		
		g.add(dong);
		g.add(price);
		
		analysis[0].addActionListener(e->{
			
			String []header = { "상호명","mType","sType","도시","법정동","주소" };
			dialogShop("상권분석",header);
		});
		analysis[1].addActionListener(e->{
			String []header = { "업체", "날짜","점검구분","처분대상","점검사항","주소"};
			dialogEnv("환경분석",header);
		});
		rightTop1.add(dong);
		rightTop1.add(price);
		rightTop1.add(analysis[0]);
		rightTop1.add(analysis[1]);
		
	
		price.addActionListener(e->{
			select =1;
			showHouses();
		});
		
		dong.addActionListener(e->{
			select =2;
			showHouses();
		});
		JPanel rightTop2 = new JPanel(new GridLayout(1, 3));
		String[] item = {"---all---","동","아파트 이름"}; 
		findC = new JComboBox<String>(item);
		wordTf = new JTextField();
		searchBt = new JButton("검색");
		

		
		rightTop2.add(findC);
		rightTop2.add(wordTf);
		rightTop2.add(searchBt);
		
		rightTop.add(new Label(""));
		rightTop.add(rightTop1);
		rightTop.add(rightTop2);		
		rightTop.add(new Label(""));
		
		JPanel rightCenter = new JPanel(new BorderLayout());
		houseModel = new DefaultTableModel(title,20);
		houseTable = new JTable(houseModel);
		housePan = new JScrollPane(houseTable);
		houseTable.setColumnSelectionAllowed(true);
		rightCenter.add(new JLabel("거래 내역", JLabel.CENTER),"North");
		rightCenter.add(housePan,"Center");
		
		right.add(rightTop,"North");
		right.add(rightCenter,"Center");
		
		JPanel mainP = new JPanel(new GridLayout(1, 2));
		
		mainP.add(left);
		mainP.add(right);
		
		mainP.setBorder(BorderFactory.createEmptyBorder(20 , 10 , 10 , 10));
		frame.add(mainP,"Center");
		
		/*이벤트 연결*/

		houseTable.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row =  houseTable.getSelectedRow();
				int code = Integer.parseInt(((String)houseModel.getValueAt(row, 0)).trim());
				showHouseInfo(code);
			}
		});
		
		// complete code #01
		searchBt.addActionListener(e->{searchHouses();});
		
		
		showHouses();
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	
	/**검색 조건에 맞는 주택 정보 검색 */
	private void searchHouses() {
		for(int i = 0, size = chooseC.length; i<size; i++) {
			if(chooseC[i].isSelected()) {
				searchType[i] = true;
			}else {
				searchType[i] = false;
			}
		}
		word = wordTf.getText().trim();
		key = choice[findC.getSelectedIndex()];
		System.out.println("word:"+word+" key:"+key);
		showHouses();		
	}
	/**
	 * 주택 목록을  갱신하기 위한 메서드 
	 */
	

	public void showHouses(){
		HousePageBean  bean = new HousePageBean();
		bean.setSearchType(searchType);
		if(key !=null) {
			if(key.equals("dong")) {
				bean.setDong(word);
			}else if(key.equals("name")) {
				bean.setAptname(word);
			}
		}
		
		List<HouseDeal> deals = houseService.searchAll(bean);
		
		if(select == 1) {
			Collections.sort(deals, new Comparator<HouseDeal>() {
	            @Override
	            public int compare(HouseDeal o1, HouseDeal o2) {
	                // TODO Auto-generated method stub
	                String temp1 = o1.getDealAmount();
	                String temp2 = o2.getDealAmount();
	                temp1 = temp1.replaceAll(",", "");
	                temp2 = temp2.replaceAll(",", "");
	                return Integer.compare(Integer.parseInt(temp1), Integer.parseInt(temp2));
	            }
	        });
		}else if(select==2) {
			Collections.sort(deals, new Comparator<HouseDeal>() {
	            @Override
	            public int compare(HouseDeal o1, HouseDeal o2) {
	                return o1.getDong().compareTo(o2.getDong());
	            }
	        });
		}
		if(deals!=null){
			int i=0;
			String[][]data = new String[deals.size()][5];
			for (HouseDeal deal: deals) {
				data[i][0]= ""+deal.getNo();
				data[i][1]= deal.getDong();
				data[i][2]= deal.getAptName();
				data[i][3]= deal.getDealAmount();
				data[i++][4]= deal.getType();
			}
			houseModel.setDataVector(data, title);
		}
	}
//	public static void main(String[] args) {
//		new HouseInfoView();
//	}
	void dialogShop(String name,String []header) {
		JFrame dialogWindow = new JFrame(name);
		analysisDAO dao=new analysisDAOImpl();
		List<Shop> list = dao.Search(dongLabel.getText());
		DefaultTableModel contents = new DefaultTableModel(null,header);
		for( Shop s  : list) {
			contents.addRow(new Object[] { s.getsName(),s.getmType(),s.getsType(),
					s.getsCity(),s.getsDong(),s.getNewLoc()});
		}
		
		dialogWindow.setSize(new Dimension(700,300));
		
		JTable table = new JTable(contents);
		JScrollPane scrollpane = new JScrollPane(table);
		dialogWindow.add(scrollpane);
		dialogWindow.setVisible(true);
	}
	void dialogEnv(String name,String []header) {
		JFrame dialogWindow = new JFrame(name);
		environmentDao mgr = new environmentDaoImpl();
		try {
			mgr.getList();
		} catch (IOException e) {
			e.printStackTrace();
		}	// 엑셀 파일 불러오기
		
		List<Environment> list = mgr.Search(dongLabel.getText());
		System.out.println(list);
		DefaultTableModel contents = new DefaultTableModel(null,header);
		for( Environment e  : list) {
			contents.addRow(new Object[] { e.getFactory(),e.getDate(),e.getCheck(),
					e.getDisposal(),e.getTask(),e.getLocation()});
		}
		dialogWindow.setSize(new Dimension(700,300));
		
		JTable table = new JTable(contents);
		JScrollPane scrollpane = new JScrollPane(table);
		dialogWindow.add(scrollpane);
		dialogWindow.setVisible(true);

	}
	
}

