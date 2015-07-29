runner.login.item = {
	
	//登陆框用户名
	username:function(){
		var username = new Ext.form.TextField({
			width : 200,
			allowBlank : false,
			maxLength : 20,
			name : 'username',
			fieldLabel : runner.login.labels.usernameLabel,
			labelWidth : 45,
			labelAlign : 'right',
			blankText : runner.login.labels.usernameBlankText,
			maxLengthText : runner.login.labels.usernameMaxLengthText,
			margin : '10 0 10 0'
		});
		return username;
	},
	//登录框密码
	password:function(){
		var pass = new Ext.form.TextField({
			width : 200,
			allowBlank : false,
			maxLength : 20,
			name : 'password',
			fieldLabel : runner.login.labels.passLabel,
			labelWidth : 45,
			labelAlign : 'right',
			blankText : runner.login.labels.passBlankText,
			inputType : 'password'
		});
		return pass;
	},
	
	//登陆框登陆
	login:function(){
		var loginBtn = new Ext.Button({
			text: runner.login.labels.loginText,
			handler: function(){
				if (runner.login.loginForm.getForm().isValid()) {
					runner.login.loginForm.submit({
						url : ctx + '/user/login',
						method : 'POST',
						waitMsg : runner.login.labels.waitingMsg,
						timeout : 60000,
						success : function(form, action){
							//location.href = 'fastcontacts/mainBoard';
							alert("success")
						},
						failure : function(form, action){
							//label.setText(action.result.errMsg);
							alert("failure")
						}
					});
				}else{
					//label.setText(login.labels.loginAlertMsg);
					alert("else")
				}
			}
		});
		return loginBtn;
	}
	
};