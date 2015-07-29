runner.login = {
	loginForm : null,
	initLoginPanel : function(){
		runner.login.loginForm = Ext.create("Ext.form.Panel",{
			title : runner.login.labels.panelTitle,
			frame : true,
			//cls : 'login_form',
			buttonAlign: 'center',
			//renderTo : Ext.getBody(),
			width : 250,
			height : 150,
			items : [
				runner.login.item.username(),
				runner.login.item.password()
			],
			buttons : [
				runner.login.item.login()
			]
		});
		
		var viewport=new Ext.Viewport({
  			layout:{
				type: 'vbox',
				align: 'center',
				pack: 'center'
			},
  			items:[runner.login.loginForm]
		});
	}
};