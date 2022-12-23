package cs.mbti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface A_mbtiService {
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;

}
