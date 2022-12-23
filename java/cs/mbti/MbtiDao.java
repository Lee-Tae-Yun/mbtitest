package cs.mbti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DB연동
public class MbtiDao {
    private Connection getConnection() throws Exception {
        // Context 객체얻기
        Context initCtx = new InitialContext();
        // "java:comp/env" 에 해당하는 객체를 찾아서 envCtx에 삽입
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        // "jdbc/taeyun" 에 해당하는 객체를 찾아서 ds에 삽입
        DataSource ds = (DataSource) envCtx.lookup("jdbc/taeyun");
        // 커넥션 풀로 부터 커넥션 객체를 얻어냄
        Connection con = ds.getConnection();
        return con;

    }
    
    //회원 등록
    public void insert(LoginDto dto) {
        String sql = "insert into mbtilogin(id, pwd, name, chacter, udate, pNumber, email, gender,filename) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

        ) {

            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPwd());
            pstmt.setString(3, dto.getName());
            pstmt.setString(4, dto.getChacter());
            pstmt.setString(5, dto.getUdate());
            pstmt.setString(6, dto.getpNumber());
            pstmt.setString(7, dto.getEmail());
            pstmt.setString(8, dto.getGender());
            pstmt.setString(9, dto.getFilename());
            


            int i = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    //회원 삭제
    public void delete(String id) {
        String sql = "DELETE FROM mbtilogin WHERE id=?";

        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

        ) {

            pstmt.setString(1, id);


            int i = pstmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    

   

    //회원 1명의 데이터 값 가져오기
    public LoginDto readDate(String id) {
        LoginDto dto = null;
        String sql = "select * from mbtilogin where id=?";

        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

        ) {

            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();


            if (rs.next()) {

                dto = new LoginDto();
                dto.setPwd(rs.getString("pwd"));
                dto.setName(rs.getString("name"));
                dto.setChacter(rs.getString("chacter"));
                dto.setUdate(rs.getString("udate"));
                dto.setpNumber(rs.getString("pNumber"));
                dto.setEmail(rs.getString("email"));
                dto.setGender(rs.getString("gender"));
                dto.setFilename(rs.getString("filename"));
                

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }
    
    //회원 정보 수정
    public void update(LoginDto dto) {
        String sql = "UPDATE mbtilogin SET pwd =?, name =?, chacter =?, udate =?, pNumber =?, email=?, gender =? WHERE id =?";

        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

        ) {

            pstmt.setString(1, dto.getPwd());
            pstmt.setString(2, dto.getName());
            pstmt.setString(3, dto.getChacter());
            pstmt.setString(4, dto.getUdate());
            pstmt.setString(5, dto.getpNumber());
            pstmt.setString(6, dto.getEmail());
            pstmt.setString(7, dto.getGender());
            pstmt.setString(8, dto.getId());


            int i = pstmt.executeUpdate();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    //성격 유형 업데이트
    public void updateMBTI(String chacter, String id) {
        String sql = "UPDATE mbtilogin SET chacter = ? WHERE id = ?";

        try (
            Connection con = getConnection(); //커넥션 얻기
            PreparedStatement pstmt = con.prepareStatement(sql);

        ) {

            pstmt.setString(1, chacter);
            pstmt.setString(2, id);

            int i = pstmt.executeUpdate();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
  //프로필사진  업데이트
    public void Pro_update(String filename,String id) {
        String sql = "UPDATE mbtilogin SET filename =? WHERE id =?";

        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

        ) {

            pstmt.setString(1, filename);
            pstmt.setString(2, id);


            int i = pstmt.executeUpdate();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
  

    //회원 리스트
    public ArrayList < LoginDto > list() {

        ArrayList < LoginDto > dtos = new ArrayList < LoginDto > ();

        String sql = "select * from mbtilogin order by id";

        try (

            Connection con = getConnection(); //커넥션 얻기
            Statement stmt = con.createStatement(); //

        ) {

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //1. 레코드셋에서 데이터를 가져온다.

                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String chacter = rs.getString("chacter");
                String udate = rs.getString("udate");
                String pNumber = rs.getString("pNumber");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                String filename = rs.getString("filename");


                //2. 그 데이터들을 LoginDto로 만든다.

                LoginDto dto = new LoginDto(id, pwd, name, chacter, udate, pNumber, email, gender,filename);

                //3. 그 LoginDto를 배열(ArrayList)에 추가한다.
                dtos.add(dto);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }


        return dtos;
    }
    
  

    //로그인 확인
    public int checkUser(String id, String pwd) {
        String sql = "select pwd from mbtilogin where id=? and pwd=?";
        int check = 0;

        try (

            Connection con = getConnection(); //커넥션 얻기
            PreparedStatement pstmt = con.prepareStatement(sql); //실행 준비

        )

        {
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);

            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    check = 1;

                } else {
                    check = 0;
                }
                con.close();
                rs.close();
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }

	//1개의 게시물의 데이터 값 가져오기
    public BoardDto readBDate(int bid) {
        BoardDto dto = null;
        String sql = "select * from mbtiborad where bid=?";

        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

        ) {

            pstmt.setInt(1, bid);

            ResultSet rs = pstmt.executeQuery();


            if (rs.next()) {

                dto = new BoardDto();
                dto.setUid(rs.getString("uid"));
                dto.setBoradtype(rs.getString("boradtype"));
                dto.setBtitle(rs.getString("btitle"));
                dto.setBorad(rs.getString("borad"));
                dto.setBname(rs.getString("bname"));
                dto.setBdate(rs.getString("bdate"));
                dto.setBoradview(rs.getInt("boradview"));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

	
	//글쓰기
    public void insertB(BoardDto dto) {
        String sql = "insert into mbtiborad(bid,uid,boradtype, btitle, borad, bname, bdate,boradview) values(?,?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

        ) {

            pstmt.setString(1, null);
            pstmt.setString(2, dto.getUid());
            pstmt.setString(3, dto.getBoradtype());
            pstmt.setString(4, dto.getBtitle());
            pstmt.setString(5, dto.getBorad());
            pstmt.setString(6, dto.getBname());
            pstmt.setString(7, dto.getBdate());
            pstmt.setString(8, "0");


            int i = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //게시글 수정
    public void bupdate(String btitle, String borad, String bdate, String bid) {
        String sql = "UPDATE mbtiborad SET btitle ='" + btitle + "', borad ='" + borad + "', bdate ='" + bdate + "' WHERE bid =" + bid + "";

        try (Connection con = getConnection(); Statement stmt = con.createStatement();

        ) {

            int i = stmt.executeUpdate(sql);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    //게시글 삭제
    public void bdelete(String bid) {
        String sql = "DELETE FROM mbtiborad WHERE bid=?";

        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

        ) {

            pstmt.setString(1, bid);


            int i = pstmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

  //게시글 리스트
    public ArrayList < BoardDto > Blist() {

        ArrayList < BoardDto > dtos = new ArrayList < BoardDto > ();

        String sql = "select * from mbtiborad order by bid desc";

        try (

            Connection con = getConnection(); //커넥션 얻기
            Statement stmt = con.createStatement(); //

        ) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //1. 레코드셋에서 데이터를 가져온다.

                String bid = rs.getString("bid");
                String uid = rs.getString("uid");
                String boradtype = rs.getString("boradtype");
                String btitle = rs.getString("btitle");
                String borad = rs.getString("borad");
                String bname = rs.getString("bname");
                String bdate = rs.getString("bdate");
                int boradview = rs.getInt("boradview");


                //2. 그 데이터들을 BoradDto로 만든다.

                BoardDto dto = new BoardDto(bid, uid, boradtype, btitle, borad, bname, bdate, boradview);

                //3. 그 BoradDto를 배열(ArrayList)에 추가한다.
                dtos.add(dto);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtos;
    }
    
    //페이징 게시글 리스트
    public ArrayList < BoardDto > getBoardList(int startRow, int pageSize) {

        ArrayList < BoardDto > dtos = new ArrayList < BoardDto > ();

        String sql = "select * from mbtiborad order by bid desc limit ?,?";

        try (
            Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

        ) {
            pstmt.setInt(1, startRow - 1);
            pstmt.setInt(2, pageSize);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //1. 레코드셋에서 데이터를 가져온다.
            	
                String bid = rs.getString("bid");
                String uid = rs.getString("uid");
                String boradtype = rs.getString("boradtype");
                String btitle = rs.getString("btitle");
                String borad = rs.getString("borad");
                String bname = rs.getString("bname");
                String bdate = rs.getString("bdate");
                int boradview = rs.getInt("boradview");


                //2. 그 데이터들을 BoradDto로 만든다.

                BoardDto dto = new BoardDto(bid, uid, boradtype, btitle, borad, bname, bdate, boradview);

                //3. 그 BoradDto를 배열(ArrayList)에 추가한다.
                dtos.add(dto);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtos;

    }
    
  //게시물 전체수
    public int getBoardCount() {

        int count = 0;


        String sql = "select count(*) from mbtiborad";

        try (

            Connection con = getConnection(); //커넥션 얻기
            Statement stmt = con.createStatement(); //

        ) {

            ResultSet rs = stmt.executeQuery(sql);

            //1. 레코드셋에서 데이터를 가져온다.

            if (rs.next()) {
                count = rs.getInt(1); // 데이터가 없으면 null이고 return 0값이 된다.
                //count = rs.getInt("count(*)"); 위와 동일한 결과

            }



        } catch (Exception e) {
            e.printStackTrace();
        }


        return count;
    }
    
    //조회수
    public int countUpdate(int bid) {
        String sql = "update mbtiborad set boradview = boradview+1 where bid = ?";

        try {
            Connection con = getConnection(); //커넥션 얻기
            PreparedStatement pstmt = con.prepareStatement(sql); //실행 준비

            pstmt.setInt(1, bid);

            pstmt.executeUpdate(); //insert,delete,update

            con.close();
            pstmt.close();
            return 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; //에러
    }


	  //댓글 리스트
  public ArrayList < CommentDto > Clist(int bid) {

      ArrayList < CommentDto > dtos = new ArrayList < CommentDto > ();

      String sql = "select * from mbticomment where cbid = " + bid + "";

      try (

          Connection con = getConnection(); //커넥션 얻기
          Statement stmt = con.createStatement(); //

      ) {
          ResultSet rs = stmt.executeQuery(sql);
          while (rs.next()) {
              //1. 레코드셋에서 데이터를 가져온다.

              String cnum = rs.getString("cnum");
              String uid = rs.getString("uid");
              String cbid = rs.getString("cbid");
              String cname = rs.getString("cname");
              String cmt = rs.getString("cmt");
              String chacter = rs.getString("chacter");
              String cdate = rs.getString("cdate");

              //2. 그 데이터들을 CommentDto로 만든다.

              CommentDto dto = new CommentDto(cnum, uid, cbid, cname, cmt, chacter, cdate);

              //3. 그 BoradDto를 배열(ArrayList)에 추가한다.
              dtos.add(dto);
          }



      } catch (Exception e) {
          e.printStackTrace();
      }
      return dtos;
  }
  
  //댓글 추가
  public void insertC(CommentDto dto) {
      String sql = "insert into mbtiComment(cnum,uid,cbid,cname,cmt,chacter,cdate) values(?,?,?, ?, ?, ?, ?)";

      try (	Connection con = getConnection();
      		PreparedStatement pstmt = con.prepareStatement(sql);
      ) {

          pstmt.setString(1, null);
          pstmt.setString(2, dto.getUid());
          pstmt.setString(3, dto.getCbid());
          pstmt.setString(4, dto.getCname());
          pstmt.setString(5, dto.getCmt());
          pstmt.setString(6, dto.getChacter());
          pstmt.setString(7, dto.getCdate());

          int i = pstmt.executeUpdate();

      } catch (Exception e) {
          e.printStackTrace();
      }

  }

  //댓글수
  public int getCmtCount(int cbid) {

      int count = 0;


      String sql = "select count(*) from mbticomment where cbid = ?";

      try (

          Connection con = getConnection(); //커넥션 얻기
          PreparedStatement pstmt = con.prepareStatement(sql); //

      ) {
          pstmt.setInt(1, cbid);
          ResultSet rs = pstmt.executeQuery();

          //1. 레코드셋에서 데이터를 가져온다.

          if (rs.next()) {
              count = rs.getInt(1); // 데이터가 없으면 null이고 return 0값이 된다.
              //count = rs.getInt("count(*)"); 위와 동일한 결과

          }



      } catch (Exception e) {
          e.printStackTrace();
      }


      return count;
  }
  
  //댓글 삭제
  public void cdelete(int cnum) {
      String sql = "DELETE FROM mbticomment WHERE cnum=?";

      try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

      ) {

          pstmt.setInt(1, cnum);


          int i = pstmt.executeUpdate();


      } catch (Exception e) {
          e.printStackTrace();
      }

  }
   //메시지 등록
  public void sinsert(SnsDto dto) {
      String sql = "insert into mbtisns(sid,fid,tid,stitle,content,readCheck,sdate) values(? ,? ,? ,? ,? ,? ,?)";

      try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

      ) {

          pstmt.setString(1, null);
          pstmt.setString(2, dto.getFid());
          pstmt.setString(3, dto.getTid());
          pstmt.setString(4, dto.getStitle());
          pstmt.setString(5, dto.getContent());
          pstmt.setInt(6, 0);
          pstmt.setString(7, dto.getSdate());



          int i = pstmt.executeUpdate();

      } catch (Exception e) {
          e.printStackTrace();
      }

  }
//1개의 메시지의 데이터 값 가져오기
  public SnsDto readSDate(int sid) {
	  SnsDto dto = null;
      String sql = "select * from mbtisns where sid=?";

      try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

      ) {

          pstmt.setInt(1, sid);

          ResultSet rs = pstmt.executeQuery();


          if (rs.next()) {

              dto = new SnsDto();
              dto.setSid(rs.getString("sid"));
              dto.setFid(rs.getString("fid"));
              dto.setTid(rs.getString("tid"));
              dto.setStitle(rs.getString("stitle"));
              dto.setContent(rs.getString("content"));
              dto.setReadcheck(rs.getInt("readCheck"));
              dto.setSdate(rs.getString("sdate"));

          }


      } catch (Exception e) {
          e.printStackTrace();
      }
      return dto;
  }
  
//메시지 확인 업데이트
  public void updateReadCheck(int sid) {
      String sql = "UPDATE mbtisns SET readCheck=1 WHERE sid = ?";

      try (
          Connection con = getConnection(); //커넥션 얻기
          PreparedStatement pstmt = con.prepareStatement(sql);

      ) {

          pstmt.setInt(1, sid);

          int i = pstmt.executeUpdate();



      } catch (Exception e) {
          e.printStackTrace();
      }

  }
  //받은 메시지 전체수
  public int getSnsGetCount(String tid) {

      int count = 0;


      String sql = "select count(*) from mbtisns where tid = ?";

      try (

          Connection con = getConnection(); //커넥션 얻기
    		  PreparedStatement pstmt = con.prepareStatement(sql);

      ) {
    	  
    	  pstmt.setString(1, tid);

          ResultSet rs = pstmt.executeQuery();

          //1. 레코드셋에서 데이터를 가져온다.

          if (rs.next()) {
              count = rs.getInt(1); // 데이터가 없으면 null이고 return 0값이 된다.
              //count = rs.getInt("count(*)"); 위와 동일한 결과

          }



      } catch (Exception e) {
          e.printStackTrace();
      }


      return count;
  }
//보낸 메시지 전체수
  public int getSnsGiveCount(String fid) {

      int count = 0;


      String sql = "select count(*) from mbtisns where fid = ?";

      try (

          Connection con = getConnection(); //커넥션 얻기
    		  PreparedStatement pstmt = con.prepareStatement(sql);

      ) {
    	  
    	  pstmt.setString(1, fid);

          ResultSet rs = pstmt.executeQuery();

          //1. 레코드셋에서 데이터를 가져온다.

          if (rs.next()) {
              count = rs.getInt(1); // 데이터가 없으면 null이고 return 0값이 된다.
              //count = rs.getInt("count(*)"); 위와 동일한 결과

          }



      } catch (Exception e) {
          e.printStackTrace();
      }


      return count;
  }
//페이징 보낸 메시지 리스트
  public ArrayList < SnsDto > giveSnsList(String fid, int startRow, int pageSize) {

      ArrayList < SnsDto > dtos = new ArrayList < SnsDto > ();

      String sql = "select * from mbtisns where fid = ? order by sid desc limit ?,?";

      try (
          Connection con = getConnection();
    		 PreparedStatement pstmt = con.prepareStatement(sql);

      ) {
    	  pstmt.setString(1, fid);
          pstmt.setInt(2, startRow - 1);
          pstmt.setInt(3, pageSize);

          ResultSet rs = pstmt.executeQuery();
          while (rs.next()) {

        	  String sid = rs.getString("sid");
              String tid = rs.getString("tid");
              String stitle = rs.getString("stitle");
              String content = rs.getString("content");
              int readcheck = rs.getInt("readcheck");
              String sdate = rs.getString("sdate");



              SnsDto dto = new SnsDto(sid, fid, tid, stitle, content, readcheck, sdate);

              dtos.add(dto);
          }


      } catch (Exception e) {
          e.printStackTrace();
      }
      return dtos;

  }
//페이징 받은 메시지 리스트
  public ArrayList < SnsDto > getSnsList(String tid, int startRow, int pageSize) {

      ArrayList < SnsDto > dtos = new ArrayList < SnsDto > ();

      String sql = "select * from mbtisns where tid = ? order by sid desc limit ?,?";

      try (
          Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

      ) {
    	  pstmt.setString(1, tid);
          pstmt.setInt(2, startRow - 1);
          pstmt.setInt(3, pageSize);

          ResultSet rs = pstmt.executeQuery();
          while (rs.next()) {
          	
              String sid = rs.getString("sid");
              String fid = rs.getString("fid");
              String stitle = rs.getString("stitle");
              String content = rs.getString("content");
              int readcheck = rs.getInt("readcheck");
              String sdate = rs.getString("sdate");



              SnsDto dto = new SnsDto(sid, fid, tid, stitle, content, readcheck, sdate);

              dtos.add(dto);
          }


      } catch (Exception e) {
          e.printStackTrace();
      }
      return dtos;

  }
  
//메시지 삭제
  public void sdelete(String sid) {
      String sql = "DELETE FROM mbtisns WHERE sid=?";

      try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);

      ) {

          pstmt.setString(1, sid);


          int i = pstmt.executeUpdate();


      } catch (Exception e) {
          e.printStackTrace();
      }

  }
}