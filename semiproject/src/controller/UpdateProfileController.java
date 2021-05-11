package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class UpdateProfileController implements Controller {

   @Override
   public String execute(HttpServletRequest request,
         HttpServletResponse response) throws Exception {
      
	   HttpSession session=request.getSession(false);
      if(session==null||session.getAttribute("mvo")==null||
            request.getMethod().equals("POST")==false){
         return "redirect:index.jsp";
      }   
      String profileimage = request.getParameter("profileimage");
      String profilecontent = request.getParameter("profilecontent");
    
      MemberVO mvo = (MemberVO)session.getAttribute("mvo");
	  String userEmail=mvo.getUserEmail();
      
      mvo.setUserEmail(userEmail);
      mvo.setProfileImage(profileimage);
      mvo.setProfileContent(profilecontent);
      MemberDAO.getInstance().updateProfile(mvo);         
      String path="redirect:ProfileDetailController.do";
      return path;
   }
}