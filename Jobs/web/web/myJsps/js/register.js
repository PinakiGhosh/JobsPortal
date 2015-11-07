function register()
{
    var e=$('#email').val();
    var d=$('#dob').val();
    var n=$('#name').val();
    var ph=$('#phone').val();
    var pwd=$('#pwd').val();
    var cpwd=$('#cPwd').val();
    console.log('Email '+e);
    console.log('DOB '+d);
    console.log('Name '+n);
    console.log('Phone '+ph);
    console.log('Pwd '+pwd);
    console.log('Confirm Pwd '+cpwd);
    $.ajax({
      url:'../../LoginRegisterServlet',
      type:'POST',
      data:{email:e,pwd:pwd,param:'register',cPwd:cpwd,name:n,phone:ph},
      success:function(data)
      {
          console.log(data);
      }
    });
}

$('body').on('click','#register',function(){
    register();
});