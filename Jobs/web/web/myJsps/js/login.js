function logIn()
{
    var u=$('#loginUsername').val();
    var p=$('#loginPwd').val();
    $.ajax({
      url:'../../LoginRegisterServlet',
      type:'POST',
      data:{email:u,pwd:p,param:'login'},
      success:function(data)
      {
          console.log(data);
      }
    });
}

$('body').on('click','#logIn',function(){
    logIn();
});



