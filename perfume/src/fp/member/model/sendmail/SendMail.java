package fp.member.model.sendmail;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMail {

	public String mail(String memberId) {
		Random r = new Random();//랜덤 객체 생성
		StringBuilder sb = new StringBuilder();//StringBuilder 객체 생성
		for(int i=0;i<8;i++) {//임의번호 8개 랜덤으로 생성
			sb.append(r.nextInt(7)+1);
		}
		System.out.println("회원 인증 코드 " +sb.toString());//회원 인증 코드 출력
//		Properties에 SMTP서버정보를 설정(구글계정 설정)
		Properties prop = System.getProperties();//시스템의 속성을 가져와서 prop라는 변수로 저장
		prop.put("mail.smtp.host", "smtp.gmail.com");//smtp 서버 호스트 "www.gmail.com"을 prop에 저장
		prop.put("mail.smtp.port", 465);//gmail SMTP 서비스 포트 설정
		prop.put("mail.smtp.auth", "true");//권한부여를 하게 해서 prop에 저장
		prop.put("mail.smtp.ssl.enable", "true");//자동으로 보안 채널을 생성하여 메일 전송을 가능케하여 prop에 저장
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");//이 문구를 제거하면 인증서 관련 오류가 발생
		
		//SMTP서버 정보와 사용자 정보를 기반으로 Session클래스의 인스턴스 생성
		Session session = Session.getDefaultInstance(prop, new Authenticator() {// Properties에 저장디어있는 설정 값을 getDefaultInstance() 메소드로 설정값을 저장하여 세션 생성
			protected PasswordAuthentication getPasswordAuthentication() {//패스워드 인증이 필요한 경우에 불려감
				return new PasswordAuthentication("tchook1224@gmail.com", "khbae1224!");//사용자로부터 수집한 PasswordAuthentication, 없는 경우에는 null을 반환
			}
		});
		
		MimeMessage msg = new MimeMessage(session);//매일 내용을 담을 객체
		try {
			msg.setSentDate(new Date());//메세지 보낸 시간
			msg.setFrom(new InternetAddress("tchook1224@gmail.com","twenty second"));//발신자 셋팅
			InternetAddress to = new InternetAddress(memberId);//수신자
			msg.setRecipient(Message.RecipientType.TO, to);// 받는 쪽 설정
			msg.setSubject("TWENTY SECOND 회원가입 인증 번호 안내","UTF-8");//메일 제목 설정
			msg.setContent("<span>TWENTY SECOND 회원가입 인증 번호 안내 메일입니다.</span><br>"+"<span>고객님의 인증 번호는 "+sb.toString()+"입니다.</span><br><span>감사합니다. 🙏</span>","text/html;charset=UTF-8");//인증메일 내용 설정(태크 내용을 전달할 수 있음)
			Transport.send(msg);//메세지 전송
		}catch (AddressException ae) {
			System.out.println("AddressException:"+ae.getMessage());//주소 에러 메세지 출력
		}catch (MessagingException me) {
			System.out.println("MessagingException:"+me.getMessage());//메세지 에러 메세지 출력
		}catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException:"+e.getMessage());//지원되지 않는 인코딩 에러 메세지 출력
		}
		return sb.toString();//sb.toString()값으로 return해준다.
	}

	public String mail2(String memberId) {
		Random r = new Random();//랜덤 객체 생성
		StringBuilder sb = new StringBuilder();//StringBuilder 객체 생성
		for(int i=0;i<8;i++) {//임의번호 8개 랜덤으로 생성
			sb.append(r.nextInt(7)+1);
		}
		System.out.println("회원 인증 코드 " +sb.toString());//회원 인증 코드 출력
//		Properties에 SMTP서버정보를 설정(구글계정 설정)
		Properties prop = System.getProperties();//시스템의 속성을 가져와서 prop라는 변수로 저장
		prop.put("mail.smtp.host", "smtp.gmail.com");//smtp 서버 호스트 "www.gmail.com"을 prop에 저장
		prop.put("mail.smtp.port", 465);//gmail SMTP 서비스 포트 설정
		prop.put("mail.smtp.auth", "true");//권한부여를 하게 해서 prop에 저장
		prop.put("mail.smtp.ssl.enable", "true");//자동으로 보안 채널을 생성하여 메일 전송을 가능케하여 prop에 저장
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");//이 문구를 제거하면 인증서 관련 오류가 발생
		
		//SMTP서버 정보와 사용자 정보를 기반으로 Session클래스의 인스턴스 생성
		Session session = Session.getDefaultInstance(prop, new Authenticator() {// Properties에 저장디어있는 설정 값을 getDefaultInstance() 메소드로 설정값을 저장하여 세션 생성
			protected PasswordAuthentication getPasswordAuthentication() {//패스워드 인증이 필요한 경우에 불려감
				return new PasswordAuthentication("tchook1224@gmail.com", "khbae1224!");//사용자로부터 수집한 PasswordAuthentication, 없는 경우에는 null을 반환
			}
		});
		
		MimeMessage msg = new MimeMessage(session);//매일 내용을 담을 객체
		try {
			msg.setSentDate(new Date());//메세지 보낸 시간
			msg.setFrom(new InternetAddress("tchook1224@gmail.com","twenty second"));//발신자 셋팅
			InternetAddress to = new InternetAddress(memberId);//수신자
			msg.setRecipient(Message.RecipientType.TO, to);// 받는 쪽 설정
			msg.setSubject("TWENTY SECOND 임시 비밀번호 안내","UTF-8");//메일 제목 설정
			msg.setContent("<span>TWENTY SECOND 임시 비밀번호 안내 메일입니다.</span><br>"+"<span>고객님의 임시 비밀번호는 "+sb.toString()+"입니다.</span><br><span>감사합니다. 🙏</span>","text/html;charset=UTF-8");//인증메일 내용 설정(태크 내용을 전달할 수 있음)
			Transport.send(msg);//메세지 전송
		}catch (AddressException ae) {
			System.out.println("AddressException:"+ae.getMessage());//주소 에러 메세지 출력
		}catch (MessagingException me) {
			System.out.println("MessagingException:"+me.getMessage());//메세지 에러 메세지 출력
		}catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException:"+e.getMessage());//지원되지 않는 인코딩 에러 메세지 출력
		}
		return sb.toString();//sb.toString()값으로 return해준다.
	}
}
