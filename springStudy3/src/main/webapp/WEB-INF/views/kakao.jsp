<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
    <title>Login Demo - Kakao JavaScript SDK</title>
    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    </head>
    <body>
    <form action="/test/kakao" method="post" id="form">
	    <a id="kakao-login-btn"></a>
	    <a href="http://developers.kakao.com/logout"></a>
    </form>
    <script type='text/javascript'>
    $(document).ready(function(){
      //<![CDATA[
        // 사용할 앱의 JavaScript 키를 설정해 주세요.
        Kakao.init('6b4faab23eaba656537389c827749ac0');
        // 카카오 로그인 버튼을 생성합니다.
        Kakao.Auth.createLoginButton({
          container: '#kakao-login-btn',
          success: function(authObj) {
            console.log(JSON.stringify(authObj));
            var token = authObj.access_token;
            
            var str = "<input type='hidden' name='accessToken' value='" + token + "'>";
            
            $("#kakao-login-btn").html(str);
            $("#form").submit();
            
          },
          fail: function(err) {
        	  console.log(JSON.stringify(err));
          }
        });
        
    });
      //]]>
    </script>

    </body>
    </html>