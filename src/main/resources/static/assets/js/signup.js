$(document).ready(function () {


$('#signup-form button[name="signup-button"]').click(function(evt) {
  // 회원분류 설정
  var userCategory = $('#userCategory > option:checked')
 
  if(userCategory.val() != '') {
    $('span[title="userCategory-value"]').show().html('GOOD!').css('color', 'green')

  } else {
    $('span[title="userCategory-value"]').show().html('카테고리를 설정해주세요').css('color', 'red')

  }
      // 회원등급 설정
      var userGrade = $('#userGrade > option:checked')
    // console.log(countryselect);
    if(userGrade.val() != '') {
      $('span[title="userGrade-value"]').show().html('GOOD!').css('color', 'green')

    } else {
      $('span[title="userGrade-value"]').show().html('등급을 설정해주세요').css('color', 'red')

    }
  // 비밀번호 힌트설정
  var userQuestion = $('#userQuestion > option:checked')
 
  if(userCategory.val() != '') {
    $('span[title="userQuestion-value"]').show().html('GOOD!').css('color', 'green')

  } else {
    $('span[title="userQuestion-value"]').show().html('비밀번호 힌트를 설정해주세요').css('color', 'red')

  }
  var userAnswer = $('#signup-form input[name="userAnswer"]')
  // console.log(userAnswer.val());
  if(userAnswer.val()) {
    $('span[title="userAnswer-value"]').show().html('GOOD!').css('color', 'green')
    userAnswer.removeClass('is-invalid')
    userAnswer.addClass('is-valid')
  } else {
    $('span[title="userAnswer-value"]').show().html('힌트 답변을 입력해주세요').css('color', 'red')
    userAnswer.removeClass('is-valid')
    userAnswer.addClass('is-invalid')
    evt.preventDefault();
    userAnswer.focus();
    
  }
//닉네임설정
  var nickname = $('#signup-form input[name="userNickName"]')
  // console.log(nickname.val());
  if(nickname.val()) {
    $('span[title="nickname-value"]').show().html('GOOD!').css('color', 'green')
    nickname.removeClass('is-invalid')
    nickname.addClass('is-valid')
  } else {
    $('span[title="nickname-value"]').show().html('닉네임을 입력해주세요').css('color', 'red')
    nickname.removeClass('is-valid')
    nickname.addClass('is-invalid')
    evt.preventDefault();
    nickname.focus();
    // last.value = '';
  }
  //생년월일설정
  var userBirthDate = $('#signup-form input[name="userBirthDate"]')
  // console.log(userBirthDate.val());
  if(userBirthDate.val()) {
    $('span[title="userBirthDate-value"]').show().html('GOOD!').css('color', 'green')
    userBirthDate.removeClass('is-invalid')
    userBirthDate.addClass('is-valid')
  } else {
    $('span[title="userBirthDate-value"]').show().html('생년월일을 입력해주세요').css('color', 'red')
    userBirthDate.removeClass('is-valid')
    userBirthDate.addClass('is-invalid')
    evt.preventDefault();
    userBirthDate.focus();
    // last.value = '';
  }
  //이름설정
  var username = $('#signup-form input[name="userName"]')
  // console.log(nickname.val());
  if(username.val()) {
    $('span[title="username-value"]').show().html('GOOD!').css('color', 'green')
    username.removeClass('is-invalid')
    username.addClass('is-valid')
  } else {
    $('span[title="username-value"]').show().html('이름을 입력해주세요').css('color', 'red')
    username.removeClass('is-valid')
    username.addClass('is-invalid')
    evt.preventDefault();
    username.focus();
    // last.value = '';
  }
    //아이디설정
    var userId = $('#signup-form input[name="userId"]')
    var idReg = /^[a-z]+[a-z0-9]{5,19}$/.test(userId.val())
  // console.log(userId.val());
  if( !idReg ){
    $('span[title="userId-value"]').show().html('아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.').css('color', 'red');
    userId.removeClass('is-valid')
    userId.addClass('is-invalid')
    evt.preventDefault();
    userId.focus();
  } else {
    $('span[title="userId-value"]').show().html('GOOD!').css('color', 'green');
    userId.removeClass('is-invalid')
    userId.addClass('is-valid')
  }

  // 이메일 정규성 검사
  var email = $('#signup-form input[name="userEmail"]')
  var emailcheck =  /\S+@\S+\.\S+/.test(email.val())
  if ( !emailcheck ){
    $('span[title="email-value"]').show().html('올바른 이메일 형식으로 입력해주세요.').css('color', 'red');
    email.removeClass('is-valid')
    email.addClass('is-invalid')
    evt.preventDefault();
    email.focus();
  } else {
    $('span[title="email-value"]').show().html('GOOD!').css('color', 'green');
    email.removeClass('is-invalid')
    email.addClass('is-valid')
  }
    // 전화번호
    var userTel = $('#signup-form input[name="userTel"]')
    // console.log(userTel);
    if(userTel.val()) {
      $('span[title="phone-value"]').show().html('GOOD!').css('color', 'green')
      userTel.removeClass('is-invalid')
      userTel.addClass('is-valid')
    } else {
      $('span[title="phone-value"]').show().html('전화번호를 입력하시오.').css('color', 'red')
      userTel.removeClass('is-valid')
      userTel.addClass('is-invalid')
      evt.preventDefault();
      userTel.focus();

    }
  // 성별 
    var userGender = $('#userGender > option:checked')
    // console.log(countryselect);
    if(userGender.val() != '') {
      $('span[title="userGender-value"]').show().html('GOOD!').css('color', 'green')
      // countryselect.removeClass('is-invalid')
      // countryselect.addClass('is-valid')
    } else {
      $('span[title="userGender-value"]').show().html('성별을 선택하세요').css('color', 'red')
      // countryselect.removeClass('is-valid')
      // countryselect.addClass('is-invalid')
    }

  
  // 암호
  var userPw = $('#signup-form input[name="userPw"]')
  var num = userPw.val().search(/[0-9]/g);
  var eng = userPw.val().search(/[a-z]/ig);
  var spe = userPw.val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
  // console.log(password.val());
  // 길이가 8 ~ 20
  if(userPw.val().length < 8 || userPw.length > 20) {
    $('span[title="pw-value"]').show().html('비밀번호는 길이가 8~20자로 영문자 또는 숫자이어야 합니다.').css('color', 'red');
    userPw.removeClass('is-valid')
    userPw.addClass('is-invalid')
    evt.preventDefault();
    userPw.focus();
    // return false
    //공백체크
    } else if (userPw.val().search(/\s/) != -1 ) {
      $('span[title="pw-value"]').show().html('공백 없이 입력하시오.').css('color', 'red');
      userPw.removeClass('is-valid')
      userPw.addClass('is-invalid')
      evt.preventDefault();
      userPw.focus();
      // return false
      // 영문, 숫자, 특수문자 확인
    } else if (num < 0 || eng < 0 || spe < 0) {
      $('span[title="pw-value"]').show().html('영문, 숫자, 특수문자를 혼합하여 입력하시오..').css('color', 'red');
      userPw.removeClass('is-valid')
      userPw.addClass('is-invalid')
      evt.preventDefault();
      userPw.focus();
      // return false
    } else {
      $('span[title="pw-value"]').show().html('GOOD!').css('color', 'green');
      userPw.removeClass('is-invalid')
      userPw.addClass('is-valid')
      // return true
    }
  

/*   // 암호 확인
  var pwcheck = $('#signup-form input[name="password-check-input"]')
  // console.log(pwcheck);
  if(pwcheck.val() == password.val() && pwcheck.val().length != 0) {
    $('span[title="pwcheck-value"]').show().html('GOOD!').css('color', 'green')
    pwcheck.removeClass('is-invalid')
    pwcheck.addClass('is-valid')
  } else {
    $('span[title="pwcheck-value"]').show().html('비밀번호가 일치하지 않습니다.').css('color', 'red')
    pwcheck.removeClass('is-valid')
    pwcheck.addClass('is-invalid')
  } */


});

});
