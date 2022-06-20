Vue.component("login", { 
	data: function () {
	    return {
	      user: {username: null,password:null,name:'zxdasd',lastName:'dasda',gender:'FEMALE',dateOfBirth:null,role:null },
	      showEmptyMessage: false,
	      Data:null
	      }
	      
	},
	template:
	`<div>
		<table>
			<tr><td>Username</td><td><input type="text" v-model = "user.username" name="username"></td></tr>
			<tr><td>Password</td><td><input type="password" v-model = "user.password" name="password"></td></tr>
			<tr><td><button v-on:click="Login">Login</button></td></tr>
			<tr><td><button v-on:click="Register">Register</button></td></tr>
			
		</table>
		<div v-show="showEmptyMessage">
	    		<label>No such account</label>
	    </div>
	</div>`,
	methods : {
		Login:function(){
			
			if(this.user.username===null||this.user.password===null){return};
			
			axios.post('rest/login', this.user).
				then(response => (this.Data=response.data));
				
			if(this.Data===true)
			{
			window.location.href= "http://localhost:8080/FitPall/establishments.html";
			return;
			}
			else
			{
				this.showEmptyMessage=!this.Data;
				return;
			}
		},
		

		
		Register:function(){
			router.push(`/register/`);
			
		}
	}
});