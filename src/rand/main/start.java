package rand.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;

import common.JDBCTemplate;

public class start {

	public static void main(String[] args) {
		Random rand = new Random();
		int i = 0;
		generateRandomAddr();
		while(i!=50) {
		String sql = "insert into customer values(CUSTOMER_SEQ.NEXTVAL,?,?,?,?,GET_KORNM('1','3'), ?, ?,?  , 'detail addr' , ?,sysdate)";
		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idGen());
			pstmt.setString(2, pwGen());
			pstmt.setDate(3, new java.sql.Date(new Date().getTime()));
			pstmt.setString(4, rand.nextBoolean() ? "남성":"여성");
			pstmt.setString(5, generateRandomEmail(rand.nextInt(20)+9));
			pstmt.setString(6, generateRandomAddr());
			pstmt.setString(7, phoneGen());
			pstmt.setString(8, RandomStringUtils.random(5,"0123456789"));
			
			int result = pstmt.executeUpdate();
			System.out.println(result);
			JDBCTemplate.commit(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		i++;
		}
	}
	public static String generateRandomAddr() {
		ArrayList<String> addrList = new ArrayList<String>(); //주소
	      addrList.add("서울특별시");
	      addrList.add("경기도");
	      addrList.add("강원도");
	      addrList.add("충청북도");
	      addrList.add("충청남도");
	      addrList.add("경상북도");
	      addrList.add("경상남도");
	      addrList.add("전라북도");
	      addrList.add("전라남도");
	      addrList.add("광주광역시");
	      addrList.add("제주특별자치도");
	      ArrayList<ArrayList<String>> mainAddr = new ArrayList<ArrayList<String>>();
	      ArrayList<String> addrDetailList11 =  new ArrayList<String>(); //광주광역시
	      addrDetailList11.add("광산구");
	      addrDetailList11.add("북구");
	      addrDetailList11.add("서구");
	      addrDetailList11.add("동구");
	      addrDetailList11.add("남구");
	      
	      ArrayList<String> addrDetailList1 =  new ArrayList<String>(); // 경기도
	      addrDetailList1.add("수원시 장안구");
	      addrDetailList1.add("수원시 장안구");
	      addrDetailList1.add("수원시 장안구");
	      addrDetailList1.add("성남시 중원구");
	      addrDetailList1.add("성남시 수정구");
	      addrDetailList1.add("성남시 분당구");
	      addrDetailList1.add("용인시 처인구");
	      addrDetailList1.add("용인시 기흥구");
	      addrDetailList1.add("용인시 수지구");
	      addrDetailList1.add("안양시 동안구");
	      addrDetailList1.add("안양시 만안구");
	      addrDetailList1.add("안산시 단원구");
	      addrDetailList1.add("안산시 상록구");

	      ArrayList<String> addrDetailList2 =  new ArrayList<String>(); // 서울특별시

	      addrDetailList2.add("강서구");
	      addrDetailList2.add("양천구");
	      addrDetailList2.add("구로구");
	      addrDetailList2.add("금천구");
	      addrDetailList2.add("영등포구");
	      addrDetailList2.add("동작구");
	      addrDetailList2.add("관악구");
	      addrDetailList2.add("서초구");
	      addrDetailList2.add("강남구");
	      addrDetailList2.add("송파구");
	      addrDetailList2.add("강동구");
	      addrDetailList2.add("광진구");
	      addrDetailList2.add("성동구");
	      addrDetailList2.add("용산구");
	      addrDetailList2.add("중구");
	      addrDetailList2.add("종로구");
	      addrDetailList2.add("서내문구");
	      addrDetailList2.add("마포구");
	      addrDetailList2.add("은평구");
	      addrDetailList2.add("성북구");
	      addrDetailList2.add("동대문구");
	      addrDetailList2.add("중랑구");
	      addrDetailList2.add("노원구");
	      addrDetailList2.add("도봉구");
	      addrDetailList2.add("강북구");
	      
	      ArrayList<String> addrDetailList3 =  new ArrayList<String>();; // 강원도
	      addrDetailList3.add("철원군");
	      addrDetailList3.add("화천군");
	      addrDetailList3.add("양구군");
	      addrDetailList3.add("고성군");
	      addrDetailList3.add("춘천시");
	      addrDetailList3.add("인제군");
	      addrDetailList3.add("속초시");
	      addrDetailList3.add("양양군");
	      addrDetailList3.add("총천군");
	      addrDetailList3.add("강릉시");
	      addrDetailList3.add("횡성군");
	      addrDetailList3.add("평창군");
	      addrDetailList3.add("동해시");
	      addrDetailList3.add("정선군");
	      addrDetailList3.add("원주시");
	      addrDetailList3.add("영월군");
	      addrDetailList3.add("태백시");
	      addrDetailList3.add("삼척시");
	      
	      
	      ArrayList<String> addrDetailList4 =  new ArrayList<String>();; // 충청북도
	      addrDetailList4.add("진천군");
	      addrDetailList4.add("음성군");
	      addrDetailList4.add("충주시");
	      addrDetailList4.add("제천시");
	      addrDetailList4.add("단양군");
	      addrDetailList4.add("괴산군");
	      addrDetailList4.add("청주시");
	      addrDetailList4.add("보은군");
	      addrDetailList4.add("옥천군");
	      addrDetailList4.add("영동군");
	      
	      ArrayList<String> addrDetailList5 =  new ArrayList<String>();; // 충청남도
	      addrDetailList5.add("당진시");
	      addrDetailList5.add("서산시");
	      addrDetailList5.add("태안군");
	      addrDetailList5.add("아산시");
	      addrDetailList5.add("천안시");
	      addrDetailList5.add("예산군");
	      addrDetailList5.add("홍성군");
	      addrDetailList5.add("청양군");
	      addrDetailList5.add("공주시");
	      addrDetailList5.add("보령시");
	      addrDetailList5.add("부여군");
	      addrDetailList5.add("서천군");
	      addrDetailList5.add("논산시");
	      addrDetailList5.add("금산군");
	      
	      ArrayList<String> addrDetailList6 =  new ArrayList<String>();; // 경상북도
	      addrDetailList6.add("포항시");
	      addrDetailList6.add("김천시");
	      addrDetailList6.add("구미시");
	      addrDetailList6.add("영천시");
	      addrDetailList6.add("문경시");
	      addrDetailList6.add("군위군");
	      addrDetailList6.add("청송군");
	      addrDetailList6.add("영덕군");
	      addrDetailList6.add("고령군");
	      addrDetailList6.add("칠곡군");
	      addrDetailList6.add("봉화군");
	      addrDetailList6.add("울릉군");
	      addrDetailList6.add("경주시");
	      addrDetailList6.add("안동시");
	      addrDetailList6.add("영주시");
	      addrDetailList6.add("상주시");
	      addrDetailList6.add("경산시");
	      addrDetailList6.add("의성군");
	      addrDetailList6.add("영양군");
	      addrDetailList6.add("청도군");
	      addrDetailList6.add("성주군");
	      addrDetailList6.add("예천군");
	      addrDetailList6.add("울진군");
	      
	      ArrayList<String> addrDetailList7 =  new ArrayList<String>();; // 경상남도
	      addrDetailList7.add("거창군");
	      addrDetailList7.add("함양군");
	      addrDetailList7.add("합천군");
	      addrDetailList7.add("창녕군");
	      addrDetailList7.add("밀양시");
	      addrDetailList7.add("양산시");
	      addrDetailList7.add("김해시");
	      addrDetailList7.add("창원시");
	      addrDetailList7.add("의령군");
	      addrDetailList7.add("함안군");
	      addrDetailList7.add("진주시");
	      addrDetailList7.add("산청군");
	      addrDetailList7.add("하동군");
	      addrDetailList7.add("사천시");
	      addrDetailList7.add("고성군");
	      addrDetailList7.add("통영시");
	      addrDetailList7.add("거제시");
	      addrDetailList7.add("남해군");
	      
	      ArrayList<String> addrDetailList8 =  new ArrayList<String>();; // 전라북도
	      addrDetailList8.add("군산시");
	      addrDetailList8.add("익산시");
	      addrDetailList8.add("완주군");
	      addrDetailList8.add("진안군");
	      addrDetailList8.add("무주군");
	      addrDetailList8.add("장수군");
	      addrDetailList8.add("임실군");
	      addrDetailList8.add("정읍시");
	      addrDetailList8.add("김제시");
	      addrDetailList8.add("부안군");
	      addrDetailList8.add("고창군");
	      addrDetailList8.add("순창군");
	      addrDetailList8.add("임실군");
	      addrDetailList8.add("남원시");
	      
	      ArrayList<String> addrDetailList9 =  new ArrayList<String>();; // 전라남도
	      addrDetailList9.add("영광군");
	      addrDetailList9.add("장성군");
	      addrDetailList9.add("담양군");
	      addrDetailList9.add("곡성군");
	      addrDetailList9.add("구례군");
	      addrDetailList9.add("광양시");
	      addrDetailList9.add("순천시");
	      addrDetailList9.add("여수시");
	      addrDetailList9.add("보성군");
	      addrDetailList9.add("고흥군");
	      addrDetailList9.add("화순군");
	      addrDetailList9.add("나주시");
	      addrDetailList9.add("함평군");
	      addrDetailList9.add("영광군");
	      addrDetailList9.add("무안군");
	      addrDetailList9.add("시안군");
	      addrDetailList9.add("진도군");
	      addrDetailList9.add("완도군");
	      
	      ArrayList<String> addrDetailList10 =  new ArrayList<String>(); // 제주도
	      addrDetailList10.add("서귀포시");
	      addrDetailList10.add("제주시");
	      
	      
	      mainAddr.add(addrDetailList2);
	      mainAddr.add(addrDetailList1);
	      mainAddr.add(addrDetailList3);
	      mainAddr.add(addrDetailList4);
	      mainAddr.add(addrDetailList5);
	      mainAddr.add(addrDetailList6);
	      mainAddr.add(addrDetailList7);
	      mainAddr.add(addrDetailList8);
	      mainAddr.add(addrDetailList9);
	      mainAddr.add(addrDetailList10);
	      mainAddr.add(addrDetailList11);
	      
	      ArrayList<String> arrList = new ArrayList<String>();
	      arrList.add("서울특별시");
	      arrList.add("경기도");
	      arrList.add("강원도");
	      arrList.add("충청북도");
	      arrList.add("충정남도");
	      arrList.add("경상북도");
	      arrList.add("경상남도");
	      arrList.add("전라북도");
	      arrList.add("전라남도");
	      arrList.add("제주특별자치도");
	      arrList.add("광주광역시");
	      Random rand = new Random();
	      int randNo = rand.nextInt(11);
	      String mainStr = arrList.get(randNo);
	      ArrayList<String> detailList= mainAddr.get(randNo);
	      int secondNo = rand.nextInt(detailList.size());
	      String detailStr = detailList.get(secondNo);
	      return mainStr + " " + detailStr;
	}
	public static String generateRandomEmail(int length) {
		Random rand = new Random();
	    String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
	    String email = "";
	    String temp = RandomStringUtils.random(length, allowedChars);
	    email = temp.substring(0, temp.length() - 9)+"@";
	    email += RandomStringUtils.random(rand.nextInt(3)+4, "zxcvbnmasdfghjklqwertyuiop");
	    email += ".com";
	    return email;
	}
	public static String companynoGen() {
		Random rand = new Random();
		int randNo = rand.nextInt(10);
		String mainForm = "";
		mainForm += RandomStringUtils.random(3,"0123456789");
		mainForm += "-";
		mainForm += RandomStringUtils.random(2,"0123456789");
		mainForm += "-";
		mainForm += RandomStringUtils.random(5,"0123456789");
		return mainForm;
		
	}
	public static String phoneGen() {
		String mainForm = "010-";
		mainForm += RandomStringUtils.random(4,"0123456789");
		mainForm += "-";
		mainForm += RandomStringUtils.random(4,"0123456789");
		return mainForm;
	}
	public static String idGen() {
		Random rand = new Random();
		int randNo = rand.nextInt(14)+6;
		return RandomStringUtils.random(randNo,"0123456789abcdefghijk");
	}
	public static String pwGen() {
		Random rand = new Random();
		int randNo = rand.nextInt(14)+6;
		return RandomStringUtils.random(randNo,"0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKZXCVBNM!@#$%^&*");
	}
}
