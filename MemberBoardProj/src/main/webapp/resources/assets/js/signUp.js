var idCheckResult = false;
var pwCheckResult = false;

function idChange(out){
    idCheckResult = false;
    out.innerHTML = "";
}

function idCheckfunc(mid, out){
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function(){
        if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200){
            if(httpRequest.responseText == "true"){
                idCheckResult = true;
                out.style = "color: #0000ff;"
                out.innerHTML = "사용가능";
            }else{
                out.style = "color: #ff0000;"
                out.innerHTML = "사용불가";
            }
        }
    }
    httpRequest.open("POST", "idCheck", true);
    httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    httpRequest.send("mid="+mid.value);
}

function pwReg(pw, pwCheck, out, checkOut){
    var num = pw.value.search(/[0-9]/g);
    var eng = pw.value.search(/[a-z]/ig);
    this.pwCheckResult = false;
    
    if(pw.value.search(/\s/)!=-1){
        out.style.color = "#ff0000";
        out.innerHTML = "비밀번호는 공백 없이 입력해주세요!";
    } else if (pw.value.length < 8 || pw.value.length > 20){
        out.style.color = "#ff0000";
        out.innerHTML = "8자리 ~ 20자리 이내로 입력해주세요!";
    } else if( num < 0 || eng < 0){
        out.style.color = "#ff0000";
        out.innerHTML = "영문, 숫자를 포함하여 입력해주세요!";
    } else {
        out.style.color = "#0000ff";
        out.innerHTML = "적절한 비밀번호 입니다!";
        pwCheckResult = true;
    }
    this.pwCheckfunc(pw, pwCheck, checkOut);
}

function pwCheckfunc(pw, pwCheck, checkOut){
    console.log(pw.value);
    console.log(pwCheck.value);
    if(pw.value != ""){
        if(pw.value == pwCheck.value){
            checkOut.style.color = "#0000ff";
            checkOut.innerHTML = "비밀번호가 일치합니다.";
        }else{
            checkOut.style.color = "#ff0000";
            checkOut.innerHTML = "비밀번호가 일치하지 않습니다!";
        }
    }else{
        checkOut.innerHTML = "";
    }
}

function checkValue(pw, pwCheck){
    if(idCheckResult){
        if(pwCheckResult){
            if(pw.value != pwCheck.value){
                alert("비밀번호를 동일하게 입력하세요.");
                return false;
            }
        }else{
            alert("비밀번호를 형식에 맞춰입력해주세요.");
            return false;
        }
    }else{
        alert("아이디 중복확인을 해주세요.");
        return false;
    }
}